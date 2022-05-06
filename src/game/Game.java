package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 * @author Abbib Akram
 * @version 1
 */
public class Game {


    GameLevel currentLevel;
    GameView view;
    SoldierController controller;
    /**
     * This is the field for the controlpanel
     */
    private ControlPanel controlPanel;
    /**
     * This is the field for the settingspanel
     */
    private SettingsPanel settingsPanel;
    /**
     * This is the field for the Jframe
     */
    private JFrame frame;
    /**
     * This is the field for the background music of the game
     */
    public SoundClip gameMusic;


    /**
     * This initialises the new game.
     */
    public Game() {


        currentLevel = new Level1(this);
        //menuVisible=false;




        try {
            gameMusic = new SoundClip("data/battlesong.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }



        //3. make a view to look into the game world
        view = new GameView(currentLevel, 500, 500);
        //GameView view = new GameView((GameLevel) world, 500, 500);
        view.addMouseListener(new GiveFocus(view));
         controller = new SoldierController(currentLevel.getSoldier());
        view.addKeyListener(controller);


        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        /*delete the ControlPanel*/
        controlPanel=new ControlPanel(this);
       settingsPanel = new SettingsPanel(this);
      frame.add(controlPanel.mainPanel, BorderLayout.WEST);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        currentLevel.start();
    }


    /**
     * This method is used to update the level,which wiil also update the position in the current world
     * @param level
     */
    public void setLevel(GameLevel level){
        currentLevel.stop();
        currentLevel = level;
        view.setWorld(currentLevel);
        controller.updateSoldier(currentLevel.getSoldier());
        currentLevel.start();

    }

    /**
     * This method is used to transition between levels
     */
    public void goToNextLevel() {
        System.out.println("Changing level...");
        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel = new Level2(this);




            view.setWorld(currentLevel);

            controller.updateSoldier(currentLevel.getSoldier());

            currentLevel.start();
            System.out.println("Starting level 2");

        } else if (currentLevel instanceof Level2) {

            currentLevel.stop();


            currentLevel = new Level3(this);
            view.setWorld(currentLevel);


            controller.updateSoldier(currentLevel.getSoldier());

            currentLevel.start();
            System.out.println("Starting level 3");



        }else if (currentLevel instanceof Level3) {
            System.out.println("game done");
            System.exit(0);
        }


    }

    /**
     * This method is used to transition to the settings panel
     */
    public void transitionToSettings(){
        frame.remove(controlPanel.mainPanel);
        frame.add(settingsPanel.mainPanel, BorderLayout.WEST);
        frame.pack();

    }

    /**
     * This method is used to transition to the main panel
     */
    public void transitionToMain(){
        frame.remove(settingsPanel.mainPanel);
        frame.add(controlPanel.mainPanel,BorderLayout.WEST);
        frame.pack();

    }








    /** Run the game. */
        public static void main (String[]args){

            new Game();

        }

    }

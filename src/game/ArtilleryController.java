package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *This is a class which links the class artillery to keyboard control
 */
public class ArtilleryController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private  Artillery artillery;

    public ArtilleryController(Artillery artillery) {
        this.artillery = artillery;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed " + e.getKeyCode());
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_Q){
            artillery.shoot();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}





package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * This class enables the view to switch between levels
 */
public class GameView extends UserView {

    private GameLevel level;


    public GameView(GameLevel world, int width, int height) {
        super(world, width, height);
        this.level = world;


    }

    @Override
    public void setWorld(World world) {
        super.setWorld(world);
        this.level = (GameLevel) world;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(level.getBackground(), 0, 0, this);

    }
}


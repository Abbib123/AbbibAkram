package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * This class is for level 1 of my game
 */

public class Level1 extends GameLevel {

    private Image background;

    public Level1(Game game) {
        super(game);
        background = new ImageIcon("data/desert.png").getImage();
        Shape shape = new BoxShape(100, 2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.5f));

        Shape platformShape = new BoxShape(2f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(+10f, -4f));

        Shape platformShape2 = new BoxShape(2f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(3f, 4f));


        getSoldier().setPosition(new Vec2(7, -9));
        getArtillery1().setPosition(new Vec2(-10, 6f));
        getArtillery2().setPosition(new Vec2(-10, 0.5f));
        getArtillery3().setPosition(new Vec2(-10, -5f));


    }





    @Override
    public boolean isComplete() {

        return true;
    }


    @Override
    public Image getBackground() {
        return background;
    }
}
    



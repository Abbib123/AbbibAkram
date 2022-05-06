package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * This is a class for level 3 of my game
 */
public class Level3 extends GameLevel {
    private Image background;
    public Level3(Game game){
        super(game);
        background = new ImageIcon("data/warzone.png").getImage();
        Shape platformShape = new BoxShape(2f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(+10f, -4f));

        Shape platformShape4 = new BoxShape(2f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(7f, 8f));

        Shape platformShape5 = new BoxShape(2f, 0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(6f, 7.5f));




        //Body b = new DynamicBody(this,new CircleShape(2));
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


package game;

import city.cs.engine.BoxShape;
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * This is a class for level 2 of my game.
 */
public class Level2 extends GameLevel {
    private Image background;
    public Level2(Game game) {
        super(game);
        background = new ImageIcon("data/jungle.png").getImage();
        Shape platformShape = new BoxShape(2f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(+10f, -4f));

        Shape platformShape3 = new BoxShape(2f, 0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(5f, 2f));

        Shape platformShape4 = new BoxShape(2f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(7f, 8f));



        getSoldier().setPosition(new Vec2(7, -9));
        getArtillery1().setPosition(new Vec2(-10, 6f));
        getArtillery2().setPosition(new Vec2(-10, 0.5f));
        getArtillery3().setPosition(new Vec2(-10, -5f));
    }


    @Override
    public boolean isComplete(){
        return true;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}

//}



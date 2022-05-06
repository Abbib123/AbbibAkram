package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.net.http.WebSocket;

/**
 * This class is a base class for all levels,which contains everything a generic level should have
 */
public abstract class GameLevel extends World implements StepListener {
    /**
     * This is the field for the soldier
     */
    private Soldier soldier;
    /**
     * This is the field for the first cannon
     * This is the field for the second cannon
     * This is the field for the third cannon
     */
    private Artillery artillery1, artillery2, artillery3;

    /**
     * This is the field for the counter
     * @param game
     */
    private int counter;

    

    public GameLevel(Game game) {
        super();
        this.addStepListener(this);
        counter = 0;
        // make the ground
        Shape shape = new BoxShape(100, 2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.5f));

        Shape platformShape = new BoxShape(2f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(+10f, -4f));

        Shape platformShape2 = new BoxShape(2f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(3f, 4f));

        Shape platformShape3 = new BoxShape(2f, 0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(-2f, 9f));


        // make the character
        soldier = new Soldier(this);
        soldier.setPosition(new Vec2(7, -9));

        BallPickup listener = new BallPickup(this,game);

        soldier.addCollisionListener(listener);


        //Make the Artillery
        /**
         * This method initialises the first artillery gun and its position in the world
         */
        artillery1 = new Artillery(this);
        artillery1.setPosition(new Vec2(-10, 6f));

        //Make the Artillery
        /**
         * This method initialises the second artillery gun and its position in the world
         */
        artillery2 = new Artillery(this);
        artillery2.setPosition(new Vec2(-10, 0.5f));

        //Make the Artillery
        /**
         * this method intitialises the third artillery gun and its position in the world
         */
        artillery3 = new Artillery(this);
        artillery3.setPosition(new Vec2(-10, -5f));


    }

    public Artillery getArtillery1() {
        return artillery1;

    }

    public Artillery getArtillery2() {
        return artillery2;
    }


    public Artillery getArtillery3(){
        return artillery3;

    }

    //new accessor for the student field
    public Soldier getSoldier() {
        return soldier;
    }

    @Override
    /**
     * This method controls the amount of projectiles fired in a minute
     */
    public void preStep(StepEvent stepEvent) {
        counter++;
        if (counter % 120==0) {
            artillery1.shoot();
            artillery2.shoot();
            artillery3.shoot();

        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
    public abstract boolean isComplete();
    public abstract Image getBackground();
}








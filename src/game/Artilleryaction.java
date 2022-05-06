package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * This class dictates whenever a soldier will die whenever it is hit by a projectile
 */
public class Artilleryaction implements CollisionListener {
    private Soldier soldier;


    public Artilleryaction(Soldier soldier) {
        this.soldier = soldier;

    }
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Soldier){
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
        }

    }
}

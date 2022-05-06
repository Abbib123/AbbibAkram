package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * This class is designed to detect whenever the projectile has touched the soldier
 */
public class BallPickup implements CollisionListener {

    GameLevel currentLevel;
    Game game;

    /**
     * This method detects whenever a projectile has been picked up in a certain level
     * @param level
     * @param game
     */
    public BallPickup(GameLevel level,Game game){
        currentLevel=level;
        this.game=game;

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        /**
         * This method notifies the user whenever a soldier has collided with a projectile
         */
       if (collisionEvent.getOtherBody() instanceof Artillery){
           System.out.println(currentLevel.isComplete());
           if (currentLevel.isComplete())
               game.goToNextLevel();
           System.out.println("the student has collided with the projectile");



        }


      








    }
}

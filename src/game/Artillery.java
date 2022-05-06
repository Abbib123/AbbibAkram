package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This is a class for my artillery which controls how the artillery looks and sounds
 */
public class Artillery extends StaticBody {
    /**
     * This is the field for the soldier
     */
    private Soldier soldier;
    private static final Shape artilleryShape = new BoxShape(1, 2);
    /**
     * This method presents the image of the artillery body
     */
    private static final BodyImage image =
            new BodyImage("data/artillery2.png", 4f);
    /**
     * This method outputs the sound of the artillery
     */
    private static SoundClip artillerySound;

    static {
        try {
            artillerySound = new SoundClip("data/artillerysound.wav");
            System.out.println("Loading artillery sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }








    public Artillery(World world) {
        super(world, artilleryShape);
        this.addImage(image);
    }

    public static BodyImage getImage() {
        return image;
    }

    /**
     * This method controls the velocity of the artillery fire
     */
    public void shoot(){
            DynamicBody cannonball = new DynamicBody( this.getWorld(),new CircleShape(0.5f));
            cannonball.addCollisionListener(new Artilleryaction(soldier));


            cannonball.setPosition(new Vec2(this.getPosition().x+1,this.getPosition().y));
           cannonball.setLinearVelocity(new Vec2(25,3));
           artillerySound.play();
        }
    }

    





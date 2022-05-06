package game;

import city.cs.engine.*;

/**
 * This is the class that sets the image of my soldier
 */
public class Soldier extends Walker {



    private static final Shape soldierShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/soldier2.png", 4f);
    private int hits;

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Soldier(World world) {
        super(world, soldierShape);
        this.addImage(image);
        hits = 10;


    }






}

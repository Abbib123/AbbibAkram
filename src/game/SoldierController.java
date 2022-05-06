package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is to enable the user to control the soldier via the keyboard and mouse
 */
public class SoldierController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private Soldier soldier;

    public SoldierController(Soldier soldier) {
        this.soldier = soldier;
    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed " + e.getKeyCode());
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            soldier.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            soldier.startWalking(WALKING_SPEED);
        }
        if (code == KeyEvent.VK_SPACE) {
            soldier.jump(15);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            soldier.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            soldier.stopWalking();

        }
        
        /*i was here*/



    }






public void updateSoldier(Soldier newSoldier){
        soldier = newSoldier;

}


    }


package main01; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhand implements KeyListener{

    public boolean upPress, downPress, leftPress, rightPress;
                
    @Override
    public void keyPressed(KeyEvent e) {
        
        int cokey = e.getKeyCode();

        if (cokey == KeyEvent.VK_W) {
            upPress = true;
        }
        if (cokey == KeyEvent.VK_S) {
            downPress = true;
        }
        if (cokey == KeyEvent.VK_A) {
            leftPress = true;
        }
        if (cokey == KeyEvent.VK_D) {
            rightPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
        int cokey = e.getKeyCode();

        if (cokey == KeyEvent.VK_W) {
            upPress = false;
        }
        if (cokey == KeyEvent.VK_S) {
            downPress = false;
        }
        if (cokey == KeyEvent.VK_A) {
            leftPress = false;
        }
        if (cokey == KeyEvent.VK_D) {
            rightPress = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }



}

package player;

import java.awt.Color;
import java.awt.Graphics2D;

import main01.Keyhand;
import main01.p01;

public class player1 extends entity{

    p01 gp;
    Keyhand keyH;

    public player1(p01 gp, Keyhand keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update() {
        if (keyH.upPress == true) {
            y -= speed;
        }else if (keyH.downPress == true) {
            y += speed;
        }else if (keyH.leftPress == true) {
            x -= speed;
        }else if (keyH.rightPress == true) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);

        g2.fillRect (x, y, gp.tileSize, gp.tileSize);

    }
}

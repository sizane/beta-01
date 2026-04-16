package player;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            pic1 = ImageIO.read(getClass().getResourceAsStream("/asset/pic1.png"));
            pic2 = ImageIO.read(getClass().getResourceAsStream("/asset/pic2.png"));
            pic3 = ImageIO.read(getClass().getResourceAsStream("/asset/pic3.png"));
            pic4 = ImageIO.read(getClass().getResourceAsStream("/asset/pic4.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
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

        movement++;
        if (movement > 10){
            if (movementNum == 1) {
                movementNum = 2;
            }
            if (movementNum == 2) {
                movementNum = 3;
            }
            if (movementNum == 3) {
                movementNum = 4;
            }
            movement = 0;
        }
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.BLUE);

        //g2.fillRect (x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
            case "down" :
            if (movementNum == 1) {
                image = pic1;
            }
            if (movementNum == 2) {
                image = pic2;
            }
            if (movementNum == 3) {
                image = pic3;
            }
            if (movementNum == 4) {
                image = pic4;
            }
        break;
        }
    }
       
}

package main01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class p01 extends JPanel implements Runnable{

    // setting screen
    final int oriTiSi = 16; // 16x16 pixel
    final int scale = 3; 

    final int tileSize = oriTiSi * scale; // 48x48 pixel
    final int maksScreenCon = 22;
    final int maksScreenRow = 14;
    final int screenWidth = tileSize * maksScreenCon; // 960 pixel
    final int screenHeight = tileSize * maksScreenRow; // 864 pixel

    Thread gameThread;

    public p01() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        while (gameThread != null) {
            System.out.println("the game loop is running");

            // update : for update the information such as character positions
            update();

            // draw(repaint) : for draw the screen with update information
            repaint();
        }
    }
    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.blue);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }


}

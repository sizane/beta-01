package main01;

import player.player1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class p01 extends JPanel implements Runnable{

    // setting screen
    final int oriTiSi = 16; // 16x16 pixel
    final int scale = 3; 

    public final int tileSize = oriTiSi * scale; // 48x48 pixel
    final int maksScreenCon = 22;
    final int maksScreenRow = 14;
    final int screenWidth = tileSize * maksScreenCon; // 960 pixel
    final int screenHeight = tileSize * maksScreenRow; // 864 pixel

    //
    int FPS = 60;

    Keyhand keyH = new Keyhand();
    Thread gameThread;
    player1 charPlayer = new player1(this, keyH);

    // set player default position
    int playerX = 100;
    int playerY = 100;
    int speedP = 4; 

    public p01() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInters = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int countFps = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/ drawInters;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta --;
                countFps ++;
            }

            if (timer >= 1000000000){
                System.out.println("FPS : " + countFps);
                countFps = 0;
                timer = 0;
            }
        }   
    }
    /*public void run() {
         
        double drawInter = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInter;

        while (gameThread != null) {

            // update : for update the information such as character positions
            update();

            // draw(repaint) : for draw the screen with update information
            repaint();

            try {
                double remainTime = nextDrawTime - System.nanoTime();
                remainTime = remainTime/1000000;
                if (remainTime < 0) {
                    remainTime = 0;
                }

                Thread.sleep((long) remainTime);

                nextDrawTime += drawInter;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    */
    public void update(){
        charPlayer.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        charPlayer.draw(g2);        

        g2.dispose();   
    }


}

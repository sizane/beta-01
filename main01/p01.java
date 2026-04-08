package main01;

import java.awt.Color;
import java.awt.Dimension;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }


}

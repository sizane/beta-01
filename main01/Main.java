package main01;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame layar = new JFrame();
        layar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layar.setResizable(false);
        layar.setTitle("unknown-01");

        p01 gameP01 = new p01();
        layar.add(gameP01);

        layar.pack();

        layar.setLocationRelativeTo(null);
        layar.setVisible(true);
    }
}

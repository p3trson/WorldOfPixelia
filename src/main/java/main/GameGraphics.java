package main;

import main.GameData;
import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame {
    public GameData data;

    public GameGraphics() throws HeadlessException {

        Draw draw = new Draw();
        add(draw);

        setTitle("World Of Pixelia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(GameData data) {
        this.data = data;
        repaint();
    }


    class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2  = (Graphics2D) g;

            if (data != null) {
                data.getPlayer().generate(g2);
            }

        }
    }
}

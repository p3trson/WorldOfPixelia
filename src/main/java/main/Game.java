package main;

import Entity.Direction;
import Entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        GameData data = new GameData();
        GameGraphics graphics = new GameGraphics();

        data.initialize();
        graphics.render(data);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.update();
                graphics.render(data);
            }

        });

        timer.start();

        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    data.getPlayer().move(5, Direction.LEFT);
                }

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    data.getPlayer().move(5, Direction.RIGHT);
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    data.getPlayer().move(5, Direction.DOWN);
                }

                if (e.getKeyCode() == KeyEvent.VK_W) {
                    data.getPlayer().move(5, Direction.UP);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
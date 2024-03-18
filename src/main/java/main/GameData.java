package main;

import Entity.Direction;
import Entity.Player;
public class GameData {

    private Player player;

    public void update() {

    }
    public void initialize() {
        player = new Player(10, 10, 48, 48);
    }

    public Player getPlayer() {
        return player;
    }
}
package ru.kpfu.itis.teamgbe.gameengine;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(10,10);
	    GameWindow window = new GameWindow("MyWindow",800,600,30, game);
    }
}

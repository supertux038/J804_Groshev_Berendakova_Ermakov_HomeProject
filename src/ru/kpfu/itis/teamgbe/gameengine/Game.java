package ru.kpfu.itis.teamgbe.gameengine;

public class Game {
    Cell[][] gameField;
    private final int height;
    private final int width;

    public Game(int height, int width) {
        this.height = height;
        this.width = width;
        gameField = new Cell[height][width];
    }
}

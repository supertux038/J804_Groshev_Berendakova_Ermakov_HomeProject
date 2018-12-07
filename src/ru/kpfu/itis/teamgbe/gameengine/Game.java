package ru.kpfu.itis.teamgbe.gameengine;

public class Game {
    public Cell[][] gameField;
    private final int HEIGHT;
    private final int WIDTH;

    public Game(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        gameField = new Cell[HEIGHT][WIDTH];
        for(int i = 0; i < HEIGHT; i++) {git
            for(int j = 0; j < WIDTH; j++) {
                gameField[i][j] = new Cell();
            }
        }
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}

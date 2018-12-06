package ru.kpfu.itis.teamgbe.gameengine;

public class Game {
    public Cell[][] gameField;
    private final int height;
    private final int width;

    public Game(int height, int width) {
        this.height = height;
        this.width = width;
        gameField = new Cell[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Cell c = new Cell();
                c.setText(i + " " + j);
                gameField[i][j] = c;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

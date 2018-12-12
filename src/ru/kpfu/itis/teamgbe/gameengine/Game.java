package ru.kpfu.itis.teamgbe.gameengine;

/**
 * The class, that stores data about game situation, which can be drawn by GameWindow
 * @author Alexander Ermakov aka supertux038
 * @version 1.0
 */
public class Game {

    /**
     * Two dimensional array of cells, storing the state of each cell in current game situation
     * USE WITH ACCURACY!
     */
    public Cell[][] gameField;
    private final int HEIGHT;
    private final int WIDTH;

    /**
     * Constructor for game class. Every cell is initialized with its default properties
     * @param HEIGHT height of gamefield in cells
     * @param WIDTH width of gamefield in cells
     */
    public Game(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        gameField = new Cell[HEIGHT][WIDTH];
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = 0; j < WIDTH; j++) {
                gameField[i][j] = new Cell();
            }
        }
    }

    /**
     * getter for const int HEIGHT of the game instance
     * @return height of gamefield in cells
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * getter for const int WIDTH of the game instance
     * @return width of gamefield in cells
     */
    public int getWIDTH() {
        return WIDTH;
    }
}

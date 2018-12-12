package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * The main window drawing class
 * It implements all the logics connected with displaing pixels and colors
 * @author Hyperbot
 * @version 1.0
 */
public class GameWindow extends JFrame {
    private JPanel panel;
    private Timer timer;
    private final Game game;
    private boolean gridEnabled = true;
    private int gridThickness = 1;
    private boolean coordinatesEnabled = true;
    private Color gridColor = Color.BLACK;
    private Color textColor = Color.BLACK;

    /**
     * the main constructor
     * @param windowLabel the headline of the form which user sees
     * @param defaultWidth width in pixels with which window would appear (only appear, width can change during runtime)
     * @param defaultHeight height in pixels with which window would appear (only appear, height can change during runtime)
     * @param fps frames per second, how fast would the window be redrawn
     * @param game the Game class instance, that would be drawn with this window
     */
    public GameWindow(String windowLabel, int defaultWidth, int defaultHeight, int fps, Game game) {
        super(windowLabel);
        this.game = game;
        this.setBounds(0,0, defaultWidth, defaultHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        timer = new Timer((1000 / fps), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });
        timer.start();
    }

    /**
     * getter for the color of grid
     * @return the color of the grid
     */
    public Color getGridColor() {
        return gridColor;
    }

    /**
     * setter for the color of grid
     * @param gridColor the color the grid will be
     */
    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    /**
     * getter for the color of text
     * @return the color of text
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * setter for the color of text
     * @param textColor the color the text will be
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    /**
     * getter for gridEnabled boolean
     * @return true if grid drawing is enabled, else if disabled
     */
    public boolean isGridEnabled() {
        return gridEnabled;
    }

    /**
     * setter for gridEnabled boolean
     * @param gridEnabled true to enable grid, false to disable
     */
    public void setGridEnabled(boolean gridEnabled) {
        this.gridEnabled = gridEnabled;
    }

    /**
     * getter for gridThickness
     * @return int, meaning width of grid lines in pixels
     */
    public int getGridThickness() {
        return gridThickness;
    }

    /**
     * setter for gridThickness
     * @param gridThickness int, meaning width of grid lines in pixels
     */
    public void setGridThickness(int gridThickness) {
        this.gridThickness = gridThickness;
    }

    /**
     * getter for coordinatesEnabled boolean
     * @return true if numbers and letters on the edges are drawn, else if are not drawn
     */
    public boolean isCoordinatesEnabled() {
        return coordinatesEnabled;
    }

    /**
     * setter for coordinateEnabled boolean
     * @param coordinatesEnabled true to enable numbers and letters on the edges, false to disable
     */
    public void setCoordinatesEnabled(boolean coordinatesEnabled) {
        this.coordinatesEnabled = coordinatesEnabled;
    }

    /** Function that draws new frame. It's called *fps* times per second (fps is set in constructor and can't be changed during the runtime)
     *
     */
    public void draw() {
        //creating imageBuffer to swap it at a moment to reduce fps flicker
        BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bufferedImageGraphics = bufferedImage.createGraphics();
        int cellWidth = panel.getWidth()/game.getWIDTH();
        int cellHeight = panel.getHeight()/game.getHEIGHT();

        /* drawing cells and its fields */
        for(int i = 0; i < game.getHEIGHT(); i++) {
            for(int j = 0; j < game.getWIDTH(); j++) {
                bufferedImageGraphics.setColor(game.gameField[i][j].getColor());
                bufferedImageGraphics.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
                bufferedImageGraphics.setColor(textColor);
                bufferedImageGraphics.drawString(game.gameField[i][j].getText(),i*cellWidth,j*cellHeight + cellHeight/2);
            }
        }

        //drawing grid
        if(gridEnabled) {
            bufferedImageGraphics.setColor(gridColor);
            for (int i = 1; i < game.getWIDTH(); i++) {
                bufferedImageGraphics.fillRect(i*cellWidth,0,gridThickness,panel.getHeight());
            }
            for (int i = 1; i < game.getHEIGHT(); i++) {
                bufferedImageGraphics.fillRect(0,i * cellHeight, panel.getWidth(), gridThickness);
            }
        }

        //drawing coordinates
        if(coordinatesEnabled) {
            bufferedImageGraphics.setColor(textColor);
            for (int i = 0; i < game.getHEIGHT(); i++) {
                bufferedImageGraphics.drawString(Integer.toString(i + 1),1,i*cellHeight + cellHeight/2 );
            }
            for(int i = 0; i < game.getWIDTH(); i++) {
                bufferedImageGraphics.drawString(Character.toString((char)('A' + i)),i*cellWidth + cellWidth /2, panel.getHeight() - 1 );
            }
        }

        bufferedImageGraphics.dispose();

        //swapping buffers
        Graphics panelGraphics = panel.getGraphics();
        panelGraphics.drawImage(bufferedImage,0,0, null);
        panelGraphics.dispose();
    }
}

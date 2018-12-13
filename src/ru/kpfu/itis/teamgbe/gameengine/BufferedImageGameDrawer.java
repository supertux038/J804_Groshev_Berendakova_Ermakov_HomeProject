package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract and universal gamefield image drawer (experimental)
 * @author Hyperbot
 * @version 0.9
 */
public class BufferedImageGameDrawer {
    private BufferedImage bufferedImage;
    private Gamefield gamefield;
    //probably we should create GamefieldDrawingParameters class for next properties
    private boolean gridEnabled = true;
    private int gridThickness = 1;
    private boolean coordinatesEnabled = true;
    private Color gridColor = Color.BLACK;
    private Color textColor = Color.BLACK;
    /**
     * A font with which coordinates and text in cells are drawn
     */
    private Font font = UIManager.getDefaults().getFont("Label.font");

    /**
     * Getter for the font
     * @return font with which coordinates and text in cells are now drawn
     */
    public Font getFont() {
        return font;
    }

    /**
     * Setter the font
     * @param font font you want coordinates and text in cells to be drawn
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * Getter for gridEnabled boolean
     * @return true if grid is enabled, else false
     */
    public boolean isGridEnabled() {
        return gridEnabled;
    }

    /**
     * Setter for gridEnabled boolean
     * @param gridEnabled true to enable grid, false to disable
     */
    public void setGridEnabled(boolean gridEnabled) {
        this.gridEnabled = gridEnabled;
    }

    /**
     * Getter for grid thickness in pixels
     * @return grid thickness in pixels
     */
    public int getGridThickness() {
        return gridThickness;
    }

    /**
     * Setter for grid thickness in pixels
     * @param gridThickness grid thickness in pixels to display
     */
    public void setGridThickness(int gridThickness) {
        this.gridThickness = gridThickness;
    }

    /**
     * Getter for coordinatesEnabled boolean
     * @return true if coordinates are drawn on edges, false if aren't
     */
    public boolean isCoordinatesEnabled() {
        return coordinatesEnabled;
    }

    /**
     * Setter for coordinatesEnabled boolean
     * @param coordinatesEnabled true to enable drawing numbers and letters (coordinates) on the edges of the image, false to  disable
     */
    public void setCoordinatesEnabled(boolean coordinatesEnabled) {
        this.coordinatesEnabled = coordinatesEnabled;
    }

    /**
     * Getter for grid color
     * @return grid colot
     */
    public Color getGridColor() {
        return gridColor;
    }

    /**
     * Setter for grid colot
     * @param gridColor color you want grid to be drawn with
     */
    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    /**
     * Getter for text and coordinates color
     * @return color, that coordinates and text in cells are drawn with
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * Setter for text and coordinates color
     * @param textColor color, that coordinates and text in cells you want to be drawn with
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    /**
     * Constructor for GameDrawer
     * @param width width of image in pixels to be drawn
     * @param height height of image in pixels to be drawn
     * @param gamefield gamefield to draw
     */
    //maybe we don't need constructor and should give arguments straight to drawGamefield?
    public BufferedImageGameDrawer(int width, int height, Gamefield gamefield) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.gamefield = gamefield;
    }

    /**
     * A method that draws new "frame" showing current situation on gamefield
     * @return BufferedImage, containing frame of gamefield
     */
    public BufferedImage drawGamefield() {
        Graphics bufferedImageGraphics = bufferedImage.createGraphics();
        int cellWidth = bufferedImage.getWidth()/ gamefield.getWIDTH();
        int cellHeight = bufferedImage.getHeight()/ gamefield.getHEIGHT();

        if(font != null) {
            bufferedImageGraphics.setFont(font);
        }

        /* drawing cells and its fields */
        for(int i = 0; i < gamefield.getHEIGHT(); i++) {
            for(int j = 0; j < gamefield.getWIDTH(); j++) {
                bufferedImageGraphics.setColor(gamefield.gameField[i][j].getColor());
                bufferedImageGraphics.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
                if(gamefield.gameField[i][j].getImage() != null) {
                    bufferedImageGraphics.drawImage(gamefield.gameField[i][j].getImage(),i*cellWidth,j*cellHeight,
                            cellWidth, cellHeight, null  );
                }
                bufferedImageGraphics.setColor(textColor);
                bufferedImageGraphics.drawString(gamefield.gameField[i][j].getText(),i*cellWidth,j*cellHeight + cellHeight/2);
            }
        }

        //drawing grid
        if(gridEnabled) {
            bufferedImageGraphics.setColor(gridColor);
            for (int i = 1; i < gamefield.getWIDTH(); i++) {
                bufferedImageGraphics.fillRect(i*cellWidth,0,gridThickness,bufferedImage.getHeight());
            }
            for (int i = 1; i < gamefield.getHEIGHT(); i++) {
                bufferedImageGraphics.fillRect(0,i * cellHeight, bufferedImage.getWidth(), gridThickness);
            }
        }

        //drawing coordinates
        if(coordinatesEnabled) {
            bufferedImageGraphics.setColor(textColor);
            for (int i = 0; i < gamefield.getHEIGHT(); i++) {
                bufferedImageGraphics.drawString(Integer.toString(i + 1),1,i*cellHeight + cellHeight/2 );
            }
            for(int i = 0; i < gamefield.getWIDTH(); i++) {
                bufferedImageGraphics.drawString(Character.toString((char)('A' + i)),i*cellWidth + cellWidth /2, bufferedImage.getHeight() - 1 );
            }
        }

        bufferedImageGraphics.dispose();
        return bufferedImage;
    }
}

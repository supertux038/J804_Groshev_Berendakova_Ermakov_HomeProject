package ru.kpfu.itis.teamgbe.gameengine;

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
    private boolean gridEnabled = true;
    private int gridThickness = 1;
    private boolean coordinatesEnabled = true;
    private Color gridColor = Color.BLACK;
    private Color textColor = Color.BLACK;

    public BufferedImageGameDrawer(int width, int height, Gamefield gamefield) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.gamefield = gamefield;
    }

    public BufferedImage drawGamefield() {
        Graphics bufferedImageGraphics = bufferedImage.createGraphics();
        int cellWidth = bufferedImage.getWidth()/ gamefield.getWIDTH();
        int cellHeight = bufferedImage.getHeight()/ gamefield.getHEIGHT();

        /* drawing cells and its fields */
        for(int i = 0; i < gamefield.getHEIGHT(); i++) {
            for(int j = 0; j < gamefield.getWIDTH(); j++) {
                bufferedImageGraphics.setColor(gamefield.gameField[i][j].getColor());
                bufferedImageGraphics.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
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

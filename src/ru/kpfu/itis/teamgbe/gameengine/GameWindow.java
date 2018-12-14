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
    private final Gamefield gamefield;
    private boolean gridEnabled = true;
    private int gridThickness = 1;
    private boolean coordinatesEnabled = true;
    private boolean textInCellsEnabled = true;
    private Color gridColor = Color.BLACK;
    private Color textColor = Color.BLACK;
    private Font font;

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * the main constructor
     * @param windowLabel the headline of the form which user sees
     * @param defaultWidth width in pixels with which window would appear (only appear, width can change during runtime)
     * @param defaultHeight height in pixels with which window would appear (only appear, height can change during runtime)
     * @param fps frames per second, how fast would the window be redrawn
     * @param gamefield the Gamefield class instance, that would be drawn with this window
     */
    public GameWindow(String windowLabel, int defaultWidth, int defaultHeight, int fps, Gamefield gamefield) {
        super(windowLabel);
        this.gamefield = gamefield;
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
    private void draw() {
        BufferedImageGameDrawer bufferedImageGameDrawer = new BufferedImageGameDrawer(panel.getWidth(), panel.getHeight(), gamefield);
        bufferedImageGameDrawer.setCoordinatesEnabled(coordinatesEnabled);
        bufferedImageGameDrawer.setGridColor(gridColor);
        bufferedImageGameDrawer.setGridEnabled(gridEnabled);
        bufferedImageGameDrawer.setGridThickness(gridThickness);
        bufferedImageGameDrawer.setTextColor(textColor);
        bufferedImageGameDrawer.setTextInCellsEnabled(true);
        if(font != null) {
            bufferedImageGameDrawer.setFont(font);
        }
        Graphics panelGraphics = panel.getGraphics();
        panelGraphics.drawImage(bufferedImageGameDrawer.drawGamefield() ,0,0, null);
        panelGraphics.dispose();
    }
}

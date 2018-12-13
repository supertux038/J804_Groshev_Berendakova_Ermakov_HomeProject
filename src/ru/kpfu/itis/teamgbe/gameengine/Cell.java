package ru.kpfu.itis.teamgbe.gameengine;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class, that stores information about a cell
 * @author Alexander Ermakov aka supertux038
 * @version 1.0
 */
public class Cell {
    private final Color DEFAULT_COLOR = Color.WHITE;
    private Color color;
    private String text;
    private BufferedImage image;

    /**
     * Empty constructor. Cell has white color and emty text (not null!) by default. Image is null (but it is not critical, because it's checked while drawing)
     */
    public Cell() {
        this.color = DEFAULT_COLOR;
        this.text = "";
    }

    /**
     * Constructor with color. Text is set as empty (not null!) string by default. Image is null (but it is not critical, because it's checked while drawing)
     * @param color color the cell will be created with
     */
    public Cell(Color color) {
        this.color = color;
        this.text = "";
    }

    /**
     * Just another constructor. See descriptions above.
     * @param color color
     * @param text text
     */
    public Cell(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    /**
     * Full constructor.
     * @param color color the cell will be created with
     * @param text label the cell will be created with
     * @param image image the cell will be created with
     */
    public Cell(Color color, String text, BufferedImage image) {
        this.color = color;
        this.text = text;
        this.image = image;
    }

    /**
     * Getter for image, that is drawn in the cell
     * @return BufferedImage image that is drawn in the cell
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Setter for image that is drawn in the cell
     * @param image BufferedImage image you want to be drawn in the cell. Any resolution is suitable, image is auto-scaled while drawing.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Getter for the color of the cell
     * @return color of the cell
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for the color of the cell
     * @param color color you want the cell to be drawn with
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter for the text of the label that is drawn in the cell
     * @return string text, that is drawn inside the cell
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for text of the label that is drawn in the cell
     * @param text text you want to be drawn inside the cell
     */
    public void setText(String text) {
        this.text = text;
    }
}

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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Cell() {
        this.color = DEFAULT_COLOR;
        this.text = "";
    }
    public Cell(Color color) {
        this.color = color;
        this.text = "";
    }
    public Cell(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

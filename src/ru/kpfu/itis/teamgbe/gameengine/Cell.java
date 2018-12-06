package ru.kpfu.itis.teamgbe.gameengine;

import java.awt.*;

public class Cell {
    private Color color;
    private String text;

    public Cell() {
    }

    public Cell(Color color) {
        this.color = color;
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

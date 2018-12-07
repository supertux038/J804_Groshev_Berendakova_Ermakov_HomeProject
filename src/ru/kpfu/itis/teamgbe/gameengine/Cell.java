package ru.kpfu.itis.teamgbe.gameengine;

import java.awt.*;

public class Cell {
    private final Color DEFAULTCOLOR = Color.WHITE;
    private Color color;
    private String text;

    public Cell() {
        this.color = DEFAULTCOLOR;
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

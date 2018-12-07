package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {
    private JPanel panel;
    private Timer timer;
    private final Game game;
    private boolean gridEnabled = true;
    private int gridThickness = 1;
    private Color gridColor = Color.BLACK;
    private Color textColor = Color.BLACK;

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

    public void draw() {
        //creating imageBuffer to swap it at a moment to reduce fps flicker
        BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bufferedImageGraphics = bufferedImage.createGraphics();
        int cellWidth = panel.getWidth()/game.getWIDTH();
        int cellHeight = panel.getHeight()/game.getHEIGHT();

        //drawing cells and its fields
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

        bufferedImageGraphics.dispose();

        //swapping buffers
        Graphics panelGraphics = panel.getGraphics();
        panelGraphics.drawImage(bufferedImage,0,0, null);
        panelGraphics.dispose();
    }
}

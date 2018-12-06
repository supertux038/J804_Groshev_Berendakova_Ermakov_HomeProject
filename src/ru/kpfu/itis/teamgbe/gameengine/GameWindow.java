package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow extends JFrame {
    private JPanel panel;
    private Timer timer;
    private final Game game;

    public  GameWindow(String windowLabel, int defaultWidth, int defaultHeight, Game game) {
        super(windowLabel);
        this.game = game;
        this.setBounds(0,0, defaultWidth, defaultHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        draw();
    }

    public GameWindow(String windowLabel, int defaultWidth, int defaultHeight, double fps, Game game) {
        super(windowLabel);
        this.game = game;
        this.setBounds(0,0, defaultWidth, defaultHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        timer = new Timer( (int)(1000 / fps), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });
        timer.start();
    }

    public void draw() {
        BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bufferedImageGraphics = bufferedImage.createGraphics();
        //Graphics bufferedImageGraphics = panel.getGraphics();
        bufferedImageGraphics.clearRect(0,0,panel.getWidth(), panel.getHeight());
        int cellWidth = panel.getWidth()/game.getWidth();
        int cellHeight = panel.getHeight()/game.getHeight();

        for(int i = 0; i < game.getHeight(); i++) {
            for(int j = 0; j < game.getWidth(); j++) {
                //game.gameField[i][j].setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
                bufferedImageGraphics.setColor(game.gameField[i][j].getColor());
                bufferedImageGraphics.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
                bufferedImageGraphics.setColor(Color.BLACK);
                bufferedImageGraphics.drawString(game.gameField[i][j].getText(),i*cellWidth + cellWidth/2,j*cellHeight + cellHeight/2);
            }
        }

        bufferedImageGraphics.setColor(Color.BLACK);
        for(int i = 1; i < game.getWidth(); i++) {
            bufferedImageGraphics.drawLine(i*cellWidth, 0, i*cellWidth, panel.getHeight());
        }
        for (int i = 1; i < game.getHeight(); i++) {
            bufferedImageGraphics.drawLine(0, i*cellHeight, panel.getWidth(), i*cellHeight);
        }

        bufferedImageGraphics.dispose();

        Graphics panelGraphics = panel.getGraphics();
        panelGraphics.drawImage(bufferedImage,0,0, null);
        panelGraphics.dispose();
    }
}

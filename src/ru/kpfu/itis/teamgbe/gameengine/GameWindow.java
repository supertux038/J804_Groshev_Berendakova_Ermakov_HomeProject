package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWindow extends JFrame {
    private JPanel panel;
    private Timer timer;
    private final Game game;

    public  GameWindow(String windowLabel, int defualtWidth, int defaultHeight, Game game) {
        super(windowLabel);
        this.game = game;
        this.setBounds(0,0, defualtWidth, defaultHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        draw();
    }

    public GameWindow(String windowLabel, int defualtWidth, int defaultHeight, double fps, Game game) {
        super(windowLabel);
        this.game = game;
        this.setBounds(0,0, defualtWidth, defaultHeight);
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
        Graphics g = panel.getGraphics();
        g.clearRect(0,0,panel.getWidth(), panel.getHeight());
        int cellWidth = panel.getWidth()/game.getWidth();
        int cellHeight = panel.getHeight()/game.getHeight();

        for(int i = 0; i < game.getHeight(); i++) {
            for(int j = 0; j < game.getWidth(); j++) {
                //game.gameField[i][j].setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
                g.setColor(game.gameField[i][j].getColor());
                g.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawString(game.gameField[i][j].getText(),i*cellWidth,j*cellHeight + cellHeight);
            }
        }

        g.setColor(Color.BLACK);
        for(int i = 1; i < game.getWidth(); i++) {
            g.drawLine(i*cellWidth, 0, i*cellWidth, panel.getHeight());
        }
        for (int i = 1; i < game.getHeight(); i++) {
            g.drawLine(0, i*cellHeight, panel.getWidth(), i*cellHeight);
        }

        g.dispose();
    }
}

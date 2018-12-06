package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private final int defualtWidth;
    private final int defaultHeight;
    private JPanel panel;
    private Timer timer;

    public GameWindow(String windowLabel, int defualtWidth, int defaultHeight, int fps) {
        super(windowLabel);
        this.defualtWidth = defualtWidth;
        this.defaultHeight = defaultHeight;
        this.setBounds(0,0, defualtWidth, defaultHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        timer = new Timer(1000 / fps, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });
    }

    private void draw() {
        Graphics g = panel.getGraphics();

        g.drawString("Hello world", 100, 100); //just an example
        //later there would be game drawing

        g.dispose();
    }
}

package ru.kpfu.itis.teamgbe.gameengine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //tests
        Gamefield gamefield = new Gamefield(10, 10);
        GameWindow window = new GameWindow("MyWindow", 800, 600, 30, gamefield);
        gamefield.gameField[0][0].setText("Я самая первая клетка");
        gamefield.gameField[1][1].setColor(Color.red);
        gamefield.gameField[1][1].setText("А я красная");
        gamefield.gameField[2][3].setText("Дискотека");
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamefield.gameField[2][3].setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            }
        });
        timer.start();
        try {
            gamefield.gameField[1][4].setImage(ImageIO.read(new File("C:/im.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

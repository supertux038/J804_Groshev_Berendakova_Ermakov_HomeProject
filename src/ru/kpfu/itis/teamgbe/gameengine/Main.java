package ru.kpfu.itis.teamgbe.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        //tests
        Game game = new Game(10, 10);
        GameWindow window = new GameWindow("MyWindow", 800, 600, 30, game);
        game.gameField[0][0].setText("Я самая первая клетка");
        game.gameField[1][1].setColor(Color.red);
        game.gameField[1][1].setText("А я красная");
        game.gameField[2][3].setText("Дискотека");
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameField[2][3].setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            }
        });
        timer.start();
    }
}

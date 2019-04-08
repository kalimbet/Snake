package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    public MainWindow(){
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1320,1040);
        setLocation(400, 10);
        add(new GameBody());
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args){

        MainWindow startGame = new MainWindow();
    }
}

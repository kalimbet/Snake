package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class GameBody extends JPanel implements ActionListener {


    Constants constants = new Constants();
    ItemAplle itemAplle = new ItemAplle(2,2);
    Hero hero = new Hero();
    UploadedImages uploadedImages = new UploadedImages();


    public int[] x = new int[constants.ALL_HERO_BODY];
    public int[] y = new int[constants.ALL_HERO_BODY];
    public boolean inGame = true;
    private Timer timer;

    int testX;
    int testY;

    LinkedList<ItemAplle> testList = new LinkedList<>();


    public GameBody(){
        setBackground(Color.BLACK);
        uploadedImages.loadImages();
        initGame();
        addKeyListener(new FieldKeyListtener());
        setFocusable(true);
    }

    public void initGame(){
        hero.startGame(x,y);
        timer = new Timer(220, this);
        timer.start();

        itemAplle.addAplle();
        testList = itemAplle.getList();
    }

    public void getItems(int numberItem){
        itemAplle = testList.get(numberItem);
        testX = itemAplle.getAppX();
        testY = itemAplle.getAppY();
    }


    public void checkApple(){
            for(int i = 0; i < itemAplle.getCondition(); i++){
                getItems(i);
                if(x[0] == testX && y[0] == testY){
                    hero.heroBody++;
                    hero.score += 100;
                    itemAplle.addAplle();
                }


        }
    }



    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //JButton restart = new JButton("RESTART");
        Font fontYouDied = g.getFont().deriveFont( 40.0f );
        Font fontScore = g.getFont().deriveFont( 40.0f );
        Font fontScoreEnd = g.getFont().deriveFont( 25.0f );
        if(inGame){
            //BACKGROUND
            g.setColor(constants.BACKGROUND_COLOR);
            g.fillRect(0,0, 1020,1040);

            //SCORE title
            g.setColor(Color.white);
            g.setFont(fontScore);
            g.drawString(constants.SCORE,1030,50);

            //SCORE number
            g.setColor(Color.white);
            g.setFont(fontScore);
            g.drawString(String.valueOf(hero.score),1030,100);



            for(int i = 0; i < itemAplle.getCondition(); i++){
                getItems(i);
                g.drawImage(uploadedImages.getApple(), testX, testY, this);      /////HEY LOOCK HERE!
            }
            for(int i = 0; i < hero.heroBody; i++){
                g.drawImage(uploadedImages.getDot(), x[i], y[i],this);
            }
        }else {
            g.setColor(Color.RED);
            g.setFont(fontYouDied);
            g.drawString(constants.YOU_DIED, 550, constants.SIZE/2);
            g.setFont(fontScoreEnd);
            g.drawString(constants.SCORE, 100, constants.SIZE/7);
            g.drawString(String.valueOf(hero.score), 250, constants.SIZE/7);

        }
    }


    public void move(){
        for(int i = hero.heroBody; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(hero.left){
            x[0] -= constants.HERO_BODY_SIZE;
        }
        if(hero.right){
            x[0] += constants.HERO_BODY_SIZE;
        }
        if(hero.up){
            y[0] -= constants.HERO_BODY_SIZE;
        }
        if(hero.down){
            y[0] += constants.HERO_BODY_SIZE;
        }
    }

    public void checkCollision(){
        for(int i = hero.heroBody; i > 0; i-- ){
            if(i > 3 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }
        }

        if(x[0] > constants.SIZE){
            inGame = false;
        }
        if(x[0] < 0){
            inGame = false;
        }
        if(y[0] > constants.SIZE){
            inGame = false;
        }
        if(y[0] < 0){
            inGame = false;
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }


    class FieldKeyListtener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();
            hero.moveHeroListener(key);
        }

    }
}

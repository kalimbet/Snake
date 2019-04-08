package com.company;


import java.awt.event.KeyEvent;


public class Hero {
    Constants constants = new Constants();
    public int heroBody;
    public boolean left = false;
    public boolean right = true;
    public boolean up = false;
    public boolean down = false;

    public int score = 0;


    public void startGame(int x[], int y[]){
        this.heroBody = 3;
        for(int i = 0; i < heroBody; i++){
            x[i] = 32 - i * constants.HERO_BODY_SIZE;
            y[i] = 32;
        }
    }


    public void moveHeroListener(int key){
        if(key == KeyEvent.VK_LEFT && !right){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_UP && !down){
            up = true;
            right = false;
            left = false;
        }
        if(key == KeyEvent.VK_DOWN && !up){
            down = true;
            right = false;
            left = false;
        }
    }

}

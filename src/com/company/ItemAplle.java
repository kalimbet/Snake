package com.company;

import java.util.LinkedList;
import java.util.Random;

public class ItemAplle {

    int appX;
    int appY;
    public int condition = 5;

    Constants constants = new Constants();

    LinkedList<ItemAplle> test = new LinkedList<>();


    ItemAplle(int x, int y){
        appX = x;
        appY = y;
    }



    public void createApple() {
        for(int i = 0; i < condition; i++){
            appX = new Random().nextInt(30) * constants.HERO_BODY_SIZE;
            appY = new Random().nextInt(30) * constants.HERO_BODY_SIZE;
        }

    }

    public LinkedList<ItemAplle> addAplle() {
        for(int i = 0; i < condition; i++){
            createApple();
            ItemAplle itemAplle = new ItemAplle(appX, appY);
            test.add(itemAplle);
        }
        return test;
    }


    public LinkedList<ItemAplle> getList(){
        return test;
    }


    public int getAppX() {

        return appX;
    }

    public int getAppY() {
        return appY;
    }
    public int getCondition(){
        return condition;
    }
}



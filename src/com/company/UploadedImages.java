package com.company;

import javax.swing.*;
import java.awt.*;

public class UploadedImages {



    public Image dot;
    public Image apple;




    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple32.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("snake32.png");
        dot = iid.getImage();
    }


    public Image getDot(){
        return dot;
    }

    public Image getApple(){
        return apple;
    }
}

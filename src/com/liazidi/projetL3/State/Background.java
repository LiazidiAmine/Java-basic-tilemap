package com.liazidi.projetL3.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by ghost on 09/11/15.
 */
public class Background {

    private BufferedImage image;

    public Background(String s){
        try{
            image = ImageIO.read(new File(s));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Image non chargé");
        }
    }

    public void update(){}

    public void draw(Graphics2D g){
        g.drawImage(image,0,0,null);
    }
}

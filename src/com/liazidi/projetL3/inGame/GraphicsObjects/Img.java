package com.liazidi.projetL3.inGame.GraphicsObjects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by ghost on 30/12/15.
 */
public class Img {

    private BufferedImage image = null;
    private String url;

    //////////////////////////////////////////////////////////////////////////////////////////////

    public Img(String url){
    	this.url = url;
        try{
            image = ImageIO.read(this.getClass().getResourceAsStream(url));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Image non chargé");
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public BufferedImage getImage(){
        return image;
    }

}

package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Entity;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

import java.awt.*;

/**
 * Created by ghost on 01/01/16.
 */
public class Knife extends Entity {

    private int force;
    //////////////////////////////////////////////////////////////

    public Knife(float x, float y, float angle){
        super(x,y,angle);
        this.force = 10;
        this.size = 2f;
    }


    /////////////////////////////////////////////////////////////

    public int getForce(){
        return force;
    }

    ////////////////////////////////////////////////////////////

    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect((int)(x* TileMap.TILESIZE),(int)(y*TileMap.TILESIZE),
                (int)size, (int)size);
    }
}

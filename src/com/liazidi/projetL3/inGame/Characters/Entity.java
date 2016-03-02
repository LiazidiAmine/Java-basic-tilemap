package com.liazidi.projetL3.inGame.Characters;

import com.liazidi.projetL3.inGame.GraphicsObjects.Img;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;


import java.awt.*;

/**
 * Created by ghost on 01/01/16.
 */
public abstract class Entity {

    protected float x;
    protected float y;
    protected float size;
    protected float angle;
    protected Img img;
    protected String name;

    ////////////////////////////////////////////////////////////////////////

    public Entity(float x, float y, float angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    ///////////////////////////////////////////////////////////////////////

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getSize(){
        return size;
    }

    public float getAngle(){
        return angle;
    }

    public String getName(){return name;}

    ///////////////////////////////////////////////////////////////////////////

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setAngle(float angle){
        this.angle = angle;
    }

    ///////////////////////////////////////////////////////////////////////////

    public Rectangle getRect(){
        return new Rectangle((int)(x+size)* TileMap.TILESIZE,
                (int)(y+size)*TileMap.TILESIZE,
                TileMap.TILESIZE,
                TileMap.TILESIZE);
    }





}

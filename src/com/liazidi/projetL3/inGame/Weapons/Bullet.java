package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.*;
import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

import java.awt.*;

/**
 * Created by ghost on 30/12/15.
 */
public class Bullet extends Entity {

    private boolean visible;
    private float speed;
    private int force;
    private Point point;
    private boolean destroyWall;
    private boolean destroyTile;
    private float distanceMax;
    private float distanceTraveled;


    //////////////////////////////////////////////////////////////////////////////////////////

    public Bullet(float x, float y, float ang, Point point, float size, float speed, int force){
        super(x,y,ang);
        this.visible = true;
        this.point = point;
        this.size = size;
        this.speed = speed;
        this.force = force;
        this.distanceTraveled = 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public boolean isVisible(){
        return visible;
    }
    public float getSpeed(){return speed;}
    public int getForce(){return force;}
    public boolean isDestroyWall(){return destroyWall;}
    public boolean isDestroyTile(){return destroyTile;}
    public float getDistanceMax(){return distanceMax; }
    public float getDistanceTraveled(){return distanceTraveled;}


    ////////////////////////////////////////////////////////////////////////////////////////

    public void setVisible(boolean b){visible = b;}
    public void setDestroyWall(boolean b){this.destroyWall = b;}
    public void setDestroyTile(boolean b){this.destroyTile = b;}
    public void setDistanceMax(float i){this.distanceMax = i;}

    @Override
    public Rectangle getRect(){
        return new Rectangle((int)(x)* TileMap.TILESIZE,
                (int)(y)*TileMap.TILESIZE,
                TileMap.TILESIZE,
                TileMap.TILESIZE);
    }

    //////////////////////////////////////////////////////////////////////////////////


    public void move(Character character){
        float diffX = character.getX() - point.getX();
        float diffY = character.getY() - point.getY();

        float angle = (float)(Math.atan2(diffY,diffX)- (Math.PI));

        x += speed*Math.cos(angle);
        y += speed*Math.sin(angle);

        distanceTraveled += speed*2;

    }


    public void draw(Graphics2D g){
        g.setColor(Color.RED);
        g.fillOval((int) (x * TileMap.TILESIZE), (int) (y * TileMap.TILESIZE),
                (int) size, (int) size);
    }




}

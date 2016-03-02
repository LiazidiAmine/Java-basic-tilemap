package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.Comportement.Shoot;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ghost on 06/01/16.
 */
public abstract class FireArm {

    protected int force;
    protected float speed;
    protected float size;
    protected String name;
    protected  boolean current;

    protected boolean destroyWall;
    protected boolean destroyTile;
    protected float distance;



    protected Character character;
    protected ArrayList<Bullet> bullets;
    protected Shoot shoot;
    protected int shootLimit;
    protected int shootIndice;

    /////////////////////////////////////////////////////////////////////////////////

    public FireArm(Character character){
        this.character = character;
        bullets = new ArrayList<Bullet>();
        shoot = new Shoot(bullets, character);
        this.shootIndice = 0;
    }

    /////////////////////////////////////////////////////////////////////////////////

    public float getSpeed(){
        return speed;
    }
    public int getForce(){
        return force;
    }
    public float getSize(){
        return size;
    }
    public String getName(){return name;}
    public boolean isCurrent(){return current;}
    public void setCurrent(boolean b){current = b;}
    public boolean isDestroyWall(){return destroyWall;}
    public boolean isDestroyTile(){return destroyTile;}
    public float getDistance(){return distance;}
    public int getShootLimit(){return shootLimit - shootIndice;}


    /////////////////////////////////////////////////////////////////////////////////

    public void fire(Point point) {
        if(shootIndice < shootLimit) {
            Bullet bullet = new Bullet(character.getX(), character.getY(), character.getAngle(), point, getSize(), getSpeed(),
                    getForce());
            bullet.setDestroyWall(isDestroyWall());
            bullet.setDestroyTile(isDestroyTile());
            bullet.setDistanceMax(getDistance());
            bullets.add(bullet);
            shootIndice++;
        }


    }

    /////////////////////////////////////////////////////////////////////////////////////


    public void update(ArrayList<Character> team){
    	if(character.isCurrent()){
    		shoot.deplacement();
        	shoot.collision(team);
    	}
    }

    public void draw(Graphics2D g){
        for(Bullet bullet : bullets){
            if(character.isCurrent()) {
                bullet.draw(g);
            }
        }
    }


}

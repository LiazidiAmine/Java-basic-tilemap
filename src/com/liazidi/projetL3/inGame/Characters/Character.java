package com.liazidi.projetL3.inGame.Characters;
import com.liazidi.projetL3.inGame.Comportement.*;
import com.liazidi.projetL3.inGame.GraphicsObjects.*;
import com.liazidi.projetL3.inGame.Weapons.*;
import com.liazidi.projetL3.inGame.Weapons.Point;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ghost on 09/11/15.
 */
public abstract class Character extends Entity {

    protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;

    protected int currentArm;

    protected float moveSpeed;
    protected int team;
    protected TileMap tileMap;
    protected boolean alive;
    protected boolean current;
    protected int health;

    //Attack
    protected Catapult catapult;
    protected MachineGun machineGun;
    protected Gun gun;
    protected SniperRifle sniperRifle;
    protected ShotGun shotGun;
    protected ArrayList<FireArm> fireArms;
    protected KnifeAttack knifeAttack;
    protected Med med;

    //////////////////////////////////////////////////////////////////////////////////////////////

    public Character(TileMap tileMap, int team, float x, float y) {
        super(x,y,0);
        this.tileMap = tileMap;
        this.team = team;
        this.alive = true;
        this.current = false;
        this.currentArm = 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public boolean isLeft(){
        return left;
    }
    public boolean isRight(){
        return right;
    }
    public boolean isUP(){
        return up;
    }
    public boolean isDown(){
        return down;
    }
    public boolean isAlive(){return alive;}
    public boolean isCurrent(){return current;}
    public float getMoveSpeed(){
        return moveSpeed;
    }
    public TileMap getTileMap(){
        return tileMap;
    }
    public int getHealth(){return health;}
    public int getTeam(){return team;}
    public int getCurrentArm(){return currentArm;}

    public ArrayList<FireArm> getFireArms(){return fireArms;}

    ///////////////////////////////////////////////////////////////////////////////

    public void setLeft(boolean b){left = b;}
    public void setRight(boolean b){right = b;}
    public void setUP(boolean b){up = b;}
    public void setDown(boolean b){down = b;}

    public void setAlive(boolean b){alive = b;}
    public void setCurrent(boolean b){current = b;}
    public void setHealth(int force){this.health += force;}
    public void setCurrentArm(int i){this.currentArm += i;}
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void deplacement(MoveCharacter moveCharacter){

        moveCharacter.deplacement();
    }

    public void fire(Point point){
        if(fireArms!=null) {
            for (FireArm a : fireArms) {
                if (a.isCurrent() && a != null) {
                    a.fire(point);
                }
            }
        }
    }

    public void nextArm(){

        if(fireArms!=null) {
            if (getCurrentArm() == fireArms.size())
                setCurrentArm(-getCurrentArm());
            if (getCurrentArm() < fireArms.size()) {
                fireArms.get(getCurrentArm()).setCurrent(true);
                for (FireArm a : fireArms)
                    if (!a.equals(fireArms.get(getCurrentArm())))
                        a.setCurrent(false);
                setCurrentArm(1);
            }
        }

    }

    public void attackKnife(ArrayList<Character> team){
        if(knifeAttack!=null)
            knifeAttack.knifeAttack(team);
    }

    public void med(ArrayList<Character> team){
        if (med!=null)
            med.med(team);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void draw(Graphics2D g){

        int xp = (int) (TileMap.TILESIZE * x);
        int yp = (int) (TileMap.TILESIZE * y);

        // rotate the image based on the current angle and then
        // draw it

        if(alive) {
            g.rotate(angle, xp, yp);
            g.drawImage(img.getImage(), (xp - 16), (yp - 16), null);
            g.rotate(-angle, xp, yp);
        }
        ////////////////////////////////////////////

        if(fireArms!=null && fireArms.size()>0){
            for (FireArm a : fireArms) {
                a.draw(g);
            }
        }

    }


}


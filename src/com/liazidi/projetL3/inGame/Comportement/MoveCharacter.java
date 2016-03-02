package com.liazidi.projetL3.inGame.Comportement;

import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ghost on 25/12/15.
 */
public class MoveCharacter {

    private Character character;
    private ArrayList<Character> team;


    ///////////////////////////////////////////////////////////////////////////////

    public MoveCharacter(ArrayList<Character> team){
        this.team = team;

    }

    ///////////////////////////////////////////////////////////////////////////////

    public void setCharacter(Character character){
        this.character = character;
    }

    ///////////////////////////////////////////////////////////////////////////////

    public void deplacement(){

        float dx = 0;
        float dy = 0;
        if(character.isLeft()){
            dx -= 2;
            }
        if(character.isRight()){
            dx += 2;
               }
        if(character.isUP()){
            dy -= 2;
        }
        if(character.isDown()){
            dy += 2;
        }
        if((dx != 0) || (dy != 0)) {//if movement not null
            move(dx * character.getMoveSpeed(), dy * character.getMoveSpeed());

        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    public boolean move(float dx, float dy){
        float nx = character.getX() + dx;
        float ny = character.getY() + dy;

        if(validLocation(nx,ny)){
            character.setX(nx);
            character.setY(ny);

            //determine angle of character based on his movement
            float ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
            character.setAngle(ang);


            return true;
        }

        return false;

    }

    //////////////////////////////////////////////////////////////////////////////////

    // Return TRUE if collision between r & r2
    public boolean collides(Rectangle r, Rectangle r2){
        return r.intersects(r2);
    }

    ///////////////////////////////////////////////////////////////////////////////////

    //Determine if next position is valid
    public boolean validLocation(float nx, float ny) {

        Rectangle r = new Rectangle((int) (nx-character.getSize()) * TileMap.TILESIZE,
                (int) (ny-character.getSize()) * TileMap.TILESIZE,
                TileMap.TILESIZE, TileMap.TILESIZE);

        for (Character c : team){ //MoveCharacter teammates & enemies
            if (!character.equals(c) && collides(r,c.getRect())) {
                return false;
            }
        }

        if (character.getTileMap().isBlock(nx - character.getSize(), ny - character.getSize())) {
            return false;
        }
        if (character.getTileMap().isBlock(nx + character.getSize(), ny - character.getSize())) {
            return false;
        }
        if (character.getTileMap().isBlock(nx - character.getSize(), ny + character.getSize())) {
            return false;
        }
        if (character.getTileMap().isBlock(nx + character.getSize(), ny + character.getSize())) {
            return false;
        }
        if(character.getTileMap().isWater(nx,ny)){
            return false;
        }

        return true;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////


}

package com.liazidi.projetL3.inGame.Comportement;

import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;
import com.liazidi.projetL3.inGame.Weapons.Knife;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ghost on 31/12/15.
 */
public class KnifeAttack {

    private Character character;
    private Knife knife;
    private String name;


    ////////////////////////////////////////////////////////////////////////////

    public KnifeAttack(Character character){

        this.character = character;
        knife = new Knife(character.getX(),character.getY(),character.getAngle());
        this.name = "Knife";
    }


    /////////////////////////////////////////////////////////////////////////

    public void knifeAttack(ArrayList<Character> team){

        if(team.size() > 0){
            Rectangle r = new Rectangle((int)(character.getX()*TileMap.TILESIZE),
                    (int)(character.getY()*TileMap.TILESIZE),TileMap.TILESIZE+1,TileMap.TILESIZE+1);
            for(Character c : team){
                if(!character.equals(c) && character.getTeam()!=c.getTeam() &&
                        r.intersects(c.getRect())){
                    c.setHealth(-knife.getForce());
                }
            }
        }

    }

    public void draw(Graphics2D g){

        g.setColor(Color.BLUE);
        g.fillRect((int)(knife.getX()* TileMap.TILESIZE), (int)(knife.getY()* TileMap.TILESIZE),
                (int)knife.getSize(), (int)knife.getSize());

    }


}

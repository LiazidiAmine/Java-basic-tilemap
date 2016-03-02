package com.liazidi.projetL3.inGame.Comportement;

import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;
import com.liazidi.projetL3.inGame.Weapons.Medoc;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ghost on 01/01/16.
 */
public class Med {

    private Character character;
    private Medoc medoc;
    private String name;

    //////////////////////////////////////////////////////////////////////////

    public Med(Character character) {
        this.character = character;
        this.medoc = new Medoc();
        this.name = "Medoc";

    }

    //////////////////////////////////////////////////////////////////////////

    public void med(ArrayList<Character> team) {

        if(team.size() > 0){
            Rectangle r = new Rectangle((int)(character.getX()*TileMap.TILESIZE),
                    (int)(character.getY()*TileMap.TILESIZE),TileMap.TILESIZE+1,TileMap.TILESIZE+1);
            for(Character c : team){
                if(!character.equals(c) && character.getTeam()==c.getTeam() &&
                        r.intersects(c.getRect())){
                    c.setHealth(medoc.getHealth());
                }
            }
        }
    }
}

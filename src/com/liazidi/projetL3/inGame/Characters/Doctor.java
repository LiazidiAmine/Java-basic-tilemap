package com.liazidi.projetL3.inGame.Characters;

import com.liazidi.projetL3.inGame.Comportement.Med;
import com.liazidi.projetL3.inGame.GraphicsObjects.Img;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

/**
 * Created by ghost on 31/12/15.
 */
public class Doctor extends Character {


    private final String s = "/sprite.gif";

    public Doctor(TileMap tileMap, int team, float x, float y){
        super(tileMap, team, x, y);

        this.moveSpeed = 0.03f;
        img = new Img(s);
        this.name = "Toubib";
        med = new Med(this);
        this.health = 80;

    }
}

package com.liazidi.projetL3.inGame.Characters;

import com.liazidi.projetL3.inGame.Comportement.KnifeAttack;
import com.liazidi.projetL3.inGame.GraphicsObjects.Img;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

/**
 * Created by ghost on 11/11/15.
 */
public class Civil extends Character {

    private final String s = "/sprite.gif";

    public Civil(TileMap tileMap, int team, float x, float y) {
        super(tileMap, team, x, y);
        this.moveSpeed = 0.03f;
        img = new Img(s);
        this.knifeAttack = new KnifeAttack(this);
        this.name = "Civil";
        this.health = 80;
    }



}

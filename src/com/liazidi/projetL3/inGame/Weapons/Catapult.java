package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Character;


/**
 * Created by ghost on 09/01/16.
 */
public class Catapult extends FireArm {

    public Catapult(Character character){
        super(character);
        this.force = 20;
        this.speed = 0.2f;
        this.size = 3.5f;
        this.name = "Grenade";
        this.shootLimit = 3;
        this.destroyWall = true;
        this.distance = 4;
        this.destroyTile = true;
    }
}

package com.liazidi.projetL3.inGame.Weapons;

/**
 * Created by ghost on 06/01/16.
 */

import com.liazidi.projetL3.inGame.Characters.Character;

public class SniperRifle extends FireArm {


    public SniperRifle(Character character){
        super(character);
        this.speed = 1f;
        this.force = 15;
        this.size = 5f;
        this.name = "Sniper R";
        this.shootLimit = 3;
        this.destroyWall = false;
        this.distance = 20;
    }
}

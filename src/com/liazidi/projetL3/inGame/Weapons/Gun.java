package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Character;

/**
 * Created by ghost on 06/01/16.
 */
public class Gun extends FireArm {

    public Gun(Character character){
        super(character);
        this.force = 3;
        this.speed = 0.45f;
        this.size = 4f;
        this.name = "Gun";
        this.shootLimit = 10;
        this.destroyWall = false;
        this.distance = 10;
    }
}

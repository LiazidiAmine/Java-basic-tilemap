package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Character;

/**
 * Created by ghost on 06/01/16.
 */
public class ShotGun extends FireArm {

    public ShotGun(Character character){
        super(character);
        this.force = 15;
        this.speed = 0.6f;
        this.size = 5f;
        this.name = "Shot Gun";
        this.shootLimit = 5;
        this.destroyWall = true;
        this.distance = 5;
    }
}

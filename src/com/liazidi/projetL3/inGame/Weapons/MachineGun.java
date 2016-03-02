package com.liazidi.projetL3.inGame.Weapons;

import com.liazidi.projetL3.inGame.Characters.Character;

/**
 * Created by ghost on 06/01/16.
 */
public class MachineGun extends FireArm {

    ////////////////////////////////////////////

    public MachineGun(Character character){
        super(character);
        this.force = 5;
        this.speed = 0.65f;
        this.size = 3.5f;
        this.name = "M Gun";
        this.shootLimit = 30;
        this.destroyWall = false;
        this.distance = 10;
    }


}

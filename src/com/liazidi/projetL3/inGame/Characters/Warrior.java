package com.liazidi.projetL3.inGame.Characters;

import com.liazidi.projetL3.inGame.Comportement.KnifeAttack;
import com.liazidi.projetL3.inGame.GraphicsObjects.Img;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;
import com.liazidi.projetL3.inGame.Weapons.*;

import java.util.ArrayList;

/**
 * Created by ghost on 31/12/15.
 */
public class Warrior extends Character{

    private final String s = "/sprite.gif";

    public Warrior(TileMap tileMap, int team, float x, float y){
        super(tileMap, team, x, y);

        this.moveSpeed = 0.04f;
        img = new Img(s);

        this.fireArms = new ArrayList<FireArm>();
        this.knifeAttack = new KnifeAttack(this);
        this.machineGun = new MachineGun(this);
        fireArms.add(machineGun);
        this.shotGun = new ShotGun(this);
        fireArms.add(shotGun);
        this.gun = new Gun(this);
        fireArms.add(gun);
        this.catapult = new Catapult(this);
        fireArms.add(catapult);
        this.name = "Warrior";

        this.health = 120;

    }
}

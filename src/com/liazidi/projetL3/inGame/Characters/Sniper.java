package com.liazidi.projetL3.inGame.Characters;

import com.liazidi.projetL3.inGame.Comportement.KnifeAttack;
import com.liazidi.projetL3.inGame.GraphicsObjects.Img;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;
import com.liazidi.projetL3.inGame.Weapons.*;

import java.util.ArrayList;

/**
 * Created by ghost on 09/11/15.
 */
public class Sniper extends Character {

    private final String s = "/sprite.gif";

    /////////////////////////////////////////////////////////////

    public Sniper(TileMap tileMap, int team, float x, float y) {
        super(tileMap, team, x, y);
        this.moveSpeed = 0.035f;
        img = new Img(s);

        this.name = "Sniper";

        this.fireArms = new ArrayList<FireArm>();
        this.knifeAttack = new KnifeAttack(this);
        this.machineGun = new MachineGun(this);
        fireArms.add(machineGun);
        this.shotGun = new ShotGun(this);
        fireArms.add(shotGun);
        this.gun = new Gun(this);
        fireArms.add(gun);
        this.sniperRifle = new SniperRifle(this);
        fireArms.add(sniperRifle);

        this.health = 100;

    }

    /////////////////////////////////////////////////////////////



}

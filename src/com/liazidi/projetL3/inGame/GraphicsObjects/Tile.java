package com.liazidi.projetL3.inGame.GraphicsObjects;

import com.liazidi.projetL3.inGame.Characters.Entity;

import java.awt.*;

/**
 * Created by ghost on 24/12/15.
 */
public class Tile extends Entity{

    private Color color;
    private boolean block;

    ////////////////////////////////////////////////////////////

    public Tile(Color color, float x, float y, boolean block){
        super(x,y,0);
        this.color = color;
        this.block = block;
    }

    //////////////////////////////////////////////////////////////

    public Color getColor(){
        return color;
    }
    public boolean isBlock(){
        return block;
    }

    //////////////////////////////////////////////////////////////


    public void draw(Graphics2D g){
        g.setColor(getColor());
        int xf = (int) x;
        int yf = (int) y;
        g.fillRect(xf, yf, TileMap.TILESIZE, TileMap.TILESIZE);
    }
}

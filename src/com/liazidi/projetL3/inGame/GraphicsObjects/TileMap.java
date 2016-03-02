package com.liazidi.projetL3.inGame.GraphicsObjects;

import java.awt.Color;
import java.awt.Graphics2D;


public class TileMap {
    /** The value indicating a clear cell */
    public static final int CLEAR = 0;
    /** The value indicating a blocked cell */
    public static final int BLOCKED = 1;
    /** The value indicating a water cell */
    public static final int WATER = 2;
    /** The width in grid cells of our map */
    public static final int WIDTH = 15;
    /** The height in grid cells of our map */
    public static final int HEIGHT = 15;
    /** The rendered SIZE of the tile (in pixels) */
    public static final int TILESIZE = 20;
    /** The actual data for our map */
    private int[][] data = new int[WIDTH][HEIGHT];


    ///////////////////////////////////////////////////////////////////////////////////

    public TileMap() {

        for (int y=0;y<HEIGHT;y++) {
            data[0][y] = BLOCKED;
            data[WIDTH-1][y] = BLOCKED;
        }
        for(int i=0; i<HEIGHT; i+=2){
        	for(int y=0; y<WIDTH; y+=3)
        		data[i][y]=BLOCKED;
        }

        
        
        
        for (int x=0;x<WIDTH;x++) {
        	
            data[x][0] = BLOCKED;
            data[x][HEIGHT-1] = BLOCKED;
        }
    }


    public void draw(Graphics2D g) {

        for (int x=0;x<WIDTH;x++) {
            //System.out.println();
            for (int y=0;y<HEIGHT;y++) {

                g.setColor(Color.darkGray);
                if (data[x][y] == BLOCKED) {
                    g.setColor(Color.gray);
                }
                if(data[x][y] == WATER) {
                    g.setColor(Color.BLUE);
                }

                g.fillRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);
            }
        }
        g.setColor(Color.WHITE);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    public void setValue(int x, int y, int v){
        data[x][y]=v;
    }

    public boolean isBlock(float x, float y) {
        return data[(int) x][(int) y] == BLOCKED;
    }

    public boolean isWater(float x, float y) { return data[(int)x][(int)y] == WATER;}
}

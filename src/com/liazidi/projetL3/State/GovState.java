package com.liazidi.projetL3.State;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by ghost on 09/11/15.
 */
public class GovState extends GameState {

    //private Background bg;
    private Color titleColor;
    private Font titleFont;
    public static int player;

    /////////////////////////////////////////////////////////
    public GovState(GameStateManager gsm){
        this.gsm = gsm;

        /**try {

         bg = new Background("menubg.gif");
         }catch (Exception e){
         e.printStackTrace();
         }**/

        titleColor = Color.RED;
        titleFont = new Font("Century Gothic", Font.PLAIN, 28);

    }

    public void init(){}
    public void update(){}
    public void draw(Graphics2D g){

//        bg.draw(g);

        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Vinqueur Joueur "+player,15,70);

    }

    @Override
    public void keyPressed(int k) {}

    @Override
    public void keyReleased(int k) {}

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent){}

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}


}

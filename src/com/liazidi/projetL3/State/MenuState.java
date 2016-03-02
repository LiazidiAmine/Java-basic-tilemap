package com.liazidi.projetL3.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by ghost on 09/11/15.
 */
public class MenuState extends GameState {

    private int currentChoice = 0;

    //Presentation
    //private Background bg;

    private String[] options = {
            "Start",
            "Help",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont;
    private Font font;

    /////////////////////////////////////////////////////////
    public MenuState(GameStateManager gsm){
        this.gsm = gsm;

        /**try {

         bg = new Background("menubg.gif");
         }catch (Exception e){
         e.printStackTrace();
         }**/
        titleColor = Color.BLUE;
        titleFont = new Font("Century Gothic", Font.PLAIN, 28);
        font = new Font("Arial", Font.PLAIN, 12);


    }

    public void init(){}
    public void update(){}
    public void draw(Graphics2D g){

//        bg.draw(g);

        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("L3 PROJET",70,70);

        //draw menu option
        g.setFont(font);
        for(int i=0;i<options.length;i++){
            if(i==currentChoice){
                g.setColor(Color.BLUE);
            }
            else{
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i],130,140+ i * 15);
        }
    }

    private void select(){
        if(currentChoice == 0){
            gsm.setState(GameStateManager.PLAYSTATE);
        }
        if(currentChoice == 1){
            //gsm.setState(GameStateManager.PLAYSTATE);
        }
        if(currentChoice == 2){
            System.exit(0);
        }
    }
    @Override
    public void keyPressed(int k) {

        if(k == KeyEvent.VK_ENTER)
        {
            select();
        }
        if(k == KeyEvent.VK_UP)
        {
            currentChoice --;
            if(currentChoice == -1){
                currentChoice = options.length -1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }

    }

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

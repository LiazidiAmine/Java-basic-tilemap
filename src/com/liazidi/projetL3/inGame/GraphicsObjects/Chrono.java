package com.liazidi.projetL3.inGame.GraphicsObjects;

import com.liazidi.projetL3.inGame.Characters.Character;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by ghost on 11/11/15.
 */
public class Chrono extends Component {

    private static final long serialVersionUID = 1L;

    private static Font f;
    private Color color;

    private Timer timer;

    private int timeRemainig;
    private int time;

    private int cpt = 0;
    private int player=1;
    public int player(){return player;}

    ////////////////////////////////////////////////////////////////////////////////////////////
    public Chrono(int N, ArrayList<Character> team){
        color = Color.orange;
        f  = new Font("Book Antiqua", Font.BOLD,8 );

        timer = createTimer();
        timer.start();
        setPreferredSize(new Dimension(24, 24));
        this.setTimeRemainig(N);
        this.setTime(N);
    }

    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }

    private Timer createTimer(){
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(timeRemainig>0){
                    timeRemainig--;
                    repaint();
                    ++cpt;
                }
                else {
                    timer.stop();
                    if(cpt % 2 == 0){
                        player = 1;
                    }else{
                        player = 2;
                    }
                    setTimeRemainig(15);
                    timer.start();
                }

            }
        };
        return new Timer(1000, action);
    }

    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r){
        cg.setColor(Color.WHITE);
        cg.fillOval(xCenter-r, yCenter-r,2*r,2*r);
        cg.setColor(color);
        cg.fillArc(xCenter-r, yCenter-r, 2*r, 2*r, 90, -(360-timeRemainig*360/time));
        cg.setColor(Color.black);
        cg.setFont(f);
        if(timeRemainig>9){
            cg.drawString(""+this.timeRemainig,284,13);
        }
        else {
            cg.drawString("0"+this.timeRemainig,284,13);
        }
    }


    public void paintComponent(Graphics g){
        this.drawCircle(g, 290, 10, 10);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getTimeRemainig(){
        return timeRemainig;
    }

    public void setTimeRemainig(int timeRemainig){
        this.timeRemainig = timeRemainig;
    }

    public void setTime(int time){
        this.time=time;
    }


}

package com.liazidi.projetL3.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by ghost on 09/11/15.
 */
public class GameStateManager {

    //Listing gameState
    private ArrayList<GameState> gameStates;
    private int currentState;

    public static final int MENUSTATE = 0;
    public static final int PLAYSTATE = 1;
    public static final int GOVSTATE = 2;

    public int getCurrentState(){
        return currentState;
    }

    public GameStateManager(){
        gameStates = new ArrayList<GameState>();

        //First menu
        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new PlayState(this));
        gameStates.add(new GovState(this));
    }

    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void update(){
        gameStates.get(currentState).update();
    }
    public void draw(Graphics2D g){
        gameStates.get(currentState).draw(g);
    }
    public void keyPressed(int k){
        gameStates.get(currentState).keyPressed(k);
    }
    public void keyReleased(int k){
        gameStates.get(currentState).keyReleased(k);
    }
    public void mouseClicked(MouseEvent mouseEvent){gameStates.get(currentState).mouseClicked(mouseEvent);}
    public void mousePressed(MouseEvent mouseEvent){gameStates.get(currentState).mousePressed(mouseEvent);}
    public void mouseReleased(MouseEvent mouseEvent){gameStates.get(currentState).mouseReleased(mouseEvent);}
    public void mouseEntered(MouseEvent mouseEvent){gameStates.get(currentState).mouseEntered(mouseEvent);}
    public void mouseExited(MouseEvent mouseEvent){gameStates.get(currentState).mouseExited(mouseEvent);}





}

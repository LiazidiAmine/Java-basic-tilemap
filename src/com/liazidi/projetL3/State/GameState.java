package com.liazidi.projetL3.State;

import java.awt.event.MouseEvent;

/**
 * Created by ghost on 09/11/15.
 */
public abstract class GameState {

    protected GameStateManager gsm;

    public abstract void init();
    public abstract void update();
    public abstract void draw(java.awt.Graphics2D g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
    public abstract void mouseClicked(MouseEvent mouseEvent);
    public abstract void mouseReleased(MouseEvent mouseEvent);
    public abstract void mousePressed(MouseEvent mouseEvent);
    public abstract void mouseEntered(MouseEvent mouseEvent);
    public abstract void mouseExited(MouseEvent mouseEvent);

}

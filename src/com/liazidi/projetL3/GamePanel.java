package com.liazidi.projetL3;

import com.liazidi.projetL3.State.GameStateManager;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by ghost on 08/11/15.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {

    //dimensions
    public static final int WIDTH = TileMap.TILESIZE * TileMap.WIDTH;
    public static final int HEIGHT = TileMap.TILESIZE * TileMap.HEIGHT;
    public static final int HEIGHTT = HEIGHT + 120;
    public static final Font f  = new Font("Book Antiqua", Font.BOLD,14 );
    public static final Font f1  = new Font("Book Antiqua", Font.ITALIC,10 );

    private Thread thread;
    public boolean running;
    private int FPS = 30;
    private int targetTime = 1000 / FPS;

    private BufferedImage image;
    private static Graphics2D g;

    private GameStateManager gsm;

    public static Graphics2D getG(){return g;}



    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHTT));
        setFocusable(true);
        requestFocus();


    }

    public void addNotify(){
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(this);
        addMouseListener(this);
    }

    private void init(){
        running = true;

        image = new BufferedImage(WIDTH, HEIGHTT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        gsm = new GameStateManager();


    }

    public void run(){

        init();

        long starTime;
        long urdTime;
        long waitTime;

        //game loop
        while(running){

            starTime = System.nanoTime();

            update();
            render();
            draw();

            urdTime = (System.nanoTime() - starTime) / 1000000;
            waitTime = targetTime - urdTime;
            if(waitTime<0)
                waitTime=waitTime*(-1);

            try {
                Thread.sleep(waitTime);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


    ////////////////////////////////////////////////////////////////
    private void update(){
            gsm.update();

    }

    private void render(){
        gsm.draw(g);
    }

    private void draw(){
            Graphics g2 = getGraphics();
            g2.drawImage(image, 0, 0, WIDTH, HEIGHTT, null);
            g2.dispose();
    }

    public void keyTyped(KeyEvent key){}
    public void keyPressed(KeyEvent key){gsm.keyPressed(key.getKeyCode());}
    public void keyReleased(KeyEvent key){
        gsm.keyReleased(key.getKeyCode());
    }


    public void mouseClicked(MouseEvent mouseEvent) {gsm.mouseClicked(mouseEvent);}
    public void mousePressed(MouseEvent mouseEvent) {}
    public void mouseReleased(MouseEvent mouseEvent) {}
    public void mouseEntered(MouseEvent mouseEvent) {}
    public void mouseExited(MouseEvent mouseEvent) {}
}

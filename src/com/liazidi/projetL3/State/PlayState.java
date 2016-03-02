package com.liazidi.projetL3.State;

import com.liazidi.projetL3.inGame.Characters.*;
import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.Comportement.MoveCharacter;
import com.liazidi.projetL3.inGame.GraphicsObjects.Chrono;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;
import com.liazidi.projetL3.inGame.Weapons.*;
import com.liazidi.projetL3.inGame.Weapons.Point;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class PlayState extends GameState {

    private TileMap tileMap;
    private ArrayList<Character> allCharacters;
    private Chrono chrono;
    private MoveCharacter moveCharacter;
    private Character character;
    private int indexTeam1 = 0;
    private int indexTeam2 = 0;
    private ArrayList<Character> teamOne;
    private ArrayList<Character> teamTwo;
    /////////////////////////////////////////////////////////////////////////

    public PlayState(GameStateManager gsm) {

        this.gsm = gsm;

        tileMap = new TileMap();
        allCharacters = new ArrayList<>();

        allCharacters.add(new Sniper(tileMap, 1, 1.5f, 3.5f));
        allCharacters.add(new Sniper(tileMap, 2, 13.5f, 3.5f));
        allCharacters.add(new Civil(tileMap, 1, 1.5f, 6.5f));
        allCharacters.add(new Civil(tileMap, 2, 13.5f, 6.5f));
        allCharacters.add(new Doctor(tileMap, 1, 1.5f, 9.5f));
        allCharacters.add(new Doctor(tileMap, 2, 13.5f, 9.5f));
        allCharacters.add(new Warrior(tileMap, 1, 1.5f, 12.5f));
        allCharacters.add(new Warrior(tileMap, 2, 13.5f, 12.5f));

        moveCharacter = new MoveCharacter(allCharacters);

        teamOne = new ArrayList<Character>();
        teamTwo = new ArrayList<Character>();

        for(Character c : allCharacters){
            if(c.getTeam() == 1)
                teamOne.add(c);
            else
                teamTwo.add(c);
        }

        character = teamOne.get(0);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void updateTeam() {

        if (!allCharacters.equals(null) && allCharacters.size() > 0) {

            for (int i = 0; i < allCharacters.size(); i++) {
                Character perso = allCharacters.get(i);
                if (perso.getHealth() == 0 || perso.getHealth() < 0){
                    if(perso.getTeam() == 1)
                        teamOne.remove(perso);
                    if(perso.getTeam() == 2)
                        teamTwo.remove(perso);
                    perso.setAlive(false);
                    allCharacters.remove(perso);

                }
            }
        }

    }

    public void init(){
        chrono = new Chrono(15, allCharacters);
        chrono.start();
    }
    public void change(){
        if(chrono!=null){
        	if (chrono.getTimeRemainig() == 0 && allCharacters.size()>0) {
        		for (Character c : allCharacters)
        			c.setCurrent(false);
        	}
        }

    }
    public void selectNextPlayer1() {
        if(chrono.player() == 1) {
            if (indexTeam1 >= teamOne.size() || indexTeam1 < 0)
                indexTeam1 = 0;
            character = teamOne.get(indexTeam1);
            character.setCurrent(true);
            indexTeam1++;
        }else{
            if (indexTeam2 >= teamTwo.size() || indexTeam2 < 0)
                indexTeam2 = 0;
            character = teamTwo.get(indexTeam2);
            character.setCurrent(true);
            indexTeam2++;
        }
        for (Character c : allCharacters) {
            if (!c.equals(character))
                c.setCurrent(false);
        }
    }

    public boolean gameOver(){
        int i = 0;
        int y = 0;
        for (Character c : teamOne) {
            i++;
        }
        for(Character c : teamTwo){
            y++;
        }
        return (i==0 || y==0);
    }

    public void update(){
        change();
        if(character!=null && character.isCurrent()) {
            moveCharacter.setCharacter(character);
            character.deplacement(moveCharacter);
            updateTeam();
        }

        for(Character c : allCharacters) {
            if (c.getFireArms()!=null && c.getFireArms().size() > 0) {
                for (FireArm a : c.getFireArms()) {
                    a.update(allCharacters);
                }
            }
        }

        if(gameOver()){
        	GovState.player = allCharacters.get(0).getTeam();
        	gsm.setState(GameStateManager.GOVSTATE);
        }




    }

    public void draw(Graphics2D g){
        tileMap.draw(g);

        int x = 0;
        int y = 310;
        g.setColor(Color.BLUE);
        g.fillRect(0,300,300,120);
        g.setColor(Color.BLACK);
        for(int index = 0; index< allCharacters.size(); index++) {
            Character c = allCharacters.get(index);
            c.draw(g);
            if(c.isAlive()) {
                if(c.isCurrent())
                    g.setColor(Color.YELLOW);
                g.drawString(c.getTeam()+" "+c.getName()+" "+c.getHealth(), x, y);
                g.setColor(Color.BLACK);
                int i = 70;
                if (c.getFireArms() != null) {
                    for (FireArm a : c.getFireArms()) {
                        if (a.isCurrent())
                            g.setColor(Color.YELLOW);
                        if(a.getShootLimit() == 0)
                            g.setColor(Color.RED);
                        g.drawString(a.getName(), i, y);
                        g.setColor(Color.BLACK);
                        i += 50;
                    }
                }
                y += 10;
            }

        }
        if(chrono!=null){
        	chrono.paintComponent(g);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void keyPressed(int k){

        if(k == KeyEvent.VK_Q) {
            character.setLeft(true);
        }
        if(k == KeyEvent.VK_D) {
            character.setRight(true);
        }
        if(k == KeyEvent.VK_Z) {
            character.setUP(true);
        }
        if(k == KeyEvent.VK_S) {
            character.setDown(true);
        }
        if(k == KeyEvent.VK_A) {
            character.nextArm();
        }
        if(k == KeyEvent.VK_E) {
            character.attackKnife(allCharacters);
        }
        if(k == KeyEvent.VK_R){
            character.med(allCharacters);
        }
        if(k == KeyEvent.VK_V){
            selectNextPlayer1();
        }
    }

    @Override
    public void keyReleased(int k) {

        if (k == KeyEvent.VK_Q) {
            character.setLeft(false);
        }
        if (k == KeyEvent.VK_D) {
            character.setRight(false);
        }
        if (k == KeyEvent.VK_Z) {
            character.setUP(false);
        }
        if (k == KeyEvent.VK_S) {
            character.setDown(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        float x = (float)mouseEvent.getX() / TileMap.TILESIZE;
        float y = (float)mouseEvent.getY() / TileMap.TILESIZE;
        Point p = new Point(x,y);
        character.fire(p);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


}
package com.liazidi.projetL3.inGame.Comportement;

import com.liazidi.projetL3.GamePanel;
import com.liazidi.projetL3.inGame.Characters.Character;
import com.liazidi.projetL3.inGame.Weapons.Bullet;
import com.liazidi.projetL3.inGame.GraphicsObjects.TileMap;

import java.util.ArrayList;

/**
 * Created by ghost on 03/01/16.
 */
public class Shoot {

    private ArrayList<Bullet> bullets;
    private Character character;
    private static int WIDTH = GamePanel.WIDTH / TileMap.TILESIZE;
    private static int HEIGHT = GamePanel.HEIGHT / TileMap.TILESIZE;

    public Shoot(ArrayList<Bullet> bullets, Character character){
        this.bullets = bullets;
        this.character = character;
    }

    public void validLocation(Bullet bullet){
        int nx =(int) (bullet.getX() + bullet.getSpeed());
        int ny =(int) (bullet.getY() + bullet.getSpeed());

        if (nx > WIDTH || ny > HEIGHT || character.getTileMap().isBlock(nx, ny)) {
            bullet.setVisible(false);
        }
        if(nx < 14 && ny < 14 && nx > 0 && ny > 0)
            if(character.getTileMap().isBlock(nx, ny) && bullet.isDestroyWall()){
                bullet.setVisible(false);
                character.getTileMap().setValue(nx,ny,0);
            }
        if(bullet.getDistanceMax() < (bullet.getDistanceTraveled()+0.1f) && bullet.isDestroyTile()){
            if(bullet.getX()>0 && bullet.getX() < 14 && bullet.getY() > 0 && bullet.getY() < 14){
                character.getTileMap().setValue((int)bullet.getX(), (int)bullet.getY(),2);
            }
        }

    }

    public void deplacement(){
        for (int i = 0; i < bullets.size(); i++) {

            Bullet m = bullets.get(i);

                if (m.isVisible() && m.getDistanceTraveled() < m.getDistanceMax()) {


                    m.move(character);
                    validLocation(m);


                } else {
                    bullets.remove(i);
                }
        }
    }

    public void collision(ArrayList<Character> team){

        if(team.size() > 0 && bullets.size() > 0){
            Bullet bullet = bullets.get(0);
            for(Character c : team){
                if(!character.equals(c) && character.getTeam()!=c.getTeam() &&
                        bullet.getRect().intersects(c.getRect())){
                    c.setHealth(-bullet.getForce());
                    bullet.setVisible(false);
                }
            }
        }

    }


}

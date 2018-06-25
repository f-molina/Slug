/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 *
 * @author Frank
 */
public class Menu extends BasicGameState{

    Image playNow, exitGame, bck;
    public static final int ID = 1;
    Music music;
    
    @Override
    public int getID() {
        return Menu.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        music = new Music("data/song.ogg");
        playNow = new Image("data/play.png");
        exitGame = new Image("data/quit.png");
        bck = new Image("data/war.png");
        
        music.play();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bck.draw(0,0);
        g.drawString("Slug Test", 100, 50);
        playNow.draw(600,100);
        exitGame.draw(600,200);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        //falta posicion mouse en Y
        if((posX>600 && posX<880) && (posY>280 && posY<420)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(2);
            }
        }
        
        if((posX>600 && posX<880) && (posY>280 && posY<330)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
    
    
    
    
}

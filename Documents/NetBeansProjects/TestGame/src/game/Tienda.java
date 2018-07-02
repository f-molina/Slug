/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author fmolina
 */
public class Tienda extends BasicGameState{
    
    Image bck, soldier, ret, coin;
    public static final int ID = 3;

    @Override
    public int getID() {
        return Tienda.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bck = new Image("data/tienda.png");
        soldier = new Image("data/machine.gif");
        ret = new Image("data/return.png");
        coin = new Image("data/coin.png");
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bck.draw();
        soldier.draw(100,50);
        ret.draw(860,450);
        
        g.drawRect(115, 75, 175, 175);
        g.drawRect(800, 40, 100, 30);
        g.setColor(Color.black);
        coin.draw(800,40);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if((posX>850 && posX<1300) && (posY>10 && posY<100)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(2);
            }
        }
    }
    
}

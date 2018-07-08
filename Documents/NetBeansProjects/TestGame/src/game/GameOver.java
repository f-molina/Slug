/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author fmolina
 */
public class GameOver extends BasicGameState{
    
    Image bck, over;
    public static final int ID = 4;

    @Override
    public int getID() {
        return GameOver.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bck = new Image("data/over.png");
        over = new Image("data/gameover.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bck.draw();
        over.draw(300,50);
        g.setColor(Color.white);
        g.drawString("VOLVER A JUGAR (N)" ,400,350);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_N)){
            sbg.getContainer().reinit();
            sbg.enterState(2);
        }

    }
    
}

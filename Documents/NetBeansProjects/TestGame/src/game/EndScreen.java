/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Personajes.Jugador;
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
public class EndScreen extends BasicGameState{

    public static final int ID = 5;
    Image end, replay;
    private Jugador jugador;
    
    @Override
    public int getID() {
        return EndScreen.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        end = new Image("data/end.png");
        replay = new Image("data/replay.png");
        jugador = new Jugador();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        end.draw();
        g.drawString("LEVEL COMPLETED!!!",415 , 100);
        g.drawString("Puntos: "+jugador.getScore(), 425, 200);
        replay.draw(425,275);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }
}

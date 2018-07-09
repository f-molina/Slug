/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import Singleton.PropiedadesJugador;
import org.lwjgl.input.Mouse;
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
    Image end, replay, out;
    public static PropiedadesJugador pd = PropiedadesJugador.getInstance();
    
    @Override
    public int getID() {
        return EndScreen.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        end = new Image("data/end.png");
        replay = new Image("data/replay.png");
        out = new Image("data/out.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        end.draw();
        g.drawString("LEVEL COMPLETED!!!",415 , 100);
        g.drawString("Puntos: "+pd.getScore2()/100, 425, 200);
        replay.draw(425,250);
        out.draw(425,300);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if((posX>430 && posX<515) && (posY>256 && posY<285)){
            if(Mouse.isButtonDown(0)){
                Game.xMap=0;
                sbg.enterState(1);
                pd.setMonedas(0);
                pd.setVida(3);
                pd.setScore(0);
                pd.setScore2(0);
            }
        }else if((posX>430 && posX<515) && (posY>207 && posY<238)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
}

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
    private PropiedadesJugador pd;
    
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
        g.drawString("Puntos: "+pd.getScore2(), 425, 200);
        replay.draw(425,250);
        out.draw(425,300);
        g.drawString("x"+Mouse.getX(), 600, 150);
        g.drawString("y"+Mouse.getY(), 600, 250);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if((posX>430 && posX<515) && (posY>256 && posY<285)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(2);
            }
        }else if((posX>430 && posX<515) && (posY>207 && posY<238)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
}

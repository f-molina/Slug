/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Personajes.Jugador;
import Singleton.PropiedadesJugador;
import org.lwjgl.input.Mouse;
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
public class Tienda extends BasicGameState{
    private Input entrada;
    private Jugador jugador;
    Image bck, soldier, ret, coin, rage, buy, heart;
    public static final int ID = 3;
    public static PropiedadesJugador pd = PropiedadesJugador.getInstance(); //instancia del singleton
    
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
        rage = new Image("data/rage.png");
        buy = new Image("data/buy.png");
        heart = new Image("data/heart2.png");
        jugador = new Jugador();
        entrada=gc.getInput();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bck.draw();
        heart.draw(130,75);
        rage.draw(140,300);
        ret.draw(860,450);
        
        buy.draw(350,30);
        buy.draw(350,250);
        
        //rect vida extra
        g.drawString("Vida extra", 150, 55);
        g.drawRect(115, 75, 175, 175);
        //rect potenciador
        g.drawString("Potenciador puntos", 125, 255);
        g.drawRect(115, 275, 175, 175);
        //rect barra monedas
        g.drawRect(800, 40, 100, 30);
        g.setColor(Color.black);
        coin.draw(800,40);
        g.drawString("     "+((pd.getScore()/100)/5), 820, 43);
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
        else if((posX>380 && posX<600) && (posY>320 && posY<400)){
            if(entrada.isMousePressed(0)){
                long n=pd.getScore()-500;
                if(pd.getScore()>=500){
                pd.setVida(pd.getVida()+1);
                //pd.setMonedas(pd.getMonedas()-1);
                pd.setScore(n);
            }
        }
        }
        else if((posX>380 && posX<600) && (posY>110 && posY<190)){
            if(entrada.isMousePressed(0)){
               long cont=pd.getContador();
               if(cont==0){
                long n=pd.getScore()+500;
                if(pd.getScore()>=500){
                //pd.setScore(pd.getScore());
                //pd.setMonedas(pd.getMonedas()-1);
                pd.setContador(pd.getContador()+1);
                pd.setScore(n);
            }}
        }
        }
        
    }
   
}

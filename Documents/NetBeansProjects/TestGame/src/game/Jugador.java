/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Interfaces.IColisionable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author fmolina
 */
public class Jugador implements IColisionable{
    
    private SpriteMovil jugador;
    private float x = 60f, y = 370f;
    private Rectangle areaColision;
    
    public void Jugador() throws SlickException{
        jugador = new SpriteMovil("data/machine2.gif",new Punto(170,365),new Punto(0,0));
        areaColision = new Rectangle(jugador.getPosicion().getX(), jugador.getPosicion().getY(), jugador.getWidth(), jugador.getHeight());
    }
    
    public void draw(){
        jugador.draw((int) x, (int) y);
    }
    
    public void update(int delta){
        jugador.update(delta);
    }

    @Override
    public Shape getAreaColision() {
        return areaColision;
    }

    @Override
    public void sincronizarArea() {
        areaColision.setX(jugador.getPosicion().getX());
        areaColision.setY(jugador.getPosicion().getY());
    }
    
}

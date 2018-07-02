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
public class Bala implements IColisionable{
    
    private SpriteMovil bala;
    private Rectangle colision;
    
    public Bala(float x, float y) throws SlickException{
        bala = new SpriteMovil("data/fuego.png",new Punto(x,y),new Punto(300,0));
        colision = new Rectangle(bala.getPosicion().getX(), bala.getPosicion().getY(), bala.getWidth(), bala.getHeight());
    }
    
    public void draw(){
        bala.draw();
    }
    
    public void update(int delta){
        bala.update(delta);
    }

    @Override
    public Shape getAreaColision() {
        return colision;
    }

    @Override
    public void sincronizarArea() {
        colision.setX(bala.getPosicion().getX());
        colision.setY(bala.getPosicion().getY());
    }
    
}

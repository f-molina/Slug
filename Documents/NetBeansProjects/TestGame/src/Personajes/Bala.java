/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Interfaces.IColisionable;
import game.Punto;
import game.SpriteMovil;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author fmolina
 */
public class Bala implements IColisionable{
    
    private SpriteMovil bala;
    public static Rectangle colision;

    public Bala(float x, float y) throws SlickException{
        bala = new SpriteMovil("data/fuego.png",new Punto(x,y),new Punto(300,0));
        colision = new Rectangle(bala.getPosicion().getX(), bala.getPosicion().getY(), bala.getWidth(), bala.getHeight());
       
    }
    
    public void draw(){
        bala.draw();
    }
    
    public void update(int delta){
        bala.update(delta);
        sincronizarArea();
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

    @Override
    public void alColisionar(IColisionable colision) {
        if(Bala.colision.intersects(Enemigo.colision)){
            bala.getPosicion().setX(-5000);
            bala.getPosicion().setY(-5000);
            
        }
    }
    
}

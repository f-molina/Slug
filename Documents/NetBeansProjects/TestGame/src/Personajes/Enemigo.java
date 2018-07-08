/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Personajes.Bala;
import Controlador.GestorColision;
import Interfaces.IColisionable;
import static Personajes.Meteoro.colision;
import game.Punto;
import game.SpriteMovil;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author fmolina
 */
public class Enemigo implements IColisionable{
   
    private SpriteMovil enemigo;
    public static Rectangle colision;
    
   
    
    public Enemigo(float x, float y) throws SlickException{
        enemigo = new SpriteMovil("data/tanque.gif",new Punto(x,y), new Punto(-250,0));
        
        colision = new Rectangle(enemigo.getPosicion().getX(), enemigo.getPosicion().getY(), enemigo.getWidth(), enemigo.getHeight());
        
    }
    
    public void draw(){
        enemigo.draw();
    }
    public void render(Graphics g){
        
        g.drawRect(colision.getX(), colision.getY(), colision.getWidth(), colision.getHeight());
    }
    public void update(int delta){
        enemigo.update(delta);
        sincronizarArea();
    }

    @Override
    public Shape getAreaColision() {
        return colision;
    }

    @Override
    public void sincronizarArea() {
        colision.setX(enemigo.getPosicion().getX());
        colision.setY(enemigo.getPosicion().getY());
    }

    @Override
    public void alColisionar(IColisionable colision) {
        if(Bala.colision.intersects(Enemigo.colision)){
            enemigo.getPosicion().setX(-5000);
        }
        else if(Jugador.colision.intersects(Enemigo.colision)){
            enemigo.getPosicion().setX(-5000);
        }
    }
}

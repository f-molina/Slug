/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Interfaces.IColisionable;
import game.Punto;
import game.SpriteMovil;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author EdwinLovo
 */
public class Meteoro implements IColisionable{
    private SpriteMovil meteoro;
    public static Rectangle colision;
    
    public Meteoro(float x, float y) throws SlickException{
        meteoro = new SpriteMovil("data/meteoro2.png", new Punto(x,y), new Punto(0,-750));
        colision = new Rectangle(meteoro.getPosicion().getX(), meteoro.getPosicion().getY(), meteoro.getWidth(), meteoro.getHeight());
    }
    public void render(Graphics g){
        
        //g.drawRect(colision.getX(), colision.getY(), colision.getWidth(), colision.getHeight());
    }
    
    public void draw(){
        meteoro.draw();
    }
    
    public void update(int delta){
        meteoro.update2(delta);
        sincronizarArea();
    }
    
    @Override
    public Shape getAreaColision() {
        return colision;
    }

    @Override
    public void sincronizarArea() {
        colision.setX(meteoro.getPosicion().getX());
        colision.setY(meteoro.getPosicion().getY());
    }

    @Override
    public void alColisionar(IColisionable colision) {
        if(Jugador.colision.intersects(Meteoro.colision)){
            meteoro.getPosicion().setY(5000);
        }
        else if(meteoro.getPosicion().getY()>900){
            meteoro.getPosicion().setY(2000);
        }
        
    }
    
}
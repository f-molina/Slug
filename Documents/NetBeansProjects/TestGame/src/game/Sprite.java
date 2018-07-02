/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.newdawn.slick.*;

/**
 *
 * @author HP PC
 */
public class Sprite extends Image {
    
    protected Punto posicion;
    public Sprite(String ruta, Punto posicion) throws SlickException{
        super(ruta);
        this.posicion=posicion;
    }
    public Sprite(String ruta) throws SlickException{
        this(ruta,new Punto(0,0));
    }
    public Sprite(String ruta, float x, float y) throws SlickException{
        this(ruta,new Punto(x,y));
}
    @Override public void draw(){
       super.draw(posicion.getX(),posicion.getY()); 
    }
    
    public Punto getPosicion(){
        return this.posicion;
    }
    public void setPosicion(Punto posicion){
        this.posicion=posicion;
    }
    public void setPosicion(float x, float y){
        this.posicion=new Punto(x,y);
    }
    
}
    

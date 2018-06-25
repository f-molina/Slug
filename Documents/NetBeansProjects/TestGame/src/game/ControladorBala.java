/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.newdawn.slick.*;

/**
 *
 * @author HP PC
 */
public class ControladorBala {
    private ArrayList<SpriteMovil> balas;
    public ControladorBala(){
        balas=new ArrayList<SpriteMovil>();
    }
    public void addbala(float x,float y) throws SlickException{
        SpriteMovil bala= new SpriteMovil("data/fuego.png",new Punto(x,y),new Punto(300,0));
        balas.add(bala);
    }
    public void draw(){
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).draw();
        }
    }
    public void update(int delta){
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).update(delta);
        }
    }
    public void delete(){
        for (int i = 0; i < balas.size(); i++) {
            if(balas.get(i).getPosicion().getX()>1000){
                balas.remove(i);
            }
        }
    }
}

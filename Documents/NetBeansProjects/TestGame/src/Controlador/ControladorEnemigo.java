/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Controlador;
import game.Punto;
import game.SpriteMovil;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

/**
 *
 * @author EdwinLovo
 */
public class ControladorEnemigo implements Controlador{

    private ArrayList<SpriteMovil> enemigos;
    
    public ControladorEnemigo(){
        enemigos = new ArrayList<SpriteMovil>();
    }
    
    @Override
    public void add(float x, float y) throws SlickException {
        SpriteMovil enemigo = new SpriteMovil("data/tanque.gif",new Punto(x,y), new Punto(-250,0));
        enemigos.add(enemigo);
    }

    @Override
    public void draw() {
        for(int i = 0; i< enemigos.size(); i++){
            enemigos.get(i).draw();
        }
    }

    @Override
    public void update(int delta) {
        for(int i = 0; i< enemigos.size(); i++){
            enemigos.get(i).update(delta);
        }
    }

    @Override
    public void delete() {
        for(int i = 0; i< enemigos.size(); i++){
            if(enemigos.get(i).getPosicion().getX()<0){
                enemigos.remove(i);
            }
        }
    }
    
}

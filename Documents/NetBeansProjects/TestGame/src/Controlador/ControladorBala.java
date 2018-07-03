/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Interfaces.Controlador;
import game.Bala;
import java.util.ArrayList;
import org.newdawn.slick.*;

/**
 *
 * @author HP PC
 */
public class ControladorBala implements Controlador{
    
    private ArrayList<Bala> balas;
    
    public ControladorBala(){
        balas = new ArrayList<Bala>();
    }
    @Override
    public void add(float x,float y) throws SlickException{
        Bala bala = new Bala(x, y);
        balas.add(bala);
    }
    @Override
    public void draw(){
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).draw();
        }
    }
    @Override
    public void update(int delta){
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).update(delta);
        }
    }
    @Override
    public void delete(){
        for (int i = 0; i < balas.size(); i++) {
            if(balas.get(i).getAreaColision().getX()>1000){
                balas.remove(i);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Interfaces.Controlador;
import Personajes.Meteoro;
import game.Game;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author EdwinLovo
 */
public class ControladorMeteoro implements Controlador{
    private Game game;
    private ArrayList<Meteoro> meteoros;

    public ControladorMeteoro() {
        meteoros = new ArrayList<Meteoro>();
    }

    @Override
    public void add(float x, float y, GestorColision gestor) throws SlickException {
        Meteoro meteoro = new Meteoro(x,y);
        meteoros.add(meteoro);
        gestor.registarCuerpo(meteoro);
    }

    @Override
    public void draw(Graphics g) {
        for(int i = 0; i< meteoros.size(); i++){
            meteoros.get(i).draw();
            meteoros.get(i).render(g);
        }
    }

    @Override
    public void update(int delta) {
        for(int i = 0; i< meteoros.size(); i++){
            meteoros.get(i).update(delta);
        }
    }

    @Override
    public void delete() {
        for(int i = 0; i< meteoros.size(); i++){
            if(meteoros.get(i).getAreaColision().getY()>1500  && meteoros.get(i).getAreaColision().getY()<3500){
                meteoros.remove(i);
            }
        }
    }
    @Override
    public int delete2(){
        int n=0;
        for(int i = 0; i< meteoros.size(); i++){
            if(meteoros.get(i).getAreaColision().getY()>4500  && meteoros.get(i).getAreaColision().getY()<7500){
                meteoros.remove(i);
                System.out.println("SE FUE METEORO");
                n=1;
            }
        }
        return n;
    }

    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Controlador.ControladorBala;
import Interfaces.IColisionable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
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
    private boolean jumping;
    private float verticalSpeed;
    private Input input;
    private ControladorBala bala;
    private Rectangle colision;
    
    public void init() throws SlickException{
        jugador = new SpriteMovil("data/machine2.gif",new Punto(170,365),new Punto(0,0));
        bala = new ControladorBala();
        colision = new Rectangle(jugador.getPosicion().getX(), jugador.getPosicion().getY(), jugador.getWidth(), jugador.getHeight());
        jumping = false;
        verticalSpeed = 0.0f;
    }
    
    public void render(Graphics g){
        jugador.draw((int)x, (int)y);
        bala.draw();
    }
    
    public void update(GameContainer container, int delta) throws SlickException{
        input = container.getInput();
        bala.update(delta);
        if (input.isKeyPressed(Input.KEY_SPACE)&&!jumping) {
            verticalSpeed = -0.50f*delta;
            jumping = true;
          }
        if(jumping){
            verticalSpeed+=0.01f*delta;
        }
        jugador.getPosicion().setY(y+=verticalSpeed);
        if(y>=364f){
            jumping = false;
            verticalSpeed=0.0f;
        }
        
        if (input.isKeyDown(Input.KEY_A)) {
            if(Game.xMap>-1){
                Game.xMap -= delta*0.1f;
            }else{
                Game.xMap += delta*0.1f;
            }   
            
        } else if (input.isKeyDown(Input.KEY_D)) {
                Game.xMap -= delta*0.1f;

        }
        
        if(input.isMousePressed(0)){
            bala.add(jugador.getPosicion().getX()+30,(jugador.getPosicion().getY()+jugador.getHeight()/2)-15);
        }
        bala.delete();
    }

    @Override
    public Shape getAreaColision() {
        return colision;
    }

    @Override
    public void sincronizarArea() {
        colision.setX(jugador.getPosicion().getX());
        colision.setY(jugador.getPosicion().getY());
    }
    
}

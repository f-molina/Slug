/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Frank
 */
public class Game extends BasicGameState {
    
    public static final int ID = 2;
    private TiledMap grassMap;
    private Animation sprite, up, down, left, right;
    private float x = 60f, y = 350f;
    private static final int SIZE = 32;
    private float xMap=0, yMap=0;
    private boolean jumping;
    private float verticalSpeed;
    private ControladorBala balas;
    private SpriteMovil jugador;
    private Input entrada;
   
    @Override
    public int getID() {
        return Game.ID;
    }
    
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        entrada=gc.getInput();
        Image[] movementUp = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementDown = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementLeft = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementRight = {new Image("data/lol.png"), new Image("data/lol.png")};
        jugador=new SpriteMovil("data/lol.png",new Punto(170,350),new Punto(0,0));
        balas=new ControladorBala();
        int[] duration = {300, 300};
        //grassMap = new TiledMap("data/grassmap.tmx");
        grassMap = new TiledMap("data/pupu.tmx");
        up = new Animation(movementUp, duration, false);
        down = new Animation(movementDown, duration, false);
        left = new Animation(movementLeft, duration, false);
        right = new Animation(movementRight, duration, false);

        jumping = false;
        verticalSpeed = 0.0f;
        sprite = right;
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        
        grassMap.render((int) xMap, (int) yMap);
        sprite.draw((int) x, (int) y);
        g.drawString("Posicion x: " +x + " Posicion y: " +y, 550,50);
        g.drawString("Posicion xMapa: " +xMap + " Posicion yMapa: " +yMap, 550,150);
        g.setColor(Color.yellow);
       jugador.draw();
        balas.draw();
        
       
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        //actualizar();
       // eliminar();
       /*this.bola.update(delta);
       if(bola.getPosicion().getX()>1000){
           bola.setVelocidad(new Vector(new Punto(0,0)));
       }*/
       
        Input input = container.getInput();
        jugador.update(delta);
        balas.update(delta);
        
        
        if (input.isKeyPressed(Input.KEY_SPACE)&&!jumping) {
            verticalSpeed = -0.50f*delta;
            jumping = true;
          }
        if(jumping){
            verticalSpeed+=0.01f*delta;
        }
        y+=verticalSpeed;
        if(y>=349f){
            jumping = false;
            verticalSpeed=0.0f;
        }
        
        
        if (input.isKeyDown(Input.KEY_DOWN)) {
            sprite = down;
            sprite.update(delta);
            y += delta * 0.1f;
            if(y>350){
                y -= delta * 0.1f;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            
            xMap += delta*0.1f;
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            xMap -= delta*0.1f;
            if(xMap <-60 && y >213){
                xMap += delta*0.1f;
            }
             
        
        }
        controlteclado();
        balas.delete();
    }
   private void controlteclado() throws SlickException{
       
       if(entrada.isMousePressed(0)){
            balas.addbala(jugador.getPosicion().getX()+120,jugador.getPosicion().getY()+jugador.getHeight()/2);
        }
       else if(entrada.isKeyDown(Input.KEY_RIGHT)){
           jugador.setVelocidad(new Vector(new Punto(100,0)));
       }
       else if(entrada.isKeyDown(Input.KEY_LEFT)){
           jugador.setVelocidad(new Vector(new Punto(-100,0)));
       }
       else if(entrada.isKeyDown(Input.KEY_UP)){
           jugador.setVelocidad(new Vector(new Punto(0,-200)));
       }
   }
}

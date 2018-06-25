/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Controlador.ControladorBala;
import Controlador.ControladorEnemigo;
import java.util.Random;
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
    Image b, r;//b: imagen background, r: imagen de roca
    int maxHealth = 100;
    int currentHealth=50;
    private boolean quit = false;
    private ControladorEnemigo enemigos;
    private Random numeros;
    private int relojEnemigo = 0;
   
    @Override
    public int getID() {
        return Game.ID;
    }
    
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        b = new Image("data/b2.png");
        r = new Image("data/rock.png");
        entrada=gc.getInput();
        Image[] movementUp = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementDown = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementLeft = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementRight = {new Image("data/lol.png"), new Image("data/lol.png")};
        jugador=new SpriteMovil("data/lol.png",new Punto(170,365),new Punto(0,0));
        balas=new ControladorBala();
        int[] duration = {300, 300};
        //grassMap = new TiledMap("data/grassmap.tmx");
        grassMap = new TiledMap("data/pupu.tmx");
        up = new Animation(movementUp, duration, false);
        down = new Animation(movementDown, duration, false);
        left = new Animation(movementLeft, duration, false);
        right = new Animation(movementRight, duration, false);
        enemigos = new ControladorEnemigo();
        numeros = new Random();
        jumping = false;
        verticalSpeed = 0.0f;
        sprite = right;

    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        b.draw((int) xMap, (int) yMap);
        b.draw((int) xMap+950, (int) yMap);
        b.draw((int) xMap+1900, (int) yMap);
        r.draw((int) xMap+400, (int) yMap+450);
        //grassMap.render((int) xMap, (int) yMap);
        sprite.draw((int) x, (int) y);
        g.drawString("Posicion x: " +x + " Posicion y: " +y, 550,50);
        g.drawString("Posicion xMapa: " +xMap + " Posicion yMapa: " +yMap, 550,100);
        g.setColor(Color.black);
        //jugador.draw();
        balas.draw();
        enemigos.draw();
        //health bar
        g.drawRect(x, 50, maxHealth, 30);
        g.setColor(Color.green);
        g.fillRect(x, 50, currentHealth, 30);
        
        //menu in-game cuando presiona esc
        if(quit==true){
            g.drawString("Reanudar Juego (R)", 400, 150);
            g.drawString("Menu Principal (M)", 400, 200);
            g.drawString("Salir (S)", 400, 250);
            if(quit==false){
                g.clear();
            }
        }
       
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
        enemigos.update(delta);
        relojEnemigo += delta;
        if(relojEnemigo > 4000 + numeros.nextInt(2000)){
            lanzarEnemigo();
            relojEnemigo=0;
        }
        
        if (input.isKeyPressed(Input.KEY_SPACE)&&!jumping) {
            verticalSpeed = -0.50f*delta;
            jumping = true;
          }
        if(jumping){
            verticalSpeed+=0.01f*delta;
        }
        y+=verticalSpeed;
        if(y>=364f){
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
        } else if (input.isKeyDown(Input.KEY_A)) {
            
            xMap += delta*0.1f;
        } else if (input.isKeyDown(Input.KEY_D)) {
            xMap -= delta*0.1f;
            /*if(xMap <-60 && y >213){
                xMap += delta*0.1f;
            }*/
            
        }else if(input.isKeyPressed(Input.KEY_ESCAPE)){
            quit = true;
        }else if(input.isKeyPressed(Input.KEY_R)){
            quit = false;
        }else if(input.isKeyPressed(Input.KEY_M)){
            sbg.enterState(1);
        }else if(input.isKeyPressed(Input.KEY_S)){
            System.exit(0);
        }
        
        
  
        controlteclado();
        balas.delete();
    }
   private void controlteclado() throws SlickException{
       
       if(entrada.isMousePressed(0)){
            balas.add(jugador.getPosicion().getX()+120,jugador.getPosicion().getY()+jugador.getHeight()/2);
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
   
   public void lanzarEnemigo() throws SlickException{
       
        enemigos.add(1000, 402);
        
   }
}

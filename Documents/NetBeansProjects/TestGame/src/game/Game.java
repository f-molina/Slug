/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Controlador.ControladorBala;
import Controlador.ControladorEnemigo;
import java.awt.Rectangle;
import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Frank
 */
public class Game extends BasicGameState {
    
    public static final int ID = 2;
    private float x = 60f, y = 370f;
    private static final int SIZE = 32;
    private float xMap=0, yMap=0;
    private boolean jumping;
    private float verticalSpeed;
    private ControladorBala balas;
    private Jugador jugador;
    private Input entrada;
    Image b, r, pause, heart, coin;//b: imagen background, r: imagen de roca
    int maxHealth = 100;
    int currentHealth=100;
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
        pause = new Image("data/pause.png");
        b = new Image("data/b2.png");
        heart = new Image("data/heart.png");
        coin = new Image("data/coin.png");
        entrada=gc.getInput();
        jugador = new Jugador();
        balas=new ControladorBala();
        int[] duration = {300, 300};
        enemigos = new ControladorEnemigo();
        numeros = new Random();
        jumping = false;
        verticalSpeed = 0.0f;

    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        b.draw((int) xMap-950, (int) yMap);
        b.draw((int) xMap, (int) yMap);
        b.draw((int) xMap+950, (int) yMap);
        b.draw((int) xMap+1900, (int) yMap);
        b.draw((int) xMap+2850, (int) yMap);
        /*g.drawString("Posicion x: " +x + " Posicion y: " +y, 550,50);
        g.drawString("Posicion xMapa: " +xMap + " Posicion yMapa: " +yMap, 550,100);*/
        g.setColor(Color.black);
        jugador.draw();
        balas.draw();
        enemigos.draw();

        heart.draw(10,20);
        heart.draw(50,20);
        heart.draw(90,20);
        
        g.drawRect(10, 60, 100, 30);
        coin.draw(10,60);

        //menu in-game cuando presiona esc
        if(quit==true){
            pause.draw();
            gc.pause();
            g.drawString("Reanudar Juego (R)", 400, 150);
            g.drawString("Menu Principal (M)", 400, 200);
            g.drawString("Tienda (T)", 400, 250);
            g.drawString("Salir (S)", 400, 300);
            if(quit==false){
                g.clear();
            }
        }
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
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
        jugador.getAreaColision().setY(y+=verticalSpeed);
        if(y>=364f){
            jumping = false;
            verticalSpeed=0.0f;
        }
        
        if (input.isKeyDown(Input.KEY_A)) {
            if(xMap>-1){
                xMap -= delta*0.1f;
            }else{
                xMap += delta*0.1f;
            }   
            
        } else if (input.isKeyDown(Input.KEY_D)) {
                xMap -= delta*0.1f;
                if(intersects()){
                    xMap += delta*0.1f;
                }

        }else if(input.isKeyPressed(Input.KEY_ESCAPE)){
            quit = true;
        }else if(input.isKeyPressed(Input.KEY_R)){
            quit = false;
            container.resume();
        }else if(input.isKeyPressed(Input.KEY_M)){
            sbg.enterState(1);
        }else if(input.isKeyPressed(Input.KEY_T)){
            sbg.enterState(3);    
        }else if(input.isKeyPressed(Input.KEY_S)){
            System.exit(0);
        }

        controlteclado();
        balas.delete();
    }
   private void controlteclado() throws SlickException{
       
       if(entrada.isMousePressed(0)){
            balas.add(jugador.getAreaColision().getX()+120,jugador.getAreaColision().getY()+jugador.getAreaColision().getHeight()/2);
        }
   }
   
   public void lanzarEnemigo() throws SlickException{
       
        enemigos.add(1000, 402);
        
   }
   
   public boolean intersects(){
       Rectangle rect = new Rectangle((int) x, (int) y, 145, 185);
       Rectangle rect1 = new Rectangle((int) xMap+300, (int) yMap+450, 90, 90);
       Rectangle rect2 = new Rectangle((int) 1000,402, 184, 132);
        return rect.intersects(rect2);
   }
}

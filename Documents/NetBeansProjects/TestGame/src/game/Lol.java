/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.application.Application;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Frank
 */
public class Lol extends StateBasedGame{
    
    public static final int MAINMENU     = 1;
    public static final int GAME         = 2;

    public static final int WIDTH   = 950;
    public static final int HEIGHT  = 540;
    public static final int FPS     = 60;
    public static final double VERSION = 1.0;

    public Lol(String appName) {
        super("SlugTest");
    }

    // llama los states de cada clase con su id
    public void initStatesList(GameContainer gc) throws SlickException {
        //va por orden
        this.addState(new Menu());
        this.addState(new Game());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Lol("My Game v" + VERSION));
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(true);
            app.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
    
}

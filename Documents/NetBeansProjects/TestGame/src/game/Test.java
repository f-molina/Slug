/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Frank
 */
public class Test extends BasicGame {

    private TiledMap grassMap;
    private Animation sprite, up, down, left, right;
    private float x = 60f, y = 350f;
    private static final int SIZE = 32;
    private float jumpStrength, weight, speed;

    public Test() {
        super("Slug Test");
    }
    
    public static void main(String[] arguments) {
        try {
            AppGameContainer app = new AppGameContainer(new Test());
            app.setDisplayMode(950, 600, false);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        speed = 3;
        weight =1;
        Image[] movementUp = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementDown = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementLeft = {new Image("data/lol.png"), new Image("data/lol.png")};
        Image[] movementRight = {new Image("data/lol.png"), new Image("data/lol.png")};
        int[] duration = {300, 300};
        //grassMap = new TiledMap("data/grassmap.tmx");
        grassMap = new TiledMap("data/pupu.tmx");
        up = new Animation(movementUp, duration, false);
        down = new Animation(movementDown, duration, false);
        left = new Animation(movementLeft, duration, false);
        right = new Animation(movementRight, duration, false);

        sprite = right;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            /*jumpStrength =delta*150f;
            y-=delta*jumpStrength;
            jumpStrength-=weight;*/
            y-=delta*30f;
            //sprite = up;
            //sprite.update(delta);
            // mas bajo el delta mas bajo animara el sprite
        }else if (input.isKeyDown(Input.KEY_DOWN)) {
            sprite = down;
            sprite.update(delta);
            y += delta * 0.1f;
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            sprite = left;
            sprite.update(delta);
            x -= delta * 0.1f;
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            sprite = right;
            sprite.update(delta);
            x += delta * 0.1f;
        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        grassMap.render(0, 0);
        sprite.draw((int) x, (int) y);
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import org.newdawn.slick.SlickException;

/**
 *
 * @author EdwinLovo
 */
public interface Controlador {
    public void add(float x,float y) throws SlickException;
    public void draw();
    public void update(int delta);
    public void delete();
}

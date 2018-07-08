/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controlador.GestorColision;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author EdwinLovo
 */
public interface Controlador {
    public void add(float x,float y,GestorColision gestor) throws SlickException;
    public void draw(Graphics g);
    public void update(int delta);
    public void delete();
    public int delete2();
}

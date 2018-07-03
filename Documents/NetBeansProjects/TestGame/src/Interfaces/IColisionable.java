/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import org.newdawn.slick.geom.Shape;

/**
 *
 * @author fmolina
 */
public interface IColisionable {
    
    public Shape getAreaColision();
    public void sincronizarArea();
    public void alColisionar(IColisionable colision);
}

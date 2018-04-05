/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naldana;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Guardar a un estudiante
 * @author Néstor Aldana <nexxtor at naldana.com>
 */
public class Estudiante {
    private String nombres, apellidos, carnet;
       
    public Estudiante() {}

    public Estudiante(String nombres, String apellidos){
        this.nombres =  nombres;
        this.apellidos =  apellidos;
    }

    public Estudiante(String nombres, String apellidos, String carnet) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carnet = carnet;
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", carnet=" + carnet + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.carnet);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.carnet, other.carnet)) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String ... args) {
        Estudiante est1 = new Estudiante();
        Estudiante est2 = new Estudiante("Néstor Santiago", "Aldana Rodriguez");
        Estudiante est3 = new Estudiante("Néstor Santiago", "Aldana Rodriguez","00031111");
        
        System.out.println(est1.toString());
        System.out.println(est2.toString());
        System.out.println(est3.toString());
        
        Menu menu = Menu.getInstance();
       
        //menu.mostrar();
        
        ListaEstudiantes lista = new ListaEstudiantes();
               
        try {
            lista.add(new Estudiante("Néstor", "Aldana", "00031111"));
            Estudiante e = new Estudiante();
            e.setCarnet("00031111");
            lista.add(e);
        } catch (Exception ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}

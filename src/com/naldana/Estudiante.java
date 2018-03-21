/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naldana;

/**
 * Guardar a un estudiante
 * @author Néstor Aldana <nexxtor at naldana.com>
 */
public class Estudiante {
    private String nombres;
    private String apellidos;
    private String carnet;
    
    
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
    
   
    
    
    public static void main(String ... args) {
        Estudiante est1 = new Estudiante();
        Estudiante est2 = new Estudiante("Néstor Santiago", "Aldana Rodriguez");
        Estudiante est3 = new Estudiante("Néstor Santiago", "Aldana Rodriguez","00031111");
        
        System.out.println(est1.toString());
        System.out.println(est2.toString());
        System.out.println(est3.toString());
        
        Menu menu = Menu.getInstance();
       
        menu.mostrar();
    }
   
}

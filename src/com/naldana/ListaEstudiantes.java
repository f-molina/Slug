/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naldana;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Néstor Aldana <nexxtor at naldana.com>
 */
public class ListaEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    
    public ListaEstudiantes() {
        estudiantes = new ArrayList<>();
    }
    
    /**
     * Añadir un estudiante a la lista
     * Obtiene los valor desde teclado
     */
    public void add() {
        Estudiante estudiante = new Estudiante();
        
        estudiantes.add(estudiante);
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese los nombres del estudiante");
        System.out.print(": ");
        estudiante.setNombres(leer.nextLine());
        
        System.out.println("Ingrese los apellids del estudiante");
        System.out.print(": ");
        estudiante.setApellidos(leer.nextLine());
        
        System.out.println("Ingrese el carne del estudiante");
        System.out.print(": ");
        estudiante.setCarnet(leer.next());
        
        
    }
    
    public void add(Estudiante estudiante) throws Exception{
        if(estudiante != null) {
            if (!estudiantes.contains(estudiante)) {
                estudiantes.add(estudiante);
            }
            Exception e = new Exception("No se permiten datos duplicados");
            throw e;
        } else {
            throw new Exception("No se puede agregar un estudiante nulo");
        }
        
    }
    
    public void mostrar() {
        for ( Estudiante e : estudiantes) {
            System.out.println(e.toString());
        }
    }
}

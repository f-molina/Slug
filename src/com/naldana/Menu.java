/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naldana;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Néstor Aldana <nexxtor at naldana.com>
 */
public class Menu {

    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {
        System.out.println("----- Menu -----");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Mostrar Estudiante");
        System.out.println("3. Salir");
    }

    public void mostrar() {
        int opcion = 4;
        Scanner leer = new Scanner(System.in);
        ListaEstudiantes estudiantes = new ListaEstudiantes();

        while (opcion != 3) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        estudiantes.add();
                        break;
                    case 2:
                        estudiantes.mostrar();
                        break;
                    case 3:
                        System.out.println("Adios :(");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }

}

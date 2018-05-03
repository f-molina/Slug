/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprueba;
import java.util.Scanner;

/**
 *
 * @author Frank
 */
public class Menu {
    public static Menu menu;

    public Menu() {
    }
    
    public static Menu getInstance(){
        if(menu==null){
            menu = new Menu();
        }
        return menu;
    }
    
    public void menuAdmin(){
        int opc;
        do{
            System.out.println("********ADMINISTRACION********");
            System.out.println("1. Habilitar/Inhabilitar Habitaciones");
            System.out.println("2. Habilitar/Inhabilitar Pisos");
            System.out.println("3. Modificar precio de habitacion");
            System.out.println("4. Modificar servicio");
            System.out.println("5. Modificar precio de servicio"); 
            System.out.println("5. Salir"); 
        
            Scanner leer = new Scanner(System.in);
            System.out.println("Digite una opcion: ");
            opc = leer.nextInt();
            switch(opc){    
                case 1:
                    
                break;
                case 2:
                break;
                case 3:
                break;
                default:
                     System.out.println("");
            }
        }while(opc!=5);
    }
    
    public void menuEmpleado(){
        int opc;
        do{
            System.out.println("********VINHA RAFINHA********");
            System.out.println("1. Agregar reservacion");
            System.out.println("2. Ver reservacion");
            System.out.println("3. Cancelar reservacion");
            System.out.println("4. Modificar reservacion"); 
            System.out.println("5. Salir");
        
            Scanner leer = new Scanner(System.in);
            ParcialPrueba p = new ParcialPrueba();
            System.out.println("Digite una opcion: ");
            opc = leer.nextInt();
            switch(opc){    
                case 1:    
                    p.pupu();
                break;
                case 2:
                break;
                case 3:
                break;
                default:
                     System.out.println("");
            }
        }while(opc!=5);
    }
}




        
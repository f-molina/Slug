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
public class ParcialPrueba {
    static GeneradorHabitaciones generador = new GeneradorHabitaciones();

    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.login();        
    }
    
    public void pupu(){
        String codigo;      
        Habitacion habitacion;  
        Scanner leer = new Scanner(System.in);
        while(true){
            //imprime las habitaciones
            System.out.println("\n*******************VINHA RAFINHA******************* \n\n"+getListaHabitaciones(generador));

            while(true){
                System.out.println("\nIngrese el codigo de la habitacion a reservar o X para salir: ");
                codigo = leer.nextLine();
                if(codigo.equals("x")||codigo.equals("X")){
                    System.exit(0);
                }

                if(getHabitacion(codigo) == null){

                    System.out.println("El codigo es invalido, ingrese el codigo de nuevo");

                }
                else{

                    habitacion = getHabitacion(codigo);

                    if(!habitacion.yaReservado()){
                        System.out.println("Reservado");
                        habitacion.setReservado(true);
                        break;
                    }
                    else{
                        System.out.println("El codigo es invalido, ingrese el codigo de nuevo");
                    }

                }

            }

        }
        
    }

    public static String getListaHabitaciones(GeneradorHabitaciones generador)
    {

        String listaHabi = "";
        for(Habitacion r:generador.getHabitacion())
        {

            if(!r.yaReservado())
            {
                listaHabi = listaHabi+r.getCodigo()+" Disponible"+"   ";
            }
            else
            {
                listaHabi = listaHabi+r.getCodigo()+" Reservada ";
            }

        }
        return listaHabi;
    }


    public static Habitacion getHabitacion(String codigo){

        for(Habitacion r:generador.getHabitacion()){

            if(r.getCodigo().equals(codigo)){
                return r;
            }
        }
        return null;
    }
}


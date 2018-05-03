/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprueba;

import java.util.ArrayList;

/**
 *
 * @author Frank
 */
public class GeneradorHabitaciones {
    private ArrayList<Habitacion> habitacion;
    private String[] codigo = {"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","\nB1","B2","B3","B4","B5","B6","B7","B8","B9","B10",
    "\nC1","C2","C3","C4","C5","C6","C7","C8","C9","C10","\nD1","D2","D3","D4","D5","D6","D7","D8","D9","D10","\nE1","E2","E3","E4","E5","E6","E7","E8","E9","E10",
    "\nF1","F2","F3","F4","F5","F6","F7","F8","F9","F10"};

    GeneradorHabitaciones(){
        
        habitacion = new ArrayList<Habitacion>();                     
        for(int i=0;i<codigo.length;i++)
        {
            agregarHabi(new Habitacion(codigo[i]));
        }

    }

    public void agregarHabi(Habitacion agregarHabi){
        habitacion.add(agregarHabi);
    }

    public ArrayList<Habitacion> getHabitacion(){
        return habitacion;
    }
    
}

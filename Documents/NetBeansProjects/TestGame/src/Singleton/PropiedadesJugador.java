/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author EdwinLovo
 */
public class PropiedadesJugador {
    
    private static PropiedadesJugador instance;
    private static long score2;
    private static long score;
    private static int vida = 3;
    private static long monedas = 0;
    private static long contador=0;

    private PropiedadesJugador() {
    }
    
    public synchronized static PropiedadesJugador getInstance() {
        if(instance == null){
            instance = new PropiedadesJugador();
        }
        return instance;
    }

    public static long getContador() {
        return contador;
    }

    public static void setContador(long contador) {
        PropiedadesJugador.contador = contador;
    }
    
    public static long getScore2() {
        return score2;
    }

    public static void setScore2(long score2) {
        PropiedadesJugador.score2 = score2;
    }
    
    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        PropiedadesJugador.score = score;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        PropiedadesJugador.vida = vida;
    }

    public long getMonedas() {
        return monedas;
    }

    public void setMonedas(long monedas) {
        PropiedadesJugador.monedas = monedas;
    }
  
}
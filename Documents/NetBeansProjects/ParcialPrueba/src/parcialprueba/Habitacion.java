/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprueba;

/**
 *
 * @author Frank
 */
public class Habitacion {
    private String codigo  = null;
    private boolean reservado = false;

    Habitacion(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   
    void cancelar(){
        reservado = false;
    }
    
    public boolean yaReservado(){
        return reservado;
    }

    public void setReservado(boolean reservado){
        this.reservado = reservado;
    }
    
}

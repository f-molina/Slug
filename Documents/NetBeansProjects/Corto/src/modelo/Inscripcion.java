/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Frank
 */
public class Inscripcion {
    private int id;
    private String nombre, apellidos, profesion, afp;
    private int edad;
    boolean estado;

    public Inscripcion() {
    }

    public Inscripcion(int id, String nombre, String apellidos, String profesion, int edad, String afp, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.edad = edad;
        this.afp = afp;
        this.estado = estado;
    }

    public Inscripcion(String nombre, String apellidos, String profesion, int edad, String afp, boolean estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.edad = edad;
        this.afp = afp;
        this.estado = estado;
    }

    public Inscripcion(String nombre, String apellidos, String profesion, int edad, String afp) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.edad = edad;
        this.afp = afp;
    }

    public Inscripcion(String nombre, String apellidos, String profesion, String afp, boolean estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.afp = afp;
        this.estado = estado;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}

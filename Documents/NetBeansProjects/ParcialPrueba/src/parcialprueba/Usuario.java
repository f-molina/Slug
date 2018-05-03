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
public class Usuario {
    
    public String user;
    public String password;

    public Usuario() {
    }

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su usuario");
        System.out.print(": ");
        user = leer.nextLine();
        System.out.println("Ingrese su contrasenia");
        System.out.print(": ");
        password = leer.nextLine();
        if(user.equals("admin") && password.equals("admin")){
            System.out.println("Ha iniciado sesion como administrador\n");
            Menu menu = new Menu();
            menu.menuAdmin();
        }else if(user.equals("empleado") && password.equals("empleado")){
            System.out.println("Ha iniciado sesion como empleado\n");
            Menu menu2 = new Menu();
            menu2.menuEmpleado();
        }else{
            System.out.println("Credenciales incorrectas");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idb;

import conexion.Conexion;
import interfaz.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inscripcion;

/**
 *
 * @author Frank
 */
public class InscripcionDb implements metodos<Inscripcion>{
    
    private static final Conexion con =  Conexion.conectar();
    
    private static final String SQL_INSERT = "INSERT INTO inscripciones (id, numAfiliacion, nombres, apellidos,  edad, profesion, estado) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE inscripciones SET numAfiliacion=?, nombres=?, apellidos=?, edad=?, profesion=?, estado=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM inscripciones WHERE id=?";
    private static final String SQL_READ = "SELECT * FROM inscripciones WHERE id=? ";
    private static final String SQL_READALL = "SELECT * FROM inscripciones";

    @Override
    public boolean create(Inscripcion i) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setInt(1, i.getId());
            ps.setString(2, i.getAfp());
            ps.setString(3, i.getNombre());
            ps.setString(4, i.getApellidos());
            ps.setInt(5, i.getEdad());
            ps.setString(6, i.getProfesion());
            ps.setBoolean(7, true);
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(InscripcionDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(InscripcionDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Inscripcion c) {
        PreparedStatement ps;
        try{
            System.out.println(c.getId());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getAfp());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getApellidos());
            ps.setInt(5, c.getEdad());
            ps.setString(6, c.getProfesion());
            ps.setBoolean(7, true);
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(InscripcionDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Inscripcion read(Object key) {
        Inscripcion i = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                i = new Inscripcion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getBoolean(7));
            }
            rs.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(InscripcionDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return i;
    }

    @Override
    public ArrayList<Inscripcion> readAll() {
        ArrayList<Inscripcion> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new Inscripcion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getBoolean(7)));
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(InscripcionDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return all;
    }
    
}

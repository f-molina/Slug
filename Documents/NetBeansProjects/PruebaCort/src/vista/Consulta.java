/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class Consulta extends JFrame{
    
    public JLabel lblNombre, lblClasificacion, lblDirector, lblAnio, lblPais, lblProyeccion;
    public JTextField nombre, director, anio, pais;
    public JComboBox clasificacion;
    public JCheckBox proyeccion;
    public JTable resultados;
    public JPanel table;
    
    public JButton buscar, eliminar, insertar, actualizar;
    
    public static final int ANCHOC = 130, ALTOC = 30;
    DefaultTableModel tm;
    
    public Consulta(){
        super("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNombre);
        container.add(lblClasificacion);
        container.add(lblDirector);
        container.add(lblAnio);
        container.add(lblPais);
        container.add(lblProyeccion);
        container.add(nombre);
        container.add(director);
        container.add(anio);
        container.add(pais);
        container.add(clasificacion);
        container.add(proyeccion);
        container.add(buscar);
        container.add(eliminar);
        container.add(insertar);
        container.add(actualizar);
        container.add(table);
        setSize(650,550);
    }
    
    public final void agregarLabels(){
        lblNombre = new JLabel("Nombre");
        lblClasificacion = new JLabel("Clasificacion");
        lblDirector = new JLabel("Director");
        lblAnio = new JLabel("Anio");
        lblPais = new JLabel("Pais");
        lblProyeccion = new JLabel("En Proyeccion");
        lblNombre.setBounds(50, 10, ANCHOC, ALTOC);
        lblClasificacion.setBounds(350, 10, ANCHOC, ALTOC);
        lblDirector.setBounds(50, 50, ANCHOC, ALTOC);
        lblAnio.setBounds(350, 50, ANCHOC, ALTOC);
        lblPais.setBounds(50, 100, ANCHOC, ALTOC);
        lblProyeccion.setBounds(350, 100, ANCHOC, ALTOC);
    }
    
    public final void formulario(){
        nombre = new JTextField();
        clasificacion = new JComboBox();
        director = new JTextField();
        anio = new JTextField();
        pais = new JTextField();
        proyeccion = new JCheckBox();
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("insertar");
        actualizar = new JButton("actualizar");
        eliminar = new JButton("eliminar");
        
        table = new JPanel();
        
        clasificacion.addItem("FRAM");
        clasificacion.addItem("WIX");
        clasificacion.addItem("Luber Finer");
        clasificacion.addItem("OSK");
        
        nombre.setBounds(140,10,ANCHOC,ALTOC);
        clasificacion.setBounds(450,10,ANCHOC,ALTOC);
        director.setBounds(140,50,ANCHOC,ALTOC);
        anio.setBounds(450,50,ANCHOC,ALTOC);
        pais.setBounds(140,100,ANCHOC,ALTOC);
        proyeccion.setBounds(500,100,50,ALTOC);
        
        buscar.setBounds(450,210,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,600,200);
        table.add(new JScrollPane(resultados));
        
    }
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                        case 1:
                        return String.class;
                        case 2:
                        return String.class;
                        default:
                        return Boolean.class;
                }
            }
        };
        
        tm.addColumn("Nombre");
        tm.addColumn("Director");
        tm.addColumn("Pais");
        tm.addColumn("Clasificacion");
        tm.addColumn("Anio");
        tm.addColumn("En Proyeccion");
        
        resultados.setModel(tm);
    }
    
    public static void main(String[] args){
            java.awt.EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    new Consulta().setVisible(true);
                }
            });
        }
    
    
    
    
    
}

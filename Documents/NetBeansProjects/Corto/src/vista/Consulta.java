/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Idb.InscripcionDb;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inscripcion;

/**
 *
 * @author Frank
 */
public class Consulta extends JFrame{
    
    public JLabel lblafp, lblnombre, lblapellido, lbledad, lblprofesion, lblestado;
    public JTextField afp, nombre, apellido, edad;
    public JComboBox profesion;
    
    ButtonGroup estado = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    public JPanel table;
    
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    
    public static final int ANCHOC = 130, ALTOC = 30;
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblafp);
        container.add(lblnombre);
        container.add(lblapellido);
        container.add(lbledad);
        container.add(lblprofesion);
        container.add(lblestado);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600,600);
        eventos();
        
    }
    
    public final void agregarLabels(){
        lblafp = new JLabel("N AFP");
        lblnombre = new JLabel("Nombres");
        lblapellido = new JLabel("Apellidos");
        lbledad = new JLabel("Edad");
        lblprofesion = new JLabel("Profesion");
        lblestado = new JLabel("Estado");
        lblafp.setBounds(10, 10, ANCHOC, ALTOC);
        lblnombre.setBounds(10, 60, ANCHOC, ALTOC);
        lblapellido.setBounds(10, 100, ANCHOC, ALTOC);
        lbledad.setBounds(10, 140, ANCHOC, ALTOC);
        lblprofesion.setBounds(10, 140, ANCHOC, ALTOC);
        lblestado.setBounds(10, 140, ANCHOC, ALTOC);
    }
    
    public final void formulario(){
        afp = new JTextField();
        nombre = new JTextField();
        apellido = new JTextField();
        edad = new JTextField();
        profesion = new JComboBox();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("insertar");
        actualizar = new JButton("actualizar");
        eliminar = new JButton("eliminar");
        limpiar = new JButton("limpiar");
        
        table = new JPanel();
        
        profesion.addItem("Ingenierio");
        profesion.addItem("Licenciado");
        profesion.addItem("Abogado");
        profesion.addItem("Doctor");
        
        estado = new ButtonGroup();
        estado.add(si);
        estado.add(no);
        
        afp.setBounds(140,10,ANCHOC,ALTOC);
        nombre.setBounds(140,60,ANCHOC,ALTOC);
        apellido.setBounds(140,100,ANCHOC,ALTOC);
        edad.setBounds(140,100,ANCHOC,ALTOC);
        profesion.setBounds(140,100,ANCHOC,ALTOC);
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        limpiar.setBounds(450,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
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
        
        tm.addColumn("N AFP");
        tm.addColumn("Nombres");
        tm.addColumn("Apellidos");
        tm.addColumn("Profesion");
        tm.addColumn("Estado");
        
        InscripcionDb id = new InscripcionDb();
        ArrayList<Inscripcion> inscripcion = id.readAll();
        
        for(Inscripcion in : inscripcion){
            tm.addRow(new Object[]{in.getAfp(), in.getNombre(), in.getApellidos(), in.getProfesion(), in.isEstado()});
        }
        
        resultados.setModel(tm);
    }
    
    public void eventos(){
        insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                InscripcionDb in = new InscripcionDb();
                Inscripcion i = new Inscripcion(nombre.getText(), apellido.getText(), profesion.getSelectedItem().toString(), Integer.parseInt(edad.getText()),
           afp.getText());
            
            if(no.isSelected()){
                i.setEstado(false);
            }
            
            if(in.create(i)){
                JOptionPane.showMessageDialog(null, "Alumno registrado con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al inscribir");
            }
            }
        });
        
        actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            InscripcionDb fd = new InscripcionDb();
            Inscripcion i = new Inscripcion(nombre.getText(), apellido.getText(), profesion.getSelectedItem().toString(), Integer.parseInt(edad.getText()),
            afp.getText());
            
            if(no.isSelected()){
                i.setEstado(false);
            }
            
            if(fd.update(i)){
                JOptionPane.showMessageDialog(null, "Alumno modificado con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar");
            }
        }
        });
        
        eliminar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            InscripcionDb in = new InscripcionDb();
            if(in.delete(afp.getText())){
                JOptionPane.showMessageDialog(null, "Alumno Eliminado con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio problema al eliminar alumno");
            }
        }   
    });
        
        buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                InscripcionDb fd = new InscripcionDb();
                Inscripcion f = fd.read(afp.getText());
                if(f==null){
                    JOptionPane.showMessageDialog(null, "no se encontro alumno ");
                }else{
                    JOptionPane.showMessageDialog(null, "Se encontro alumno! ");
                    afp.setText(f.getAfp());
                    nombre.setText(f.getNombre());
                    apellido.setText(f.getApellidos());
                    profesion.setSelectedItem(f.getProfesion());
                    //estado
                    
                    if(f.isEstado()){
                        si.setSelected(true);
                    }else{
                        no.setSelected(true);
                    }
                }
            }
        });
        
        limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                limpiarCampos();
            }
        });
    }
    
    public void limpiarCampos(){
            afp.setText("");
            profesion.setSelectedItem("Ingeniero");
            nombre.setText("");
            apellido.setText("");
            edad.setText("");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Octavio
 */
public class Controlador {
    private Cliente cliente;
    private VPrincipal vp;
    private VNuVenta vnv;
    private VNuCliente vnc;
    private Edit edit;
    
   
    
    
    
    public Controlador(){
        vp = new VPrincipal();
        vnv = new VNuVenta(vp,true);
        vnc = new VNuCliente(vnv,true);
        edit=new Edit(vp,true);
       
    }
    
    public void ejecutar(){
        vp.setControlador(this);
        vp.setVisible(true);
        
        vnv.setControlador(this);
        vnc.setControlador(this);
        edit.setControlador(this);
        
    }
    
    
    public void procesar(String valor){
        if(valor.equals(vp.BTN_NUEVA_VENTA)){
            vnv.setVisible(true);
        }
        
        if(valor.equals(vnv.BTN_NUEVO_CLIENTE)){
            vnc.setVisible(true);
        }
        
        if(valor.equals(vnc.BTN_AGREGAR_CLIENTE)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            
            String nombre      = vnc.getNombre();      
            String apellido    = vnc.getApellido();
            int dni            = vnc.getDNI();
            String fechaNac    =  vnc.getFechaNac();
            String ciudad      = vnc.getCiudad();
            String direccion   = vnc.getDireccion();
            int telFijo        = vnc.getTelFijo();
            int celular        = vnc.getCelular();
            String correo      = vnc.getCorreo();
            
            
            
             String SQL = "INSERT INTO cliente (nombre,apellido,dni,fecha_nacimiento,tel_fijo,tel_movil,ciudad,direccion,correo) "
                      +    "VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+fechaNac+"','"+telFijo+"','"+celular+"','"+ciudad+"','"+direccion+"','"+correo+"')";
              
              
              // cliente = new Cliente(nombre,apellido,DNI,fechaNac,Ciudad,direccion,telFijo,celular,correo);
              
              /* String SQL = "INSERT INTO cliente (idCliente,nombre,apellido,dni,fecha_nacimiento,tel_fijo,tel_movil,ciudad,direccion,correo) "
                      +    "VALUES ('"+vnc.getNombre()+"','"+vnc.getApellido()+"','"+vnc.getDNI()+"','"+vnc.getFechaNac()+"','"+vnc.getTelFijo()+"','"+vnc.getCelular()+"','"+vnc.getCiudad()+"','"+vnc.getDireccion()+"','"+vnc.getCorreo()+"')"; */
              
              
              try{
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
                  
              }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
            
            
     
        }
    }
    /*EMMANUEL PROGRAMACION*/
    public void proc(String valor){
    if(valor.equals(vp.BTN_NUEVO_EDITORIAL)){
            edit.setVisible(true);
        }
    }
public void alta(String valor){
if(valor.equals(edit.BTN_NUEVO_PRO)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
    String n= edit.getnombreeditorial(); 
    if(n.equals(""))
    { JOptionPane.showMessageDialog(null,"Debe tener un nombre editorial");}
    else{
   

    
    
    String nombre      = edit.getnombreeditorial();
      int telefono        = edit.gettelefonoeditorial();
    String direccion      = edit.getdireccioneditorial();
    String ciudad      = edit.getciudadeditoral();
    
    String SQL = "INSERT INTO editorial (nombre,telefono,direccion,ciudad) "
                      +    "VALUES ('"+nombre+"','"+telefono+"','"+direccion+"','"+ciudad+"')";
    
    
       try{  
           
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
                  
              }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              } 
}
        }
}
    
    
    
   
    

   
    
}

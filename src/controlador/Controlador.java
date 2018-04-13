/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

/**
 *
 * @author Octavio
 */
public class Controlador {
    private Cliente cliente;
    private VPrincipal vp;
    private VNuVenta vnv;
    private VNuCliente vnc;
    
    
    
    public Controlador(){
        vp = new VPrincipal();
        vnv = new VNuVenta(vp,true);
        vnc = new VNuCliente(vnv,true);
        
       
    }
    
    public void ejecutar(){
        vp.setControlador(this);
        vp.setVisible(true);
        
        vnv.setControlador(this);
        vnc.setControlador(this);
    }
    
    
    public void procesar(String valor){
        if(valor.equals(vp.BTN_NUEVA_VENTA)){
            vnv.setVisible(true);  
        }
        
        if(valor.equals(vnv.BTN_NUEVO_CLIENTE)){
            vnc.setVisible(true);
        }
        
        if(valor.equals(vnc.BTN_AGREGAR_CLIENTE)){
            cliente = new Cliente(vnc.getNombre(),vnc.getApellido(),vnc.getDNI(),vnc.getFechaNac(),vnc.getCiudad(),vnc.getDireccion(),vnc.getTel(),
                      vnc.getCorreo());
            
         //   String sql = INSERT INTO cliente (nombre,apellido,dni,fecha_nacimiento,tel_fijo,tel_movil,ciudad,direccion,correo) VALUES (vnc.getNombre(),vnc.getApellido(),vnc.getDNI(),vnc.getFechaNac(),vnc.getTel(),null,vnc.getCiudad(),vnc.getDireccion(),
          //               vnc.getCorreo());
            
            
            
        }
    }
    
}

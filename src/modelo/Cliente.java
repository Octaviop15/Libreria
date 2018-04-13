/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Octavio
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String fechaNacimiento;
    private String ciudad;
    private String domicilio;
    private int tel_fijo;
    private int tel_movil;
    private String correo;
    
    public Cliente(){
        
    }
    
    public Cliente(String nombre,String apellido,int dni,String fechaNac,String ciudad,String domicilio,int tel,String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNac;
        this.ciudad = ciudad;
        this.domicilio = domicilio;
        this.tel_fijo = tel;
        this.correo = correo;
        
    }
    
}

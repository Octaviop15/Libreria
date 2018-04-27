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
public class Empleado {
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

    public Empleado() {
    }

    
    
    public Empleado(int id, String nombre, String apellido, int dni, String fechaNacimiento, String ciudad, String domicilio, int tel_fijo, int tel_movil, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.domicilio = domicilio;
        this.tel_fijo = tel_fijo;
        this.tel_movil = tel_movil;
        this.correo = correo;
    }
     
    
    
    
}

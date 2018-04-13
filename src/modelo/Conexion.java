/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Octavio
 */


public class Conexion {
    private String bd = "libreria";
    private String url = "jdbc:mysql://localhost/libreria";
    private String user = "root";
    private String pass = "";

    Connection conn = null;

    public Conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"e");
        }
        }

    public Connection getConexion(){
        return conn;
    }

    }

    


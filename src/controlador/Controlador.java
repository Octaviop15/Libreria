/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.lang.invoke.MethodHandles;


import java.math.BigInteger;
import modelo.*;
import vista.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Octavio
 */
public class Controlador {
    private Cliente cliente;
    private VPrincipal vp;
    private VNuVenta vnv;
    private VNuCliente vnc;
    private VLibro vl;
    private VModLibro vml;
    private VCompra vc;
    private Edit edit;
    private EditM editm;
    private Vaut vaut;
    private VautorM vautorm;
    private Vcategoria vcategoria;
    private VmodiCliente vmodcliente;
    private Vmodificacioncliente vmodificacioncliente;
    private ValtaEmpleado valtaEmple;
    private Login login;
    /*Variables de ayuda*/
    String f;
    String o;
    String i;
    int bnb;
    int tkl;
    int iden;
    int iddomi;
    int idturno;
    int dom;
    int turro;
    String  e;
    String h;
    String t;
    /*-------------------*/
    
    public Controlador(){
        vp = new VPrincipal();
        vnv = new VNuVenta(vp,true);
        vnc = new VNuCliente(vnv,true);
        vl = new VLibro(vp, true);
        vml = new VModLibro(vp, true);
        vc = new VCompra(vp, true);
        
   
        
        
        
        valtaEmple = new ValtaEmpleado(vp, true);
        edit=new Edit(vp,true);
        editm = new EditM(null,true);
         vaut= new Vaut(vp,true);
      vautorm= new VautorM(null,true);
      vcategoria = new Vcategoria(vp,true);
       vmodcliente=new VmodiCliente(null,true);
       vmodificacioncliente=new Vmodificacioncliente(null,true);
       login=new Login ();
    }
     public void ejecutar0(){
         login.setLocationRelativeTo(null);
       login.setControlador(this);
       login.setVisible(true);
    }
    
    public void ejecutar(){
        vp.setControlador(this);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
        vnv.setControlador(this);
        vnv.setLocationRelativeTo(null);
        vnc.setControlador(this);
        vnc.setLocationRelativeTo(null);
        vl.setControlador(this);
        vl.setLocationRelativeTo(null);
        vml.setControlador(this);
        vml.setLocationRelativeTo(null);
        vc.setControlador(this);
        vc.setLocationRelativeTo(null);
        edit.setControlador(this);
        edit.setLocationRelativeTo(null);
        editm.setControlador(this);
        editm.setLocationRelativeTo(null);
        valtaEmple.setControlador(this);
   
        mostar();
        mostrar();
        motacho();
        mostrarempleado();
        mostarUser();
        vautorm.setControlador(this);
        vautorm.setLocationRelativeTo(null);
        vaut.setControlador(this);
        vaut.setLocationRelativeTo(null);
        vcategoria.setControlador(this);
        vcategoria.setLocationRelativeTo(null);
        vmodcliente.setControlador(this);
        vmodcliente.setLocationRelativeTo(null);
        vmodificacioncliente.setControlador(this);
        vmodificacioncliente.setLocationRelativeTo(null);
    
        
    }
     public void ejecutarusuario(){
        vp.setControlador(this);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
        vnv.setControlador(this);
        vnv.setLocationRelativeTo(null);
        vnc.setControlador(this);
        vnc.setLocationRelativeTo(null);
        vl.setControlador(this);
        vl.setLocationRelativeTo(null);
        vml.setControlador(this);
        vml.setLocationRelativeTo(null);
        vc.setControlador(this);
        vc.setLocationRelativeTo(null);
        edit.setControlador(this);
        edit.setLocationRelativeTo(null);
        editm.setControlador(this);
        editm.setLocationRelativeTo(null);
        valtaEmple.setControlador(this);
   
        mostar();
        mostrar();
        motacho();
        mostrarempleado();
        mostarUser();
        vautorm.setControlador(this);
        vautorm.setLocationRelativeTo(null);
        vaut.setControlador(this);
        vaut.setLocationRelativeTo(null);
        vcategoria.setControlador(this);
        vcategoria.setLocationRelativeTo(null);
        vmodcliente.setControlador(this);
        vmodcliente.setLocationRelativeTo(null);
        vmodificacioncliente.setControlador(this);
        vmodificacioncliente.setLocationRelativeTo(null);
        
       vp.jMenu5.setEnabled(false);
       vp.menuItemCompra.setEnabled(false);
    }
    
    
    
    
    //OCTAVIO PROGRAMACION
    
    //metodo para cargar los libros en el jTable de la ventana libros
    public void cargarLibros(){
        Conexion conectar = new Conexion();
        Connection conn = conectar.getConexion();
        
        Object[] datos = new Object[8];
        String SQL = "SELECT * FROM libro";
        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0] = rs.getString("ISBN");
                datos[1] = rs.getString("titulo");
                datos[3] = rs.getString("Edicion");
                datos[5] = rs.getDouble("precio_venta");
                datos[6] = rs.getDouble("precio_compra");
                datos[7] = rs.getString("stock");
                
                //para mostrar en el jTable el nombre de autor y editorial primero obtenemos su respectivos id
                //obtenemos el idAutor y el idEditorial de la tabla libros 
                String idAutor = rs.getString("idAutor");
                String idEditorial = rs.getString("idEditorial");
                
                   //de acuerdo al idAutor obtenido anteriormente nos vamos a la tabla autor y obtenemos el nombre
                   String SQL1 = "SELECT nombre FROM autor where idAutor = '"+idAutor+"'";
                   Statement st1 = conn.createStatement();
                   ResultSet rs1 = st1.executeQuery(SQL1);
                   while(rs1.next()){
                       datos[2] = rs1.getString("nombre");
                   }
                   
                   //de acuerdo al idEditorial obtenido anteriormente nos vamos a la tabla editorial y obtenemos el nombre
                   String SQL2 = "SELECT nombre FROM editorial where idEditorial = '"+idEditorial+"'";
                   Statement st2 = conn.createStatement();
                   ResultSet rs2 = st2.executeQuery(SQL1);
                   while(rs2.next()){
                       datos[4] = rs2.getString("nombre");
                   
                   }
                   
                   //ya teniendo todos los datos que queremos mostrar en la tabla los agregamos
                   vl.insertarFila(datos);
          
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        
        }

    }
    
  
    
    //metodo para pasar las editoriales al jComboBox de la ventana libro
     public void obtenerEditorialComboBox(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          
          
          String SQL = "SELECT idEditorial,nombre FROM editorial";
          vl.setComboBoxEditorial("Seleccione una editorial");
          vml.setComboBoxEditorial("Seleccione una editorial");
          try {
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(SQL);
              while(rs.next()){
                  String nombre = rs.getString("nombre");
                  int idEditorial = rs.getInt("idEditorial");
                  
                  vl.setComboBoxEditorial(nombre);
                  vml.setComboBoxEditorial(nombre);
                  vl.addIdEditorial(idEditorial);
                  vml.addIdEditorial(idEditorial);
                 
                  
                  
              }   
          } catch (Exception e) {
          }
     }
     
     //metodo para pasar las editoriales al JComboBox de la ventana compra
     public void obtenerEditorialComboBoxCompra(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          String SQL = "SELECT idEditorial,nombre FROM editorial";
          vc.setComboBoxEditorial("Seleccione una editorial");
          try {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL);
             while(rs.next()){
                 String nombre = rs.getString("nombre");
                 int idEditorial = rs.getInt("idEditorial");
                 
                 vc.setComboBoxEditorial(nombre);
                 vc.addIdEditorial(idEditorial);
                 
                 
             }
         } catch (Exception e) {
         }
         
     }
     
     //metodo para pasar los autores al jComboBox de la ventana libro
     public void obtenerAutorComboBox(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          String SQL = "SELECT idAutor,nombre FROM autor";
          vl.setComboBoxAutor("Seleccione un autor");
          vml.setComboBoxAutor("Seleccione un autor");
          try {
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(SQL);
              while(rs.next()){                  
                  String nombre = rs.getString("nombre");
                  int idAutor = rs.getInt("idAutor");
                  
                  vl.setComboBoxAutor(nombre);
                  vml.setComboBoxAutor(nombre);
                  vl.addIdAutor(idAutor);
                  vml.addIdAutor(idAutor);
                  
                  
                  
              }   
          } catch (Exception e) {
          }
     }
     
     //Metodo para obtener pasar las categorias al jComboBox de la ventana libro
     public void obtenerCategoriaComboBox(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          String SQL = "SELECT * FROM categoria";
          vl.setComboBoxCategoria("Seleccione una categoria");
          vml.setComboBoxCategoria("Seleccione una categoria");
          
          try {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL);
             while(rs.next()){
                 String nombre = rs.getString("nombre");
                 int idCategoria = rs.getInt("idCategoria");
                 
                 vl.setComboBoxCategoria(nombre);
                 vml.setComboBoxCategoria(nombre);
                 vl.addIdCategoria(idCategoria);
                 vml.addIdCategoria(idCategoria);
                 
             }
         } catch (Exception e) {
         }
         
     }
     
     
         
     
    // ACCESOS A LA VISTA DE EMPLEADO
     

    public void pasarAvistaAgregarEmpleado(String valor) {
        if(valor.equals(vp.BTN_ALTA_EMPLEADO)){
            valtaEmple.setVisible(true);
        }
    }
    
    public void procesar(String valor){
        if(valor.equals(vp.BTN_VENTA)){
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
            String fechaNac    = vnc.getFechaNac();
            String ciudad      = vnc.getCiudad();
            String direccion   = vnc.getDireccion();
            String telFijo       = vnc.getTelFijo();
            String celular        = vnc.getCelular();
            String correo      = vnc.getCorreo();
            
            
            
            
             String SQL1 = "INSERT INTO domicilio (direccion) "
                      +    "VALUES ('"+direccion+"')";
             
             String SQL2= "SELECT idDomicilio FROM domicilio WHERE direccion='"+direccion+"' ";
             
              try{
               
                
                  Statement st1 = conn.createStatement();
                  st1.executeUpdate(SQL1);
                 
                  Statement st2= conn.createStatement();
                  ResultSet rs=st2.executeQuery(SQL2);
                  if(rs.next()){
                       
                       int idDomicilio= rs.getInt("idDomicilio");
   
    
                       String SQL3 = "INSERT INTO cliente (nombre,apellido,DNI,fecha_nacimiento,tel_fijo,tel_movil,ciudad,correo,idDomicilio2) "
                      +    "VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+fechaNac+"','"+telFijo+"','"+celular+"','"+ciudad+"','"+correo+"','"+idDomicilio+"')";
                
   
                  Statement st3 = conn.createStatement();
                  st3.executeUpdate(SQL3);
              }
                    
     
                  
              }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
              JOptionPane.showMessageDialog(null,"Cliente agregado");
              vnc.limpiar();
        }
        
        //VENTANA VENTA
        if(valor.equals(vnv.BTN_BUSCAR_CLIENTE)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            int idDomicilio;
            
            String[] datos = new String[3];
            int DNI = vnv.getDNI();
            
            String SQL1 = "SELECT nombre,apellido,idDomicilio FROM cliente WHERE DNI = '"+DNI+"'";
            
            try{
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(SQL1);
                if(rs1.next()){
                    idDomicilio = rs1.getInt("idDomicilio");
                    datos[0] = rs1.getString("nombre");
                    datos[1] = rs1.getString("apellido"); 
                    
                    String SQL2 = "SELECT direccion FROM domicilio WHERE idDomicilio = '"+idDomicilio+"'";
                    Statement st2= conn.createStatement();
                    ResultSet rs2= st2.executeQuery(SQL2);
                    if(rs2.next()){
                        datos[2] = rs2.getString("direccion");                                                              
                }           
                    
               
                }
                vnv.setNombre(datos[0]);
                vnv.setApellido(datos[1]);
                vnv.setDireccion(datos[2]);
                
            }
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
               
        }
         
        }
        
          //VENTANA VENTA
          if(valor.equals(vnv.BTN_BUSCAR_LIBRO)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            String[] datos = new String[3];
            int ISBN = vnv.getISBN();
            String SQL = "SELECT * FROM libro WHERE ISBN = '"+ISBN+"'";
            
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while(rs.next()){
                    datos[0] = rs.getString("titulo");
                    datos[1]  =rs.getString("precio_venta");
                    datos[2] = rs.getString("stock");        
                }
                
                  vnv.setTitulo(datos[0]);
                  vnv.setPrecio(datos[1]);
                  vnv.setStock(datos[2]);
                  vnv.visibilidadCantOn();
                
                
            }
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
               
        }
            
          
            
        }
             //VENTANA VENTA 
             if(valor.equals(VNuVenta.BTN_AGREGAR_DETALLE_VENTA)){
                
                 boolean b = false;
                   for(int i=0;i<vnv.getCantFilasTabla();i++){
                     if(vnv.getISBN() == vnv.getISBN_tabla(i)){
                         b = true;
                     }
                   }
                 if(vnv.getCantidad() <= vnv.getStock()){ 
                   if(b==false){
                 
                 Object[] datos = new Object[5];
                 int ISBN = vnv.getISBN();
                 
                 datos[0] = vnv.getISBN();
                 datos[1] = vnv.getTitulo();
                 datos[2] = vnv.getCantidad();
                 datos[3] = vnv.getPrecio();               
                 datos[4] = vnv.getSubtotal();
                 
                 vnv.insertarFila(datos);
                 vnv.limpiar();
                 vnv.visibilidadCantOff();
                 }
                   else{
                       JOptionPane.showMessageDialog(null,"Libro con ISBN ya ingresado");
                   }
                 }
                 
                 else{
                         JOptionPane.showMessageDialog(null,"Stock insuficiente");
                 }
                 
    }
             
           //VENTANA VENTA
           if(valor.equals(vnv.BTN_ELIMINAR_DETALLE_VENTA)){
               int fila = vnv.getFila();
               if(fila >= 0){
               vnv.eliminarFila(fila);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Seleccione una fila");
               }
               
           }  
           
           //VENTANA VENTA
           if(valor.equals(vnv.BTN_FINALIZAR_CARGA)){
               
               vnv.setTotal(vnv.getTotal());
               
           }
           
           //VENTANA VENTA
           if(valor.equals(vnv.BTN_GENERAR_VENTA)){
                Conexion conectar = new Conexion();
                Connection conn   = conectar.getConexion();
                
                int cantFilas = vnv.getCantFilasTabla();
                int modoPago  = vnv.getModoPago();
                int stock;
                String fecha    = vnv.getFecha();                       
                double total       = vnv.getTotalf();
                int dni         = vnv.getDNI();
                     
                
                
                if(modoPago > 0){
                for(int i=0;i<cantFilas;i++){
                    int ISBN = vnv.getISBN_tabla(i);
                    String SQL1 = "SELECT stock from libro WHERE ISBN ='"+ISBN+"'";
                    
                    try {
                        Statement st1 = conn.createStatement();
                        ResultSet rs = st1.executeQuery(SQL1);
                        while(rs.next()){
                            stock = rs.getInt("stock");
                            stock = stock - 1;
                            String SQL2 = "UPDATE libro SET stock = '"+stock+"' where ISBN='"+ISBN+"'";
                            Statement st2  =conn.createStatement();
                            st2.executeUpdate(SQL2);
                        }
                        
                        
                    }catch (Exception e) {
                          JOptionPane.showMessageDialog(null, e);
                    }
                }
                        
                        
                String SQL3 = "SELECT idCliente FROM cliente WHERE DNI = '"+dni+"'";
                        
                try {                             
                    Statement st2 = conn.createStatement();
                    ResultSet rs2 = st2.executeQuery(SQL3);
                    if(rs2.next()){                                                     
                        int idCliente = rs2.getInt("idCliente");
                        
                        String SQL4 = "INSERT INTO venta (fecha,total,idModoPago,idCliente,idUsuario) VALUES ('"+fecha+"','"+total+"','"+modoPago+"','"+idCliente+"','"+1+"')";
                        
                        Statement st3 = conn.createStatement();
                        st3.executeUpdate(SQL4);
                        ResultSet rs3 = st3.getGeneratedKeys();
                        if(rs3.next()){
                            int idVenta = rs3.getInt("idVenta");
                            JOptionPane.showMessageDialog(null, idVenta);
                        
                        
                        for(int i=0;i<cantFilas;i++){
                            int ISBN = vnv.getISBN_tabla(i);
                            int cantidad = vnv.getCant_table(i);
                            double subtotal = vnv.getSubtotal_tabla(i);
                            
                            String SQL5 = "INSERT INTO detalleVenta (cantidad,subtotal,idLibro,idVenta,idUsuario) VALUES ('"+cantidad+"','"+subtotal+"','"+ISBN+"','"+idVenta+"'";

                                }
                                           
                       }
                    }
                }catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e);
                       }
                        
                                                                                                                                                                                            
            }
                        
                        JOptionPane.showMessageDialog(null,"Venta generada con exito");
                        JOptionPane.showMessageDialog(null,"Stock actualizado");
                     
                    
                }
                
               
           

        
      
        //VENTANA LIBRO
        if(valor.equals(vp.BTN_LIBRO)){
            vl.limpiarComboBox();    
            vl.limpiarTabla();
             //llamamos a los metodos para que se carguen previamente los autores y las editoriales en el combo box 
            obtenerEditorialComboBox();
            obtenerAutorComboBox();
            obtenerCategoriaComboBox();
            //llamamos al metodo para que se carguen los libros en el jTable
            cargarLibros();
            vl.setVisible(true);
            
        }
        
        //VENTANA LIBRO
        if(valor.equals(vl.BTN_AGREGAR_LIBRO)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            int ISBN = vl.getISBN();
            String titulo = vl.getTitulo();
            String fecha = vl.getFecha();
            String edicion = vl.getEdicion();
            int paginas = vl.getPaginas();           
            double preciov = vl.getPrecioVenta();
            double precioc = vl.getPrecioCompra();
            int stock = vl.getStock();
            String descripcion = vl.getDescripcion();
            
            String nombreAutor = vl.getComboBoxAutor1();
            String nombreEditorial = vl.getComboBoxEditorial1();
           
            int ed = vl.getComboBoxEditorial2();
            int a = vl.getComboBoxAutor2();
            int c = vl.getComboBoxCategoria2();
            
            int idEditorial = vl.getIdEditorial(ed - 1 );
            int idAutor      = vl.getIdAutor(a - 1 );
            int idCategoria = vl.getIdCategoria(c - 1);
            
            
            Object[] datos = new Object[7];
            datos[0]       = ISBN;
            datos[1]       = titulo;           
            datos[2]       = nombreAutor;        
            datos[3]       = edicion;
            datos[4]       = nombreEditorial;
            datos[5]       = preciov;
            datos[6]       = precioc;
            datos[7]       = stock;
             
            
            
            String SQL = "INSERT INTO libro (ISBN,titulo,fecha_de_lanzamiento,paginas,descripcion,edicion,precio_venta,precio_compra,stock,idAutor,idEditorial,idCategoria) "
                       + "VALUES ('"+ISBN+"','"+titulo+"','"+fecha+"','"+paginas+"','"+descripcion+"','"+edicion+"','"+preciov+"','"+precioc+"','"+stock+"','"+idAutor+"','"+idEditorial+"','"+idCategoria+"')";
       
        try {
             Statement sentencia = conn.createStatement();
             sentencia.executeUpdate(SQL);
             vl.insertarFila(datos);
             vl.limpiar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        
        
        
        //VENTANA LIBRO
        if(valor.equals(vl.BTN_ELIMINAR_LIBRO)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            int fila = vl.getFila();
            if(fila >= 0){
                if (JOptionPane.showConfirmDialog(null,"Se eliminta la fila seleccionada") == JOptionPane.YES_OPTION){
                    
                    int ISBN = vl.getISBN_tabla();
                    String SQL = "DELETE FROM libro WHERE ISBN = '"+ISBN+"'";
                    
                    try {
                        Statement st = conn.createStatement();
                        st.executeUpdate(SQL);
                        vl.eliminarFila(fila);
                        
                    } catch (Exception e) {
                    }
                    
                    
                }
            }  
        }
        
        //VENTANA MODIFICAR LIBRO
        if(valor.equals(VLibro.BTN_MODIFICAR_LIBRO)){

            vl.limpiarComboBox();
            vml.limpiarComboBox();  
             
            
            //llamamos a los metodos para que se carguen previamente los autores y las editoriales en el combo box
            obtenerEditorialComboBox();
            obtenerAutorComboBox();
            obtenerCategoriaComboBox();
            
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            int fila = vl.getFila();
            if(fila>= 0){
            
            int ISBN = vl.getISBN_tabla();
           
            String SQL = "SELECT * FROM libro WHERE ISBN = '"+ISBN+"'";
            
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                if(rs.next()){
                    //establecemos los valores en los jTextField de la ventana modLibro
                    vml.setISBN(rs.getString("ISBN"));
                    vml.setTitulo(rs.getString("titulo"));
                    vml.setEdicion(rs.getString("edicion"));
                    vml.setFecha(rs.getString("fecha_de_lanzamiento"));
                    vml.setPaginas(rs.getInt("paginas"));
                    vml.setPreciov(rs.getDouble("precio_venta"));
                    vml.setPrecioc(rs.getDouble("precio_compra"));
                    vml.setStock(rs.getInt("stock"));
                    vml.setDescripcion(rs.getString("descripcion"));
                }
            }
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
             }
         
             vml.setVisible(true);   
            }
            
              else{
                JOptionPane.showMessageDialog(null,"Seleccione una fila");
            }
        }
             
             //VENTANA MODIFICAR LIBRO
             if(valor.equals(vml.BTN_ACEPTAR_MODIFICACION)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
             
            //incluimos los datos que se agregarar en el jTbale de libros           
            Object[] datos = new Object[8];
            datos[0]       = vml.getISBN();
            datos[1]       = vml.getTitulo();
            datos[2]       = vml.getComboBoxAutor1();
            datos[3]       = vml.getEdicion();
            datos[4]       = vml.getComboBoxEditorial1();
            datos[5]       = vml.getPreciov();
            datos[6]       = vml.getPrecioc();
            datos[7]       = vml.getStock();
            
            //incluimos los demas datos restantes para completar la sentencia SQL
            String fecha         = vml.getFecha();
            int paginas          = vml.getPaginas();
            String descripcion   = vml.getDescripcion();
            
            
            //Obtenemos los idEditorial, idAutor, idCategoria
            int ed = vml.getComboBoxEditorial2();
            int a = vml.getComboBoxAutor2();
            int c = vml.getComboBoxCategoria2();
            
            int idEditorial      = vml.getIdEditorial(ed - 1);
            int idAutor          = vml.getIdAutor(a - 1);
            int idCategoria      = vml.getIdCategoria(c - 1);
            
            int ISBN = vl.getISBN_tabla();
        
        
            String SQL = "UPDATE libro SET ISBN = '"+datos[0]+"', titulo='"+datos[1]+"', idAutor='"+idAutor+"', edicion='"+datos[3]+"', fecha_de_lanzamiento='"+fecha+"', paginas='"+paginas+"', idEditorial='"+idEditorial+"', precio_venta = '"+datos[5]+"',precio_compra='"+datos[6]+"', stock= '"+datos[6]+"', descripcion='"+descripcion+"', idCategoria='"+idCategoria+"' WHERE ISBN = '"+ISBN+"'";
            
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(SQL); 
                    vl.modificarFila(datos);
                    vml.limpiar();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
             }   
         
             
            //VENTANA COMPRA     
            if(valor.equals(vp.BTN_COMPRA)){
                vc.limpiarComboBox();
                obtenerEditorialComboBoxCompra();
                vc.setVisible(true);
            }
             
            //VENTANA COMPRA
            if(valor.equals(vc.BTN_BUSCAR_LIBRO_COMPRA)){               
                Conexion conectar = new Conexion();
                Connection conn   = conectar.getConexion();
                                         
                Object[] datos = new Object[3];
                    
                int idEditorial = vc.getidEditorial(vc.getComboBoxEditorial());
                int ISBN = vc.getISBN();
                   
                String SQL = "SELECT * FROM libro WHERE ISBN ='"+ISBN+"' and idEditorial= '"+idEditorial+"' ";
                
                try {
                    
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(SQL);
                    if(rs.next()){                                 
                                          
                        datos[0] = rs.getString("titulo");
                        datos[1] = rs.getInt("precio");
                        datos[2] = rs.getInt("stock");                                                      
                         
                    
                        vc.setTitulo(datos[0]);
                        vc.setPrecio(datos[1]);
                        vc.setStock(datos[2]);
                    }           
                     else{
                        JOptionPane.showMessageDialog(null,"No se encontro libro con la editorial especificada");
                    }
                         
                    } catch (Exception e) {
                         JOptionPane.showMessageDialog(null,e);  
                     }
                 }
            
            //VENTANA COMPRA
            if(valor.equals(vc.BTN_AGREGAR_DETALLE_COMPRA)){
                
                boolean b = false;
                for(int i=0;i<vc.getCantFilas();i++){
                    if(vc.getISBN() == vc.getISBN_tabla(i)){
                        b = true;
                    }}
                
                if(b==false){
                Object[] datos = new Object[5];
                datos[0] = vc.getISBN();
                datos[1] = vc.getTitulo();
                datos[2] = vc.getPrecio();
                datos[3] = vc.getCant();
                datos[4] = vc.getSubtotal();
                vc.insertarFila(datos);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Libro con ISBN ya ingresado");
                }
                

            }   
            
            
            
            //VENTANA COMPRA
            if(valor.equals(vc.BTN_ELIMINAR_DETALLE_COMPRA)){
                int fila = vc.getFila();
                if(fila >= 0){
                     if (JOptionPane.showConfirmDialog(null,"Se eliminta la fila seleccionada") == JOptionPane.YES_OPTION){
                         vc.eliminarFila(fila);
                     }
                     
                }
                else{
                    JOptionPane.showMessageDialog(null,"Seleccione una fila");
                }
                
            }
            
            
            //VENTANA COMPRA
            if(valor.equals(vc.BTN_OBTENER_TOTAL)){
                double total = vc.getTotal();
                vc.setTotal(total);
            }
            
            
            //VENTANA COMPRA
            if(valor.equals(vc.BTN_GENERAR_COMPRA)){
                Conexion conectar = new Conexion();
                Connection conn   = conectar.getConexion();
             
                int cantFilas = vc.getCantFilas();
                int stock;
                int idEditorial; 
                
                String fecha = vc.getFecha();
                for(int i=0;i<cantFilas;i++){
                    int ISBN = vc.getISBN_tabla(i);
                    int cant = vc.getCant_tabla(i);
                    double  subtotal = vc.getSubTotal_tabla(i);
                    double total = vc.getTotal();
                    
                    String SQL1 = "SELECT stock,idEditorial from libro WHERE ISBN ='"+ISBN+"'";
                   // String SQL2 = "SELECT idUsuario FROM usuario where nombre= '"+nombre+"'";
              
                    try {
                        Statement st1 = conn.createStatement();
                        ResultSet rs = st1.executeQuery(SQL1);
                        if(rs.next()){
                            stock = rs.getInt("stock");
                            idEditorial = rs.getInt("idEditorial");
                            stock = stock + cant;
                            String SQL2 = "UPDATE libro SET stock = '"+stock+"' where ISBN='"+ISBN+"'";
                            Statement st2  =conn.createStatement();
                            st2.executeUpdate(SQL2);
                        }
                    }
                            
                          catch (Exception e) {
                                  JOptionPane.showMessageDialog(null,e);  
                          }
                    
                 /*   String SQL2 = "INSERT INTO pedidos (fechaPedido,total,idEditorial,idUsuario) VALUES ('"+fecha+"','"+total+"','"+idEditorial+"','"+idUsuario+"')";
                    
                    String SQL3 = "INSERT INTO detallepedido(cantidad,subtotal,idPedido,idLibro) VALUES ('"+cant+"','"+subtotal+"''"+idPedido+"','"+ISBN+"'"; */
                    
                    
                                   
                                  
                         
                     }
                
                
                
            }
             
             
    }
    
    

             
             
             
             

    


 //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

   /*EMMANUEL PROGRAMACION*/
    public void proc(String valor){
    if(valor.equals(vp.BTN_EDITORIAL)){
            edit.setVisible(true);
            
        }
    }
public void alta(String valor){
if(valor.equals(edit.BTN_NUEVO_PRO)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
    String n= edit.getnombreeditorial();
    String p=edit.gettelefonoeditorial();
    if(n.equals("")||p.equals("") )
    { JOptionPane.showMessageDialog(null,"Debe tener un nombre y Telefono la editorial");}
    else{
   

    
    
    String nombre      = edit.getnombreeditorial();
    String telefono        = edit.gettelefonoeditorial();
    String direccion      = edit.getdireccioneditorial();
    String ciudad      = edit.getciudadeditoral();
    
    String SQL = "INSERT INTO editorial (nombre,telefono,ciudad) "
                      +    "VALUES ('"+nombre+"','"+telefono+"','"+ciudad+"')";
    
    
     String edi = "SELECT idEditorial FROM editorial WHERE nombre='"+nombre+"' ";
                      
    
      
       
    
    
       try{  
           
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
                 
                  
                  Statement lm = conn.createStatement();
                  ResultSet rs=lm.executeQuery(edi);
                  
                  
                  while(rs.next()){
    f=rs.getString("idEditorial");
   String flit = "INSERT INTO domicilio (direccion,Editorial_idEditorial) "
                      +    "VALUES ('"+direccion+"','"+f+"')";
                
   
                  Statement gs = conn.createStatement();
                  gs.executeUpdate(flit);
              }
       }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Editorial Agregada");
}
     mostar();
    edit.limp();  
        }
}/*aqui termina el alta*/

/*mostar usuario en el jtable*/
public void mostar(){
    
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idEditorial");
modo.addColumn("nombre");
modo.addColumn("telefono");
modo.addColumn("ciudad");
modo.addColumn("direccion");

edit.tabla.setModel(modo);

String sql="SELECT * FROM EDITORIAL";

String datos[]= new String [6];
try{
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    
     
    
    String edi = "SELECT direccion FROM domicilio WHERE Editorial_idEditorial='"+rs.getString(1)+"' ";
    
     Statement lm = conn.createStatement();
     ResultSet ns=lm.executeQuery(edi);
    
     while(ns.next()){
         i=ns.getString("direccion");
     }
     datos[4]=i;
    modo.addRow(datos);
    }
    
   
    
    edit.tabla.setModel(modo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}




}
 



    
public void buscar(String atri){
    if(atri.equals(edit.BTN_NUEVO_BUS)){
     buscando(edit.jTextField5.getText());
    edit.limpi();}
   
}
    
    
    
public void buscando(String value){
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idEditorial");
modo.addColumn("nombre");
modo.addColumn("telefono");
modo.addColumn("ciudad");
modo.addColumn("direccion");

edit.tabla.setModel(modo);

String sql;
if(value.equals("")){
 JOptionPane.showMessageDialog(null,"Ingrese una ID para buscar");
 mostar();
}
else{
   
 sql="SELECT * FROM EDITORIAL WHERE idEditorial='"+value+"'";        

String datos[]= new String [6];
try{
    Statement st =conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    
         String edi = "SELECT direccion FROM domicilio WHERE Editorial_idEditorial='"+rs.getString(1)+"' ";
    
     Statement lm = conn.createStatement();
     ResultSet ns=lm.executeQuery(edi);
    
     while(ns.next()){
         o=ns.getString("direccion");
     }
     datos[4]=o;
    modo.addRow(datos);
    }
    edit.tabla.setModel(modo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}

}


}
    
   
    

   public void sec(String atri){
    if(atri.equals(edit.BTN_NUEVO_ACT)){
     mostar();}
   
}
    
   public void consultar(String mod){
     
   if(mod.equals(edit.BTN_NUEVO_MOD))
   {
       
   int fila = edit.tabla.getSelectedRow();
   if(fila>=0){
       editm.ide.setText(edit.tabla.getValueAt(fila, 0).toString());
       editm.editxt.setText(edit.tabla.getValueAt(fila, 1).toString());
       editm.telefonoxtxt.setText(edit.tabla.getValueAt(fila, 2).toString());
       editm.diretxt.setText(edit.tabla.getValueAt(fila, 4).toString());
       editm.ciutxt.setText(edit.tabla.getValueAt(fila, 3).toString());
     editm.setVisible(true);
     
   
   
   
   
   
   
   
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }
   
    /*
        editm.editxt.setText(edit.tabla.getValueAt(fila, 1).toString());
       editm.telefonoxtxt.setText(edit.tabla.getValueAt(fila, 2).toString());
       editm.diretxt.setText(edit.tabla.getValueAt(fila, 3).toString());
       editm.ciutxt.setText(edit.tabla.getValueAt(fila, 4).toString());
   
   
       */
       public void modi(String valor){
if(valor.equals(editm.BTN_NUEVO_ACE)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
   String n= editm.getedi();
    String p=editm.gettel();
    if(n.equals("")||p.equals("") )
    { JOptionPane.showMessageDialog(null,"Debe tener un nombre y Telefono la editorial");}
    else{
        try{
    int idEditorial        = editm.getide();
    String nombre      = editm.getedi();
    String telefono        = editm.gettel();
    String direccion      = editm.getdirec();
    String ciudad      = editm.getciu();
    

    String Ssql = "UPDATE editorial SET nombre=?, telefono=?, ciudad=? "
                    + "WHERE idEditorial=?";
    
    String sql = "UPDATE domicilio SET direccion=? "
                    + "WHERE Editorial_idEditorial=?";
    
    PreparedStatement prest = conn.prepareStatement(Ssql);
    PreparedStatement tic = conn.prepareStatement(sql);
    
    prest.setString(1,nombre);
        prest.setString(2, telefono);
      tic.setString(1, direccion);
        prest.setString(3, ciudad);
        prest.setInt(4, idEditorial);
     tic.setInt(2, idEditorial);
        
        
         tic.executeUpdate();
    prest.executeUpdate();
   
    
    
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Editorial Modificada");
       
}
    editm.setVisible(false);
     mostar();
     edit.limp(); 
   
         }


}
        public void eliminar(String loca){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(loca.equals(edit.BTN_NUEVO_BORRA))
   {
   int fila = edit.tabla.getSelectedRow();
   if(fila>=0){
     String id=edit.tabla.getValueAt(fila, 0).toString();
     try{
         PreparedStatement sst = conn.prepareStatement("DELETE FROM domicilio WHERE Editorial_idEditorial='"+id+"'");
         sst.executeUpdate();
     PreparedStatement ppt = conn.prepareStatement("DELETE FROM Editorial WHERE idEditorial='"+id+"'");
     ppt.executeUpdate();
     JOptionPane.showMessageDialog(null,"Editorial Eliminada");
     mostar();
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}

    }
   
     /* AUTOR*/
    public void proce(String valor){
    if(valor.equals(vp.BTN_AUTOR)){
            vaut.setVisible(true);
            
        }
    }
    

    
    public void altaau(String valor){
if(valor.equals(vaut.BTN_NUEVO_AUTOR)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
    String n= vaut.getaunom();
    String h= vaut.getauape();
    
    if(n.equals("") || h.equals(""))
    { JOptionPane.showMessageDialog(null,"EL autor Debe Tener Nombre Y Apellido");}
    else{
   

    
    
    String nombre      = vaut.getaunom();
    String apellido        = vaut.getauape();
    String pais      = vaut.getaupa();
    String ciudad      = vaut.getauci();
    String fecha      = vaut.getaufechanaci();
    
    String SQL = "INSERT INTO autor (nombre,apellido,pais,ciudad,fecha_nacimiento) "
                      +    "VALUES ('"+nombre+"','"+apellido+"','"+pais+"','"+ciudad+"','"+fecha+"')";
    
    
       try{  
           
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
                  
              }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Autor Agregado");
        mostrar();
}
    
        }
}/*aqui termina el alta*/
    
    
    
    
    public void mostrar(){
    
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel nodo = new DefaultTableModel();
nodo.addColumn("idAutor");
nodo.addColumn("nombre");
nodo.addColumn("Apellido");
nodo.addColumn("pais");
nodo.addColumn("ciudad");
nodo.addColumn("Fecha Nacimiento");

vaut.tablaautor.setModel(nodo);

String sql="SELECT * FROM autor";

String datos[]= new String [6];
try{
    Statement st =conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    datos[5]=rs.getString(6);
        
    nodo.addRow(datos);
    }
    vaut.tablaautor.setModel(nodo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}




}
 
    
    public void buscarautor(String atri){
    if(atri.equals(vaut.BTN_NUEVO_BUSQUEDA)){
     buscandoautor(vaut.busqautorid.getText());
    vaut.limpiautorbusqueda();}
   
}
    
    public void buscandoautor(String value){
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel nodo = new DefaultTableModel();
nodo.addColumn("idAutor");
nodo.addColumn("nombre");
nodo.addColumn("Apellido");
nodo.addColumn("pais");
nodo.addColumn("ciudad");
nodo.addColumn("Fecha Nacimiento");

vaut.tablaautor.setModel(nodo);

String sql;
if(value.equals("")){
sql="SELECT * FROM autor";
}
else{
    sql="SELECT * FROM autor WHERE idAutor='"+value+"'";
        }

String datos[]= new String [6];
try{
    Statement st =conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    datos[5]=rs.getString(6);
        
    nodo.addRow(datos);
    }
vaut.tablaautor.setModel(nodo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}




}
    

       public void consultarautor(String mod){
     
   if(mod.equals(vaut.BTN_NUEVO_MODIDICAR))
   {
       
   int fil = vaut.tablaautor.getSelectedRow();
   if(fil>=0){
       
       vautorm.n.setText(vaut.tablaautor.getValueAt(fil, 1).toString());
       vautorm.a.setText(vaut.tablaautor.getValueAt(fil, 2).toString());
       vautorm.p.setText(vaut.tablaautor.getValueAt(fil, 3).toString());
       vautorm.c.setText(vaut.tablaautor.getValueAt(fil, 4).toString());
       vautorm.f.setText(vaut.tablaautor.getValueAt(fil, 5).toString());
       vautorm.i.setText(vaut.tablaautor.getValueAt(fil, 0).toString());
       
     vautorm.setVisible(true);
     
   
   
   
   
   
   
   
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }
    
    
public void actualizartablaautor(String atri){
    if(atri.equals(vaut.BTN_NUEVO_BUSQUEDA)){
     mostrar();}
   
}
    
       public void modiautor(String valor){
if(valor.equals(vautorm.BTN_NUEVO_ACEPTAR)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
      String f= vautorm.getn();
    String h= vautorm.geta();
    
    if(f.equals("") || h.equals(""))
    { JOptionPane.showMessageDialog(null,"EL autor Debe Tener Nombre Y Apellido");}
    else
    {
        try{
     int idAutor= vautorm.geti();
     String nombre      = vautorm.getn();
    String apellido        = vautorm.geta();
    String pais      = vautorm.getp();
    String ciudad      = vautorm.getc();
    String fecha      = vautorm.getf();
    

    String Ssql = "UPDATE autor SET nombre=?, apellido=?, pais=?, ciudad=?, fecha_nacimiento=? "
                    + "WHERE idAutor=?";
    
    PreparedStatement prest = conn.prepareStatement(Ssql);
    
        prest.setString(1,nombre);
        prest.setString(2, apellido);
        prest.setString(3, pais);
        prest.setString(4, ciudad);
        prest.setString(5, fecha);
         prest.setInt(6, idAutor);
          
    prest.executeUpdate();
   
    
    
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Autor Modificado");
       
}
    vautorm.setVisible(false);
     mostrar();
      vaut.limpiautor();
   
         }


}


     public void eliminarautor(String local){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(local.equals(vaut.BTN_NUEVO_BORRAR))
   {
   int fila = vaut.tablaautor.getSelectedRow();
   if(fila>=0){
     String id=vaut.tablaautor.getValueAt(fila, 0).toString();
     try{
         
     PreparedStatement ppt = conn.prepareStatement("DELETE FROM autor WHERE idAutor='"+id+"'");
     ppt.executeUpdate();
     JOptionPane.showMessageDialog(null,"Usuario Eliminado");
     mostrar();
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}

    }



     /*CATEGORIA*/
      public void p(String valor){
    if(valor.equals(vp.BTN_CATEGORIA)){
            vcategoria.setVisible(true);
            
        }
    }
     
      
      
      public void a(String valor){
if(valor.equals(vcategoria.BTN_NUEVO_AGREC)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
    String n= vcategoria.getnombrecategoria();
    if(n.equals(""))
    { JOptionPane.showMessageDialog(null,"Debe tener un nombre Categoria");}
    else{
   

    
    
    String nombre      = vcategoria.getnombrecategoria();
 
    
    String SQL = "INSERT INTO categoria (nombre) "
                      +    "VALUES ('"+nombre+"')";
    
    
       try{  
           
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
                  
              }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Categoria Agregada");
}
   
        }
motacho();
vcategoria.lit();
}
      
      
     public void motacho(){
    
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel nodo = new DefaultTableModel();
nodo.addColumn("idCategoria");
nodo.addColumn("nombre");


vcategoria.tablacategoria.setModel(nodo);

String sql="SELECT * FROM categoria";

String datos[]= new String [2];
try{
    Statement st =conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);

        
    nodo.addRow(datos);
    }
    vcategoria.tablacategoria.setModel(nodo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}




}
     
     //---------------------------------------------------------------------------------------------------------------------------------------
     
     
     
     //TONY PROGRAMACION 
      public void e(String local){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(local.equals(vcategoria.BTN_NUEVO_BORC))
   {
   int fila = vcategoria.tablacategoria.getSelectedRow();
   if(fila>=0){
     String id=vcategoria.tablacategoria.getValueAt(fila, 0).toString();
     try{
         
     PreparedStatement ppt = conn.prepareStatement("DELETE FROM categoria WHERE idCategoria='"+id+"'");
     ppt.executeUpdate();
     JOptionPane.showMessageDialog(null,"Categoria Eliminada");
     motacho();
     
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}
    }
    public void mostrarclientes(String valor){
    if(valor.equals(vnc.BTN_AGREGAR_MODC)){
        mostarclientes();
            vmodcliente.setVisible(true);
            
        }
    }
      
public void mostarclientes(){

Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idCliente");
modo.addColumn("Nombre");
modo.addColumn("Apellido");
modo.addColumn("DNI");
modo.addColumn("Fecha de Nacimiento");
modo.addColumn("Telefono Fijo");
modo.addColumn("Telefono Movil");
modo.addColumn("Ciudad");
modo.addColumn("Correo");
modo.addColumn("direccion");

vmodcliente.modcliente.setModel(modo);

String sql="SELECT * FROM cliente";

String datos[]= new String [10];
try{
   int tu=0; 
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    datos[5]=rs.getString(6);
    datos[6]=rs.getString(7);
    datos[7]=rs.getString(8);
    datos[8]=rs.getString(9);
    tu=rs.getInt(10);
     
   
          String edi = "SELECT direccion FROM domicilio WHERE idDomicilio ='"+tu+"' ";
     Statement lm = conn.createStatement();
     ResultSet ns=lm.executeQuery(edi);
    
   
     while(ns.next()){
         datos[9]=ns.getString("direccion");
     }
     
    modo.addRow(datos);
    vmodcliente.modcliente.setModel(modo);
    }
    
   
    
    
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}
}

   public void modicli(String valor){
     
   if(valor.equals(vmodcliente.BTN_NUEVO_MODICLI))
   {
       
   int fila = vmodcliente.modcliente.getSelectedRow();
   if(fila>=0){
       vmodificacioncliente.idtxt.setText(vmodcliente.modcliente.getValueAt(fila, 0).toString());
       vmodificacioncliente.nomtxt.setText(vmodcliente.modcliente.getValueAt(fila, 1).toString());
       vmodificacioncliente.apetxt.setText(vmodcliente.modcliente.getValueAt(fila, 2).toString());
       vmodificacioncliente.dnitxt.setText(vmodcliente.modcliente.getValueAt(fila, 3).toString());
       vmodificacioncliente.nacitxt.setText(vmodcliente.modcliente.getValueAt(fila, 4).toString());
       vmodificacioncliente.fijotxt.setText(vmodcliente.modcliente.getValueAt(fila, 5).toString());
       vmodificacioncliente.moviltxt.setText(vmodcliente.modcliente.getValueAt(fila, 6).toString());
       vmodificacioncliente.ciutxt.setText(vmodcliente.modcliente.getValueAt(fila, 7).toString());
       vmodificacioncliente.cotxt.setText(vmodcliente.modcliente.getValueAt(fila, 8).toString());
       vmodificacioncliente.diretxt.setText(vmodcliente.modcliente.getValueAt(fila, 9).toString());
    
       vmodificacioncliente.setVisible(true);
     
   
   
   
   
   
   
   
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }

public void confirmar(String valor){
if(valor.equals(vmodificacioncliente.BTN_NUEVO_MODICLIENTE)){
    
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
        try{
     int idcliente        = vmodificacioncliente.getidcli();
     String nom        = vmodificacioncliente.getnombrecli();
     String ape        = vmodificacioncliente.getapellidocli();
     int dni        = vmodificacioncliente.getDNIcli();
     String fecha        = vmodificacioncliente.getnacicli();
     String fijo        = vmodificacioncliente.getfijocli();
     String movil        = vmodificacioncliente.getmovicli();
     String ciu        = vmodificacioncliente.getcicli();
     String correo        = vmodificacioncliente.getcocli();
     String direcc        = vmodificacioncliente.getdirecli();
                                                     

    
    String edi = "SELECT idDomicilio FROM domicilio WHERE direccion='"+direcc+"' ";
     
     Statement lm = conn.createStatement();
     ResultSet rs=lm.executeQuery(edi);
         
         while(rs.next()){
    tkl=rs.getInt("idDomicilio");
              }
    String Ssql = "UPDATE cliente SET idCliente=?, nombre=?, apellido=?, DNI=?, fecha_nacimiento=?, tel_fijo=?, tel_movil=?, ciudad=?, correo=?"
                    + "WHERE idDomicilio2=?";
    
    String sql = "UPDATE domicilio SET direccion=? "
                    + "WHERE idDomicilio=?";
    PreparedStatement prest = conn.prepareStatement(Ssql);
    PreparedStatement tic = conn.prepareStatement(sql);

     
    
    
    
     prest.setInt(1,idcliente);
     prest.setString(2, nom);
     prest.setString(3, ape);
     prest.setInt(4, dni);
     prest.setString(5, fecha);
     prest.setString(6, fijo);
     prest.setString(7, movil);
     prest.setString(8, ciu);
     prest.setString(9, correo);
     prest.setInt(10, tkl);
     tic.setString(1, direcc);
     tic.setInt(2, tkl);
    
    
        
        
     tic.executeUpdate();
     prest.executeUpdate();
    
    
    
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Editorial Modificada");
       

   
     mostarclientes();
    
   vmodificacioncliente.setVisible(false);
   
         }


}

        public void elicli(String loca){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(loca.equals(vmodcliente.BTN_NUEVO_ELICLI))
   {
   int fila = vmodcliente.modcliente.getSelectedRow();
   if(fila>=0){
     String direc=vmodcliente.modcliente.getValueAt(fila, 9).toString();
     try{
         
      
         String edi = "SELECT idDomicilio FROM domicilio WHERE direccion='"+direc+"' ";
           Statement lm = conn.createStatement();
           ResultSet rs=lm.executeQuery(edi);
           while(rs.next()){
    iden=rs.getInt("idDomicilio");
              }
           
                  
         PreparedStatement sst = conn.prepareStatement("DELETE FROM cliente WHERE idDomicilio2='"+iden+"'");
         sst.executeUpdate();
           
         PreparedStatement ppt = conn.prepareStatement("DELETE FROM domicilio WHERE direccion='"+direc+"'");
         ppt.executeUpdate();

     JOptionPane.showMessageDialog(null,"Cliente Eliminado");
     mostarclientes();
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}

    }

      
      /*TONY PROGRAMACION*/
   

    public void cargarEmpleado(String valor) {
        if(valor.equals(valtaEmple.BTN_AGREGAR_EMPLEADO)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion(); 
    
    String nombre= valtaEmple.getNombre();
    String cuil= valtaEmple.getCuil();
    String apellido= valtaEmple.getApellido();
    String ciudad= valtaEmple.getCiudad();
    String naci = valtaEmple.getFechaNacimiento();
    String domi = valtaEmple.getDomicilio();
    String fijo = valtaEmple.getTelFijo();
    String movil=valtaEmple.getTelMovil();
    String co=valtaEmple.getCorreo();
    String tu=valtaEmple.getTurno();
    
   
   
    
   String SQL = "INSERT INTO turno (descripcion) "
                      +    "VALUES ('"+tu+"')";
   String edi = "SELECT idTurno FROM turno WHERE descripcion='"+tu+"' ";
   
   String Stl = "INSERT INTO domicilio (direccion) "
                      +    "VALUES ('"+domi+"')";
   String di = "SELECT idDomicilio FROM domicilio WHERE direccion='"+domi+"' "; 
    
   
    
    
       try{  
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);
           
                  Statement lm = conn.createStatement();
                  ResultSet rs=lm.executeQuery(edi);
                  
                                while(rs.next()){
    idturno=rs.getInt("IdTurno");
     System.out.println(idturno);
              }
                  
                  Statement sen = conn.createStatement();
                  sen.executeUpdate(Stl);
           
                  
                  Statement lp = conn.createStatement();
                  ResultSet rp=lp.executeQuery(di);
                  
      
        while(rp.next()){
    iddomi=rp.getInt("idDomicilio");
     System.out.println(iddomi);
              }
               String Stp = "INSERT INTO empleado (nombre,apellido,fecha_nacimiento,ciudad,tel_fijo,tel_movil,correo,CUIL,idTurno,idDomicilio1)"
            +    "VALUES ('"+nombre+"','"+apellido+"','"+naci+"','"+ciudad+"','"+fijo+"','"+movil+"','"+co+"','"+cuil+"','"+idturno+"','"+iddomi+"')";
                    
                    Statement t = conn.createStatement();
                    t.executeUpdate(Stp);
                
                    
              }
              catch(SQLException e){
                  
                  JOptionPane.showMessageDialog(null,e);
              }
       JOptionPane.showMessageDialog(null,"Empleado Agregado");

    mostrarempleado();
    valtaEmple.limpiar();
        }
    }
    
    
    public void mostrarempleado(){
    
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idEmpleado");
modo.addColumn("Nombre");
modo.addColumn("Apellido");
modo.addColumn("Fecha Nacimiento");
modo.addColumn("Ciudad");
modo.addColumn("Telefono Fijo");
modo.addColumn("Telefono Movil");
modo.addColumn("Correo");
modo.addColumn("Cuil");
modo.addColumn("Id Turno");
modo.addColumn("Id Domicilio");


valtaEmple.tablaempleados.setModel(modo);

DefaultTableModel moda = new DefaultTableModel();
moda.addColumn("idEmpleado");
moda.addColumn("Nombre");
moda.addColumn("Apellido");
moda.addColumn("Cuil");




valtaEmple.tablausuario.setModel(moda);


String sql="SELECT * FROM empleado";

String datos[]= new String [12];
String datosusuario[]= new String [4];
try{
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    datos[5]=rs.getString(6);
    datos[6]=rs.getString(7);
    datos[7]=rs.getString(8);
    datos[8]=rs.getString(9);
    datos[9]=rs.getString(10);
    datos[10]=rs.getString(11);
    
    datosusuario[0]=rs.getString(1);
    datosusuario[1]=rs.getString(2);
    datosusuario[2]=rs.getString(3);
    datosusuario[3]=rs.getString(10);
     
    
    
     
     
    modo.addRow(datos);
    moda.addRow(datosusuario);
    }
    
   
    
    valtaEmple.tablaempleados.setModel(modo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}
}
    
   
    public void buscandoemp(String value){
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idEmpleado");
modo.addColumn("Nombre");
modo.addColumn("Apellido");
modo.addColumn("Fecha Nacimiento");
modo.addColumn("Ciudad");
modo.addColumn("Telefono Fijo");
modo.addColumn("Telefono Movil");
modo.addColumn("Correo");
modo.addColumn("Cuil");
modo.addColumn("Id Turno");
modo.addColumn("Id Domicilio");

valtaEmple.tablaempleados.setModel(modo);


if(value.equals("")){
 JOptionPane.showMessageDialog(null,"Ingrese un Cuil para buscar");
  mostrarempleado();
}
else{
  String sql;
 sql="SELECT * FROM empleado WHERE CUIL='"+value+"'";        

String datos[]= new String [12];
try{
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    datos[5]=rs.getString(6);
    datos[6]=rs.getString(7);
    datos[7]=rs.getString(8);
    datos[8]=rs.getString(9);
    datos[9]=rs.getString(10);
    datos[10]=rs.getString(11);
    
     
    
    
     
     
    modo.addRow(datos);
    }
    
   
    
    valtaEmple.tablaempleados.setModel(modo);
    
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}

}

 }   

public void buscaremp(String valor) {
       if(valor.equals(valtaEmple.BTN_BUSCAR_EMPLEADO)){
     buscandoemp(valtaEmple.campoBuscarcuil.getText());
   valtaEmple.limpiar();
   
}
   
}

public void elegir(String mod){
     String aiuda;
   if(mod.equals(valtaEmple.BTN_BUSCAR_ELEGIR))
   {Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();
       
   int fila =valtaEmple.tablaempleados.getSelectedRow();
   if(fila>=0){
       h=valtaEmple.tablaempleados.getValueAt(fila, 10).toString();
       try{
         String di = "SELECT direccion FROM domicilio WHERE idDomicilio='"+h+"' "; 
    
   
              Statement lp = conn.createStatement();
                  ResultSet rp=lp.executeQuery(di);
                  
      
        while(rp.next()){
    aiuda=rp.getString("direccion");
     System.out.println(aiuda);
     valtaEmple.campoDomicilio.setText(aiuda);
              }     
       }
       catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se pudo agrega domicilio para modificar");
}
       
       t=valtaEmple.tablaempleados.getValueAt(fila, 0).toString();
       valtaEmple.campoNombre.setText(valtaEmple.tablaempleados.getValueAt(fila, 1).toString());
       valtaEmple.campoApellido.setText(valtaEmple.tablaempleados.getValueAt(fila, 2).toString());
       valtaEmple.campoCiudad.setText(valtaEmple.tablaempleados.getValueAt(fila, 4).toString());
       valtaEmple.campoFechaNacimiento.setText(valtaEmple.tablaempleados.getValueAt(fila, 3).toString());
      
       valtaEmple.campoTelFijo.setText(valtaEmple.tablaempleados.getValueAt(fila, 5).toString());
       valtaEmple.campoTelMovil.setText(valtaEmple.tablaempleados.getValueAt(fila,6).toString());
       valtaEmple.campoCuil.setText(valtaEmple.tablaempleados.getValueAt(fila, 8).toString());
       valtaEmple.campoCorreo.setText(valtaEmple.tablaempleados.getValueAt(fila, 7).toString());
       e=valtaEmple.tablaempleados.getValueAt(fila, 9).toString();
       
      
   
       
   
   
   
   
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }

       public void modiemp(String valor){
if(valor.equals(valtaEmple.BTN_BUSCAR_MODIEMP)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
        try{
    String nombre= valtaEmple.getNombre();
    String cuil= valtaEmple.getCuil();
    String apellido= valtaEmple.getApellido();
    String ciudad= valtaEmple.getCiudad();
    String naci = valtaEmple.getFechaNacimiento();
    String domi = valtaEmple.getDomicilio();
    String fijo = valtaEmple.getTelFijo();
    String movil=valtaEmple.getTelMovil();
    String co=valtaEmple.getCorreo();
    String tu=valtaEmple.getTurno();
    
  

    String Ssql = "UPDATE empleado SET nombre=?, apellido=?, fecha_nacimiento=?, ciudad=?, tel_fijo=?, tel_movil=?, CUIL=?, correo=?, idTurno=?, idDomicilio1=?"
                    + "WHERE idEmpleado=?";
    
    String sql = "UPDATE turno SET descripcion=? "
                    + "WHERE idTurno=?";
    
    String sqlo = "UPDATE domicilio SET direccion=? "
                    + "WHERE idDomicilio=?";
    PreparedStatement prest = conn.prepareStatement(Ssql);
    PreparedStatement tic = conn.prepareStatement(sql);
    PreparedStatement te = conn.prepareStatement(sqlo);
    
     prest.setString(1,nombre);
     prest.setString(2, apellido);
     prest.setString(3, naci);
     prest.setString(4, ciudad);
     
     prest.setString(5, fijo);
     prest.setString(6, movil);
     prest.setString(7, cuil);
     prest.setString(8, co);
     prest.setString(9, e);
     prest.setString(10, h);
     prest.setString(11, t);
     
    
     tic.setString(1, tu);
     tic.setString(2, e);
     
     
    te.setString(1, domi);
     te.setString(2, h);
    
        
        
     tic.executeUpdate();
     prest.executeUpdate();
     te.executeUpdate();
   
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
         mostrarempleado();
    valtaEmple.limpiar();
       JOptionPane.showMessageDialog(null,"Empleado Modificado");
       
}
  
   
         }
       
       
               public void eliemp(String loca){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(loca.equals(valtaEmple.BTN_BUSCAR_BORRAR))
   {
   int fila = valtaEmple.tablaempleados.getSelectedRow();
   if(fila>=0){
     String domi=valtaEmple.tablaempleados.getValueAt(fila, 5).toString();
     String idemp=valtaEmple.tablaempleados.getValueAt(fila, 0).toString();
     String tur=valtaEmple.tablaempleados.getValueAt(fila, 10).toString();
     try{
         
         
         PreparedStatement ttm = conn.prepareStatement("DELETE FROM turno WHERE idTurno='"+tur+"'");
         ttm.executeUpdate();
                  
         PreparedStatement sst = conn.prepareStatement("DELETE FROM empleado WHERE idEmpleado='"+idemp+"'");
         sst.executeUpdate();
           
         PreparedStatement ppt = conn.prepareStatement("DELETE FROM domicilio WHERE direccion='"+domi+"'");
         ppt.executeUpdate();

     JOptionPane.showMessageDialog(null,"Empleado Eliminado");
     
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}
mostrarempleado();
mostarUser();
    }


               public void buscarusuarios(String mod){
     
   if(mod.equals(valtaEmple.BTN_BUSCAR_USER))
   {
       
   int fila =valtaEmple.tablausuario.getSelectedRow();
   if(fila>=0){
       valtaEmple.idemptxt.setText(valtaEmple.tablausuario.getValueAt(fila, 0).toString());
       valtaEmple.nametxt.setText(valtaEmple.tablausuario.getValueAt(fila, 1).toString());
       valtaEmple.lastnametxt.setText(valtaEmple.tablausuario.getValueAt(fila, 2).toString());
       valtaEmple.cuiltxtemp.setText(valtaEmple.tablausuario.getValueAt(fila, 3).toString());

   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }
               
public void altausuario(String valor){
if(valor.equals(valtaEmple.BTN_BUSCAR_ALTAU)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
    int n= valtaEmple.getidempleado();
     String user= valtaEmple.getUsuario();
      String pa= valtaEmple.getpass();
       String ro= valtaEmple.getRol();
    if(n<=0 || user.equals("") || pa.equals("") || ro.equals("") )
    { JOptionPane.showMessageDialog(null,"Los campos PASSWORD y USUARIO no pueden ser Nulos");}
    else{
   

    
    
   
    
    String SQL = "INSERT INTO usuario (usuario,password,rol,idEmpleado) "
                      +    "VALUES ('"+user+"','"+pa+"','"+ro+"','"+n+"')";

    
       try{  
           
                  Statement sentencia = conn.createStatement();
                  sentencia.executeUpdate(SQL);

       }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
        valtaEmple.limpiaruser();
        mostarUser();
       JOptionPane.showMessageDialog(null,"Usuario Agregado");
}
   
        }
}

 public void bus3(String value){
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel moda = new DefaultTableModel();
moda.addColumn("idEmpleado");
moda.addColumn("Nombre");
moda.addColumn("Apellido");
moda.addColumn("Cuil");




valtaEmple.tablausuario.setModel(moda);




if(value.equals("")){
 JOptionPane.showMessageDialog(null,"Ingrese un ID para buscar");
  mostrarempleado();
}
else{
  String sql;
 sql="SELECT * FROM empleado WHERE idEmpleado='"+value+"'";        

String datosusuario[]= new String [4];
try{
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
   
    
     
    datosusuario[0]=rs.getString(1);
    datosusuario[1]=rs.getString(2);
    datosusuario[2]=rs.getString(3);
    datosusuario[3]=rs.getString(10);
    
     
     
    moda.addRow(datosusuario);
    }
    
   
    
    valtaEmple.tablausuario.setModel(moda);
    
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}

}

 }   
 public void bus2(String valor) {
       if(valor.equals(valtaEmple.BTN_BUSCAR_bus2)){
     bus3(valtaEmple.bus.getText());
   valtaEmple.limpiaruser();
   
}

    }
 
 
 public void mostarUser(){
    
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idUsuario");
modo.addColumn("Usuario");
modo.addColumn("Rol");
modo.addColumn("idEmpleado");

valtaEmple.tablauser.setModel(modo);

String sql="SELECT * FROM usuario";

String datos[]= new String [4];
try{
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(4);
    datos[3]=rs.getString(5);
    
     
    
    
    modo.addRow(datos);
    }
    
   
    
    valtaEmple.tablauser.setModel(modo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}
}
 
 public void search(String valor) {
       if(valor.equals(valtaEmple.BTN_BUSCAR_SEARCH)){
     search1(valtaEmple.ingresariduser.getText());
   valtaEmple.limpiaruser();
   
}
 }
 
     public void search1(String value){
Conexion conectar = new Conexion();
Connection conn   = conectar.getConexion();

DefaultTableModel modo = new DefaultTableModel();
modo.addColumn("idUsuario");
modo.addColumn("Usuario");
modo.addColumn("Rol");
modo.addColumn("idEmpleado");

valtaEmple.tablauser.setModel(modo);


if(value.equals("")){
 JOptionPane.showMessageDialog(null,"Ingrese El ID de el Empleado para buscar");
 mostarUser();
}
else{
  String sql;
 sql="SELECT * FROM usuario WHERE idEmpleado='"+value+"'";        

String datos[]= new String [4];
try{
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
  
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(4);
    datos[3]=rs.getString(5);

    
     
    
    
     
     
    modo.addRow(datos);
    }
    
   
    
    valtaEmple.tablauser.setModel(modo);
    
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
}

}
}

 public void modiuser(String valor){
if(valor.equals(valtaEmple.BTN_BUSCAR_MODIUSER)){
    Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    
       
    String pass= valtaEmple.getpass();
    int iduser= valtaEmple.getidUsuario();
    String user= valtaEmple.getUsuario();
    int idemp= valtaEmple.getidempleado();
    String ro= valtaEmple.getRol();
    
     if( user.equals("") || pass.equals(""))
    { JOptionPane.showMessageDialog(null,"Los campos USUARIO y PASSWORD no pueden ser Nulos");}
    else{
   try{

    String Ssql = "UPDATE usuario SET usuario=?, password=?,rol=?"
                    + "WHERE idEmpleado=?";
    
 
    PreparedStatement prest = conn.prepareStatement(Ssql);

    
     
     prest.setString(1, user);
     prest.setString(2, pass);
     prest.setString(3, ro);
     prest.setInt(4, idemp);
     

    
        
        
    
     prest.executeUpdate();
   
   
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
              }
         
    valtaEmple.limpiaruser();
       JOptionPane.showMessageDialog(null,"Usuario Modificado");
       mostarUser();
}
     }
  
   
         }
 
    public void seleccionarusuario(String valor){
     
   if(valor.equals(valtaEmple.BTN_BUSCAR_SELECT))
   {
       
   int fila = valtaEmple.tablauser.getSelectedRow();
   if(fila>=0){
       String t="";
       
       String pass=valtaEmple.tablauser.getValueAt(fila, 1).toString();
       valtaEmple.usuario.setText(valtaEmple.tablauser.getValueAt(fila, 1).toString());
       valtaEmple.idfix.setText(valtaEmple.tablauser.getValueAt(fila, 0).toString());
       valtaEmple.idemptxt.setText(valtaEmple.tablauser.getValueAt(fila, 3).toString());
       Conexion conectar = new Conexion();
       Connection conn   = conectar.getConexion();
        String SQL = "SELECT password FROM usuario WHERE usuario='"+pass+"' ";
         try {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL);
             while(rs.next()){
                  t = rs.getString("password");
               
             }
              valtaEmple.pass .setText(t);
         } catch (Exception e) {JOptionPane.showMessageDialog(null,"nose pudo mostrar");
         }

   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
   
   }
  
   }

 public void borman(String local){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(local.equals(valtaEmple.BTN_BUSCAR_BORMAN))
   {
   int fila = valtaEmple.tablauser.getSelectedRow();
   if(fila>=0){
     String id=valtaEmple.tablauser.getValueAt(fila, 0).toString();
     try{
         
     PreparedStatement ppt = conn.prepareStatement("DELETE FROM usuario WHERE idUsuarios='"+id+"'");
     ppt.executeUpdate();
     JOptionPane.showMessageDialog(null,"Usuario Eliminado");
    mostarUser();
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
}

    }

 
  public void Logear(String local){
        Conexion conectar = new Conexion();
    Connection conn   = conectar.getConexion();
    if(local.equals(login.BTN_LOGUSER))
   {    
       String cap="";
       String user=login.getusuariologin();
       String passw=login.getpasslogin();
  String SQL = "SELECT * FROM usuario WHERE usuario='"+user+"' && password='"+passw+"' ";
         try {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL);
             while(rs.next()){
                  cap= rs.getString("rol");
               
                 
             }
              if(cap.equals("Administrador"))
              {
              JOptionPane.showMessageDialog(null,"Sesion Iniciada como ADMINISTRADOR\n Bienvenido"+user);
              ejecutar();
              login.setVisible(false);
             
              }
              if(!cap.equals("Administrador")&&(!cap.equals("Usuario")))
              {
              JOptionPane.showMessageDialog(null,"DATOS ERRONEOS");
             
              }
              if(cap.equals("Usuario"))
              {
              JOptionPane.showMessageDialog(null,"Sesion Iniciada como USUARIO\n Bienvenido "+user);
                ejecutarusuario();
            
              login.setVisible(false);
             
              }
              
         } catch (Exception e) {JOptionPane.showMessageDialog(null,"nose pudo mostrar");
         }
       
       
       
       
       
       
       
    }

    }
    
    
  
   public void bemp(String valor){
    if(valor.equals(valtaEmple.BTN_BUSCAR_ACTEMPLEADO)){
        
      mostrarempleado();
      mostarUser();
       JOptionPane.showMessageDialog(null,"Tabla Actualizada");     
        }
    }
   public void busa(String valor){
    if(valor.equals(valtaEmple.BTN_BUSCAR_ACTUSUARIO)){
        
      mostrarempleado();
      mostarUser();
          JOptionPane.showMessageDialog(null,"Tabla Actualizada");  
        }
    }
  
 }
    
 
   

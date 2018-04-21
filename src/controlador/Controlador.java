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
    private Edit edit;
    private EditM editm;
    private Vaut vaut;
    
   
    
    
    
    public Controlador(){
        vp = new VPrincipal();
        vnv = new VNuVenta(vp,true);
        vnc = new VNuCliente(vnv,true);
        vl = new VLibro(vp, true);
        vml = new VModLibro(vp, true);
        
        edit=new Edit(vp,true);
        editm = new EditM(null,true);
         vaut= new Vaut(vp,true);
      
       
    }
    
    public void ejecutar(){
        vp.setControlador(this);
        vp.setVisible(true);
        vnv.setControlador(this);
        vnc.setControlador(this);
        vl.setControlador(this);
        vml.setControlador(this);
        edit.setControlador(this);
        editm.setControlador(this);
        mostar();
        
          vaut.setControlador(this);
    }
    
    
    
    
    //OCTAVIO PROGRAMACION
    
    //metodo para cargar los libros en el jTable de la ventana libros
    public void cargarLibros(){
        Conexion conectar = new Conexion();
        Connection conn = conectar.getConexion();
        
        Object[] datos = new Object[6];
        String SQL = "SELECT * FROM libro";
        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0] = rs.getString("ISBN");
                datos[1] = rs.getString("titulo");
                datos[3] = rs.getString("Edicion");
                datos[5] = rs.getString("precio");
                
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
                  String idEditorial = rs.getString("idEditorial");
                  vl.setComboBoxEditorial(nombre);
                  vml.setComboBoxEditorial(nombre);
                  vl.setIdEditorial(idEditorial);
                  vml.setIdEditorial(idEditorial);
                  
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
                  String idAutor = rs.getString("idAutor");
                  vl.setComboBoxAutor(nombre);
                  vml.setComboBoxAutor(nombre);
                  vl.setIdAutor(idAutor);
                  vml.setIdAutor(idAutor);
                  
              }   
          } catch (Exception e) {
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
              
              vnc.limpiar();
        }
        
        
        if(valor.equals(vnv.BTN_BUSCAR_CLIENTE)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            String[] datos = new String[2];
            int DNI = vnv.getDNI();
            String SQL = "SELECT * FROM cliente WHERE DNI = '"+DNI+"'";
            
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while(rs.next()){
                    datos[0] = rs.getString("nombre");
                    datos[1] = rs.getString("apellido");
                    
                    vnv.setNombre(datos[0]);
                    vnv.setApellido(datos[1]);
                }
            }
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
               
        }
        }
        
        if(valor.equals(vp.BTN_LIBRO)){
            vl.limpiarComboBox();    
            vl.limpiarTabla();
             //llamamos a los metodos para que se carguen previamente los autores y las editoriales en el combo box 
            obtenerEditorialComboBox();
            obtenerAutorComboBox();
            //llamamos al metodo para que se carguen los libros en el jTable
            cargarLibros();
            vl.setVisible(true);
            
        }
        
        if(valor.equals(vl.BTN_AGREGAR_LIBRO)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            int ISBN = vl.getISBN();
            String titulo = vl.getTitulo();
            int paginas = vl.getPaginas();
            String fecha = vl.getFecha();
            String descripcion = vl.getDescripcion();
            String edicion = vl.getEdicion();
            double precio = vl.getPrecio();
            int stock = vl.getStock();
            
            
            String nombreAutor = vl.getComboBoxAutor();
            String nombreEditorial = vl.getComboBoxEditorial();
            int idEditorial = vl.getIdEditorial();
            int idAutor = vl.getIdAutor();
            
            
            Object[] datos = new Object[7];
            datos[0]       = ISBN;
            datos[1]       = titulo;
            datos[2]       = nombreAutor;
            datos[3]       = edicion;
            datos[4]       = nombreEditorial;
            datos[5]       = precio;
            datos[6]       = stock;
             
            
            
            String SQL = "INSERT INTO libro (ISBN,titulo,fecha_lanzamiento,paginas,descripcion,edicion,precio,stock,idAutor,idEditorial,idCategoria) "
                       + "VALUES ('"+ISBN+"','"+titulo+"','"+fecha+"','"+paginas+"','"+descripcion+"','"+edicion+"','"+precio+"','"+stock+"','"+idAutor+"','"+idEditorial+"','"+1+"')";
       
        try {
             Statement sentencia = conn.createStatement();
             sentencia.executeUpdate(SQL);
             vl.insertarFila(datos);
             vl.limpiar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        
        
        
        
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
        
        
        if(valor.equals(VLibro.BTN_MODIFICAR_LIBRO)){
            vml.limpiarComboBox();  
            vml.limpiarComboBox();
            
            //llamamos a los metodos para que se carguen previamente los autores y las editoriales en el combo box
            obtenerEditorialComboBox();
            obtenerAutorComboBox();
            
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
            
            int fila = vl.getFila();
            if(fila>= 0){
            
            int ISBN = vl.getISBN_tabla();
           
            String SQL = "SELECT * FROM libro WHERE ISBN = '"+ISBN+"'";
            
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while(rs.next()){
                    //establecemos los valores en los jTextField de la ventana modLibro
                    vml.setISBN(rs.getString("ISBN"));
                    vml.setTitulo(rs.getString("Titulo"));
                    vml.setEdicion(rs.getString("Edicion"));
                    vml.setFecha(rs.getString("fecha_lanzamiento"));
                    vml.setPaginas(rs.getString("paginas"));
                    vml.setPrecio(rs.getString("precio"));
                    vml.setStock(rs.getString("stock"));
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
             
             
             if(valor.equals(vml.BTN_ACEPTAR_MODIFICACION)){
            Conexion conectar = new Conexion();
            Connection conn   = conectar.getConexion();
             
                       
            Object[] datos = new Object[7];
            datos[0]       = vml.getISBN();
            datos[1]       = vml.getTitulo();
            datos[2]       = vml.getComboBoxAutor();
            datos[3]       = vml.getEdicion();
            datos[4]       = vml.getComboBoxEditorial();
            datos[5]       = vml.getPrecio();
            datos[6]       = vml.getStock();
            
           
                
            String fecha         = vml.getFecha();
            int paginas          = vml.getPaginas();
            String descripcion   = vml.getDescripcion();
            int idEditorial      = vml.getIdEditorial();
            int idAutor          = vml.getIdAutor();
            
            int ISBN = vl.getISBN_tabla();
        
        
            String SQL = "UPDATE libro SET ISBN = '"+datos[0]+"', titulo='"+datos[1]+"', idAutor='"+idAutor+"', edicion='"+datos[3]+"', fecha_lanzamiento='"+fecha+"', paginas='"+paginas+"', idEditorial='"+idEditorial+"', precio = '"+datos[5]+"', stock= '"+datos[6]+"', descripcion='"+descripcion+"', idCategoria='"+1+"' WHERE ISBN = '"+ISBN+"'";
            
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(SQL); 
                    vl.modificarFila(datos);
                    vml.limpiar();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
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
modo.addColumn("direccion");
modo.addColumn("ciudad");

edit.tabla.setModel(modo);

String sql="SELECT * FROM EDITORIAL";

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
modo.addColumn("direccion");
modo.addColumn("ciudad");

edit.tabla.setModel(modo);

String sql;
if(value.equals("")){
sql="SELECT * FROM EDITORIAL";
}
else{
    sql="SELECT * FROM EDITORIAL WHERE idEditorial='"+value+"'";
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
        
    modo.addRow(datos);
    }
    edit.tabla.setModel(modo);
    }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"no se puedo mostrar");
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
       editm.diretxt.setText(edit.tabla.getValueAt(fila, 3).toString());
       editm.ciutxt.setText(edit.tabla.getValueAt(fila, 4).toString());
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
    if(n.equals(""))
    { JOptionPane.showMessageDialog(null,"Debe tener un nombre editorial");}
    else{
        try{
    int idEditorial        = editm.getide();
    String nombre      = editm.getedi();
    int telefono        = editm.gettel();
    String direccion      = editm.getdirec();
    String ciudad      = editm.getciu();
    

    String Ssql = "UPDATE editorial SET nombre=?, telefono=?, direccion=?, ciudad=? "
                    + "WHERE idEditorial=?";
    
    PreparedStatement prest = conn.prepareStatement(Ssql);
    
    prest.setString(1,nombre);
        prest.setInt(2, telefono);
        prest.setString(3, direccion);
        prest.setString(4, ciudad);
        prest.setInt(5, idEditorial);
          
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
   
   
     /* AUTOR*/
    public void proce(String valor){
    if(valor.equals(vp.BTN_AUTOR)){
            vaut.setVisible(true);
            
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
         
     PreparedStatement ppt = conn.prepareStatement("DELETE FROM Editorial WHERE idEditorial='"+id+"'");
     ppt.executeUpdate();
     JOptionPane.showMessageDialog(null,"Usuario Eliminado");
     mostar();
     }
     catch(SQLException e){JOptionPane.showMessageDialog(null,"No se pudo Eliminar");}
 
   }
   else{JOptionPane.showMessageDialog(null,"no se seleciono fila");
   }
    
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



}

    
  
}

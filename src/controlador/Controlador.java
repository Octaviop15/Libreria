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
    private Edit edit;
    private EditM editm;
    
   
    
    
    
    public Controlador(){
        vp = new VPrincipal();
        vnv = new VNuVenta(vp,true);
        vnc = new VNuCliente(vnv,true);
        vl = new VLibro(vp, true);
        edit=new Edit(vp,true);
        editm = new EditM(null,true);
      
       
    }
    
    public void ejecutar(){
        vp.setControlador(this);
        vp.setVisible(true);
        vnv.setControlador(this);
        vnc.setControlador(this);
        vl.setControlador(this);
        edit.setControlador(this);
        editm.setControlador(this);
        mostar();
        
    }
    
    
    
     public void obtenerEditorialComboBox(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          String SQL = "SELECT nombre FROM editorial";
          vl.setComboBoxEditorial("Seleccione una editorial");
          try {
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(SQL);
              while(rs.next()){
                  String nombre = rs.getString("nombre");
                  int idEditorial = rs.getInt(0);
                  vl.setComboBoxEditorial(nombre);
                  vl.setIdEditorial(idEditorial);
                  
              }   
          } catch (Exception e) {
          }
     }
     
     public void obtenerAutorComboBox(){
          Conexion conexion = new Conexion();
          Connection conn   = conexion.getConexion();
          
          String SQL = "SELECT nombre FROM autor";
          vl.setComboBoxAutor("Seleccione un autor");
          try {
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(SQL);
              while(rs.next()){
                  String nombre = rs.getString("nombre");
                  vl.setComboBoxAutor(nombre);
                  
              }   
          } catch (Exception e) {
          }
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
            obtenerEditorialComboBox();
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
            double precio = vl.getPrecio();
            int stock = vl.getStock();
            int idEditorial = vl.getIdEditorial();
            int  idAutor = vl.getIdAutor();
     
            
            
            
            /*
            String SQL1 = "SELECT * FROM editorial where nombre = '"+vl.getComboBoxEditorial()+"'";
            String SQL2 = "SELECT * FROM autor where nombre = '"+vl.getComboBoxAutor()+"'";
            
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL1);
                while(rs.next()){
                   int e = rs.getInt(1);
                    
                }
                
            } catch (Exception e) {
            }
            
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL2);
                while(rs.next()){
                    idAutor = rs.getInt(1);
                }
                
            } catch (Exception e) {
            }
            
            */
            
            
            String SQL = "INSERT INTO libro VALUES(ISNB,titulo,fecha_lanzamiento,paginas,descripcion,precio,stock,idAutor,idEditorial) "
                       + "VALUES ('"+ISBN+"','"+titulo+"','"+fecha+"','"+paginas+"','"+descripcion+"','"+precio+"','"+stock+"','"+idAutor+"','"+idEditorial+"')";
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
    
  
    PreparedStatement ppt= conn.prepareStatement("UPDATE editorial SET nombre = '"+nombre+"' WHERE idEditorial = '"+idEditorial+"'");
    
    String roda = "RODA TE AMA";
    
    ppt.executeUpdate();
    
        }
              catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e);
                  JOptionPane.showMessageDialog(null,"Editorial Agregada");
              }
       JOptionPane.showMessageDialog(null,"Editorial Agregada");
}
     mostar();
    
        }
}/*aqui termina el alta*/
}

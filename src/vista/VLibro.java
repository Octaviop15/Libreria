
package vista;

import controlador.Controlador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class VLibro extends javax.swing.JDialog {

    public static final String BTN_AGREGAR_LIBRO = "AGREGAR LIBRO";
    public static final String BTN_ELIMINAR_LIBRO = "ELIMINAR LIBRO";
    public static final String BTN_MODIFICAR_LIBRO = "MODIFICAR LIBRO";
    private DefaultTableModel model;
    private Controlador controlador;
   
    
    private int contt;
    ArrayList<Integer> idEditorial = new ArrayList<Integer>();
    ArrayList<Integer> idAutor = new ArrayList<Integer>();
    ArrayList<Integer> idCategoria = new ArrayList<Integer>();
         
    
    
    
    public VLibro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Gestion de libros");
     
        cargarTabla();
        
        
        
        requerido1.setVisible(false);
        requerido2.setVisible(false);
        requerido6.setVisible(false);
        requerido4.setVisible(false);
        requerido5.setVisible(false);
        requerido3.setVisible(false);
        requerido7.setVisible(false);
        requerido8.setVisible(false);
        requerido9.setVisible(false);
     
        
    }
    
     public void setControlador(Controlador controlador){
        this.controlador = controlador;    
    }
     
     public void validacion(){
         contt = 0;
         if(txtISBN.getText().equals("")){
             requerido1.setVisible(true);
             contt++;
         }
         else{requerido1.setVisible(false);}
        
             
         if(txtNombre.getText().equals("")){
             requerido2.setVisible(true);
             contt++;
         }
         else{requerido2.setVisible(false);}
         
         if(txtPrecioVenta.getText().equals("")){
             requerido6.setVisible(true);
             contt++;
         }
         else{requerido6.setVisible(false);}
         
         if(txtPrecioCompra.getText().equals("")){
             requerido4.setVisible(true);
             contt++;
         }
         else{requerido4.setVisible(false);}
         
          if(txtStock.getText().equals("")){
             requerido5.setVisible(true);
             contt++;
         }
         else{requerido5.setVisible(false);}
          
          if(fecha.getDate() == null){
             requerido3.setVisible(true);
             contt++;
          }
          else{requerido3.setVisible(false);}
          
          if(cmbEditorial.getSelectedIndex() == 0){
             requerido7.setVisible(true);
             contt++;
          }
          else{requerido7.setVisible(false);}
          
           if(cmbAutor.getSelectedIndex() == 0){
             requerido8.setVisible(true);
             contt++;
          }
           else{requerido8.setVisible(false);}
           
            if(cmbAutor.getSelectedIndex() == 0){
             requerido9.setVisible(true);
             contt++;
          }
             else{requerido9.setVisible(false);}
                      
     }
     
     
       public void cargarTabla(){
         String[] titulos = {"ISBN","Titulo","Autor","Edicion","Editorial","Precio venta","precio compra","stock"};
         model = new DefaultTableModel(null,titulos);
         tablaLibros.setModel(model);
         
         
     }
       
       public void tamañoColumnaTabla(){
           TableColumnModel columnModel = tablaLibros.getColumnModel();

           columnModel.getColumn(0).setPreferredWidth(100);
           columnModel.getColumn(1).setPreferredWidth(200);
           columnModel.getColumn(2).setPreferredWidth(100);
           columnModel.getColumn(3).setPreferredWidth(100);
           columnModel.getColumn(4).setPreferredWidth(100);
           columnModel.getColumn(5).setPreferredWidth(50);
           columnModel.getColumn(6).setPreferredWidth(50);
           columnModel.getColumn(7).setPreferredWidth(50);
           
       }
     
     
     
     public void limpiar(){
         txtISBN.setText("");
         
         txtNombre.setText("");
         txtEdicion.setText("");
         txtPaginas.setText("");
         txtPrecioVenta.setText("");
         txtPrecioCompra.setText("");
         txtStock.setText("");
         txtareaDescripcion.setText("");
         fecha.setDate(null);
         
                 
       
     }
     
     
   
     
     public String getFecha(){        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        return formato.format(fecha.getDate());     
         
     }
     
     public void limpiarTabla(){
         cargarTabla();
         
     }
     
     public void addIdEditorial(int id){
         idEditorial.add(id);
         
         
     } 
     
     public void addIdAutor(int id){
         idAutor.add(id);
         
         
     }
     
     public void addIdCategoria(int id){
         idCategoria.add(id);
     }
     
     public int getIdAutor(int i){
      
         return idAutor.get(i);
     }
     
     
     public int getIdEditorial(int i){
         return idEditorial.get(i);
     }
     
     public int getIdCategoria(int i){
         return idCategoria.get(i);
     }
     
     public void limpiarArray(){
         int i = 0;
         while(i<idEditorial.size()){
         idEditorial.remove(i);
         }
         while(i<idAutor.size()){
          idAutor.remove(i);
         }
         
        while(i<idCategoria.size()){      
         idCategoria.remove(i);
     }
     }
     
    
    
    public String getISBN(){
        return txtISBN.getText();
    }
    
    public String getTitulo(){
        return txtNombre.getText();
    }
    
    public String getPaginas(){
        return txtPaginas.getText();
    }
    
    
    public String getDescripcion(){
        return txtareaDescripcion.getText();
    }
    
    public double getPrecioVenta(){
        return Double.parseDouble(txtPrecioVenta.getText());
    }
 
    public double getPrecioCompra(){
        return Double.parseDouble(txtPrecioCompra.getText());
    }
    
    
    
    public String getStock(){
        return txtStock.getText();
    }
    
    public String getEdicion(){
        return txtEdicion.getText();
    
    }
    
    public String getComboBoxEditorial1(){
        return cmbEditorial.getSelectedItem().toString();
    }
    
    public String getComboBoxAutor1(){
        return cmbAutor.getSelectedItem().toString(); 
    }
    
    public String getComboBoxCategoria1(){
        return cmbCategoria.getSelectedItem().toString();
    }
        
    
    public int getComboBoxEditorial2(){
        return cmbEditorial.getSelectedIndex();
    }
    
    public int getComboBoxAutor2(){
        return cmbAutor.getSelectedIndex();
    }
    
    public int getComboBoxCategoria2(){
        return cmbCategoria.getSelectedIndex();
    }
    
    
    public void setComboBoxEditorial(String item){
        cmbEditorial.addItem(item);
    }
    
    public void setComboBoxAutor(String item){
        cmbAutor.addItem(item);
    }
    
    public void setComboBoxCategoria(String item){
        cmbCategoria.addItem(item);
    }
    
    public void limpiarComboBox(){
        cmbAutor.removeAllItems();
        cmbEditorial.removeAllItems();
        cmbCategoria.removeAllItems();
    }
    
    public void insertarFila(Object[] libro){
        model.addRow(libro);
    }
    
    public void eliminarFila(int filaSeleccionada){
        model.removeRow(filaSeleccionada);
    }
    
    public void modificarFila(Object[] datos){
        tablaLibros.setValueAt(datos[0],getFila(),0);
        tablaLibros.setValueAt(datos[1],getFila(),1);
        tablaLibros.setValueAt(datos[2],getFila(),2);
        tablaLibros.setValueAt(datos[3],getFila(),3);
        tablaLibros.setValueAt(datos[4],getFila(),4);
        tablaLibros.setValueAt(datos[5],getFila(),5);
        tablaLibros.setValueAt(datos[6],getFila(),6);
        tablaLibros.setValueAt(datos[7],getFila(),7);
                
    }
    
    public int getFila(){
        return tablaLibros.getSelectedRow();
    }
    
    public String getISBN_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),0).toString();
    }
    
    public String getTitulo_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),1).toString();
    }
    
    public String getAutor_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),2).toString();
    }
    
    public String getEdicion_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),3).toString();
    }
    
    public String getEditorial_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),4).toString();
    }
    
    public String getPrecio_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),5).toString();
                
    }
    
    public String getStock_tabla(){
        return tablaLibros.getValueAt(tablaLibros.getSelectedRow(),6).toString();
    }
    
    
    
    
    
    
    
    
   
    
   
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        txtEdicion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cmbAutor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        requerido1 = new javax.swing.JLabel();
        requerido2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtareaDescripcion = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        fecha = new com.toedter.calendar.JDateChooser();
        requerido6 = new javax.swing.JLabel();
        requerido4 = new javax.swing.JLabel();
        requerido5 = new javax.swing.JLabel();
        requerido3 = new javax.swing.JLabel();
        requerido7 = new javax.swing.JLabel();
        requerido8 = new javax.swing.JLabel();
        requerido9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ISBN");

        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });
        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtISBNKeyTyped(evt);
            }
        });

        jLabel3.setText("Titulo");

        jLabel4.setText("Paginas");

        jLabel5.setText("Fecha Lanzamiento");

        jLabel6.setText("Edicion");

        txtPaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaginasActionPerformed(evt);
            }
        });
        txtPaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaginasKeyTyped(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel9.setText("Autor");

        jLabel10.setText("Precio venta");

        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel11.setText("Stock");

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel12.setText("Editorial");

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaLibros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tablaLibros);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        requerido1.setText("requerido");

        requerido2.setText("requerido");

        jLabel8.setText("Precio compra");

        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        txtareaDescripcion.setColumns(20);
        txtareaDescripcion.setRows(5);
        jScrollPane5.setViewportView(txtareaDescripcion);

        jLabel13.setText("Descripicion");

        jLabel7.setText("Categoria");

        requerido6.setText("requerido");

        requerido4.setText("requerido");

        requerido5.setText("requerido");

        requerido3.setText("requerido");

        requerido7.setText("requerido");

        requerido8.setText("requerido");

        requerido9.setText("requerido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(121, 121, 121)
                                .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requerido1)
                    .addComponent(requerido2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requerido4)
                            .addComponent(requerido6)
                            .addComponent(requerido5)))
                    .addComponent(requerido3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(requerido8)
                        .addComponent(requerido7)
                        .addComponent(requerido9)))
                .addGap(167, 167, 167)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(requerido6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(requerido4)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requerido5))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(requerido7))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(requerido8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(requerido9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requerido1)
                            .addComponent(jLabel13))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(requerido2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(requerido3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(0, 0, 977, 718);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaginasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        validacion();
        if(contt == 0){
        controlador.procesar(BTN_AGREGAR_LIBRO);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlador.procesar(BTN_ELIMINAR_LIBRO);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.procesar(BTN_MODIFICAR_LIBRO);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        this.dispose();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtPaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginasKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPaginasKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    private void txtISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtISBNKeyTyped

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();   
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEditorial;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel requerido1;
    private javax.swing.JLabel requerido2;
    private javax.swing.JLabel requerido3;
    private javax.swing.JLabel requerido4;
    private javax.swing.JLabel requerido5;
    private javax.swing.JLabel requerido6;
    private javax.swing.JLabel requerido7;
    private javax.swing.JLabel requerido8;
    private javax.swing.JLabel requerido9;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextArea txtareaDescripcion;
    // End of variables declaration//GEN-END:variables
}

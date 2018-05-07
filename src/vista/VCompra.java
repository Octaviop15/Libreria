/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Octavio
 */
public class VCompra extends javax.swing.JDialog {
    public static final String BTN_BUSCAR_LIBRO_COMPRA = "BUSCAR LIBRO COMPRA";
    public static final String BTN_AGREGAR_DETALLE_COMPRA= "AGREGAR DETALLE COMPRA";
    public static final String BTN_ELIMINAR_DETALLE_COMPRA = "ELIMINAR DETALL COMPRA";
    public static final String BTN_OBTENER_TOTAL = "OBTENER TOTAL";
    public static final String BTN_GENERAR_COMPRA = "GENERAR COMPRA";
    private Controlador controlador;
    private DefaultTableModel model;
    ArrayList<Integer> idEditorial = new ArrayList<Integer>();

   
     
    public VCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Compra");
        desactivar_txt();
        desactivar_btn();
        cargarTabla();
        setFechaHora();
    }
    
     public void setControlador(Controlador controlador){
        this.controlador = controlador;
        
    }
     
     public void setFechaHora(){
         
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String f = formatter.format(fecha);
       /* Calendar cal = Calendar.getInstance();
        String fecha;
        fecha = cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR); */
        txtFecha.setText(f); 
    
        
    }
     
     public void cargarTabla(){
         String[] titulos= {"ISBN","Titulo","Precio","Cantidad","Subtotal"};
         model = new DefaultTableModel(null,titulos);
         tablaDetalleCompra.setModel(model);
         
     }
     
     public void limpiarComboBox(){
         cmbEditorial.removeAllItems();
     }
     
     public void limpiar(){
         
         txtISBN.setText("");
         txtTitulo.setText("");
         txtPrecio.setText("");
         txtStock.setText("");
         txtCantidad.setText("");
         
         cargarTabla();
         
         
     }
     
     public void desactivar_txt(){
         txtFecha.setEditable(false);
         txtTitulo.setEditable(false);
         txtPrecio.setEditable(false);
         txtStock.setEditable(false);
         txtCantidad.setEditable(false);
         txtTotal.setEditable(false);
         txtApellido.setEditable(false);
         txtNombre.setEditable(false);
         
     }
     
     public void desactivar_btn(){
         
         btnAgregarDetalleCompra.setEnabled(false);
     }
     
     public void activarTotal(){
         
         txtTotal.setEditable(true);
     }
     
      public void desactivarTotal(){
        
         txtTotal.setEditable(false);
     }
      
       public void activarCantidad(){
         txtCantidad.setEditable(true);
         btnAgregarDetalleCompra.setEnabled(true);
     }
     
     
      public void addIdEditorial(int id){
         idEditorial.add(id);
         
         
     } 
     
      public int getIdEditorial(int i){
         return idEditorial.get(i);
     }
     
     
     public void setComboBoxEditorial(String item){
         cmbEditorial.addItem(item);    
                 }
     
     
      public int getComboBoxEditorial(){
        return cmbEditorial.getSelectedIndex();
    }
     public String getISBN(){
         return txtISBN.getText();
     }
     
     public String getNombreEmpleado(){
         return txtNombre.getText();
     }
     
     public void setNombreEmpleado(String nombre){
         txtNombre.setText(nombre);
     }
     
     public void getApellidoEmpleado(){
         txtApellido.getText();
     }
     
     public void setApellidoEmpleado(String apellido){
         txtApellido.setText(apellido);
     }
     

             
     
     public String getCant(){
         return txtCantidad.getText();
     }
     
    
     public String getTitulo(){
         return txtTitulo.getText();
     }
     
     public void setTitulo(Object titulo){
         txtTitulo.setText(String.valueOf(titulo));
     }
     
     public int getPrecio(){
         return Integer.parseInt(txtPrecio.getText());
     }
     
     
     public void setPrecio(Object precio){
         txtPrecio.setText(String.valueOf(precio));
     }
     
     public int getStock(){
         return Integer.parseInt(txtStock.getText());
     }
     
     public void setStock(Object stock){
         txtStock.setText(String.valueOf(stock));
     }
     
     public String getFecha(){
        return txtFecha.getText();
    }
     
     public void setFecha(String fecha){
         txtFecha.setText(fecha);
     }
    
    
     
     public void insertarFila(Object[] datos){
         model.addRow(datos);
     }
     
     public void eliminarFila(int index){
         model.removeRow(index);
     }
     
     public int getFila(){
         return tablaDetalleCompra.getSelectedRow();
     }
     
     public int getCantFilas(){
         return tablaDetalleCompra.getRowCount();
     }
     
     
     
     
     public double getSubtotal(){
         double subtotal = getPrecio()*(Integer.parseInt(getCant()));
         return subtotal;
     }
     
       
    public double getTotal(){
        double total = 0;
        double subtotal;
        for(int i=0;i<tablaDetalleCompra.getRowCount();i++){
            subtotal = Double.parseDouble(tablaDetalleCompra.getValueAt(i,4).toString());
            total = total + subtotal;
            
        }
        return total;
    }
    
    public double getTotal_f(){
        return Double.parseDouble(txtTotal.getText());
        
        
    }
    
 
   
    public void setTotal(double t){
        txtTotal.setText(String.valueOf(t));
    }
    
    public String getISBN_tabla(int i){
        return tablaDetalleCompra.getValueAt(i,0).toString();
    }
    
    public int getCant_tabla(int i){
        return Integer.parseInt(tablaDetalleCompra.getValueAt(i, 3).toString());
    }
    
    public Double getSubTotal_tabla(int i){
        return Double.parseDouble(tablaDetalleCompra.getValueAt(i, 4).toString());
    }
    
    
     
     
     
    
     

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        cmbEditorial = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        btnBuscaLibro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCompra = new javax.swing.JTable();
        btnAgregarDetalleCompra = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnGenerarCompra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel10.setText("Fecha:");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel1.setText("ISBN:");

        btnBuscaLibro.setText("Buscar");
        btnBuscaLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaLibroActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Stock actual:");

        tablaDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDetalleCompra);

        btnAgregarDetalleCompra.setText("Agregar");
        btnAgregarDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleCompraActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtTotal.setText("0");

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnGenerarCompra.setText("Generar compra");
        btnGenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCompraActionPerformed(evt);
            }
        });

        jLabel6.setText("Empleado:");

        jLabel7.setText("Nombre:");

        jLabel8.setText("Apellido:");

        jLabel9.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGenerarCompra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAgregarDetalleCompra)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnBuscaLibro)))))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaLibro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDetalleCompra)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarCompra)
                    .addComponent(jButton2))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnBuscaLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaLibroActionPerformed
        controlador.procesar(BTN_BUSCAR_LIBRO_COMPRA);
    }//GEN-LAST:event_btnBuscaLibroActionPerformed

    private void btnAgregarDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleCompraActionPerformed
        controlador.procesar(BTN_AGREGAR_DETALLE_COMPRA);
    }//GEN-LAST:event_btnAgregarDetalleCompraActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        controlador.procesar(BTN_ELIMINAR_DETALLE_COMPRA);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCompraActionPerformed
        controlador.procesar(BTN_GENERAR_COMPRA);
    }//GEN-LAST:event_btnGenerarCompraActionPerformed


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDetalleCompra;
    private javax.swing.JButton btnBuscaLibro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarCompra;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetalleCompra;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

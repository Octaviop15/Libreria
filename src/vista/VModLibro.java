
package vista;

import controlador.Controlador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class VModLibro extends javax.swing.JDialog {
    
    public static final String BTN_ACEPTAR_MODIFICACION = "ACEPTAR MODIFICACION";
    private Controlador controlador;
    private int contt;

    
    ArrayList<Integer> idEditorial = new ArrayList<Integer>();
    ArrayList<Integer> idAutor = new ArrayList<Integer>();
    ArrayList<Integer> idCategoria = new ArrayList<Integer>();
    
    public VModLibro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Modificacion de libro");
        requerido1.setVisible(false);
        requerido2.setVisible(false);
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
        
             
         if(txtTitulo.getText().equals("")){
             requerido2.setVisible(true);
             contt++;
         }
         else{requerido2.setVisible(false);}
                
     }
       public void limpiar(){
         txtISBN.setText("");
     
         txtTitulo.setText("");
         txtEdicion.setText("");
         txtPaginas.setText("");
         txtPreciov.setText("");
         txtPrecioc.setText("");
         txtStock.setText("");
         txtareaDescripcion.setText("");
           
     }
       
         public void limpiarComboBox(){
        cmbAutor.removeAllItems();
        cmbEditorial.removeAllItems();
        cmbCategoria.removeAllItems();
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
         
          public int getIdEditorial(int i){
             return idEditorial.get(i);
     }
          
          public int getIdAutor(int i){
              return idAutor.get(i);
          }
     
          public int getIdCategoria(int i){
             return idCategoria.get(i);
     }
         
         
 
    public String getISBN(){
        return txtISBN.getText();
    }
    
    public String getTitulo(){
        return txtTitulo.getText();
    }
    
    public String getEdicion(){
        return txtEdicion.getText();
    
    }
    
    
    public String getPaginas(){
        return txtPaginas.getText();
    }
 
      public String getFecha(){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        return formato.format(fecha.getDate());
     }
      
    public String getDescripcion(){
        return txtareaDescripcion.getText();
    }
    
    public double getPreciov(){
        return Double.parseDouble(txtPreciov.getText());
    }
    
    public double getPrecioc(){
        return Double.parseDouble(txtPrecioc.getText());
    }
    
    public int getStock(){
        return Integer.parseInt(txtStock.getText());
    }
 
    public String getComboBoxEditorial1(){
        return cmbAutor.getSelectedItem().toString();
    }
    
    public int getComboBoxEditorial2(){
        return cmbEditorial.getSelectedIndex();
    }
    
  
    public String getComboBoxAutor1(){
        return cmbEditorial.getSelectedItem().toString();
    }
    
      public int getComboBoxAutor2(){
        return cmbAutor.getSelectedIndex();
    }
    
    
      public String getComboBoxCategoria1(){
        return cmbCategoria.getSelectedItem().toString();
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
   
    public void setISBN(String ISBN){
        txtISBN.setText(ISBN);
        
    }
    
    public void setTitulo(String titulo){
        txtTitulo.setText(titulo);
    }
    
       public void setEdicion(String edicion){
        txtEdicion.setText(edicion);
    }
    
    
    public void setPaginas(String paginas){
        txtPaginas.setText(paginas);
    }
    
   
    public void setStock(int stock){
        txtStock.setText(String.valueOf(stock));
    }
    
    public void setPreciov(double precio){
        txtPreciov.setText(String.valueOf(precio));
    }
    
    public void setPrecioc(double precio){
        txtPrecioc.setText(String.valueOf(precio));
        
    }
    
    public void setNombreEditorial(String item ){
        cmbEditorial.addItem(item);
        
    }
    
    public void setNombreAutor(String item){
        cmbAutor.addItem(item);
    }
    
    public void setDescripcion(String descripcion){
        txtareaDescripcion.setText(descripcion);
    }
    
    
    
 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPreciov = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        btnAceptarMod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        requerido1 = new javax.swing.JLabel();
        requerido2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioc = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel3.setText("Titulo");

        jLabel4.setText("Paginas");

        txtEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdicionActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Lanzamiento");

        jLabel6.setText("Edicion");

        txtPaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaginasKeyTyped(evt);
            }
        });

        jLabel10.setText("Precio venta");

        txtPreciov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreciovKeyTyped(evt);
            }
        });

        jLabel11.setText("Stock");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel12.setText("Editorial");

        jLabel9.setText("Autor");

        btnAceptarMod.setText("Aceptar");
        btnAceptarMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarModActionPerformed(evt);
            }
        });

        txtareaDescripcion.setColumns(20);
        txtareaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtareaDescripcion);

        jLabel7.setText("Descripcion");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        requerido1.setText("requerido");

        requerido2.setText("requerido");

        jLabel2.setText("Categoria");

        jLabel8.setText("Precio compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnAceptarMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtISBN)
                                    .addComponent(txtTitulo)
                                    .addComponent(txtEdicion)
                                    .addComponent(txtPaginas)
                                    .addComponent(txtPreciov)
                                    .addComponent(txtPrecioc)
                                    .addComponent(txtStock)
                                    .addComponent(cmbEditorial, 0, 215, Short.MAX_VALUE)
                                    .addComponent(cmbAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(requerido1)
                                    .addComponent(requerido2)))
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requerido1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(requerido2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPreciov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarMod)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        setBounds(0, 0, 854, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicionActionPerformed

    private void btnAceptarModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarModActionPerformed
        validacion();
        if(contt==0){
        controlador.procesar(BTN_ACEPTAR_MODIFICACION);
        }
    }//GEN-LAST:event_btnAceptarModActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginasKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPaginasKeyTyped

    private void txtPreciovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreciovKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPreciovKeyTyped

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarMod;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEditorial;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel requerido1;
    private javax.swing.JLabel requerido2;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtPrecioc;
    private javax.swing.JTextField txtPreciov;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextArea txtareaDescripcion;
    // End of variables declaration//GEN-END:variables
}

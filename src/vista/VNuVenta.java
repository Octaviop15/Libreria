/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controlador;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Octavio
 */


public class VNuVenta extends javax.swing.JDialog {
    private Controlador controlador;
    public static final String BTN_NUEVO_CLIENTE = "NUEVO CLIENTE";
    public static final String BTN_BUSCAR_CLIENTE = "BUSCAR CLIENTE";
    public static final String BTN_AGREGAR_DETALLE_VENTA = "AGREGAR DETALLE VENTA";
    public static final String BTN_BUSCAR_LIBRO = "BUSCAR LIBRO";
    public static final String BTN_ELIMINAR_DETALLE_VENTA = "ELIMINAR DETALLE VENTA";
    public static final String BTN_FINALIZAR_CARGA = "FINALIZAR CARGA";
    public static final String BTN_GENERAR_VENTA = "GENERAR VENTA";
    public static final String BTN_GENERAR_FACTURA = "GENERAR FACTURA";
    DefaultTableModel model;
    

    /**
     * Creates new form VNuVenta
     */
    public VNuVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Venta");
        cargarTabla();
          setFechaHora();
        desactivar_txt();
        desactivar_btn();
      
       
       
       
    }
    
    
    public void setFechaHora(){
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String f = formatter.format(fecha);
       /*Calendar cal = Calendar.getInstance();
        //String fecha
        fecha = cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR); */
        txtFecha.setText(f);
        
        
    }
     public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
   
    
    public void cargarTabla(){
        String[] titulos = {"ISBN","Titulo","Cantidad","Precio","Subtotal"};
        model = new DefaultTableModel(null,titulos);
        tablaVentaLibros.setModel(model);
    }
    
    public void limpiar(){
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtISBN.setText("");
        txtTitulo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCant.setText("");
        txtApellidoEmpleado.setText("");
        txtNombreEmpleado.setText("");
 
        tablaVentaLibros.removeAll();
        
        
    }
    
    
    public void desactivar_txt(){
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtTitulo.setEditable(false);
        txtPrecio.setEditable(false);
        txtStock.setEditable(false);
        txtTotal.setEditable(false);
        txtCant.setEditable(false);
        txtDireccion.setEditable(false);    
        txtFecha.setEditable(false);
        txtNombreEmpleado.setEditable(false);
        txtApellidoEmpleado.setEditable(false);
        
    }
    
    public void desactivar_btn(){
        btnTotal.setEnabled(false);
        btnAgregarDetalleVenta.setEnabled(false);
    }
    
    public void activarTotal(){
        btnTotal.setEnabled(true);
        txtTotal.setEditable(true);
    }
    
     public void desactivarTotal(){
         btnTotal.setEnabled(false);
         txtTotal.setEditable(false);
     }
     
    
    public void activarCantidad(){
        txtCant.setEditable(true);
        btnAgregarDetalleVenta.setEnabled(true);
    }
    
    public void visibilidadCantOff(){
        txtCant.setEditable(false);
        
    }
   
    public String getNombreEmpleado(){
        return txtNombreEmpleado.getText();
    }
    
    public void setNombreEmpleado(String empleado){
        txtNombreEmpleado.setText(empleado);
    }
    
    public String getApellidoEmpleado(){
        return txtApellidoEmpleado.getText();
    }
    
    public void setApellidoEmpleado(String apellido){
        txtApellidoEmpleado.setText(apellido);
    }
    
    public int getDNI(){
        return Integer.parseInt(txtDNI.getText());
    }
    
    public String getNombre(){
        return txtNombre.getText();
    }
    
    public String getApellido(){
        return txtApellido.getText();
    }
    
    public String getDomicilio(){
        return txtDireccion.getText();
    }
    public void setNombre(String nombre){
        txtNombre.setText(nombre);
    }
    
    public void setApellido(String apellido){
        txtApellido.setText(apellido);
    }
    
    public void setDireccion(String direccion){
        txtDireccion.setText(direccion);
    }
    
    public  String getISBN(){
        return txtISBN.getText();
    }
    public String getTitulo(){
        return txtTitulo.getText();
    }
   
    
    public void setTitulo(String titulo){
        txtTitulo.setText(titulo);
    }
    
    public int getPrecio(){
        return Integer.parseInt(txtPrecio.getText());
    }
    
    public void setPrecio(String precio){
        txtPrecio.setText(precio);
    }
    
    public int getStock(){
        return Integer.parseInt(txtStock.getText());
    }
    
    public void setStock(String stock){
        txtStock.setText(stock);
    }
    
    public int getCantidad(){
        return Integer.parseInt(txtCant.getText());
    }
    
    public String getFecha(){
        return txtFecha.getText();
       
    }
    
 
    
    public int getCantFilasTabla(){
        return tablaVentaLibros.getRowCount();
    }
    
    public double getSubtotal(){
        int precio= Integer.parseInt(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCant.getText());
        double subtotal = precio * cantidad;
        return subtotal;
        
    }
    
    public double getTotal(){
        double total = 0;
        double subtotal;
        for(int i=0;i<tablaVentaLibros.getRowCount();i++){
            subtotal = Double.parseDouble(tablaVentaLibros.getValueAt(i,4).toString());
            total = total + subtotal;
            
        }
        return total;
    }
    
    public double getTotalf(){
        return  Double.parseDouble(txtTotal.getText());
    }
    
    public void setTotal(double total){
        txtTotal.setText(String.valueOf(total));
    }
    
    
    
    public int getFila(){
        return tablaVentaLibros.getSelectedRow();
    }
    
    public void insertarFila(Object[] datos){
        model.addRow(datos);
    }
    

    
    public void eliminarFila(int filaSeleccionada){
        model.removeRow(filaSeleccionada);
    }
    
    public String getISBN_tabla(int i){
        return tablaVentaLibros.getValueAt(i,0).toString();
    }
    public String getTitulo_tabla(int i){
        return tablaVentaLibros.getValueAt(i, 1).toString();
    }
    
    public String getPrecio_tabla(int i){
        return tablaVentaLibros.getValueAt(i,2).toString();
    }
    
    public String getCantidad_tabla(int i){
        return tablaVentaLibros.getValueAt(i,3).toString();
    }
    
    public String getSubtotal1_tabla(int i){
        return tablaVentaLibros.getValueAt(i,4).toString();
    }
    
    public Double getSubtotal2_tabla(int i){
        return Double.parseDouble(tablaVentaLibros.getValueAt(i,4).toString());
    }
        
    
    public int getCant_tabla(int i){
        return Integer.parseInt(tablaVentaLibros.getValueAt(i, 2).toString());
    }
    
    
    public int getModoPago(){
        if(cmbModoPago.getSelectedItem().toString().equals("Efectivo")){
            return 1;
        }
        
        if(cmbModoPago.getSelectedItem().toString().equals("Tarjeta")){
            return 2;
        }
        else return 0;
        
    
    
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        btnBuscarC = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtISBN = new javax.swing.JTextField();
        btnAgregarDetalleVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentaLibros = new javax.swing.JTable();
        txtCant = new javax.swing.JTextField();
        btnBuscarL = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnFactura = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbModoPago = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtApellidoEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Nuevo Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        jLabel1.setText("DNI del cliente:");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        btnBuscarC.setText("Buscar");
        btnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAgregarDetalleVenta.setText("Agregar");
        btnAgregarDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleVentaActionPerformed(evt);
            }
        });

        tablaVentaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentaLibros);

        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });

        btnBuscarL.setText("Buscar");
        btnBuscarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLActionPerformed(evt);
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        txtTotal.setText("0");

        jLabel2.setText("Total:");

        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel3.setText("ISBN del libro:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Titulo:");

        jLabel6.setText("Precio:");

        jLabel7.setText("Stock:");

        jLabel8.setText("Nombre:");

        jLabel9.setText("Apellido:");

        jLabel11.setText("Dirrecion:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnFactura.setText("Factura");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha:");

        cmbModoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modo de pago", "Efectivo", "Tarjeta" }));

        jLabel12.setText("Empleado:");

        jLabel13.setText("Nombre:");

        jLabel14.setText("Apellido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarL, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGenerarVenta)
                            .addGap(18, 18, 18)
                            .addComponent(btnFactura)
                            .addGap(268, 268, 268)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAgregarDetalleVenta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(btnTotal)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4)
                    .addComponent(cmbModoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(39, 39, 39)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreEmpleado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel12))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarC)
                        .addComponent(jButton1)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarDetalleVenta)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(cmbModoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarVenta)
                    .addComponent(btnFactura)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        setBounds(0, 0, 622, 754);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlador.procesar(BTN_NUEVO_CLIENTE);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void btnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCActionPerformed
        controlador.procesar(BTN_BUSCAR_CLIENTE);
        
    }//GEN-LAST:event_btnBuscarCActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAgregarDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleVentaActionPerformed
        controlador.procesar(BTN_AGREGAR_DETALLE_VENTA);
    }//GEN-LAST:event_btnAgregarDetalleVentaActionPerformed

    private void btnBuscarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLActionPerformed
        controlador.procesar(BTN_BUSCAR_LIBRO);
    }//GEN-LAST:event_btnBuscarLActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.procesar(BTN_ELIMINAR_DETALLE_VENTA);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        controlador.procesar(BTN_FINALIZAR_CARGA);
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        controlador.procesar(BTN_GENERAR_VENTA);
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
   
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
     
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
     
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
     
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
         char c = evt.getKeyChar();
         int cant = txtDNI.getText().length();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        
        if(cant>=8){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        char c = evt.getKeyChar();
         
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
      
        
    }//GEN-LAST:event_txtCantKeyTyped

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        controlador.procesar(BTN_GENERAR_FACTURA);
    }//GEN-LAST:event_btnFacturaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDetalleVenta;
    private javax.swing.JButton btnBuscarC;
    private javax.swing.JButton btnBuscarL;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox<String> cmbModoPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentaLibros;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}


package vista;

import controlador.Controlador;


public class VPrincipal extends javax.swing.JFrame {
    public static final String BTN_VENTA = "VENTA";
    public static final String BTN_EDITORIAL = "EDITORIAL";
    public static final String BTN_AUTOR = "AUTOR";
    public static final String BTN_LIBRO = "LIBRO";
    public static final String BTN_CATEGORIA = "CATEGORIA";    
    public static final String BTN_ALTA_EMPLEADO = "AGREGAR EMPLEADO";
    public static final String BTN_COMPRA = "COMPRA";
    public static final String BTN_NUEVO_CLIENTE = "NUEVO CLIENTE";
    public static final String BTN_NUEVA_LIQUIDACION = "NUEVA LIQUIDACION";
    
    private Controlador controlador;

   
    public VPrincipal() {
        initComponents();
        setTitle("Menu principal");
    }
    
      public void setControlador(Controlador controlador){
        this.controlador = controlador;
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemLibro = new javax.swing.JMenuItem();
        menuItemAutor = new javax.swing.JMenuItem();
        menuItemCategoria = new javax.swing.JMenuItem();
        JMenu3 = new javax.swing.JMenu();
        menuItemVenta = new javax.swing.JMenuItem();
        menuItemCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemCompra = new javax.swing.JMenuItem();
        menuItemEditorial = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItemEmpleado = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1393924_605824496122545_1496992593_n.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 370, 360);

        jMenu1.setText("Archivo");

        jMenuItem9.setText("Salir");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Libro");

        menuItemLibro.setText("Libro");
        menuItemLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLibroActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemLibro);

        menuItemAutor.setText("Autor");
        menuItemAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAutorActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAutor);

        menuItemCategoria.setText("Categoria");
        menuItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCategoria);

        jMenuBar1.add(jMenu2);

        JMenu3.setText("Venta");
        JMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenu3ActionPerformed(evt);
            }
        });

        menuItemVenta.setText("Venta");
        menuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVentaActionPerformed(evt);
            }
        });
        JMenu3.add(menuItemVenta);

        menuItemCliente.setText("Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        JMenu3.add(menuItemCliente);

        jMenuBar1.add(JMenu3);

        jMenu4.setText("Compra");

        menuItemCompra.setText("Compra");
        menuItemCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompraActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemCompra);

        menuItemEditorial.setText("Editorial");
        menuItemEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditorialActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemEditorial);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Empleado");

        menuItemEmpleado.setText("Empleado");
        menuItemEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEmpleadoActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemEmpleado);

        jMenuItem2.setText("Liquidacion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAutorActionPerformed
        controlador.proce(BTN_AUTOR);
     
    }//GEN-LAST:event_menuItemAutorActionPerformed

    private void menuItemLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLibroActionPerformed
        controlador.procesar(BTN_LIBRO);
    }//GEN-LAST:event_menuItemLibroActionPerformed

    private void menuItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategoriaActionPerformed
        controlador.p(BTN_CATEGORIA); 
    }//GEN-LAST:event_menuItemCategoriaActionPerformed

    private void JMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu3ActionPerformed
           controlador.procesar(BTN_VENTA);
    }//GEN-LAST:event_JMenu3ActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        controlador.procesar(BTN_NUEVO_CLIENTE);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVentaActionPerformed
             controlador.procesar(BTN_VENTA);
    }//GEN-LAST:event_menuItemVentaActionPerformed

    private void menuItemCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompraActionPerformed
        controlador.procesar(BTN_COMPRA);
    }//GEN-LAST:event_menuItemCompraActionPerformed

    private void menuItemEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditorialActionPerformed
        controlador.proc(BTN_EDITORIAL);
    }//GEN-LAST:event_menuItemEditorialActionPerformed

    private void menuItemEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEmpleadoActionPerformed
        controlador.pasarAvistaAgregarEmpleado(BTN_ALTA_EMPLEADO);
    }//GEN-LAST:event_menuItemEmpleadoActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        System.exit(1);// TODO add your handling code here:

      // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void nuevaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaliActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_nuevaliActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
       
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         controlador.vistali(BTN_NUEVA_LIQUIDACION);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu JMenu3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu5;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JMenuItem menuItemAutor;
    public static javax.swing.JMenuItem menuItemCategoria;
    public static javax.swing.JMenuItem menuItemCliente;
    public static javax.swing.JMenuItem menuItemCompra;
    public static javax.swing.JMenuItem menuItemEditorial;
    private javax.swing.JMenuItem menuItemEmpleado;
    public static javax.swing.JMenuItem menuItemLibro;
    public static javax.swing.JMenuItem menuItemVenta;
    // End of variables declaration//GEN-END:variables
}

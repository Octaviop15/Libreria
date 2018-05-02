
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
    
    private Controlador controlador;

   
    public VPrincipal() {
        initComponents();
    }
    
      public void setControlador(Controlador controlador){
        this.controlador = controlador;
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
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

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        jMenuItem9.setText("Salir");
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

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

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

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenu3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuItemAutor;
    private javax.swing.JMenuItem menuItemCategoria;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemCompra;
    private javax.swing.JMenuItem menuItemEditorial;
    private javax.swing.JMenuItem menuItemEmpleado;
    private javax.swing.JMenuItem menuItemLibro;
    private javax.swing.JMenuItem menuItemVenta;
    // End of variables declaration//GEN-END:variables
}

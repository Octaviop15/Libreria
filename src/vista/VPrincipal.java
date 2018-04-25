
package vista;

import controlador.Controlador;


public class VPrincipal extends javax.swing.JFrame {
    public static final String BTN_VENTA = "VENTA";
    public static final String BTN_EDITORIAL = "EDITORIAL";
    public static final String BTN_AUTOR = "AUTOR";
    public static final String BTN_LIBRO = "LIBRO";
    public static final String BTN_CATEGORIA = "CATEGORIA";
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

        btnVenta = new javax.swing.JButton();
        btnEditorial = new javax.swing.JButton();
        btnAutor = new javax.swing.JButton();
        btnLibro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        bAltaEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnEditorial.setText("Editorial");
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });

        btnAutor.setText("Autor");
        btnAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorActionPerformed(evt);
            }
        });

        btnLibro.setText("Libro");
        btnLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroActionPerformed(evt);
            }
        });

        jButton1.setText("Administrar Categorias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar Empleado");

        bAltaEmpleado.setText("Agregar Empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVenta)
                            .addComponent(btnAutor))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLibro)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1))
                            .addComponent(btnEditorial)))
                    .addComponent(bBuscar)
                    .addComponent(bAltaEmpleado))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVenta)
                    .addComponent(btnEditorial))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAutor)
                    .addComponent(btnLibro)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(bBuscar)
                .addGap(18, 18, 18)
                .addComponent(bAltaEmpleado)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
    
        controlador.procesar(BTN_VENTA);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        controlador.proc(BTN_EDITORIAL);
    }//GEN-LAST:event_btnEditorialActionPerformed

    private void btnLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroActionPerformed
        controlador.procesar(BTN_LIBRO);
    }//GEN-LAST:event_btnLibroActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        controlador.proce(BTN_AUTOR);
    }//GEN-LAST:event_btnAutorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
controlador.p(BTN_CATEGORIA);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAltaEmpleado;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton btnAutor;
    private javax.swing.JButton btnEditorial;
    private javax.swing.JButton btnLibro;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}

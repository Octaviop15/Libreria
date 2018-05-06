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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author El´s
 */
public class VLiquidacion extends javax.swing.JDialog {
private Controlador controlador;

public static final String BTN_BUSCAR_LIQUIDACIONEMPLEADO = "BUSCAR LIQUIDACIONEMP";
public static final String BTN_ACT_TABLA = "ACTUALIZAR TABLA";
public static final String BTN_SLECT_EMPLE = "SELECCIONAR EMPLE";
public static final String BTN_SLECT_AGRE = "AGREGAR";
public static final String BTN_CALCULAR = "CALCULAR";
private DefaultTableModel model;


public VLiquidacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Liquidacion");
        setFechaHora();
        editable();
    }

  public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
  

  public void editable(){
      txtFecha.setEditable(false);
      txtJubilacion.setEditable(false);
      txtEscalfon.setEditable(false);
      txtHaberes.setEditable(false);
      txtDescuentos.setEditable(false);
      txtNeto.setEditable(false);
      
  }
  
  public void limpiar(){
      txtJubilacion.setText("");
      txtEscalfon.setText("");
      txtHaberes.setText("");
      txtDescuentos.setText("");
      txtNeto.setText("");
  }
  
  public void cargarTabla(){
      String[] titulos = {"Periodo","Total"};
      model = new DefaultTableModel(null,titulos);
      tablaLiquidaciones.setModel(model);
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
   
    public int  compararFecha(){
      String fechaActual = txtFecha.getText();
      int añoA = Integer.parseInt(fechaActual.substring(0,4));     
      
      String fechaIngreso = getfecha();
      int añoI = Integer.parseInt(fechaIngreso.substring(0,4));
      
      int antiguedad = añoA - añoI;
      return antiguedad; 
    }
    
    public void calcularEscalafon(){
        if(getEscalafon() < 5){
            setEscalafon(0.0);
         
        }
        if(getEscalafon() >= 5){
            double valor = getSueldo() * 0.05;
            setEscalafon(valor);
            
             
        }
        if(getEscalafon()>= 10){
            double valor= getSueldo() * 0.10;
            setEscalafon(valor);
        }
        
        if( getEscalafon() >= 15){
            double valor =  getSueldo() * 0.15;
            setEscalafon(valor);
        }
       
            
    
    
    
    
    }
   public void setAntiguedad(int antiguedad){
       txtAntiguedad.setText(String.valueOf(antiguedad));
   }
   
  
 public String getCUIL(){
        return insertarcuil.getText();
    }
 public int getidem(){
        return  Integer.parseInt(idemp.getText());
    }
 public String getnombre(){
        return nombre.getText();
    }
 public String getfecha(){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        return formato.format(fecha.getDate()); 
    }
 
 
 
 
 
 public String getcategoria(){
        return categoria.getText();
    }
 
 
 public String getPeriodo(){
     return txtPeriodo.getText();
 }
 
 public Double getSueldo(){
     return Double.parseDouble(txtSueldo.getText());
 }
 
 public Double getJubilacion(){
      return Double.parseDouble(txtJubilacion.getText());
 }
 
 public Double getLey19032(){
      return Double.parseDouble(txtLey19032.getText());
 }
 
  public Double getEscalafon(){
      return Double.parseDouble(txtEscalfon.getText());
 }
  
  public Double getTotalHaberes(){
      return Double.parseDouble(txtHaberes.getText());
  }
  
   public Double getTotalDescuentos(){
      return Double.parseDouble(txtDescuentos.getText());
  }
   
   public Double getNetoPagar(){
      return Double.parseDouble(txtNeto.getText());
  }
   
   public void setJubilacion(Double monto){
       txtJubilacion.setText(String.valueOf(monto));
   }
   
   public void setLey_19032(Double monto){
       txtLey19032.setText(String.valueOf(monto));
   }
   
   public void setEscalafon(Double monto){
       txtEscalfon.setText(String.valueOf(monto));
   }
   
   public void setHaberes(Double monto){
       txtHaberes.setText(String.valueOf(monto));
   }
   
   public void setDescuentos(Double monto){
       txtDescuentos.setText(String.valueOf(monto));
   }
   
   public void setSueldoNeto(Double monto){
       txtNeto.setText(String.valueOf(monto));
   }
   
   public void insertarFila(Object[] datos){
       model.addRow(datos);
   }
   
   public void limpiarTabla(){
       cargarTabla();
   }
   
   
  
  
      

  
  
 
 
 
 
 public void radic(){
        insertarcuil.setText("");
        idemp.setText("0");
        nombre.setText("0"); 
        categoria.setText("");
        
     
    }
    /**
     * Creates new form VLiquidacion
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablausuario = new javax.swing.JTable();
        buscaremp = new javax.swing.JButton();
        insertarcuil = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Seleccionar = new javax.swing.JButton();
        idemp = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        categoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        liquidacion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLiquidaciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtJubilacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLey19032 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEscalfon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHaberes = new javax.swing.JTextField();
        txtDescuentos = new javax.swing.JTextField();
        txtNeto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        txtAntiguedad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tablausuario);

        buscaremp.setText("Buscar CUIL");
        buscaremp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarempActionPerformed(evt);
            }
        });

        insertarcuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarcuilActionPerformed(evt);
            }
        });
        insertarcuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                insertarcuilKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("LIQUIDACIÓN");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        idemp.setText("0");
        idemp.setEnabled(false);

        nombre.setEnabled(false);

        categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categoriaKeyTyped(evt);
            }
        });

        jLabel2.setText("ID Empleado");

        jLabel3.setText("Fecha");

        jLabel4.setText("Categoria");

        jLabel5.setText("Nombre");

        liquidacion.setText("Agregar Liquidacion");
        liquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liquidacionActionPerformed(evt);
            }
        });

        tablaLiquidaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaLiquidaciones);

        jLabel6.setText("Sueldo:");

        jLabel7.setText("Jubilacion:");

        jLabel8.setText("ley 19032:");

        jLabel9.setText("Escalafon:");

        jLabel10.setText("Total haberes:");

        jLabel11.setText("Total descuentos:");

        jLabel12.setText("Neto a pagar:");

        jLabel13.setText("Periodo:");

        jLabel14.setText("Fecha:");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel15.setText("Antiguedad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(liquidacion)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCalcular)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Seleccionar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(idemp))
                                        .addGap(47, 47, 47)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtAntiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtHaberes, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEscalfon, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNeto)
                                        .addComponent(txtDescuentos))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtJubilacion))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLey19032, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtPeriodo))
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(buscaremp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertarcuil, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaremp)
                    .addComponent(insertarcuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Seleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAntiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(liquidacion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtJubilacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLey19032, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEscalfon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtHaberes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(127, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertarcuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarcuilActionPerformed
      
    }//GEN-LAST:event_insertarcuilActionPerformed

    private void insertarcuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarcuilKeyTyped
char c = evt.getKeyChar();
        int cant = insertarcuil.getText().length();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        
        if(cant>=11){
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_insertarcuilKeyTyped

    private void buscarempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarempActionPerformed
controlador.buscarempleadoliquidacion(BTN_BUSCAR_LIQUIDACIONEMPLEADO);        // TODO add your handling code here:
    }//GEN-LAST:event_buscarempActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    controlador.actogu(BTN_ACT_TABLA);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoriaKeyTyped
char c = evt.getKeyChar();
        int cant = categoria.getText().length();
        
        if(!Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        
        if(cant>=2){
            getToolkit().beep();
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_categoriaKeyTyped

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
 controlador.selecc(BTN_SLECT_EMPLE);           // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarActionPerformed

    private void liquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liquidacionActionPerformed
       controlador.AGRE(BTN_SLECT_AGRE);   // TODO add your handling code here:
    }//GEN-LAST:event_liquidacionActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        controlador.procesar(BTN_CALCULAR);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularActionPerformed

   

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Seleccionar;
    public static javax.swing.JTable Tablausuario;
    private javax.swing.JButton btnCalcular;
    public static javax.swing.JButton buscaremp;
    public static javax.swing.JTextField categoria;
    private com.toedter.calendar.JDateChooser fecha;
    public static javax.swing.JTextField idemp;
    public static javax.swing.JTextField insertarcuil;
    public static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton liquidacion;
    public static javax.swing.JTextField nombre;
    private javax.swing.JTable tablaLiquidaciones;
    private javax.swing.JTextField txtAntiguedad;
    private javax.swing.JTextField txtDescuentos;
    private javax.swing.JTextField txtEscalfon;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHaberes;
    private javax.swing.JTextField txtJubilacion;
    private javax.swing.JTextField txtLey19032;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}

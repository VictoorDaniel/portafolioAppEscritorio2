
package view.crudDescuento;

import conectorBD.ConnectDbProducto;
import conectorBD.JavaConnectDb;
import controller.descuento.CrudDescuento;
import model.descuento.Descuento;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.LoginUser;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author fernandacancinoreyes
 */
public class createDescuentos extends javax.swing.JFrame {
    
     LoginUser mod;
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    OracleResultSet rs = null;
    
    /*declaracion de variables*/
    String ruta = null;//para la ruta de la imagen
    
    ConnectDbProducto cnProd = new ConnectDbProducto();
    
    public createDescuentos() {
        /*inicia los componentes*/
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
    }
     public createDescuentos(LoginUser mod) {
         
         this.mod=mod;
        /*inicia los componentes*/
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMinPuntosDescuento = new javax.swing.JTextField();
        txtMaxPuntosDescuento = new javax.swing.JTextField();
        txtTopeDescuento = new javax.swing.JTextField();
        btnGuardarDescuento = new javax.swing.JButton();
        btnVolverDescuento = new javax.swing.JButton();
        txtPorcentajeDescuento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descuento.png"))); // NOI18N
        jLabel1.setText("  Agregar Descuento");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Minimo Puntos");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Maximo Puntos");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Porcentaje Descuento");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Tope Descuento ($)");

        txtMinPuntosDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMinPuntosDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinPuntosDescuentoActionPerformed(evt);
            }
        });
        txtMinPuntosDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinPuntosDescuentoKeyTyped(evt);
            }
        });

        txtMaxPuntosDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMaxPuntosDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxPuntosDescuentoKeyTyped(evt);
            }
        });

        txtTopeDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTopeDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTopeDescuentoKeyTyped(evt);
            }
        });

        btnGuardarDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarDescuento.setText("Guardar");
        btnGuardarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDescuentoActionPerformed(evt);
            }
        });

        btnVolverDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverDescuento.setText("Volver");
        btnVolverDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverDescuentoActionPerformed(evt);
            }
        });

        txtPorcentajeDescuento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPorcentajeDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeDescuentoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaxPuntosDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(txtMinPuntosDescuento)
                            .addComponent(txtTopeDescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(txtPorcentajeDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnGuardarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnVolverDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMinPuntosDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaxPuntosDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcentajeDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTopeDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolverDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarDatos(){
        txtMinPuntosDescuento.setText("");
        txtMaxPuntosDescuento.setText("");
        txtTopeDescuento.setText("");
        txtPorcentajeDescuento.setText("");
    }
    
    private void verificaDatos(){
        if(    txtMinPuntosDescuento.getText().trim().length() != 0 
            && txtMaxPuntosDescuento.getText().trim().length() != 0
            && txtTopeDescuento.getText().trim().length() != 0
            && txtPorcentajeDescuento.getText().trim().length() != 0
           ) {
            //si los datos son correctamente insertados se ejecuta funcion para que guarde
            //agregaDesucento()
            try {
                agregaDesucento();
            } catch (SQLException ex) {
                Logger.getLogger(createDescuentos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        else {
            JOptionPane.showMessageDialog(null, "Debe insertar todos los datos");
        }
    }
    
    private void agregaDesucento() throws SQLException{
        
        CrudDescuento cDscto = new CrudDescuento();
        Descuento dscto = new Descuento();
                
        //cDescuento.setIdDescuento(parseInt(txtMinPuntosDescuento.getText()));
        dscto.setMinPuntos(parseInt(txtMinPuntosDescuento.getText()));
        dscto.setMaxPuntos(parseInt(txtMaxPuntosDescuento.getText()));
        dscto.setPorcentajeDescuento(parseInt(txtPorcentajeDescuento.getText()));
        dscto.setTopeDescuento(parseInt(txtTopeDescuento.getText()));
                
        cDscto.agregarDescuento(dscto);
    }
    
    
    private void btnGuardarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDescuentoActionPerformed
      
        verificaDatos();
        limpiarDatos();
        this.setVisible(false);
        readDescuento rd = new readDescuento(mod);
            rd.setVisible(true); 
            rd.pack();
         
    }//GEN-LAST:event_btnGuardarDescuentoActionPerformed

    private void btnVolverDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverDescuentoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readDescuento rp = new readDescuento(mod);
        rp.setVisible(true);
        rp.pack();
        
    }//GEN-LAST:event_btnVolverDescuentoActionPerformed

    private void txtMinPuntosDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinPuntosDescuentoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMinPuntosDescuentoActionPerformed

    private void txtMinPuntosDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinPuntosDescuentoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
        
        //O tambien se puede validar de la siguiente forma
        /*
        //VALIDA EL INGRESO DE DIGITOS
        if (Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo letras");
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Bien ha ingresado un número");
        }
        */
        
    }//GEN-LAST:event_txtMinPuntosDescuentoKeyTyped

    private void txtMaxPuntosDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxPuntosDescuentoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
        
    }//GEN-LAST:event_txtMaxPuntosDescuentoKeyTyped

    private void txtPorcentajeDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeDescuentoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_txtPorcentajeDescuentoKeyTyped

    private void txtTopeDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTopeDescuentoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_txtTopeDescuentoKeyTyped
  
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(createDescuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createDescuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createDescuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createDescuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createDescuentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDescuento;
    private javax.swing.JButton btnVolverDescuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMaxPuntosDescuento;
    private javax.swing.JTextField txtMinPuntosDescuento;
    private javax.swing.JTextField txtPorcentajeDescuento;
    private javax.swing.JTextField txtTopeDescuento;
    // End of variables declaration//GEN-END:variables
}

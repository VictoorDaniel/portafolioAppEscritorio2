
package view.crudProductos;

import conectorBD.ConnectDbProducto;
import conectorBD.JavaConnectDb;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.LoginUser;
import model.comboBox.CbxTienda;
import oracle.jdbc.OracleResultSet;
import static view.crudProductos.updateProductos.dtFechaVencimientoMod;

/**
 *
 * @author fernandacancinoreyes
 */
public class createProductos extends javax.swing.JFrame {
    
 LoginUser mod;
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    OracleResultSet rs = null;
    
    /*declaracion de variables*/
    String ruta = null;//para la ruta de la imagen
    
    
    
    public createProductos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /*inicia los componentes*/
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
        /*para limpiar el cbx de rubro*/
        cbxRubroProducto.removeAllItems();
        
        ConnectDbProducto cnProd = new ConnectDbProducto();
        
        cbxRubroProducto.setModel(getValuesRubro());
        //cbxCategoriaProducto.setModel(cnProd.getValuesCategoria());
        
        CbxTienda comboboxTienda = new CbxTienda();
        cbxTiendaProducto.removeAllItems();
        comboboxTienda.getValuesTienda(cbxTiendaProducto);
        
        //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    createProductos(LoginUser mod)throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        this.mod=mod;
        
         /*inicia los componentes*/
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
        /*para limpiar el cbx de rubro*/
        cbxRubroProducto.removeAllItems();
        
        ConnectDbProducto cnProd = new ConnectDbProducto();
        
        cbxRubroProducto.setModel(getValuesRubro());
        //cbxCategoriaProducto.setModel(cnProd.getValuesCategoria());
        
        CbxTienda comboboxTienda = new CbxTienda();
        cbxTiendaProducto.removeAllItems();
        comboboxTienda.getValuesTienda(cbxTiendaProducto);
        
        //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        cbxRubroProducto = new javax.swing.JComboBox<>();
        txtStockProducto = new javax.swing.JTextField();
        btnGuardarProducto = new javax.swing.JButton();
        btnVolverProducto = new javax.swing.JButton();
        lblimagen = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        JDfechaV = new com.toedter.calendar.JDateChooser();
        cbxTiendaProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prod.png"))); // NOI18N
        jLabel1.setText("  Agregar Producto");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Rubro");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Fecha Vencimiento");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Stock");

        txtNombreProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtPrecioProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        cbxRubroProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxRubroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRubroProductoActionPerformed(evt);
            }
        });

        txtStockProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtStockProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockProductoKeyTyped(evt);
            }
        });

        btnGuardarProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnVolverProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverProducto.setText("Volver");
        btnVolverProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProductoActionPerformed(evt);
            }
        });

        btnImagen.setText("Imagen...");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        cbxTiendaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiendaProductoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Tienda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrecioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(txtNombreProducto)
                        .addComponent(cbxRubroProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStockProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                    .addComponent(JDfechaV, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTiendaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbxRubroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(txtStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(JDfechaV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxTiendaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(405, Short.MAX_VALUE)
                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultComboBoxModel getValuesRubro(){
        
        DefaultComboBoxModel cbModelRubro = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = obj.ConnectBd();
            String sql = "select idrubro, nombrerubro from RUBRO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idrubro");
                registros[1] = rs.getString("nombrerubro");
               cbModelRubro.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cbModelRubro;
    }
    
    private void limpiarDatos(){
        txtNombreProducto.setText("");
        txtPrecioProducto.setText("");
        cbxRubroProducto.setModel(getValuesRubro());
        txtStockProducto.setText("");
        ((JTextField)JDfechaV.getDateEditor().getUiComponent()).setText("");
        lblimagen.setIcon(null);
    }
    
    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
      
       
        FileInputStream fi = null; //para la imagen..
         if(txtNombreProducto.getText().trim().length() != 0 && txtPrecioProducto.getText().trim().length() != 0
                         && txtStockProducto.getText().trim().length() != 0&& ((JTextField)JDfechaV.getDateEditor().getUiComponent()).getText().trim().length() != 0
                         )//este if es para validar algunos campos vacios
         {
             if(ruta==null)
                 {JOptionPane.showMessageDialog(null, "escoja una imagen porfavor", "Error", JOptionPane.INFORMATION_MESSAGE);}else{
                 
           
              if (!(Pattern.matches("^[0-9]{2}+[-]{1}+[a-zA-Z]{3}+[-]{1}+[0-9]{4}+$", ((JTextField)JDfechaV.getDateEditor().getUiComponent()).getText()))) 
                        {JOptionPane.showMessageDialog(null, "formato de fecha incorrecta; \n ejemplo: dd-mmm-yyyy", "Error", JOptionPane.ERROR_MESSAGE);}else{
        try {
                Connection cn = obj.ConnectBd();
                 String sql =  "insert into PRODUCTO (NOMBREPRODUCTO, RUBROPRODUCTO, PRECIOPRODUCTO, STOCKPRODUCTO,FECHAEXPIRACION ,IMAGENPRODUCTO, IDTIENDA) "
                            + "values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareCall(sql);
                
               //guardamos la imagen que emos elegido en estas variables
               File file = new File(ruta);
               fi = new FileInputStream(file);
               
                /*para obtener id de producto*/
                int idrubro =  cbxRubroProducto.getSelectedIndex();
                idrubro = idrubro + 1;
                String idRubroString = String.valueOf(idrubro);
                
                System.out.println("idTienda" + cbxTiendaProducto.getItemAt(cbxTiendaProducto.getSelectedIndex()).getIDTIENDA());
                
                /*para obtener id de producto*/
                int idTienda =  cbxTiendaProducto.getItemAt(cbxTiendaProducto.getSelectedIndex()).getIDTIENDA();
                
                /*se envian los datos a la consulta*/
                pst.setString(1, txtNombreProducto.getText());
                pst.setString(2, idRubroString) ;
                pst.setString(3, txtPrecioProducto.getText());
                pst.setString(4, txtStockProducto.getText());
                pst.setString(5,((JTextField)JDfechaV.getDateEditor().getUiComponent()).getText());
                pst.setBinaryStream(6, fi);
                pst.setInt(7, idTienda);
                
              cn.commit();
                
                rs = (OracleResultSet) pst.executeQuery();
                
                if (rs.next()){
                    limpiarDatos();
                    JOptionPane.showMessageDialog(null, "Datos insertados");
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un error, no se pudo insertar datos");
                }
                //pst.execute();
                pst.close();
                
        } catch (Exception e) {
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(null,"uups no registro"+e);
        }
        }}
         }else{  JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios");}
        
      
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnVolverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readProductos rp = new readProductos(mod);
        rp.setVisible(true);
        rp.pack();
        
    }//GEN-LAST:event_btnVolverProductoActionPerformed

    private void cbxRubroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRubroProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRubroProductoActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        //esto es para elgir la imagen y su respectiva ruta etc

        JFileChooser j = new JFileChooser();
        j.setCurrentDirectory(new File("Imagenes/"));
        int ap = j.showOpenDialog(this);

        if(ap == JFileChooser.APPROVE_OPTION){
            ruta = j.getSelectedFile().getAbsolutePath();
            
            
            //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
            Image foto= getToolkit().getImage(ruta);
            //Le damos dimension a nuestro label que tendra la imagen
            foto= foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            lblimagen.setIcon(new ImageIcon(foto));

        }

    }//GEN-LAST:event_btnImagenActionPerformed

    private void cbxTiendaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiendaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTiendaProductoActionPerformed

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        // TODO add your handling code here:
          // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }else if (validar == '-' ){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se aceptan numeros Positivos");
        }
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void txtStockProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockProductoKeyTyped
        // TODO add your handling code here:
          // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }else if (validar == '-' ){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se aceptan numeros Positivos");
        }
    }//GEN-LAST:event_txtStockProductoKeyTyped

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
            java.util.logging.Logger.getLogger(createProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new createProductos().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(createProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(createProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(createProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(createProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDfechaV;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnVolverProducto;
    private javax.swing.JComboBox<String> cbxRubroProducto;
    private javax.swing.JComboBox<model.comboBox.CbxTienda> cbxTiendaProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtStockProducto;
    // End of variables declaration//GEN-END:variables
}

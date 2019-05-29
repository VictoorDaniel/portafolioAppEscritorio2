/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudOferta;

import conectorBD.JavaConnectDb;
import controller.oferta.CrudOferta;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleResultSet;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import model.Oferta.Oferta;
import model.Oferta.Oferta2BI;
import javax.swing.JComboBox;
import model.LoginUser;
import model.comboBox.CbxEstado;
import model.comboBox.CbxProducto;
import model.comboBox.CbxTienda;

/**
 *
 * @author fernandacancinoreyes
 */
public class createOferta extends javax.swing.JFrame {
LoginUser mod;
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    OracleResultSet rs = null;
    PreparedStatement pst = null;
    /*declaracion de variables*/
    String ruta = null;//para la ruta de la imagen
    FileInputStream fi = null; //para la imagen..
    
    Oferta ofert = new Oferta();
    CrudOferta cOferta = new CrudOferta();
    
    
    public createOferta() throws SQLException {
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
        limpiarDatos();
        cargarCbx();
        
         txtPrecioProductoOferta.setEditable(false);
        
        
    }

    public createOferta(LoginUser mod)throws SQLException {
        
        this.mod=mod;
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
        limpiarDatos();
        cargarCbx();
        
         txtPrecioProductoOferta.setEditable(false);
        
    }
    
    public void limpiarDatos(){
        txtNombreOferta.setText("");
        txtPrecioProductoOferta.setText("");
        txtDesceuntoOferta.setText("");
        txtStockOferta.setText("");
        lblimagen.setIcon(null);
    }
    
    
    private void cargarCbx(){
        
        CbxProducto combobox = new CbxProducto();
        cbxProductoOferta.removeAllItems();
        combobox.getValuesProducto(cbxProductoOferta);
        
        
        CbxTienda comboboxTienda = new CbxTienda();
        cbxTiendaOferta.removeAllItems();
        comboboxTienda.getValuesTienda(cbxTiendaOferta);
        
        CbxEstado comboboxEstado = new CbxEstado();
        cbxEstadoOferta.removeAllItems();
        comboboxEstado.getValuesEstado(cbxEstadoOferta);
        
    }
    
    private int stock ;
    private int maximoDscto;
    private int varCero;
            
    
    private void cargarPrecioProducto() throws SQLException{
        Connection cn = obj.ConnectBd();
        Statement st = cn.createStatement();
        String sql = "select PRECIOPRODUCTO\n" +
                           ",STOCKPRODUCTO\n"+
                        "from PRODUCTO \n" +
                        "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
        
        pst = cn.prepareStatement(sql);
        pst.setInt(1, cbxProductoOferta.getItemAt(cbxProductoOferta.getSelectedIndex()).getIDPRODUCTO());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        Object datos[] = new Object[2];
        
        while (rs.next()) {     
                //System.out.println("rs.getString(1)" + rs.getString(1));
                txtPrecioProductoOferta.setText(rs.getString(1));
                txtStockOferta.setText(rs.getString(2));
        }
    }
    
    private int cargarPrecioProductoR() throws SQLException{
        Connection cn = obj.ConnectBd();
        Statement st = cn.createStatement();
        String sql = "select PRECIOPRODUCTO\n" +
                           ",STOCKPRODUCTO\n"+
                        "from PRODUCTO \n" +
                        "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
        
        pst = cn.prepareStatement(sql);
        pst.setInt(1, cbxProductoOferta.getItemAt(cbxProductoOferta.getSelectedIndex()).getIDPRODUCTO());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        Object datos[] = new Object[2];
        
        while (rs.next()) {     
                //System.out.println("rs.getString(1)" + rs.getString(1));
                txtPrecioProductoOferta.setText(rs.getString(1));
                txtStockOferta.setText(rs.getString(2));
                /*
                if (parseInt(txtStockOferta.getText()) > parseInt(rs.getString(2))){
                    
                }*/
                stock = parseInt(rs.getString(2));
                
        }
        //txtPrecioProductoOferta.setText(sql);
        return stock;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreOferta = new javax.swing.JTextField();
        txtDesceuntoOferta = new javax.swing.JTextField();
        txtStockOferta = new javax.swing.JTextField();
        txtPrecioProductoOferta = new javax.swing.JTextField();
        cbxTiendaOferta = new javax.swing.JComboBox<>();
        cbxProductoOferta = new javax.swing.JComboBox<>();
        btnImagen = new javax.swing.JButton();
        lblimagen = new javax.swing.JLabel();
        btnGuardarOferta = new javax.swing.JButton();
        btnVolverOferta = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbxEstadoOferta = new javax.swing.JComboBox<>();
        txtMaxProductoOferta = new javax.swing.JTextField();
        txtMinProductoOferta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Oferta");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
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
        jLabel3.setText("Nombre Oferta");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Tienda");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Producto");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Precio Producto");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Descuento (%)");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Stock");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Imagen");

        txtNombreOferta.setPreferredSize(new java.awt.Dimension(10, 32));
        txtNombreOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreOfertaActionPerformed(evt);
            }
        });

        txtDesceuntoOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDesceuntoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesceuntoOfertaActionPerformed(evt);
            }
        });
        txtDesceuntoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesceuntoOfertaKeyTyped(evt);
            }
        });

        txtStockOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtStockOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockOfertaActionPerformed(evt);
            }
        });
        txtStockOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockOfertaKeyTyped(evt);
            }
        });

        txtPrecioProductoOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecioProductoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoOfertaActionPerformed(evt);
            }
        });
        txtPrecioProductoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoOfertaKeyTyped(evt);
            }
        });

        cbxTiendaOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiendaOfertaActionPerformed(evt);
            }
        });

        cbxProductoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoOfertaActionPerformed(evt);
            }
        });

        btnImagen.setText("Imagen...");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnGuardarOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarOferta.setText("Guardar");
        btnGuardarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOfertaActionPerformed(evt);
            }
        });

        btnVolverOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverOferta.setText("Volver");
        btnVolverOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverOfertaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Estado");

        cbxEstadoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoOfertaActionPerformed(evt);
            }
        });

        txtMaxProductoOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMaxProductoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxProductoOfertaActionPerformed(evt);
            }
        });
        txtMaxProductoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxProductoOfertaKeyTyped(evt);
            }
        });

        txtMinProductoOferta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMinProductoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinProductoOfertaActionPerformed(evt);
            }
        });
        txtMinProductoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinProductoOfertaKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Minimo Producto");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Maximo Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnGuardarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxEstadoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDesceuntoOferta)
                                    .addComponent(txtNombreOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStockOferta)
                                    .addComponent(txtPrecioProductoOferta)
                                    .addComponent(btnImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMaxProductoOferta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(txtMinProductoOferta, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTiendaOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProductoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbxTiendaOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxProductoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioProductoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDesceuntoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtStockOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMinProductoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaxProductoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btnImagen))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEstadoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVolverOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDesceuntoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesceuntoOfertaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDesceuntoOfertaActionPerformed

    private void txtDesceuntoOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesceuntoOfertaKeyTyped
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

    }//GEN-LAST:event_txtDesceuntoOfertaKeyTyped

    private void txtNombreOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreOfertaActionPerformed

    private void txtStockOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockOfertaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtStockOfertaActionPerformed

    private void txtStockOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockOfertaKeyTyped
        // TODO add your handling code here:
        //System.out.println("stock" + stock);
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }else if (validar == '-' ){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se aceptan numeros Positivos");
        }
        
        /*else if (parseInt(txtStockOferta.getText()) > stock){
            JOptionPane.showMessageDialog(rootPane, "No puede ser mayor el stock al existente");
        }*/
    }//GEN-LAST:event_txtStockOfertaKeyTyped

    private void txtPrecioProductoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoOfertaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtPrecioProductoOfertaActionPerformed

    private void txtPrecioProductoOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoOfertaKeyTyped
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
    }//GEN-LAST:event_txtPrecioProductoOfertaKeyTyped

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
    
    /*
    private void agregaOferta() throws SQLException, FileNotFoundException{
        
        CrudOferta cOferta = new CrudOferta();
        Oferta oferta = new Oferta();
                
        //guardamos la imagen que emos elegido en estas variables
        File file = new File(ruta);
        fi = new FileInputStream(file);
        
        //para obtener id de producto
        int idTienda =   cbxTiendaOferta.getItemAt(cbxTiendaOferta.getSelectedIndex()).getIDTIENDA();
        int idProducto = cbxProductoOferta.getItemAt(cbxProductoOferta.getSelectedIndex()).getIDPRODUCTO();
        int idEstado =   cbxEstadoOferta.getItemAt(cbxEstadoOferta.getSelectedIndex()).getIDESTADO();
        
        System.out.println("idTienda " + idTienda);
        System.out.println("idProducto " + idProducto);
        System.out.println("idEstado " + idEstado);
        
        oferta.setNombreOferta(txtNombreOferta.getText());
        oferta.setIdTienda(idTienda);
        oferta.setIdProducto(idProducto);
        oferta.setPrecioOferta(parseInt(txtPrecioProductoOferta.getText()));
        oferta.setDescuentoOferta(parseInt(txtDesceuntoOferta.getText()));
        oferta.setStockProductoOferta(parseInt(txtStockOferta.getText()));
        oferta.setMinProducto(parseInt(txtMinProductoOferta.getText()));
        oferta.setMaxProducto(parseInt(txtMaxProductoOferta.getText()));
        
        oferta.setImagenOferta(fi);
        
        oferta.setIdEstado(idEstado);
        
        cOferta.agregarOferta(oferta);
    }
    */
    
    private void btnGuardarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOfertaActionPerformed

        varCero = 0;
        maximoDscto = 100;
        
        System.out.println("txtMaxProductoOferta" + parseInt(txtMaxProductoOferta.getText()));
        System.out.println("txtMinProductoOferta" + parseInt(txtMinProductoOferta.getText()));
        System.out.println("txtDesceuntoOferta" + parseInt(txtDesceuntoOferta.getText()));
        System.out.println("ruta imagen" + ruta );
        
        if(   txtNombreOferta.getText().trim().length() != 0 
           && txtPrecioProductoOferta.getText().trim().length() != 0
           && txtDesceuntoOferta.getText().trim().length() != 0 
           && txtStockOferta.getText().trim().length() != 0 
           && txtMinProductoOferta.getText().trim().length() != 0 
           && txtMaxProductoOferta.getText().trim().length() != 0 
           )
        {
           if (parseInt(txtStockOferta.getText()) <= stock){
                if ( parseInt(txtMaxProductoOferta.getText()) <= stock){
                    if (parseInt(txtDesceuntoOferta.getText()) <= maximoDscto){
                        if (parseInt(txtMinProductoOferta.getText()) != varCero){
                            if ( ruta != null){
                    try {

                        JavaConnectDb obj = new JavaConnectDb();
                        Connection cn = obj.ConnectBd();
                        String sql = "INSERT INTO OFERTA (IDTIENDA, IDPRODUCTO, NOMBREOFERTA, MINIMOPRODUCTO, MAXIMOPRODUCTO, "
                                   + "PRECIOOFERTA, DESCUENTOOFERTA, STOCKPRODUCTOOFERTA, IDESTADO, IMAGENOFERTA)\n" +
                                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        pst = cn.prepareStatement(sql);

                        //guardamos la imagen que emos elegido en estas variables
                        File file = new File(ruta);
                        fi = new FileInputStream(file);

                        /*para obtener id de producto*/
                        int idTienda =   cbxTiendaOferta.getItemAt(cbxTiendaOferta.getSelectedIndex()).getIDTIENDA();
                        int idProducto = cbxProductoOferta.getItemAt(cbxProductoOferta.getSelectedIndex()).getIDPRODUCTO();
                        int idEstado =   cbxEstadoOferta.getItemAt(cbxEstadoOferta.getSelectedIndex()).getIDESTADO();

                        pst.setInt(1, idTienda);
                        pst.setInt(2, idProducto);
                        pst.setString(3, txtNombreOferta.getText());
                        pst.setInt(4, parseInt(txtMinProductoOferta.getText()));
                        pst.setInt(5, parseInt(txtMaxProductoOferta.getText()));

                        pst.setInt(6, parseInt(txtPrecioProductoOferta.getText()));
                        pst.setInt(7, parseInt(txtDesceuntoOferta.getText()));
                        pst.setInt(8, parseInt(txtStockOferta.getText()));
                        pst.setInt(9, idEstado);

                        pst.setBinaryStream(10, fi);

                        cn.commit();

                        rs = (OracleResultSet) pst.executeQuery();

                           limpiarDatos();

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(createOferta.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(createOferta.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        JOptionPane.showMessageDialog(null, "Datos Actualizados..." );
                        this.setVisible(false);
                        readOferta rd = new readOferta(mod);
                        rd.setVisible(true); 
                        rd.pack();
                            try{
                                pst.close();
                            }catch(Exception ex){}
                    }
        }else {JOptionPane.showMessageDialog(rootPane, "Debe insertar una imagen");}
        }else {JOptionPane.showMessageDialog(rootPane, "No puede ingresar como minimo de productos la cantidad cero");}
        }else {JOptionPane.showMessageDialog(rootPane, "No puede realizar un descuento mayor al 100%");}
        }else {JOptionPane.showMessageDialog(rootPane, "No puede ingresar un máximo de productos mayor al stock existente");}   
        }else {JOptionPane.showMessageDialog(rootPane, "No puede ingresar un stock mayor al existente");}
        }else{JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios");}
        
    }//GEN-LAST:event_btnGuardarOfertaActionPerformed

    
    
    private void btnVolverOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverOfertaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        limpiarDatos();
        readOferta ro = new readOferta(mod);
        ro.setVisible(true);
        ro.pack();

    }//GEN-LAST:event_btnVolverOfertaActionPerformed

    private void txtMaxProductoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxProductoOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxProductoOfertaActionPerformed

    private void txtMaxProductoOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxProductoOfertaKeyTyped
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
    }//GEN-LAST:event_txtMaxProductoOfertaKeyTyped

    private void txtMinProductoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinProductoOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinProductoOfertaActionPerformed

    private void txtMinProductoOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinProductoOfertaKeyTyped
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
    }//GEN-LAST:event_txtMinProductoOfertaKeyTyped

    private void cbxTiendaOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiendaOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTiendaOfertaActionPerformed

    private void cbxProductoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoOfertaActionPerformed
        try {
            // TODO add your handling code here:
            cargarPrecioProducto() ;
            cargarPrecioProductoR();
        } catch (SQLException ex) {
            Logger.getLogger(createOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxProductoOfertaActionPerformed

    private void cbxEstadoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoOfertaActionPerformed

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
            java.util.logging.Logger.getLogger(createOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new createOferta().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(createOferta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarOferta;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnVolverOferta;
    private javax.swing.JComboBox<model.comboBox.CbxEstado> cbxEstadoOferta;
    private javax.swing.JComboBox<model.comboBox.CbxProducto> cbxProductoOferta;
    private javax.swing.JComboBox<model.comboBox.CbxTienda> cbxTiendaOferta;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JTextField txtDesceuntoOferta;
    private javax.swing.JTextField txtMaxProductoOferta;
    private javax.swing.JTextField txtMinProductoOferta;
    private javax.swing.JTextField txtNombreOferta;
    private javax.swing.JTextField txtPrecioProductoOferta;
    private javax.swing.JTextField txtStockOferta;
    // End of variables declaration//GEN-END:variables
}

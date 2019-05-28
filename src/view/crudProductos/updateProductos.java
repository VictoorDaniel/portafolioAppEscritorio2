/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudProductos;

import conectorBD.JavaConnectDb;
import controller.Renders;
import controller.producto.CrudProducto;
import controller.usuario.udUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.LoginUser;
import model.TablaImagen;
import model.Usuarios.Usuario;
import model.comboBox.CbxTienda;
import model.producto.Producto;
import oracle.jdbc.OracleResultSet;
//import sun.misc.IOUtils;

/**
 *
 * @author fernandacancinoreyes
 */
public final class updateProductos extends javax.swing.JFrame {
LoginUser mod;
    
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    /*declaracion de variables*/
    String ruta = null;//para la ruta de la imagen
    OracleResultSet rs = null;
    FileInputStream fi = null; //para la imagen..
    
    
    
    /**
     * Creates new form modifyProductos
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     */
    public updateProductos() throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, UnsupportedLookAndFeelException, IllegalAccessException, SQLException {
        initComponents();
        
        //mostrarImagen();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        
        /*dejar 'invisible' el text de id */
        txtIdProductoMod.setVisible(false);
        cbxCategoriaProductoMod.setVisible(false);
        lblCategoria.setVisible(false);
        
        
        /*Cargar cmbx*/
        cbxCategoriaProductoMod.setModel(getValuesCbxCategoria());
        cbxRubroProductoMod.setModel(getValuesCbxRubro());
       // Producto prod = getIdProducto();
        
        CbxTienda comboboxTienda = new CbxTienda();
        cbxTiendaProductoMod.removeAllItems();
        comboboxTienda.getValuesTienda(cbxTiendaProductoMod);
        
        
        //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  
    }
    
   
  public updateProductos(LoginUser mod) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, InstantiationException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, UnsupportedLookAndFeelException, IllegalAccessException, SQLException {
        initComponents();
        this.mod=mod;
        //mostrarImagen();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        
        /*dejar 'invisible' el text de id */
        txtIdProductoMod.setVisible(false);
        cbxCategoriaProductoMod.setVisible(false);
        lblCategoria.setVisible(false);
        
        
        /*Cargar cmbx*/
        cbxCategoriaProductoMod.setModel(getValuesCbxCategoria());
        cbxRubroProductoMod.setModel(getValuesCbxRubro());
       // Producto prod = getIdProducto();
        
        CbxTienda comboboxTienda = new CbxTienda();
        cbxTiendaProductoMod.removeAllItems();
        comboboxTienda.getValuesTienda(cbxTiendaProductoMod);
        
        
        //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  
    }
    
    
    private DefaultComboBoxModel getValuesCbxRubro(){
        
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = obj.ConnectBd();
            String sql = "select idrubro, nombrerubro from RUBRO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idrubro");
                registros[1] = rs.getString("nombrerubro");
               cbModel.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cbModel;
    }
    
    private DefaultComboBoxModel getValuesCbxCategoria(){
        
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = obj.ConnectBd();
            String sql = "select idcategoria, nombrecategoria from CATEGORIA";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idcategoria");
                registros[1] = rs.getString("nombrecategoria");
               cbModel.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cbModel;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxRubroProductoMod = new javax.swing.JComboBox<>();
        txtStockProductoMod = new javax.swing.JTextField();
        cbxCategoriaProductoMod = new javax.swing.JComboBox<>();
        txtPrecioProductoMod = new javax.swing.JTextField();
        txtNombreProductoMod = new javax.swing.JTextField();
        btnVolverProductoM = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        txtIdProductoMod = new javax.swing.JTextField();
        dtFechaVencimientoMod = new com.toedter.calendar.JDateChooser();
        btnImagenMod = new javax.swing.JButton();
        lblImagenMod = new javax.swing.JLabel();
        cbxTiendaProductoMod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Fecha Vencimiento");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Stock");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Rubro");

        lblCategoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCategoria.setText("Categoria");

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("Modificar Producto");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tiendas Retail Mis Ofertas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cbxRubroProductoMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtStockProductoMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        cbxCategoriaProductoMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPrecioProductoMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtNombreProductoMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNombreProductoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoModActionPerformed(evt);
            }
        });

        btnVolverProductoM.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverProductoM.setText("Volver");
        btnVolverProductoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProductoMActionPerformed(evt);
            }
        });

        btnModificarProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        txtIdProductoMod.setEditable(false);

        btnImagenMod.setText("Imagen...");
        btnImagenMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenModActionPerformed(evt);
            }
        });

        cbxTiendaProductoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiendaProductoModActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Tienda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(btnVolverProductoM, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(lblCategoria)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStockProductoMod, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(cbxCategoriaProductoMod, 0, 218, Short.MAX_VALUE)
                                    .addComponent(txtPrecioProductoMod, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtNombreProductoMod, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtIdProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnImagenMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImagenMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTiendaProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtFechaVencimientoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxRubroProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(txtIdProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecioProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cbxCategoriaProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImagenMod, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxRubroProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtStockProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImagenMod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dtFechaVencimientoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxTiendaProductoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolverProductoM, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverProductoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductoMActionPerformed
        // TODO add your handling code here:
        
       this.setVisible(false);
       readProductos rp = new readProductos(mod);
       rp.setVisible(true); 
       rp.pack();
        
    }//GEN-LAST:event_btnVolverProductoMActionPerformed

    private void limpiarDatos(){
        txtNombreProductoMod.setText("");
        txtPrecioProductoMod.setText("");
        cbxRubroProductoMod.setModel(getValuesCbxRubro());
        txtStockProductoMod.setText("");
        ((JTextField)dtFechaVencimientoMod.getDateEditor().getUiComponent()).setText("");
        lblImagenMod.setIcon(null);
    }
    
    
    
    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        try {
            // TODO add your handling code here:

            validaDatosVacios();
            readProductos rp = new readProductos(mod);
            rp.setVisible(true); 
            rp.pack();
        
            
        } catch (SQLException ex) {
            Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    public void validaDatosVacios() throws SQLException, FileNotFoundException{
        if(    txtNombreProductoMod.getText().trim().length() != 0
            && txtPrecioProductoMod.getText().trim().length() != 0
            && txtStockProductoMod.getText().trim().length() != 0
            && ((JTextField)dtFechaVencimientoMod.getDateEditor().getUiComponent()).getText().trim().length() != 0
          )//este if es para validar algunos campos vacios
        {
            modificar();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios");
        }        
        
    }
    
    //metodo para modificar 
   public void modificar() throws SQLException, FileNotFoundException {//throws SQLException{
             
           if(ruta!=null)
           {
            File file = new File(ruta);
             fi = new FileInputStream(file);
           }
             

           
        Producto prod = new Producto();
        CrudProducto controllerProd = new CrudProducto();
        
        int idRubro =  cbxRubroProductoMod.getSelectedIndex();
        idRubro = idRubro + 1;
        
        int idTienda =  cbxTiendaProductoMod.getItemAt(cbxTiendaProductoMod.getSelectedIndex()).getIDTIENDA();
        
        prod.setIdProducto(parseInt(txtIdProductoMod.getText()));
        prod.setRubroProducto(idRubro);
        prod.setNombreProducto(txtNombreProductoMod.getText());
        prod.setPrecioProducto(parseInt(txtPrecioProductoMod.getText()));
        prod.setStockProducto(parseInt(txtStockProductoMod.getText()));
        prod.setFechaExpiracion(((JTextField)dtFechaVencimientoMod.getDateEditor().getUiComponent()).getText());
        prod.setIdtienda(idTienda);
        
        System.out.println("txtIdProductoMod" + parseInt(txtIdProductoMod.getText()));
        System.out.println("idRubro" + idRubro);
        System.out.println("txtNombreProductoMod" + txtNombreProductoMod.getText());
        System.out.println("txtPrecioProductoMod" + parseInt(txtPrecioProductoMod.getText()));
        System.out.println("txtStockProductoMod" + parseInt(txtStockProductoMod.getText()));
        System.out.println("dtFechaVencimientoMod" + ((JTextField)dtFechaVencimientoMod.getDateEditor().getUiComponent()).getText());
        System.out.println("idTienda" + idTienda);
        
          if(fi==null)
        {
        controllerProd.modificarProducto(prod);
        }else
        {
            controllerProd.modificarProductoConImagen(prod,fi);
        }
        
        
   }
    
    private void btnImagenModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenModActionPerformed
        
        
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
            lblImagenMod.setIcon(new ImageIcon(foto));

        }
    }//GEN-LAST:event_btnImagenModActionPerformed

    private void txtNombreProductoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoModActionPerformed

    private void cbxTiendaProductoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiendaProductoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTiendaProductoModActionPerformed

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
            java.util.logging.Logger.getLogger(updateProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new updateProductos().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(updateProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImagenMod;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnVolverProductoM;
    public static javax.swing.JComboBox<String> cbxCategoriaProductoMod;
    public static javax.swing.JComboBox<String> cbxRubroProductoMod;
    private javax.swing.JComboBox<model.comboBox.CbxTienda> cbxTiendaProductoMod;
    public static com.toedter.calendar.JDateChooser dtFechaVencimientoMod;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    public static javax.swing.JLabel lblImagenMod;
    public static javax.swing.JTextField txtIdProductoMod;
    public static javax.swing.JTextField txtNombreProductoMod;
    public static javax.swing.JTextField txtPrecioProductoMod;
    public static javax.swing.JTextField txtStockProductoMod;
    // End of variables declaration//GEN-END:variables
}

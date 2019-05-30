/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudOferta;

import conectorBD.JavaConnectDb;
import controller.Renders;
import controller.oferta.CrudOferta;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.JFileChooser;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import model.LoginUser;
import model.Oferta.Oferta;
import model.comboBox.CbxProducto;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author fernandacancinoreyes
 */
public class updateOferta extends javax.swing.JFrame {
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
    CbxProducto combobox = new CbxProducto();
    
    private int stock ;
    private int maximoDscto;
    private int varCero;
    private int idTiendaC;
    
    /**
     * Creates new form readOferta
     */
    public updateOferta() {
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
        //cbxTiendaOfertaMod.setModel(getValuesTiendaMod());
        //cbxEstadoOfertaMod.setModel(getValuesEstadoMod());
        //cbxProductoOfertaMod.setModel(getValuesProductoMod());
        
        CbxProducto combobox = new CbxProducto();
        cbxProductoOfertaMod.removeAllItems();
        combobox.getValuesProducto(cbxProductoOfertaMod);
        
    }

    public updateOferta(LoginUser mod) {
        this.mod=mod;
        
        initComponents();
        CbxProducto combobox = new CbxProducto();
        cbxProductoOfertaMod.removeAllItems();
        combobox.getValuesProducto(cbxProductoOfertaMod);
        
    }
    
    private void cargarPrecioProducto() throws SQLException{
        Connection cn = obj.ConnectBd();
        Statement st = cn.createStatement();
        String sql = "select PRECIOPRODUCTO\n" +
                           ",STOCKPRODUCTO\n"+
                        "from PRODUCTO \n" +
                        "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
        
        pst = cn.prepareStatement(sql);
        pst.setInt(1, cbxProductoOfertaMod.getItemAt(cbxProductoOfertaMod.getSelectedIndex()).getIDPRODUCTO());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        Object datos[] = new Object[2];
        
        while (rs.next()) {     
                //System.out.println("rs.getString(1)" + rs.getString(1));
                txtPrecioProductoOfertaMod.setText(rs.getString(1));
                txtStockOfertaMod.setText(rs.getString(2));
        }
    }
    
    private int obtenerIdTienda() {
        
        idTiendaC = cbxTiendaOfertaMod.getItemAt(cbxTiendaOfertaMod.getSelectedIndex()).getIDTIENDA();  
        combobox.setIdTienda(idTiendaC);
        //combobox.getValuesProducto2(cbxProductoOferta, idTiendaC);
        return idTiendaC;
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
        pst.setInt(1, cbxProductoOfertaMod.getItemAt(cbxProductoOfertaMod.getSelectedIndex()).getIDPRODUCTO());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        Object datos[] = new Object[2];
        
        while (rs.next()) {     
                //System.out.println("rs.getString(1)" + rs.getString(1));
                txtPrecioProductoOfertaMod.setText(rs.getString(1));
                txtStockOfertaMod.setText(rs.getString(2));
                /*
                if (parseInt(txtStockOferta.getText()) > parseInt(rs.getString(2))){
                    
                }*/
                stock = parseInt(rs.getString(2));
                
        }
        //txtPrecioProductoOferta.setText(sql);
        return stock;
    }
    
    private void limpiarDatos(){
        txtNombreOfertaMod.setText("");
        txtPrecioProductoOfertaMod.setText("");
        txtDesceuntoOfertaMod.setText("");
        txtStockOfertaMod.setText("");
        lblimagen.setIcon(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardarOfertaMod = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnVolverOfertaMod = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreOfertaMod = new javax.swing.JTextField();
        cbxEstadoOfertaMod = new javax.swing.JComboBox<>();
        txtDesceuntoOfertaMod = new javax.swing.JTextField();
        txtMaxProductoOfertaMod = new javax.swing.JTextField();
        txtStockOfertaMod = new javax.swing.JTextField();
        txtMinProductoOfertaMod = new javax.swing.JTextField();
        txtPrecioProductoOfertaMod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxTiendaOfertaMod = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxProductoOfertaMod = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblimagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Oferta");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
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

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Descuento (%)");

        btnGuardarOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarOfertaMod.setText("Guardar");
        btnGuardarOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOfertaModActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Stock");

        btnVolverOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverOfertaMod.setText("Volver");
        btnVolverOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverOfertaModActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Imagen");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Estado");

        txtNombreOfertaMod.setPreferredSize(new java.awt.Dimension(10, 32));
        txtNombreOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreOfertaModActionPerformed(evt);
            }
        });

        cbxEstadoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoOfertaModActionPerformed(evt);
            }
        });

        txtDesceuntoOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDesceuntoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesceuntoOfertaModActionPerformed(evt);
            }
        });
        txtDesceuntoOfertaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesceuntoOfertaModKeyTyped(evt);
            }
        });

        txtMaxProductoOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMaxProductoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxProductoOfertaModActionPerformed(evt);
            }
        });
        txtMaxProductoOfertaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxProductoOfertaModKeyTyped(evt);
            }
        });

        txtStockOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtStockOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockOfertaModActionPerformed(evt);
            }
        });
        txtStockOfertaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockOfertaModKeyTyped(evt);
            }
        });

        txtMinProductoOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMinProductoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinProductoOfertaModActionPerformed(evt);
            }
        });
        txtMinProductoOfertaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinProductoOfertaModKeyTyped(evt);
            }
        });

        txtPrecioProductoOfertaMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecioProductoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoOfertaModActionPerformed(evt);
            }
        });
        txtPrecioProductoOfertaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoOfertaModKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Minimo Producto");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre Oferta");

        cbxTiendaOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiendaOfertaModActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Maximo Producto");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Tienda");

        cbxProductoOfertaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoOfertaModActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Producto");

        btnImagen.setText("Imagen...");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Precio Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(btnGuardarOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVolverOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110))
                        .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(cbxEstadoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(163, 163, 163))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDesceuntoOfertaMod)
                                            .addComponent(txtNombreOfertaMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtStockOfertaMod)
                                            .addComponent(txtPrecioProductoOfertaMod)
                                            .addComponent(btnImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtMaxProductoOfertaMod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                                    .addComponent(txtMinProductoOfertaMod, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxTiendaOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxProductoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGap(31, 31, 31)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(cbxTiendaOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbxProductoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPrecioProductoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDesceuntoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtStockOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMinProductoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaxProductoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(btnImagen))
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxEstadoOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGuardarOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVolverOfertaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)))
                    .addGap(63, 63, 63)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOfertaModActionPerformed

        varCero = 0;
        maximoDscto = 100;

        System.out.println("txtMaxProductoOferta" + parseInt(txtMaxProductoOfertaMod.getText()));
        System.out.println("txtMinProductoOferta" + parseInt(txtMinProductoOfertaMod.getText()));
        System.out.println("txtDesceuntoOferta" + parseInt(txtDesceuntoOfertaMod.getText()));
        System.out.println("ruta imagen" + ruta );

        if(   txtNombreOfertaMod.getText().trim().length() != 0
            && txtPrecioProductoOfertaMod.getText().trim().length() != 0
            && txtDesceuntoOfertaMod.getText().trim().length() != 0
            && txtStockOfertaMod.getText().trim().length() != 0
            && txtMinProductoOfertaMod.getText().trim().length() != 0
            && txtMaxProductoOfertaMod.getText().trim().length() != 0
        )
        {
            if (parseInt(txtStockOfertaMod.getText()) <= stock){
                if ( parseInt(txtMaxProductoOfertaMod.getText()) <= stock){
                    if (parseInt(txtDesceuntoOfertaMod.getText()) <= maximoDscto){
                        if (parseInt(txtMinProductoOfertaMod.getText()) != varCero){
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
                                    int idTienda =   cbxTiendaOfertaMod.getItemAt(cbxTiendaOfertaMod.getSelectedIndex()).getIDTIENDA();
                                    int idProducto = cbxProductoOfertaMod.getItemAt(cbxProductoOfertaMod.getSelectedIndex()).getIDPRODUCTO();
                                    int idEstado =   cbxEstadoOfertaMod.getItemAt(cbxEstadoOfertaMod.getSelectedIndex()).getIDESTADO();

                                    pst.setInt(1, idTienda);
                                    pst.setInt(2, idProducto);
                                    pst.setString(3, txtNombreOfertaMod.getText());
                                    pst.setInt(4, parseInt(txtMinProductoOfertaMod.getText()));
                                    pst.setInt(5, parseInt(txtMaxProductoOfertaMod.getText()));

                                    pst.setInt(6, parseInt(txtPrecioProductoOfertaMod.getText()));
                                    pst.setInt(7, parseInt(txtDesceuntoOfertaMod.getText()));
                                    pst.setInt(8, parseInt(txtStockOfertaMod.getText()));
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
                                    readOferta rd = new readOferta();
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

    }//GEN-LAST:event_btnGuardarOfertaModActionPerformed

    private void btnVolverOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverOfertaModActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        limpiarDatos();
        readOferta ro = new readOferta();
        ro.setVisible(true);
        ro.pack();
    }//GEN-LAST:event_btnVolverOfertaModActionPerformed

    private void txtNombreOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreOfertaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreOfertaModActionPerformed

    private void cbxEstadoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoOfertaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoOfertaModActionPerformed

    private void txtDesceuntoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesceuntoOfertaModActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDesceuntoOfertaModActionPerformed

    private void txtDesceuntoOfertaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesceuntoOfertaModKeyTyped
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
    }//GEN-LAST:event_txtDesceuntoOfertaModKeyTyped

    private void txtMaxProductoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxProductoOfertaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxProductoOfertaModActionPerformed

    private void txtMaxProductoOfertaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxProductoOfertaModKeyTyped
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
    }//GEN-LAST:event_txtMaxProductoOfertaModKeyTyped

    private void txtStockOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockOfertaModActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtStockOfertaModActionPerformed

    private void txtStockOfertaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockOfertaModKeyTyped
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
    }//GEN-LAST:event_txtStockOfertaModKeyTyped

    private void txtMinProductoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinProductoOfertaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinProductoOfertaModActionPerformed

    private void txtMinProductoOfertaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinProductoOfertaModKeyTyped
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
    }//GEN-LAST:event_txtMinProductoOfertaModKeyTyped

    private void txtPrecioProductoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoOfertaModActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPrecioProductoOfertaModActionPerformed

    private void txtPrecioProductoOfertaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoOfertaModKeyTyped
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
    }//GEN-LAST:event_txtPrecioProductoOfertaModKeyTyped

    private void cbxTiendaOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiendaOfertaModActionPerformed
        obtenerIdTienda();
        System.out.println("idTiendaC" + idTiendaC);

        //prueba();
        cbxProductoOfertaMod.removeAllItems();

        combobox.productos(cbxProductoOfertaMod,  idTiendaC);
        //combobox.getValuesProducto2(cbxProductoOferta, idTiendaC);
        //combobox.getValuesProducto(cbxProductoOferta);
    }//GEN-LAST:event_cbxTiendaOfertaModActionPerformed

    private void cbxProductoOfertaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoOfertaModActionPerformed

        try {
            // TODO add your handling code here:
            cargarPrecioProducto() ;
            cargarPrecioProductoR();
        } catch (SQLException ex) {
            Logger.getLogger(createOferta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbxProductoOfertaModActionPerformed

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
            java.util.logging.Logger.getLogger(updateOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateOferta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarOfertaMod;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnVolverOfertaMod;
    public static javax.swing.JComboBox<model.comboBox.CbxEstado> cbxEstadoOfertaMod;
    public static javax.swing.JComboBox<model.comboBox.CbxProducto> cbxProductoOfertaMod;
    public static javax.swing.JComboBox<model.comboBox.CbxTienda> cbxTiendaOfertaMod;
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
    private javax.swing.JLabel lblimagen;
    public static javax.swing.JTextField txtDesceuntoOfertaMod;
    public static javax.swing.JTextField txtMaxProductoOfertaMod;
    public static javax.swing.JTextField txtMinProductoOfertaMod;
    public static javax.swing.JTextField txtNombreOfertaMod;
    public static javax.swing.JTextField txtPrecioProductoOfertaMod;
    public static javax.swing.JTextField txtStockOfertaMod;
    // End of variables declaration//GEN-END:variables
}

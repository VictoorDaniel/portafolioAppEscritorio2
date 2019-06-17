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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.LoginUser;
import model.Oferta.Oferta;
import model.TablaImagen;
import view.menuPrincipal;

/**
 *
 * @author fernandacancinoreyes
 */
public class readOferta extends javax.swing.JFrame {
LoginUser mod;
    /**
     * Creates new form updateOferta
     */
    public readOferta() {
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
                
        propiedadesTabla();
        mostrarOfertas();
        
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(true);
        
        // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Agregar el btan a la tabla
        tblOferta.setDefaultRenderer(Object.class, new Renders());
        
                
    }
    
    
    /*variables*/
    CrudOferta cOferta = new CrudOferta();
    Oferta ofert = new Oferta();
    updateOferta uOferta = new updateOferta();
    JButton btn_modificar = new JButton("Modificar");
    JButton btn_eliminar = new JButton("Eliminar");
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
     /*utilizamos la clase de jtable*/
    DefaultTableModel tablaOferta = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }  
    }; //le agregamos el isCellEditable y lo retornamos falso para que nos epueda editar 

    public readOferta(LoginUser mod) {
        this.mod=mod;
        
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
                
        propiedadesTabla();
        mostrarOfertas();
        
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(true);
        
        // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Agregar el btan a la tabla
        tblOferta.setDefaultRenderer(Object.class, new Renders());
        
    }

    
    
    
    public void propiedadesTabla() {
        
        //para la imagen
        tblOferta.setDefaultRenderer(Object.class, new TablaImagen());
        
        tablaOferta.addColumn("Id Oferta");
        tablaOferta.addColumn("Nombre Oferta");
        tablaOferta.addColumn("Tienda");
        tablaOferta.addColumn("Prodcuto");
        tablaOferta.addColumn("Precio Producto");
        tablaOferta.addColumn("Descuento (%)");
        tablaOferta.addColumn("Stock"); 
        tablaOferta.addColumn("Minimo de Producto"); 
        tablaOferta.addColumn("Maximo de Producto"); 
        tablaOferta.addColumn("Estado"); 
        tablaOferta.addColumn("Imagen"); 
        
        
        tablaOferta.addColumn("Modificar"); //Modificar
        tablaOferta.addColumn("Eliminar"); //Eliminar
        
        //JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        //JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
        
        
        
        //modificar el ancho
        tblOferta.setRowHeight(60);
        
    }
    
     /*se crea funcion para mostrar  los productos en la tabla*/
    public  void mostrarOfertas(){
        
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "SELECT\n" +
                    "     OFERTA.IDOFERTA,\n" +
                    "     OFERTA.NOMBREOFERTA,\n" +
                    //"     OFERTA.IDTIENDA,\n" +
                    "     TIENDA.NOMBRETIENDA,\n" +
                    "     PRODUCTO.NOMBREPRODUCTO,\n" +
                    //"     OFERTA.IDPRODUCTO,\n" +
                    "     PRODUCTO.PRECIOPRODUCTO, " +
                    "     OFERTA.DESCUENTOOFERTA,\n" +
                    "     OFERTA.STOCKPRODUCTOOFERTA,\n" +
                    "     OFERTA.MINIMOPRODUCTO,\n" +
                    "     OFERTA.MAXIMOPRODUCTO,\n" +
                    //"     OFERTA.PRECIOOFERTA,\n" +
                    "     ESTADO.GLOSAESTADO,\n" +
                    //"     OFERTA.IDESTADO,\n" +
                    "     OFERTA.IMAGENOFERTA \n" +
                    //"     OFERTA.VISITAS,\n" +
                    //"     TO_CHAR(OFERTA.FECHAVISITA) ,\n" +
                    //"     TIENDA.IDTIENDA,\n" +
                    //"     PRODUCTO.IDPRODUCTO,\n" +
                    
                    //"     PRODUCTO.NOMBREPRODUCTO,\n" +
                    //"     ESTADO.IDESTADO,\n" +
                    //"     TIENDA.NOMBRETIENDA\n" +
                    "FROM\n" +
                    "     PRODUCTO INNER JOIN OFERTA ON PRODUCTO.IDPRODUCTO = OFERTA.IDPRODUCTO\n" +
                    "              INNER JOIN ESTADO ON OFERTA.IDESTADO = ESTADO.IDESTADO\n" +
                    "              INNER JOIN TIENDA ON OFERTA.IDTIENDA = TIENDA.IDTIENDA\n" +
                    "WHERE OFERTA.IDESTADO = 0";
            ResultSet rs = st.executeQuery(sql);
            
            Object datos[] = new Object[40];/* A la cantidad objetos le puse 40
            por que soy rudo antes era String pero lo cambie a
            Object para que admitiera la imagen*/
            
            while (rs.next()) {     
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                //datos[10] = rs.getString(11);
                
                Blob blob = rs.getBlob(11);//llamamos la imagen

                if(blob != null)//mandamos un mensaje de no imagen si es null
                {
                   try{
                        byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                        try{
                        img = ImageIO.read(new ByteArrayInputStream(data));
                        }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        }
                        //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
                        Image foto = img;

                        //Le damos dimension a nuestro label que tendra la imagen
                        foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                        ImageIcon icono = new ImageIcon(foto);
                        datos[10] = new JLabel(icono);
                    }catch(Exception ex){
                        datos[10] = "No Image";
                    }
                }
                else{
                   datos[10] = "No Image";
                }
                
                datos[11] = btn_modificar;
                datos[12] = btn_eliminar;
                
                tablaOferta.addRow(datos);   
                
            }
            tblOferta.setModel(tablaOferta);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenuPrincipalProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDescuentos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscartodo = new javax.swing.JTextField();
        btnAgregarOferta = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOferta = new javax.swing.JTable();

        btnMenuPrincipalProd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipalProd.setText("Menu Principal");
        btnMenuPrincipalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalProdActionPerformed(evt);
            }
        });

        tblDescuentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblDescuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDescuentos.setColumnSelectionAllowed(true);
        tblDescuentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDescuentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDescuentos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oferta.png"))); // NOI18N
        jLabel1.setText("  Mantenedor de Ofertas");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Buscar ");

        buscartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscartodoActionPerformed(evt);
            }
        });
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

        btnAgregarOferta.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnAgregarOferta.setText("Agregar Oferta");
        btnAgregarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarOfertaActionPerformed(evt);
            }
        });

        btnMenuPrincipal.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        tblOferta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblOferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblOferta.setColumnSelectionAllowed(true);
        tblOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOfertaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOferta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        // TODO add your handling code here:

        String[] titulos = {"Id Oferta", "Nombre Oferta", "Tienda", "Prodcuto", "Precio Producto", "Descuento (%)","Stock",
                            "Minimo de Producto", "Maximo de Producto", "Estado","Imagen","Modificar","Eliminar"};

        String sql = "SELECT   OFERTA.IDOFERTA \n" +
                        "     ,OFERTA.NOMBREOFERTA\n" +
                        "     ,TIENDA.NOMBRETIENDA\n" +
                        "     ,PRODUCTO.NOMBREPRODUCTO \n" +
                        "     ,PRODUCTO.PRECIOPRODUCTO \n" +
                        "     ,OFERTA.DESCUENTOOFERTA \n" +
                        "     ,OFERTA.STOCKPRODUCTOOFERTA \n" +
                        "     ,OFERTA.MINIMOPRODUCTO \n" +
                        "     ,OFERTA.MAXIMOPRODUCTO \n" +
                        "     ,ESTADO.GLOSAESTADO \n" +
                        "     ,OFERTA.IMAGENOFERTA \n" +
                        "FROM PRODUCTO INNER JOIN OFERTA ON PRODUCTO.IDPRODUCTO = OFERTA.IDPRODUCTO\n" +
                        "              INNER JOIN ESTADO ON OFERTA.IDESTADO = ESTADO.IDESTADO\n" +
                        "              INNER JOIN TIENDA ON OFERTA.IDTIENDA = TIENDA.IDTIENDA\n" +
                        "              \n" +
                        "WHERE OFERTA.IDOFERTA              LIKE ' % " + buscartodo.getText() + " % '"
                        + "OR OFERTA.NOMBREOFERTA          LIKE'%" + buscartodo.getText() + "%' "
                        + "OR TIENDA.NOMBRETIENDA          LIKE'%" + buscartodo.getText() + "%' "
                        + "OR PRODUCTO.NOMBREPRODUCTO      LIKE'%" + buscartodo.getText() + "%' "
                        + "OR PRODUCTO.PRECIOPRODUCTO      LIKE'%" + buscartodo.getText() + "%' "
                        + "OR OFERTA.DESCUENTOOFERTA       LIKE'%" + buscartodo.getText() + "%' "
                        + "OR OFERTA.STOCKPRODUCTOOFERTA   LIKE'%" + buscartodo.getText() + "%' "
                        + "OR OFERTA.MINIMOPRODUCTO        LIKE'%" + buscartodo.getText() + "%' "
                        + "OR OFERTA.MAXIMOPRODUCTO        LIKE'%" + buscartodo.getText() + "%' "
                        + "OR ESTADO.GLOSAESTADO           LIKE'%" + buscartodo.getText() + "%' "
                        + "AND OFERTA.IDESTADO = 0";
                
 
        tablaOferta = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
    };

        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            Object datos[] = new Object[40];
            while (rs.next()) {     
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                //datos[10] = rs.getString(11);
                
                Blob blob = rs.getBlob(11);//llamamos la imagen

                if(blob != null)//mandamos un mensaje de no imagen si es null
                {
                   try{
                        byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                        try{
                        img = ImageIO.read(new ByteArrayInputStream(data));
                        }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        }
                        //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
                        Image foto = img;

                        //Le damos dimension a nuestro label que tendra la imagen
                        foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                        ImageIcon icono = new ImageIcon(foto);
                        datos[10] = new JLabel(icono);
                    }catch(Exception ex){
                        datos[10] = "No Image";
                    }
                }
                else{
                   datos[10] = "No Image";
                }
                
                datos[11] = btn_modificar;
                datos[12] = btn_eliminar;
                
                tablaOferta.addRow(datos);   
                
            }
            tblOferta.setModel(tablaOferta);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_buscartodoKeyPressed
    


    private void buscartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoActionPerformed

    private void btnAgregarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarOfertaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        createOferta co = null;
        try {
            co = new createOferta(mod);
        } catch (SQLException ex) {
            Logger.getLogger(readOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_btnAgregarOfertaActionPerformed

    private void btnMenuPrincipalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalProdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMenuPrincipalProdActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        // TODO add your handling code here:

        menuPrincipal mp = null;
        mp = new menuPrincipal(mod);
        this.setVisible(false);
        mp.setVisible(true);
        mp.pack();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void tblDescuentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDescuentosMouseClicked

    }//GEN-LAST:event_tblDescuentosMouseClicked

    private void tblOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOfertaMouseClicked
        // TODO add your handling code here:
        int clic_tabla = 0;

        //si clickea la tabla
        clic_tabla = this.tblOferta.rowAtPoint(evt.getPoint());
        
        
        //enviamos los datos de la tabla a las variables
        String idOferta         = ""+tblOferta.getValueAt(clic_tabla, 0);
        String nombreOferta     = ""+tblOferta.getValueAt(clic_tabla, 1);
        String nombreTienda     = ""+tblOferta.getValueAt(clic_tabla, 2);
        String nombreProducto   = ""+tblOferta.getValueAt(clic_tabla, 3);
        String precioProducto   = ""+tblOferta.getValueAt(clic_tabla, 4);
        String dscto            = ""+tblOferta.getValueAt(clic_tabla, 5);
        String stock            = ""+tblOferta.getValueAt(clic_tabla, 6);
        String minProd          = ""+tblOferta.getValueAt(clic_tabla, 8);
        String maxProd          = ""+tblOferta.getValueAt(clic_tabla, 9);
        String estado           = ""+tblOferta.getValueAt(clic_tabla, 10);
        
        
        int column =  tblOferta.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblOferta.getRowHeight();

        if(row < tblOferta.getRowCount() && row >= 0
            && column < tblOferta.getColumnCount() && column >= 0){

            Object value = tblOferta.getValueAt(row, column);

            //ahora si apreta el botoncito de la tabla...
            if(value instanceof JButton){

                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){
                    
                    System.out.println("Click en el boton modificar");
                    System.out.println("idOferta" + idOferta);
                    System.out.println("nombreOferta" + nombreOferta);
                    System.out.println("nombreTienda" + nombreTienda);
                    System.out.println("nombreProducto" + nombreProducto);
                    
                    this.setVisible(false);
                    updateOferta ud = new updateOferta(mod);
                    ud.setVisible(true);

                    updateOferta.txtIdOfertaMod.setText(idOferta);
                    updateOferta.txtNombreOfertaMod.setText(nombreOferta);
                    //updateOferta.cbxTiendaOfertaMod.setSelectedItem(nombreTienda);
                    //updateOferta.cbxProductoOfertaMod.setSelectedItem(nombreProducto);
                    updateOferta.txtPrecioProductoOfertaMod.setText(precioProducto);
                    updateOferta.txtDesceuntoOfertaMod.setText(dscto);
                    updateOferta.txtStockOfertaMod.setText(stock);
                    updateOferta.txtMinProductoOfertaMod.setText(minProd);
                    updateOferta.txtMaxProductoOfertaMod.setText(maxProd);
                    //updateOferta.cbxEstadoOfertaMod.setSelectedItem(estado);
                    
                    /***************************/

                    ud.pack();

                }
                if(boton.getName().equals("e")){

                    System.out.println("Click en el boton eliminar");

                    int s = JOptionPane.showConfirmDialog(null, "Eliminar Descuento","Si/no",JOptionPane.YES_NO_OPTION);

                    if(s == 0){
                        
                        try {
                        //EVENTOS ELIMINAR
                        eliminar (idOferta);
                    } catch (SQLException ex){
                        Logger.getLogger(readOferta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblOfertaMouseClicked

    
    public void eliminar(String id) throws SQLException{
        
        ofert.setIdOferta(Integer.parseInt(id));
        
        cOferta.eliminarOferta(ofert);
        //re Actualizamos la pagina para que se vizualice el campo eliminado
         this.setVisible(false);
        readOferta rp = new readOferta(mod);
        rp.setVisible(true);
        rp.pack();
    }
    
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
            java.util.logging.Logger.getLogger(readOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(readOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(readOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(readOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readOferta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarOferta;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnMenuPrincipalProd;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDescuentos;
    private javax.swing.JTable tblOferta;
    // End of variables declaration//GEN-END:variables
}

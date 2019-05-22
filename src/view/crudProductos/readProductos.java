
package view.crudProductos;

import conectorBD.JavaConnectDb;
import controller.AgregarBtnATbl;
import controller.Renders;
import controller.producto.CrudProducto;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.TablaImagen;
import model.producto.Producto;
import static view.crudProductos.updateProductos.txtIdProductoMod;
import view.menuPrincipal;

/**
 *
 * @author fernandacancinoreyes
 */
public class readProductos extends javax.swing.JFrame {
 
     
   
    
    public readProductos() {
        initComponents();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        propiedadesTabla();
        
        /*cargar los datos de la tabla producto en la tabla */
       // mostrarProductos(); 
        mostrarProductos(); 
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(true);
        
        // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Agregar el btan a la tabla
        tblProductos.setDefaultRenderer(Object.class, new Renders());
        //tblProductos.setDefaultRenderer(Object.class, new RenderImages());
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tblProductos.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
        
        
    }
   
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    /*utilizamos la clase de jtable*/
    DefaultTableModel tablaProductos = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }  
    }; //le agregamos el isCellEditable y lo retornamos falso para que nos epueda editar 
    
    public void propiedadesTabla() {
        
        //modificar el ancho
        tblProductos.setRowHeight(60);
        
    }
    
    /*se crea funcion para mostrar  los productos en la tabla*/
    public  void mostrarProductos(){
        
     
        //para la imagen
        tblProductos.setDefaultRenderer(Object.class, new TablaImagen());
        
        tablaProductos.addColumn("Id");
        tablaProductos.addColumn("Nombre");
        tablaProductos.addColumn("Rubro");
        tablaProductos.addColumn("Categoria");
        tablaProductos.addColumn("Precio");
        tablaProductos.addColumn("Stock");
        tablaProductos.addColumn("Vencimiento");
        tablaProductos.addColumn("Imagen");
        tablaProductos.addColumn(""); //Modificar
        tablaProductos.addColumn(""); //Eliminar
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
      
        
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "select   IDPRODUCTO\n" +
                        "        ,NOMBREPRODUCTO\n" +
                        "        ,rubro.nombrerubro\n" +
                        "        ,CATEGORIA.nombrecategoria\n" +
                        "        ,PRECIOPRODUCTO\n" +
                        "        ,STOCKPRODUCTO\n" +
                        "        ,to_char(FECHAEXPIRACION) \n" +
                        "        ,IMAGENPRODUCTO\n" +
                        "from PRODUCTO, RUBRO, CATEGORIA\n" +
                        "where PRODUCTO.RUBROPRODUCTO = rubro.idrubro\n" +
                        "  and rubro.idcategoria = categoria.idcategoria";
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
                
                  
                Blob blob = rs.getBlob(8);//llamamos la imagen

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
                        datos[7] = new JLabel(icono);
                    }catch(Exception ex){
                        datos[7] = "No Imagen";
                    }
                }
                else{
                   datos[7] = "No Imagen";
                }
                
                datos[8] = btn_modificar;
                datos[9] = btn_eliminar;
                
                tablaProductos.addRow(datos);   
                
            }
            tblProductos.setModel(tablaProductos);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnMenuPrincipalProd = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        buscartodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

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
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mantenedor de Productos");

        tblProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.setColumnSelectionAllowed(true);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        tblProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnMenuPrincipalProd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipalProd.setText("Menu Principal");
        btnMenuPrincipalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalProdActionPerformed(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Buscar ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(642, Short.MAX_VALUE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(473, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalProdActionPerformed
        // TODO add your handling code here:
       
        menuPrincipal mp = null;
        try {
            mp = new menuPrincipal();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        mp.setVisible(true);
        mp.pack();
    }//GEN-LAST:event_btnMenuPrincipalProdActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        createProductos cp = null;
        try {
            cp = new createProductos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        cp.setVisible(true);
        cp.pack();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    /*metodo para buscar los productos en la tabla */
    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        // TODO add your handling code here:
        
        String[] titulos = {"id", "Nombre", "Rubro", "Categoria", "Precio", "Stock","Vencimiento",/*"Imagen"*/};
        
           
            String sql = "select   IDPRODUCTO\n" +
                        "        ,NOMBREPRODUCTO\n" +
                        "        ,rubro.nombrerubro\n" +
                        "        ,CATEGORIA.nombrecategoria\n" +
                        "        ,PRECIOPRODUCTO\n" +
                        //"        ,IMAGENPRODUCTO\n" +
                        "        ,STOCKPRODUCTO\n" +
                        "        ,to_char(FECHAEXPIRACION) \n" +
                        "from PRODUCTO INNER JOIN RUBRO\n" +
                        "ON PRODUCTO.RUBROPRODUCTO = rubro.idrubro\n" +
                        "  INNER JOIN CATEGORIA ON rubro.idcategoria = categoria.idcategoria "+
                    " WHERE IDPRODUCTO LIKE '%" + buscartodo.getText() + "%' "
                    + "OR NOMBREPRODUCTO  LIKE'%" + buscartodo.getText() + "%'"
                    + "OR RUBRO.NOMBRERUBRO LIKE '%" + buscartodo.getText() + "%'"
                    + "OR CATEGORIA.NOMBRECATEGORIA LIKE '%" + buscartodo.getText() + "%'"
                    + "OR FECHAEXPIRACION  LIKE'%" + buscartodo.getText() + "%'";
           tablaProductos = new DefaultTableModel(null, titulos);
           
            try {
                Connection cn = obj.ConnectBd();
                 Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
              
                Object datos[] = new Object[10];
            while (rs.next()) {     
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
             
                tablaProductos.addRow(datos);   
                
            }
            tblProductos.setModel(tablaProductos);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void mostrarDatosModificar(String id){
        
    }
    
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        // TODO add your handling code here:
        int clic_tabla = 0;
        
        
        //si clickea la tabla
        clic_tabla = this.tblProductos.rowAtPoint(evt.getPoint());
      //enviamos los datos de la tabla a las variables
        String id           = ""+tblProductos.getValueAt(clic_tabla, 0);
        String nombre       = ""+tblProductos.getValueAt(clic_tabla, 1);
        String rubro        = ""+tblProductos.getValueAt(clic_tabla, 2);
        String categoria    = ""+tblProductos.getValueAt(clic_tabla, 3);
        String precio       = ""+tblProductos.getValueAt(clic_tabla, 4);
        String stock        = ""+tblProductos.getValueAt(clic_tabla, 5);
        String vencimiento  = ""+tblProductos.getValueAt(clic_tabla, 6);
        //ImageIcon imagen       = (ImageIcon) tblProductos.getValueAt(clic_tabla,7);
        
        Producto prod = new Producto();/*
        prod.idProducto = Integer.parseInt(id);
        prod.nombreProducto = nombre;
        prod.rubroProducto = Integer.parseInt(rubro);
        prod.categoriaProducto = Integer.parseInt(categoria);
        prod.precioProducto = Integer.parseInt(precio);
        prod.stockProducto = Integer.parseInt(stock);
        prod.fechaExpiracion = vencimiento;
        */
       //enviamos las variables a las cajas de textos para que aparescan cargadas
       /*
        txtCodigo.setText(String.valueOf(codigo));
        txtNombre.setText(nombre);
        txtApellidoP.setText(apellido);
        txtApellidoM.setText(apellidoM);
        txtEmail.setText(email);
        txtRut.setText(rut); 
        
        
          
        
        if(!"Activo".equals(Estado)){
            rbInactivo.setSelected(true);
        }
        else{
            rbActivo.setSelected(true);
        }
        if("si".equals(AceptaOferta)){
            rbAceptarS.setSelected(true);
        }
        else{
           rbAceptarN.setSelected(true); 
        }
        
        ((JTextField)JDFechaN.getDateEditor().getUiComponent()).setText(fechaN);
        
        cbxRol.setSelectedItem(rol);
        
        txtPassword.setText(pass);
         
       */
       
        int column = tblProductos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblProductos.getRowHeight();
        
        if(row < tblProductos.getRowCount() && row >= 0 
           && column < tblProductos.getColumnCount() && column >= 0){
        
            Object value = tblProductos.getValueAt(row, column);
            
            //ahora si apreta el botoncito de la tabla...
            if(value instanceof JButton){
                
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){
                    System.out.println("Click en el boton modificar");
                    //EVENTOS MODIFICAR
                    //Enviar de un Jpanel a otro 
                    //jPanel.setSelectedIndex(1);
                    
                    this.setVisible(false);
                    updateProductos up = null;
                    try {
                        up = new updateProductos();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    up.setVisible(true); 
                    
                    /*ENVIAR DATOS A LA VENTANA*/
                    
                    updateProductos.txtIdProductoMod.setText(id);
                    updateProductos.txtNombreProductoMod.setText(nombre);
                    updateProductos.txtPrecioProductoMod.setText(precio);
                    updateProductos.txtStockProductoMod.setText(stock);
                    updateProductos.cbxCategoriaProductoMod.setSelectedItem(categoria);
                    updateProductos.cbxRubroProductoMod.setSelectedItem(rubro);
                    ((JTextField)updateProductos.dtFechaVencimientoMod.getDateEditor().getUiComponent()).setText(vencimiento);
                    //updateProductos.lblImagenMod.setIcon((Icon) new JLabel(imagen));
                    
                    
                    //updateProductos.lblImagenMod.setIcon(tblProductos.getValueAt(clic_tabla,7));
                   // updateProductos.lblImagenMod.setIcon(new ImageIcon(tblProductos.getValueAt(clic_tabla,7)));
                    
                    /***************************/
                    
                    up.pack();
                    
                    
                    
                }
                if(boton.getName().equals("e")){
                    
                    System.out.println("Click en el boton eliminar");
                    
                    int s = JOptionPane.showConfirmDialog(null, "Eliminar Usuario","Si/no",JOptionPane.YES_NO_OPTION);
                    
                    if(s == 0){
                    }
                    
                    try {
                        //EVENTOS ELIMINAR
                        eliminar (id);
                    } catch (SQLException ex){
                        Logger.getLogger(readProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
        
        
    }//GEN-LAST:event_tblProductosMouseClicked

    public void eliminar(String id) throws SQLException{
         CrudProducto cProducto= new CrudProducto();
          //Usuario usu = new Usuario();
          Producto prod = new Producto();
          
          prod.setIdProducto(Integer.parseInt(id));
        
        cProducto.eliminarProducto(prod);
        //re Actualizamos la pagina para que se vizualice el campo eliminado
         this.setVisible(false);
        readProductos rp = new readProductos();
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
            java.util.logging.Logger.getLogger(readProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(readProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(readProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(readProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnMenuPrincipalProd;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}


package view.crudDescuento;

import view.crudProductos.*;
import conectorBD.JavaConnectDb;
import controller.AgregarBtnATbl;
import controller.Renders;
import controller.descuento.CrudDescuento;
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
import model.LoginUser;
import model.TablaImagen;
import model.descuento.Descuento;
import model.producto.Producto;
import view.crudProductos.createProductos;
import view.crudProductos.updateProductos;
import static view.crudProductos.updateProductos.txtIdProductoMod;
import view.menuPrincipal;

/**
 *
 * @author fernandacancinoreyes
 */
public class readDescuento extends javax.swing.JFrame {
 
    LoginUser mod;
    JButton btn_modificar = new JButton("Modificar");
    JButton btn_eliminar = new JButton("Eliminar");
    
    public readDescuento() {
        initComponents();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        propiedadesTabla();
        
        /*cargar los datos de la tabla producto en la tabla */
        mostrarDescuentos(); 
        
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(true);
        
        // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Agregar el btan a la tabla
        tblDescuentos.setDefaultRenderer(Object.class, new Renders());
        //tblProductos.setDefaultRenderer(Object.class, new RenderImages());
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tblDescuentos.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
        
        
    }
   
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    /*utilizamos la clase de jtable*/
    DefaultTableModel tablaDescuentos = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }  
    }; //le agregamos el isCellEditable y lo retornamos falso para que nos epueda editar 

    public readDescuento(LoginUser mod) {

       this.mod=mod;
       
        initComponents();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        propiedadesTabla();
        
        /*cargar los datos de la tabla producto en la tabla */
        mostrarDescuentos(); 
        
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(true);
        
        // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Agregar el btan a la tabla
        tblDescuentos.setDefaultRenderer(Object.class, new Renders());
        //tblProductos.setDefaultRenderer(Object.class, new RenderImages());
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tblDescuentos.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
        
        
    }
    
    public void propiedadesTabla() {
        
        //para la imagen
        tblDescuentos.setDefaultRenderer(Object.class, new TablaImagen());
        
        tablaDescuentos.addColumn("Id");
        tablaDescuentos.addColumn("Minimo de Puntos");
        tablaDescuentos.addColumn("Maximo de Puntos");
        tablaDescuentos.addColumn("Porcentaje Descuento");
        tablaDescuentos.addColumn("Tope Descuento");
        tablaDescuentos.addColumn(""); //Modificar
        tablaDescuentos.addColumn(""); //Eliminar
        
        //JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        //JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
        
        //modificar el ancho
        tblDescuentos.setRowHeight(60);
        
    }
    
    
    
    /*se crea funcion para mostrar  los productos en la tabla*/
    public  void mostrarDescuentos(){
        
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "SELECT IDDESCUENTO\n" +
                         "      ,minpuntos\n" +
                         "      ,maxpuntos\n" +
                         "      ,porcentajedescuento\n" +
                         "      ,topedescuento\n" +
                         "FROM DESCUENTO";
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
                
                datos[5] = btn_modificar;
                datos[6] = btn_eliminar;
                
                tablaDescuentos.addRow(datos);   
                
            }
            tblDescuentos.setModel(tablaDescuentos);
            
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
        tblDescuentos = new javax.swing.JTable();
        btnMenuPrincipalProd = new javax.swing.JButton();
        btnAgregarDescuento = new javax.swing.JButton();
        buscartodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descuento.png"))); // NOI18N
        jLabel1.setText("  Mantenedor de Descuentos");

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
        tblDescuentos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnMenuPrincipalProd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipalProd.setText("Menu Principal");
        btnMenuPrincipalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalProdActionPerformed(evt);
            }
        });

        btnAgregarDescuento.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnAgregarDescuento.setText("Agregar Descuento");
        btnAgregarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDescuentoActionPerformed(evt);
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
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(518, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                    .addComponent(jLabel3)
                    .addComponent(btnAgregarDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalProdActionPerformed
        // TODO add your handling code here:
        menuPrincipal mp = null;
        
            mp = new menuPrincipal(mod);
       
        this.setVisible(false);
        mp.setVisible(true);
        mp.pack();
    }//GEN-LAST:event_btnMenuPrincipalProdActionPerformed

    private void btnAgregarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDescuentoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        createDescuentos cd = new createDescuentos(mod);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_btnAgregarDescuentoActionPerformed

    /*metodo para buscar los productos en la tabla */
    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        // TODO add your handling code here:
        
        String[] titulos = {"id", "MinPuntos", "MaxPuntos", "Porcentaje", "Tope","Modificar","Eliminar"};
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
           
            String sql = "SELECT IDDESCUENTO\n" +
                         "      ,minpuntos\n" +
                         "      ,maxpuntos\n" +
                         "      ,porcentajedescuento\n" +
                         "      ,topedescuento\n" +
                         "FROM DESCUENTO\n" +
                        "where  IDDESCUENTO LIKE '%" + buscartodo.getText() + "%' "
                    + "OR MINPUNTOS  LIKE'%" + buscartodo.getText() + "%'"
                    + "OR MAXPUNTOS LIKE '%" + buscartodo.getText() + "%'"
                    + "OR PORCENTAJEDESCUENTO LIKE '%" + buscartodo.getText() + "%'"
                    + "OR TOPEDESCUENTO  LIKE'%" + buscartodo.getText() + "%'";
          
            tablaDescuentos = new DefaultTableModel(null, titulos)
           {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
         };
           
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
                
                datos[5] = btn_modificar;
                datos[6] = btn_eliminar;
                
                tablaDescuentos.addRow(datos);   
                
            }
            tblDescuentos.setModel(tablaDescuentos);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void mostrarDatosModificar(String id){
        
    }
    
    private void tblDescuentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDescuentosMouseClicked
        // TODO add your handling code here:
        int clic_tabla = 0;
        
        
        //si clickea la tabla
        clic_tabla = this.tblDescuentos.rowAtPoint(evt.getPoint());
      //enviamos los datos de la tabla a las variables
        String id               = ""+tblDescuentos.getValueAt(clic_tabla, 0);
        String minPuntos        = ""+tblDescuentos.getValueAt(clic_tabla, 1);
        String maxPuntos        = ""+tblDescuentos.getValueAt(clic_tabla, 2);
        String procentajeDscto  = ""+tblDescuentos.getValueAt(clic_tabla, 3);
        String topeDscto        = ""+tblDescuentos.getValueAt(clic_tabla, 4);
        
        Descuento dscto = new Descuento();
       
        int column = tblDescuentos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblDescuentos.getRowHeight();
        
        if(row < tblDescuentos.getRowCount() && row >= 0 
           && column < tblDescuentos.getColumnCount() && column >= 0){
        
            Object value = tblDescuentos.getValueAt(row, column);
            
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
                    updateDescuentos ud = new updateDescuentos();
                    ud.setVisible(true); 
                    
                    /*ENVIAR DATOS A LA VENTANA*/
                    
                    updateDescuentos.txtIdDescuentoMod.setText(id);
                    updateDescuentos.txtMinPuntosDescuentoMod.setText(minPuntos);
                    updateDescuentos.txtMaxPuntosDescuentoMod.setText(maxPuntos);
                    updateDescuentos.txtPorcentajeDescuentoMod.setText(procentajeDscto);
                    updateDescuentos.txtTopeDescuentoMod.setText(topeDscto);
                    
                    /***************************/
                    
                    ud.pack();
                    
                }
                if(boton.getName().equals("e")){
                    
                    System.out.println("Click en el boton eliminar");
                    
                    int s = JOptionPane.showConfirmDialog(null, "Eliminar Descuento","Si/no",JOptionPane.YES_NO_OPTION);
                    
                    if(s == 0){
                        try {
                        //EVENTOS ELIMINAR
                        eliminar (id);
                    } catch (SQLException ex){
                        Logger.getLogger(readDescuento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    
                    
                }
            }

        }
        
        
    }//GEN-LAST:event_tblDescuentosMouseClicked

    public void eliminar(String id) throws SQLException{
         CrudDescuento cDescuento= new CrudDescuento();
          //Usuario usu = new Usuario();
          Descuento dscto = new Descuento();
          
          dscto.setIdDescuento(Integer.parseInt(id));
        
        cDescuento.eliminarDescuento(dscto);
        //re Actualizamos la pagina para que se vizualice el campo eliminado
         this.setVisible(false);
        readDescuento rp = new readDescuento(mod);
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
            java.util.logging.Logger.getLogger(readDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(readDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(readDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(readDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readDescuento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDescuento;
    private javax.swing.JButton btnMenuPrincipalProd;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblDescuentos;
    // End of variables declaration//GEN-END:variables
}

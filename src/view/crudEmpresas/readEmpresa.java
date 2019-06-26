/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudEmpresas;

import conectorBD.JavaConnectDb;
import controller.AgregarBtnATbl;
import controller.Empresa.udEmpresa;
import controller.usuario.udUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.Comuna.Comuna;
import model.Empresas.Empresa;
import model.LoginUser;
import model.Usuarios.Usuario;
import oracle.jdbc.OracleResultSet;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.crudUsuarios.readUsuario;
import view.menuPrincipal;

/**
 *
 * @author muzaka
 */
public class readEmpresa extends javax.swing.JFrame {

    LoginUser mod;
    /**
     * Creates new form readEmpresa
     */
    
      /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    /*utilizamos la clase de jtable*/
    DefaultTableModel tabla = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }}; //le agregamos el isCellEditable y lo retornamos falso para que nos epueda editar 
    int clic_tabla = 0;
    
    
    OracleResultSet rs = null;
    public readEmpresa() {
        initComponents();
        //tamaño del JFrame
        setSize(1000,700);
          /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        /*cargar los datos de la tabla */
        mostrarEnTabla(); 
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(false);
         // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregar el btan a la tabla
         tbl.setDefaultRenderer(Object.class, new AgregarBtnATbl());
         
          Usuario usuarios= new Usuario();
        cmbxUsuarios.removeAllItems();
        usuarios.getValuesUsuario(cmbxUsuarios);
        
        Comuna comunas=new Comuna();
        
        cmbxComuna.removeAllItems();
        comunas.getValuesComuna(cmbxComuna);
        //Esta sentencia viene de la libreria swing
        //sirve para que los campos se autocompleten el combx
        AutoCompleteDecorator.decorate(cmbxUsuarios);
        AutoCompleteDecorator.decorate(cmbxComuna);
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tbl.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
         //modificar el ancho
       tbl.setRowHeight(50);
    }

    public readEmpresa(LoginUser mod) {
      this.mod=mod;
      
        initComponents();
        //tamaño del JFrame
        setSize(1000,700);
          /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        /*cargar los datos de la tabla */
        mostrarEnTabla(); 
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(false);
         // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregar el btan a la tabla
         tbl.setDefaultRenderer(Object.class, new AgregarBtnATbl());
         
          Usuario usuarios= new Usuario();
        cmbxUsuarios.removeAllItems();
        usuarios.getValuesUsuario(cmbxUsuarios);
        
        Comuna comunas=new Comuna();
        
        cmbxComuna.removeAllItems();
        comunas.getValuesComuna(cmbxComuna);
        //Esta sentencia viene de la libreria swing
        //sirve para que los campos se autocompleten el combx
        AutoCompleteDecorator.decorate(cmbxUsuarios);
        AutoCompleteDecorator.decorate(cmbxComuna);
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tbl.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
         //modificar el ancho
       tbl.setRowHeight(50);

    }
   public  void mostrarEnTabla(){
        
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("usuario Asociado");
        tabla.addColumn("Apellido Paterno");
        tabla.addColumn("Apellido Materno");
        tabla.addColumn("Fecha de Registro");
        tabla.addColumn("Comuna");
        tabla.addColumn("Calle Dirección");
        tabla.addColumn("Numero Dirección");
        tabla.addColumn("Observación Dirección");
        tabla.addColumn("Modificar");
        tabla.addColumn("Eliminar");
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
      
        
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "select   IDEMPRESA\n" +
                        "        ,NOMBREEMPRESA\n" +
                        "        ,USUARIO.NOMBREUSUARIO\n" +
                        "        ,USUARIO.APELLIDOPATERNO\n" +
                        "        ,USUARIO.APELLIDOMATERNO\n" +
                        "        ,to_char(FECHAINSCRIPCION,'DD-mon-YYYY') \n" +
                       "        ,COMUNA.NOMBRECOMUNA\n" +
                       "        ,CALLEDIRECCION \n" +
                       "        ,NUMERODIRECCION \n" +
                       "        ,OBSERVACIONDIRECCION \n" +
                          "from EMPRESA,USUARIO,COMUNA \n" +
                        "where EMPRESA.IDUSUARIO = USUARIO.IDUSUARIO\n" +
                        "  and EMPRESA.IDCOMUNA = COMUNA.IDCOMUNA";
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
                 datos[10] = btn_modificar;
                datos[11] = btn_eliminar;
                
                  
                
                tabla.addRow(datos);   
                
            }
            tbl.setModel(tabla);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
     public void modificar() throws SQLException {
       udEmpresa udem= new udEmpresa();
        Empresa empre = new Empresa();
        
        empre.setNombreEmpresa(txtNombreEmpresa.getText());
        empre.setIdUsuario(cmbxUsuarios.getItemAt(cmbxUsuarios.getSelectedIndex()).getIdUsuario());
        empre.setIDComuna(cmbxComuna.getItemAt(cmbxComuna.getSelectedIndex()).getIDCOMUNA());
        empre.setCalleDireccion(txtCalleDireccion.getText());
        empre.setNumeroDireccion(txtNumero.getText());
        empre.setObservacionDireccion(txtObservacion.getText());
         empre.setIdEmpresa(Integer.parseInt(txtCodigo.getText()));
        
                        udem.Modificar_Empresa(empre);
    
    }
    

    public void eliminar(String id) throws SQLException{
        udEmpresa udem= new udEmpresa();
        Empresa empre = new Empresa();
          
          empre.setIdEmpresa(Integer.parseInt(id));
        
        udem.Eliminar_Empresa(empre);
        //re Actualizamos la pagina para que se vizualice el campo eliminado
         this.setVisible(false);
        readEmpresa rp = new readEmpresa(mod);
        rp.setVisible(true);
        rp.pack();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        buscartodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        btnGuardarProducto = new javax.swing.JButton();
        btnVolverProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbxUsuarios = new javax.swing.JComboBox<>();
        txtCalleDireccion = new javax.swing.JTextField();
        cmbxComuna = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnMenuPrincipalProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar Empresas");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empresa.png"))); // NOI18N
        jLabel1.setText(" Mostrar Empresa");

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

        jLabel3.setText("Buscar ");

        tbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "t10", "t11", "t12"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(971, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 348, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(446, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(120, Short.MAX_VALUE)))
        );

        jPanel.addTab("Mostrar", jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 32000));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Comuna");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Numero Dirección");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Calle Dirección");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane2.setViewportView(txtObservacion);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Observación Dirección");

        txtNombreEmpresa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

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

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Modificar Empresa");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tiendas Retail Mis Ofertas");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Nombre de Empresa");

        cmbxUsuarios.setEditable(true);
        cmbxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxUsuariosActionPerformed(evt);
            }
        });

        txtCalleDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleDireccionActionPerformed(evt);
            }
        });
        txtCalleDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleDireccionKeyTyped(evt);
            }
        });

        cmbxComuna.setEditable(true);
        cmbxComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxComunaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Cliente Asociado");

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel16.setText("Codigo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCalleDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbxComuna, javax.swing.GroupLayout.Alignment.LEADING, 0, 244, Short.MAX_VALUE)
                                            .addComponent(cmbxUsuarios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbxComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalleDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel.addTab("Actualizar", jPanel2);

        btnMenuPrincipalProd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipalProd.setText("Menu Principal");
        btnMenuPrincipalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173)
                                .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoActionPerformed

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        // TODO add your handling code here:

        String[] titulos = {"id", "Nombre", "Usuario", "Apellido Paterno", "Apellido Materno",
            "Fecha de Registro","Comuna","Calle Dirección","Numero Dirección",
            "Observación Dirección","Modificar","Eliminar"};
 
        String sql = "select   IDEMPRESA\n" +
                        "        ,NOMBREEMPRESA\n" +
                        "        ,USUARIO.NOMBREUSUARIO\n" +
                        "        ,USUARIO.APELLIDOPATERNO\n" +
                        "        ,USUARIO.APELLIDOMATERNO\n" +
                        "        ,to_char(FECHAINSCRIPCION,'DD-mon-YYYY') \n" +
                       "        ,COMUNA.NOMBRECOMUNA\n" +
                       "        ,CALLEDIRECCION \n" +
                       "        ,NUMERODIRECCION \n" +
                       "        ,OBSERVACIONDIRECCION \n" +
                          "from EMPRESA INNER JOIN USUARIO\n" +
        "ON  EMPRESA.IDUSUARIO = USUARIO.IDUSUARIO\n" +
           "  INNER JOIN  COMUNA ON EMPRESA.IDCOMUNA = COMUNA.IDCOMUNA "+
        "  where IDEMPRESA LIKE '%" + buscartodo.getText() + "%' "
        +" OR NOMBREEMPRESA LIKE '%" + buscartodo.getText() + "%' "
        + "OR USUARIO.NOMBREUSUARIO  LIKE'%" + buscartodo.getText() + "%'"
        + "OR COMUNA.NOMBRECOMUNA LIKE '%" + buscartodo.getText() + "%'"
        + "OR CALLEDIRECCION LIKE '%" + buscartodo.getText() + "%'"
        + "OR NUMERODIRECCION LIKE '%" + buscartodo.getText() + "%'"
        + "OR OBSERVACIONDIRECCION LIKE '%" + buscartodo.getText() + "%'"
        + "OR FECHAREGISTRO  LIKE'%" + buscartodo.getText() + "%'"; 
        
        tabla = new DefaultTableModel(null, titulos){
            public boolean isCellEditable(int row, int column){
                return false;
            }};

            JButton btn_modificar = new JButton("Modificar");
            btn_modificar.setName("m");
            JButton btn_eliminar = new JButton("Eliminar");
            btn_eliminar.setName("e");

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
                    datos[10] = btn_modificar;
                    datos[11] = btn_eliminar;

                    tabla.addRow(datos);

                }
                tbl.setModel(tabla);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        createEmpresas cp = new createEmpresas(mod);
        cp.setVisible(true);
        cp.pack();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        //si clickea la tabla
        clic_tabla = this.tbl.rowAtPoint(evt.getPoint());
        //enviamos los datos de la tabla a las variables
        String codigo = ""+tbl.getValueAt(clic_tabla, 0);
        String nombre = ""+tbl.getValueAt(clic_tabla, 1);
        String cliente = ""+tbl.getValueAt(clic_tabla, 2);
        String comuna = ""+tbl.getValueAt(clic_tabla, 6);
        String calle = ""+tbl.getValueAt(clic_tabla, 7);
        String numero= ""+tbl.getValueAt(clic_tabla, 8);
        String observacion = ""+tbl.getValueAt(clic_tabla, 9);


        //enviamos las variables a las cajas de textos para que aparescan cargadas
        txtCodigo.setText(String.valueOf(codigo));
        txtNombreEmpresa.setText(nombre);
        txtCalleDireccion.setText(calle);
        txtNumero.setText(numero);
        txtObservacion.setText(observacion);
        cmbxUsuarios.setSelectedItem(cliente);
        cmbxComuna.setSelectedItem(comuna);
        

        

       

        int column = tbl.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tbl.getRowHeight();

        if(row < tbl.getRowCount() && row >= 0
            && column < tbl.getColumnCount() && column >= 0){
            Object value = tbl.getValueAt(row, column);
            //ahora si apreta el botoncito de la tabla...
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){
                    System.out.println("Click en el boton modificar");
                    //EVENTOS MODIFICAR
                    //Enviar de un Jpanel a otro
                    jPanel.setSelectedIndex(1);
                }
                if(boton.getName().equals("e")){

                    System.out.println("Click en el boton eliminar");

                    int s = JOptionPane.showConfirmDialog(null, "Eliminar Empresa","Si/no",JOptionPane.YES_NO_OPTION);
                    if(s == 0){
                        
                     try {
                        eliminar (codigo);
                    } catch (SQLException ex) {
                        Logger.getLogger(readEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                   
                   
                }
            }

        }
    }//GEN-LAST:event_tblMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCalleDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleDireccionKeyTyped
        char validar=evt.getKeyChar();
        if(Character.isDigit(validar))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleDireccionKeyTyped

    private void txtCalleDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleDireccionActionPerformed

    private void cmbxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxUsuariosActionPerformed

    private void btnVolverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readEmpresa rp = new readEmpresa(mod);
        rp.setVisible(true);
        rp.pack();
    }//GEN-LAST:event_btnVolverProductoActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
if(txtCodigo.getText().trim().length() == 0)
 {JOptionPane.showMessageDialog(null, "seleccione un objeto para modificar", "Error", JOptionPane.ERROR_MESSAGE);}else{
        if(txtNombreEmpresa.getText().trim().length() != 0 && txtCalleDireccion.getText().trim().length() != 0
            && txtObservacion.getText().trim().length() != 0 && txtNumero.getText().trim().length() != 0
        )//este if es para validar algunos campos vacios
        {

            
            try {
                modificar();
            } catch (SQLException ex) {
                Logger.getLogger(readEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
                this.setVisible(false);
                readEmpresa rp = new readEmpresa(mod);
              rp.setVisible(true);
              rp.pack();
               
            

        }
        else{
            JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios");
        }
}
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        // TODO add your handling code here:

        //validar que la persona solo ingrese numeros
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Numeros");
        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void btnMenuPrincipalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalProdActionPerformed
        // TODO add your handling code here: this.setVisible(false);
        this.setVisible(false);
        menuPrincipal mp = null;
        
            mp = new menuPrincipal(mod);
       
        mp.setVisible(true);
        mp.pack();
    }//GEN-LAST:event_btnMenuPrincipalProdActionPerformed

    private void cmbxComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxComunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxComunaActionPerformed

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
            java.util.logging.Logger.getLogger(readEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(readEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(readEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(readEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnMenuPrincipalProd;
    private javax.swing.JButton btnVolverProducto;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JComboBox<Comuna> cmbxComuna;
    private javax.swing.JComboBox<Usuario> cmbxUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtCalleDireccion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudUsuarios;

import conectorBD.JavaConnectDb;
import controller.AgregarBtnATbl;
import controller.Utilidades;
import controller.usuario.udUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.LoginUser;
import model.TablaImagen;
import model.Usuarios.Usuario;
import oracle.jdbc.OracleResultSet;
import view.menuPrincipal;

/**
 *
 * @author muzaka
 */
public  class readUsuario extends javax.swing.JFrame {
 LoginUser mod;
    /**
     * Creates new form readUsuario
     */
    public readUsuario() {
        initComponents();
        //tamaño del JFrame
        setSize(1110,700);
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        /*cargar los datos de la tabla */
        mostrarEnTabla(); 
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(false);
         // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregar el btan a la tabla
         tblUsuarios.setDefaultRenderer(Object.class, new AgregarBtnATbl());
         
         /*para limpiar el cbx de rubro*/
        cbxRol.removeAllItems();
           /*Cargar cmbx*/
        cbxRol.setModel(getValuesRol());
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tblUsuarios.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
         //modificar el ancho
       tblUsuarios.setRowHeight(50);
       
    }
    
    public readUsuario(LoginUser mod)
    {
     initComponents();
     
     this.mod=mod;
        //tamaño del JFrame
        setSize(1110,700);
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        /*cargar los datos de la tabla */
        mostrarEnTabla(); 
        /*con esto el tamaño de la pantalla no se puede modificar*/
        this.setResizable(false);
         // Indicamos que la aplicación finaliza al cerrar la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregar el btan a la tabla
         tblUsuarios.setDefaultRenderer(Object.class, new AgregarBtnATbl());
         
         /*para limpiar el cbx de rubro*/
        cbxRol.removeAllItems();
           /*Cargar cmbx*/
        cbxRol.setModel(getValuesRol());
        
        //modificar el tamaño de las columna en la tablas (lo haremos para la imagen)
        //modificar el ancho
        tblUsuarios.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
         //modificar el ancho
       tblUsuarios.setRowHeight(50);
    }
     /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    /*utilizamos la clase de jtable*/
    DefaultTableModel tabla = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }}; //le agregamos el isCellEditable y lo retornamos falso para que nos epueda editar 
    int clic_tabla = 0;
    
    
    OracleResultSet rs = null;
  //metodo para modificar 
   public void modificar() throws SQLException{
       udUsuario ud= new udUsuario();
        Usuario usu = new Usuario();
        
        String aceptaOferta=null;
        if(rbAceptarN.isSelected())
        {
            aceptaOferta = "no";
        }
        else
        {
            aceptaOferta = "si";
        }
     
        int Estado=0;
        if(rbActivo.isSelected())
        {
            Estado=0;
        }
        else
        {
            Estado=1;
        }
          int idrol =  cbxRol.getSelectedIndex();
                        idrol = idrol + 1;
                        usu.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
                        usu.setIdRol(idrol);
                        usu.setNombreUsuario( txtNombre.getText());
                        usu.setApellidoPaterno(txtApellidoP.getText());
                        usu.setApellidoMaterno(txtApellidoM.getText());
                        usu.setEmailUsuario(txtEmail.getText());
                        usu.setRutUsuario(txtRut.getText());
                        usu.setFechaNacimiento(((JTextField)JDFechaN.getDateEditor().getUiComponent()).getText());
                        usu.setAceptaOfertasEmail(aceptaOferta);
                        usu.setIdEstado(Estado);
                        usu.setPassword(Utilidades.Encriptar(txtPassword.getText()));
                        ud.Modificar_Usuario(usu);
        
     
        
 
    }
    

    public void eliminar(String id) throws SQLException{
         udUsuario ud= new udUsuario();
          Usuario usu = new Usuario();
          
          usu.setIdUsuario(Integer.parseInt(id));
        
        ud.Eliminar_USUARIO(usu);
        //re Actualizamos la pagina para que se vizualice el campo eliminado
         this.setVisible(false);
        readUsuario rp = new readUsuario(mod);
        rp.setVisible(true);
        rp.pack();
    }
    
    /*se crea funcion para mostrar  los productos en la tabla*/
    public  void mostrarEnTabla(){
        
        tabla.addColumn("Id");
        tabla.addColumn("Rol");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido Paterno");
        tabla.addColumn("Apellido Materno");
        tabla.addColumn("Email");
        tabla.addColumn("Rut");
        tabla.addColumn("Fecha de Nacimiento");
        tabla.addColumn("Fecha de Registro");
        tabla.addColumn("Acepta oferta");
        tabla.addColumn("Estado");
        tabla.addColumn("Password");
        tabla.addColumn("Modificar");
        tabla.addColumn("Eliminar");
        
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
      
        
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "select   IDUSUARIO\n" +
                        "        ,ROL.nombrerol\n" +
                        "        ,NOMBREUSUARIO\n" +
                        "        ,APELLIDOPATERNO\n" +
                        "        ,APELLIDOMATERNO\n" +
                        "        ,EMAILUSUARIO\n" +
                        "        ,RUTUSUARIO\n" +
                        "        ,to_char(FECHANACIMIENTO) \n" +
                        "        ,to_char(FECHAREGISTRO) \n" +
                       "        ,ACEPTAOFERTASEMAIL\n" +
                       "        ,ESTADO.GLOSAESTADO \n" +
                       "        ,PASSWORD \n" +
                          "from USUARIO, ROL, ESTADO\n" +
                        "where USUARIO.IDROL = ROL.IDROL\n" +
                        "  and USUARIO.idEstado = ESTADO.IDESTADO";
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
                datos[10] = rs.getString(11);
                try {
                    //mostrar la contraseña desncriptada
                 datos[11] =  Utilidades.Desencriptar(rs.getString(12));
                } catch (Exception ex) {
                    Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                datos[12] = btn_modificar;
                datos[13] = btn_eliminar;
                
                  
                
                tabla.addRow(datos);   
                
            }
            tblUsuarios.setModel(tabla);
            
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

        gA = new javax.swing.ButtonGroup();
        gE = new javax.swing.ButtonGroup();
        btnAgregar = new javax.swing.JButton();
        btnMenuPrincipalProd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        buscartodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPActualizar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        JDFechaN = new com.toedter.calendar.JDateChooser();
        rbAceptarN = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbInactivo = new javax.swing.JRadioButton();
        rbAceptarS = new javax.swing.JRadioButton();
        rbActivo = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnGuardarUsuarios = new javax.swing.JButton();
        btnVolverProducto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar Usuarios");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnMenuPrincipalProd.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnMenuPrincipalProd.setText("Menu Principal");
        btnMenuPrincipalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalProdActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mantenedor de Usuarios");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

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

        tblUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel.addTab("ver", jPanel1);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Aceptar Oferta Email");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 100));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        gA.add(rbAceptarN);
        rbAceptarN.setSelected(true);
        rbAceptarN.setText("No");
        rbAceptarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAceptarNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Modificar Usuario");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tiendas Retail Mis Ofertas");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Nombre");
        jLabel6.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Apellido Paterno");
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 100));

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Apellido Materno");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Password");
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Email");
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 100));

        gE.add(rbInactivo);
        rbInactivo.setText("Inactivo");

        gA.add(rbAceptarS);
        rbAceptarS.setText("Si");
        rbAceptarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAceptarSActionPerformed(evt);
            }
        });

        gE.add(rbActivo);
        rbActivo.setSelected(true);
        rbActivo.setText("Activo");
        rbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Rol");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Estado");
        jLabel13.setMaximumSize(new java.awt.Dimension(100, 100));

        btnGuardarUsuarios.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarUsuarios.setText("Guardar");
        btnGuardarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuariosActionPerformed(evt);
            }
        });

        btnVolverProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverProducto.setText("Volver");
        btnVolverProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProductoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("Rut");
        jLabel14.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setText("Fecha Nacimiento");
        jLabel15.setMaximumSize(new java.awt.Dimension(100, 100));

        txtCodigo.setEditable(false);

        jLabel16.setText("Codigo");

        javax.swing.GroupLayout jPActualizarLayout = new javax.swing.GroupLayout(jPActualizar);
        jPActualizar.setLayout(jPActualizarLayout);
        jPActualizarLayout.setHorizontalGroup(
            jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarLayout.createSequentialGroup()
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarLayout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPActualizarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rbAceptarN)
                        .addGap(32, 32, 32)
                        .addComponent(rbAceptarS)))
                .addGap(38, 38, 38)
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPActualizarLayout.createSequentialGroup()
                            .addComponent(rbInactivo)
                            .addGap(18, 18, 18)
                            .addComponent(rbActivo))
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxRol, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGuardarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(127, 127, 127))
        );
        jPActualizarLayout.setVerticalGroup(
            jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarLayout.createSequentialGroup()
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPassword))
                        .addGap(29, 29, 29)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbInactivo)
                            .addComponent(rbActivo)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 89, Short.MAX_VALUE)))
                .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbAceptarN)
                            .addComponent(rbAceptarS)))
                    .addGroup(jPActualizarLayout.createSequentialGroup()
                        .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        rbInactivo.getAccessibleContext().setAccessibleDescription("");

        jPanel.addTab("Actualizar", jPActualizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(865, 865, 865))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuPrincipalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        // TODO add your handling code here:

        String[] titulos = {"id", "Rol", "Nombre", "Apellido Paterno", "Apellido Materno", 
                 "Email","Rut","Fecha Nacimiento","Fecha de Registro","Acepta Oferta","Estado"
        ,"Password","Modificar","Eliminar"};

       String sql = "select   IDUSUARIO\n" +
                        "        ,ROL.nombrerol\n" +
                        "        ,NOMBREUSUARIO\n" +
                        "        ,APELLIDOPATERNO\n" +
                        "        ,APELLIDOMATERNO\n" +
                        "        ,EMAILUSUARIO\n" +
                        "        ,RUTUSUARIO\n" +
                        "        ,to_char(FECHANACIMIENTO) \n" +
                        "        ,to_char(FECHAREGISTRO) \n" +
                       "        ,ACEPTAOFERTASEMAIL\n" +
                       "        ,ESTADO.GLOSAESTADO \n" +
                        "        ,PASSWORD \n" +
                          "from USUARIO INNER JOIN ROL\n" +
                        "ON USUARIO.IDROL = ROL.IDROL\n" +
                        "  INNER JOIN ESTADO ON USUARIO.idEstado = ESTADO.IDESTADO "+
        " where IDUSUARIO LIKE '%" + buscartodo.getText() + "%' "
        + "OR NOMBREUSUARIO  LIKE'%" + buscartodo.getText() + "%'"
        + "OR ROL.NOMBREROL LIKE '%" + buscartodo.getText() + "%'"
        + "OR APELLIDOPATERNO LIKE '%" + buscartodo.getText() + "%'"
        + "OR APELLIDOMATERNO LIKE '%" + buscartodo.getText() + "%'"
        + "OR RUTUSUARIO LIKE '%" + buscartodo.getText() + "%'"
        + "OR EMAILUSUARIO LIKE '%" + buscartodo.getText() + "%'"
        + "OR FECHANACIMIENTO LIKE '%" + buscartodo.getText() + "%'"
        + "OR ESTADO.GLOSAESTADO LIKE '%" + buscartodo.getText() + "%'"
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
                datos[10] = rs.getString(11);
                try {
                    //mostrar la contraseña desncriptada
                 datos[11] =  Utilidades.Desencriptar(rs.getString(12));
                } catch (Exception ex)
                {
                    Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                 datos[12] = btn_modificar;
                datos[13] = btn_eliminar;

                
                tabla.addRow(datos);

            }
            tblUsuarios.setModel(tabla);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        createUsuarios cp = new createUsuarios(mod);
        cp.setVisible(true);
        cp.pack();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMenuPrincipalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalProdActionPerformed
        // TODO add your handling code here:
      
              menuPrincipal mp = null;
              mp = new menuPrincipal(mod);
              this.setVisible(false);
              mp.setVisible(true);
              mp.pack();
      
          /* menuPrincipal mp = null;
           try {
               mp = new menuPrincipal();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IllegalAccessException ex) {
               Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
           } catch (InstantiationException ex) {
               Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedLookAndFeelException ex) {
               Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
              this.setVisible(false);
              mp.setVisible(true);
              mp.pack();*/
       
    }//GEN-LAST:event_btnMenuPrincipalProdActionPerformed

    private void buscartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:
        //si clickea la tabla
        clic_tabla = this.tblUsuarios.rowAtPoint(evt.getPoint());
      //enviamos los datos de la tabla a las variables
        String codigo = ""+tblUsuarios.getValueAt(clic_tabla, 0);
        String rol = ""+tblUsuarios.getValueAt(clic_tabla, 1);
        String nombre = ""+tblUsuarios.getValueAt(clic_tabla, 2);
        String apellido = ""+tblUsuarios.getValueAt(clic_tabla, 3);
        String apellidoM = ""+tblUsuarios.getValueAt(clic_tabla, 4);
        String email = ""+tblUsuarios.getValueAt(clic_tabla, 5);
        String rut = ""+tblUsuarios.getValueAt(clic_tabla, 6);
        String fechaN = ""+tblUsuarios.getValueAt(clic_tabla,7);
        String AceptaOferta = ""+tblUsuarios.getValueAt(clic_tabla,9);
        String Estado =""+tblUsuarios.getValueAt(clic_tabla, 10);
        String pass = ""+tblUsuarios.getValueAt(clic_tabla, 11);
        
       //enviamos las variables a las cajas de textos para que aparescan cargadas
        txtCodigo.setText(String.valueOf(codigo));
        txtNombre.setText(nombre);
        txtApellidoP.setText(apellido);
        txtApellidoM.setText(apellidoM);
        txtEmail.setText(email);
        txtRut.setText(rut); 
        
        
          
        
        if(!"Activo".equals(Estado))
        {
            rbInactivo.setSelected(true);
        }
        else
        {
             rbActivo.setSelected(true);
        }
        if("si".equals(AceptaOferta))
        {
         rbAceptarS.setSelected(true);
        }
        else
        {
           rbAceptarN.setSelected(true); 
        }
        
        ((JTextField)JDFechaN.getDateEditor().getUiComponent()).setText(fechaN);
        
        cbxRol.setSelectedItem(rol);
        
         txtPassword.setText(pass);
         
        
        int column = tblUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblUsuarios.getRowHeight();
        
        if(row < tblUsuarios.getRowCount() && row >= 0 
                && column < tblUsuarios.getColumnCount() && column >= 0){
            Object value = tblUsuarios.getValueAt(row, column);
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
                    
                    
                    int s = JOptionPane.showConfirmDialog(null, "Eliminar Usuario","Si/no",JOptionPane.YES_NO_OPTION);
              if(s == 0){
              try {
                        //EVENTOS ELIMINAR
                        eliminar (codigo);
                    } catch (SQLException ex) {
                        Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
        }
                    
                }
            }

        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void rbAceptarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAceptarNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAceptarNActionPerformed

    private void rbAceptarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAceptarSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAceptarSActionPerformed

    private void rbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActivoActionPerformed

    private void btnGuardarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuariosActionPerformed

       

        if(txtNombre.getText().trim().length() != 0 && txtApellidoP.getText().trim().length() != 0
            && txtApellidoM.getText().trim().length() != 0
            && ((JTextField)JDFechaN.getDateEditor().getUiComponent()).getText().trim().length() != 0
            && txtEmail.getText().trim().length() != 0&& txtRut.getText().trim().length() != 0
            && txtPassword.getText().trim().length() != 0
        )//este if es para validar algunos campos vacios
        {
            
            if(validarRut(txtRut.getText()))
            {
                udUsuario ud=new udUsuario();
                 //if(ud.ExisteRut(txtRut.getText())==0)
                 //   {
                    // if(ud.ExisteEmail(txtEmail.getText())==0)
                   //  {
                try {
                    modificar();
                    this.setVisible(false);
                    readUsuario rp = new readUsuario(mod);
                   rp.setVisible(true);
                   rp.pack();
                 
                } catch (SQLException ex) {
                    Logger.getLogger(readUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
               // }else
               //    {
                //         JOptionPane.showMessageDialog(null,"El Correo que intenta "
                  //               + "Ingresa ya existe");
                    // }
            /*    }
                else
                {
                
                JOptionPane.showMessageDialog(null,"El Rut que intenta Ingresar ya existe");
                
                }*/

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Rut incorrecto");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios");
        }
    }//GEN-LAST:event_btnGuardarUsuariosActionPerformed
public static boolean validarRut(String rut) {

    boolean validacion = false;
    try {
        rut =  rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

    } catch (java.lang.NumberFormatException e) {
    } catch (Exception e) {
    }
    return validacion;
}
 private DefaultComboBoxModel getValuesRol(){
        
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = obj.ConnectBd();
            String sql = "select idrol, nombrerol from ROL";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idrol");
                registros[1] = rs.getString("nombrerol");
               cbModel.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cbModel;
    }

    private void btnVolverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readUsuario rp = new readUsuario(mod);
        rp.setVisible(true);
        rp.pack();
    }//GEN-LAST:event_btnVolverProductoActionPerformed

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

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
            java.util.logging.Logger.getLogger(readUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(readUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(readUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(readUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new readUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDFechaN;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardarUsuarios;
    private javax.swing.JButton btnMenuPrincipalProd;
    private javax.swing.JButton btnVolverProducto;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JComboBox cbxRol;
    private javax.swing.ButtonGroup gA;
    private javax.swing.ButtonGroup gE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPActualizar;
    private javax.swing.JTabbedPane jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAceptarN;
    private javax.swing.JRadioButton rbAceptarS;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}

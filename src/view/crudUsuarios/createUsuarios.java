/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudUsuarios;

import conectorBD.ConnectDbProducto;
import conectorBD.JavaConnectDb;
import controller.Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.LoginUser;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author muzaka
 */
public class createUsuarios extends javax.swing.JFrame {
    LoginUser mods;
      /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    
    OracleResultSet rs = null;

    /**
     * Creates new form createUsuarios
     */
    public createUsuarios() {
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
         /*para limpiar el cbx de rubro*/
        cbxRol.removeAllItems();
        cbxRol.setModel(getValuesRol());
    }
   
    
    //creamos otro contructor el cual guardara los datos de la sesón
    public createUsuarios(LoginUser mods)
    {
    initComponents();
    
    this.mods=mods;
    
       /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
        
         /*para limpiar el cbx de rubro*/
        cbxRol.removeAllItems();
        cbxRol.setModel(getValuesRol());
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngAceptar = new javax.swing.ButtonGroup();
        btngEstado = new javax.swing.ButtonGroup();
        cbxRol = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        rbInactivo = new javax.swing.JRadioButton();
        rbActivo = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        btnGuardarUsuarios = new javax.swing.JButton();
        btnVolverProducto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        JDFechaN = new com.toedter.calendar.JDateChooser();
        rbAceptarN = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbAceptarS = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Password");
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 100));

        btngEstado.add(rbInactivo);
        rbInactivo.setText("Inactivo");

        btngEstado.add(rbActivo);
        rbActivo.setSelected(true);
        rbActivo.setText("Activo");
        rbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Estado");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 100));

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

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Rut");
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Fecha Nacimiento");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Aceptar Oferta Email");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 100));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btngAceptar.add(rbAceptarN);
        rbAceptarN.setSelected(true);
        rbAceptarN.setText("No");
        rbAceptarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAceptarNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Usuario");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Apellido Paterno");
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Apellido Materno");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Email");
        jLabel6.setMaximumSize(new java.awt.Dimension(100, 100));

        btngAceptar.add(rbAceptarS);
        rbAceptarS.setText("Si");
        rbAceptarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAceptarSActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Rol");
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Confirmar Password");
        jLabel13.setMaximumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(rbInactivo)
                                .addGap(18, 18, 18)
                                .addComponent(rbActivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtPassword2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addGap(265, 265, 265)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(JDFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(rbAceptarN)
                        .addGap(84, 84, 84)
                        .addComponent(rbAceptarS)
                        .addGap(150, 150, 150)
                        .addComponent(btnGuardarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbInactivo)
                            .addComponent(rbActivo))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVolverProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(rbAceptarN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(rbAceptarS))
                    .addComponent(btnGuardarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActivoActionPerformed
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
private void limpiarDatos(){
        txtNombre.setText("");
        txtApellidoP.setText("");
        cbxRol.setModel(getValuesRol());
        txtApellidoM.setText("");
        txtEmail.setText("");
        txtRut.setText("");
         txtPassword.setText("");
         txtPassword2.setText("");
        ((JTextField)JDFechaN.getDateEditor().getUiComponent()).setText("");
      
    }
    private void btnGuardarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuariosActionPerformed

     
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
        String pas=new String(txtPassword.getPassword());
        String conpas=new String(txtPassword2.getPassword());
        
        
        if(txtNombre.getText().trim().length() != 0 && txtApellidoP.getText().trim().length() != 0
            && txtApellidoM.getText().trim().length() != 0
            && ((JTextField)JDFechaN.getDateEditor().getUiComponent()).getText().trim().length() != 0
            && txtEmail.getText().trim().length() != 0&& txtRut.getText().trim().length() != 0
            &&pas.trim().length() != 0
        )//este if es para validar algunos campos vacios
        {
            
            if(validarRut(txtRut.getText()))
            {
                if(pas.equals(conpas))//compara las contraseñas se son iguales
                 {
                try {
                       
                    String nuevaPass=Utilidades.Encriptar(pas);
                    
                    Connection cn = obj.ConnectBd();
                    String sql = "Insert into USUARIO (IDROL,nombreusuario,apellidopaterno," +
                    "apellidomaterno,emailusuario,rutusuario,fechanacimiento," +
                    "aceptaofertasemail,IDESTADO,Password) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement pst = cn.prepareCall(sql)) {
                        /*para obtener id de producto*/

                        int idrol =  cbxRol.getSelectedIndex();
                        idrol = idrol + 1;
                        String idRolString = String.valueOf(idrol);
                        /*se envian los datos a la consulta*/
                        pst.setString(1, idRolString);
                        pst.setString(2, txtNombre.getText()) ;
                        pst.setString(3, txtApellidoP.getText());
                        pst.setString(4, txtApellidoM.getText());
                        pst.setString(5, txtEmail.getText());
                        pst.setString(6, txtRut.getText());
                        pst.setString(7,((JTextField)JDFechaN.getDateEditor().getUiComponent()).getText());
                        pst.setString(8,aceptaOferta);
                        pst.setInt(9,Estado);
                        pst.setString(10,nuevaPass);

                    
                         cn.commit(); 
                        rs = (OracleResultSet) pst.executeQuery();

                        if (rs.next()){
                            limpiarDatos();
                            JOptionPane.showMessageDialog(null, "Datos insertados");
                        }else{
                            JOptionPane.showMessageDialog(null, "Ocurrio un error, no se pudo insertar datos");
                        }
                        //pst.execute();
                    }

                } catch (Exception e) {
                    System.out.println(e.getCause());
                    JOptionPane.showMessageDialog(null,"uups no registro"+e);
                }
                }
        else
        {
             JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }

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

    private void btnVolverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductoActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
       
        readUsuario rp = new readUsuario(mods);
        this.setVisible(false);
        rp.setVisible(true);
        rp.pack();
    }//GEN-LAST:event_btnVolverProductoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void rbAceptarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAceptarNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAceptarNActionPerformed

    private void rbAceptarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAceptarSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAceptarSActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
 char validar=evt.getKeyChar();
        if(Character.isDigit(validar))
        {
        getToolkit().beep();
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped
  
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
            java.util.logging.Logger.getLogger(createUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDFechaN;
    private javax.swing.JButton btnGuardarUsuarios;
    private javax.swing.JButton btnVolverProducto;
    private javax.swing.ButtonGroup btngAceptar;
    private javax.swing.ButtonGroup btngEstado;
    private javax.swing.JComboBox cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbAceptarN;
    private javax.swing.JRadioButton rbAceptarS;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}

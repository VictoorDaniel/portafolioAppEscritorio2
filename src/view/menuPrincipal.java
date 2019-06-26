/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import conectorBD.JavaConnectDb;
import view.crudDescuento.readDescuento;
import view.Tienda.readTienda;
import view.crudEmpresas.readEmpresa;
import view.crudProductos.readProductos;
import view.crudProductos.readProductos;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import view.crudUsuarios.readUsuario;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.GenerarArchivoBItxt;
import model.LoginUser;
import model.Oferta.Oferta2BI;
import model.Usuarios.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.crudOferta.readOferta;
import view.crudRubro.readRubro;


/**
 *
 * @author fernandacancinoreyes
 */
public class menuPrincipal extends javax.swing.JFrame {
    
    LoginUser mod;//la importamos de esta manera ya que no estmaos creando
    //un nuevo objeto de lo contrario seria LoginUser mod=new LoginUser();
    //ademas los datos ya estan cargado del incio por lo que no queremos setearlos.
    /**
     * Creates new form menuPrincipal
     */
   public menuPrincipal() throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {
        initComponents();
        
        /*PARA QUE LA PANTALLA APAREZCA CENTRADA*/
        this.setLocationRelativeTo(null);
          
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
   
   public menuPrincipal(LoginUser mod)
   {
       initComponents();
       
       this.mod=mod;
       this.setLocationRelativeTo(null);
    if(!mod.getNombreUsuario().equals(""))
    {
       lblNombre1.setText(mod.getNombreUsuario()+" "
               + " "+mod.getApellidoPaterno()+" "+mod.getApellidoMaterno());
       lblRol.setText(mod.getNombreRol());
    }else{
        lblNombre1.setText("no hay nada");
        lblNombre1.setText("no hay nada");
    }
    
       
       if(mod.getIdRol()==1)
       {
         btnConsultaValoracionPorTienda.setVisible(false);
         btnReporteResumenPorTienda.setVisible(false);
       }else if(mod.getIdRol()==2)
       { //Gerente
                btnMantenedorDescuento.setVisible(false);
                btnMantenedorProducto.setVisible(false);
                btnMantenedorOferta.setVisible(false);
                btnMantenedorEmpresa.setVisible(false);
                btnMantenedorTienda.setVisible(false);
                btnMantenedoRubro.setVisible(false);
                btnConsultaValoracionPorTienda.setVisible(false);
                btnDescargaArchivosBI.setVisible(false);
                btnMantenedorUsuario1.setVisible(false);
       
       }
       else if(mod.getIdRol()==3)
       {
            //Jefe de Tienda
        btnMantenedorDescuento.setVisible(false);
                btnMantenedorProducto.setVisible(false);
                btnMantenedorEmpresa.setVisible(false);
                btnMantenedorTienda.setVisible(false);
                btnMantenedoRubro.setVisible(false);
                btnDescargaArchivosBI.setVisible(false);
                btnReporteResumenPorTienda.setVisible(false);
                btnMantenedorUsuario1.setVisible(false);
       } else if(mod.getIdRol()==4)
       {
       //Cliente
        btnMantenedorDescuento.setVisible(false);
                btnMantenedorProducto.setVisible(false);
                btnMantenedorOferta.setVisible(false);
                btnMantenedorEmpresa.setVisible(false);
                btnMantenedorTienda.setVisible(false);
                btnMantenedoRubro.setVisible(false);
                btnConsultaValoracionPorTienda.setVisible(false);
                btnDescargaArchivosBI.setVisible(false);
                btnReporteResumenPorTienda.setVisible(false);
                btnMantenedorUsuario1.setVisible(false);
       }else if(mod.getIdRol()==5)
       {
           JOptionPane.showMessageDialog(null, "A iniciado en modo Dios", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMantenedorProducto = new javax.swing.JButton();
        btnMantenedorOferta = new javax.swing.JButton();
        btnMantenedorEmpresa = new javax.swing.JButton();
        btnMantenedorTienda = new javax.swing.JButton();
        btnMantenedorDescuento = new javax.swing.JButton();
        btnMantenedoRubro = new javax.swing.JButton();
        btnConsultaValoracionPorTienda = new javax.swing.JButton();
        btnDescargaArchivosBI = new javax.swing.JButton();
        btnReporteResumenPorTienda = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnMantenedorUsuario1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        lblRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/identificacion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );

        btnMantenedorProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prod.png"))); // NOI18N
        btnMantenedorProducto.setText("  Mantenedor Producto");
        btnMantenedorProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorProductoActionPerformed(evt);
            }
        });

        btnMantenedorOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oferta.png"))); // NOI18N
        btnMantenedorOferta.setText(" Mantenedor Oferta");
        btnMantenedorOferta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorOfertaActionPerformed(evt);
            }
        });

        btnMantenedorEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empresa.png"))); // NOI18N
        btnMantenedorEmpresa.setText(" Mantenedor Empresa");
        btnMantenedorEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorEmpresaActionPerformed(evt);
            }
        });

        btnMantenedorTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tienda.png"))); // NOI18N
        btnMantenedorTienda.setText(" Mantenedor Tienda");
        btnMantenedorTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorTiendaActionPerformed(evt);
            }
        });

        btnMantenedorDescuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descuento.png"))); // NOI18N
        btnMantenedorDescuento.setText("Mantenedor Descuento");
        btnMantenedorDescuento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorDescuentoActionPerformed(evt);
            }
        });

        btnMantenedoRubro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rubro.png"))); // NOI18N
        btnMantenedoRubro.setText("             Mantenedor Rubro");
        btnMantenedoRubro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedoRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedoRubroActionPerformed(evt);
            }
        });

        btnConsultaValoracionPorTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        btnConsultaValoracionPorTienda.setText("Consulta Valoracion por Tienda");
        btnConsultaValoracionPorTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultaValoracionPorTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaValoracionPorTiendaActionPerformed(evt);
            }
        });

        btnDescargaArchivosBI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BI.png"))); // NOI18N
        btnDescargaArchivosBI.setText("       Descarga Archivos BI");
        btnDescargaArchivosBI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescargaArchivosBI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargaArchivosBIActionPerformed(evt);
            }
        });

        btnReporteResumenPorTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informe.png"))); // NOI18N
        btnReporteResumenPorTienda.setText("Reporte Resumen por Tienda");
        btnReporteResumenPorTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteResumenPorTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteResumenPorTiendaActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnMantenedorUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        btnMantenedorUsuario1.setText("Mantenedor Usuario");
        btnMantenedorUsuario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenedorUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorUsuario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMantenedorProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedorEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedorTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedorDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(btnMantenedorUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedorOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultaValoracionPorTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteResumenPorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedoRubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargaArchivosBI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMantenedorProducto)
                    .addComponent(btnMantenedoRubro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultaValoracionPorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMantenedorOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReporteResumenPorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMantenedorEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMantenedorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMantenedorDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDescargaArchivosBI, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMantenedorUsuario1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnSalir)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        //System.exit(0);
        login m = new login();
        this.setVisible(false);
        m.setVisible(true);
        m.pack();
       
    }//GEN-LAST:event_btnSalirActionPerformed
 
    
    
    private void btnMantenedoRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedoRubroActionPerformed
        // TODO add your handling code here: 
        this.setVisible(false);
        readRubro ru = null;
        try {
            ru = new readRubro(mod);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ru.setVisible(true);
        ru.pack();
    }//GEN-LAST:event_btnMantenedoRubroActionPerformed

    private void btnMantenedorOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorOfertaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readOferta ro= new  readOferta(mod);
        ro.setVisible(true);
    }//GEN-LAST:event_btnMantenedorOfertaActionPerformed

    private void btnMantenedorDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorDescuentoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readDescuento rd = new readDescuento(mod);
        rd.setVisible(true);
         rd.pack();  
    }//GEN-LAST:event_btnMantenedorDescuentoActionPerformed

    private void btnMantenedorEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorEmpresaActionPerformed
      readEmpresa re = new readEmpresa(mod);
        this.setVisible(false);
        re.setVisible(true);
        re.pack();        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantenedorEmpresaActionPerformed

    private void btnMantenedorTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorTiendaActionPerformed
        // TODO add your handling code here:
         readTienda re = new readTienda(mod);
        this.setVisible(false);
        re.setVisible(true);
        re.pack();  
    }//GEN-LAST:event_btnMantenedorTiendaActionPerformed

    private void btnDescargaArchivosBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargaArchivosBIActionPerformed
        // TODO add your handling code here:
     
                    String Ruta="src\\Reportes\\ReportesBI\\";
                      File ReporteBI=new File(Ruta);
                      
                      if(ReporteBI.exists())
                      {
                          String Ruta2=null;
         int s = JOptionPane.showConfirmDialog(null, "El Archivo se a descargado exitosamente se encuentra en :\n "+Ruta+"\n"+"¿Desea mostrar el contenido?","Si/no",JOptionPane.YES_NO_OPTION);
                    if(s == 0){
                        
               JFileChooser fileChooser = new JFileChooser("src\\Reportes\\ReportesBI\\");
                int seleccion = fileChooser.showOpenDialog(null);
                
                if (seleccion == JFileChooser.APPROVE_OPTION)
                   {
               File fichero = fileChooser.getSelectedFile();
                      Ruta2= fichero.getAbsolutePath();
                       
                    GenerarArchivoBItxt.abrirarchivo(Ruta2);
                    }    
                        
                     
                    }
        
                         
                      }
                      else
                      {
                         JOptionPane.showMessageDialog(null, "\t \t La Carpeta de ReportesBI no existe o esta vacía.\n"
                                 + " Porfavor espere hasta el día Lunes para que se cree y  genere el primer reporte.\n"
                                 + " gracias por su comprensión \n");
                         
                         
                      }
         
        
        
             
        
        
        
        
        
      
			
			
			
			
        
        
    }//GEN-LAST:event_btnDescargaArchivosBIActionPerformed

    private void btnMantenedorUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorUsuario1ActionPerformed
        // TODO add your handling code here:
        
         this.setVisible(false);
        readUsuario ru = new readUsuario(mod);
        ru.setVisible(true);
        ru.pack();
    }//GEN-LAST:event_btnMantenedorUsuario1ActionPerformed

    private void btnConsultaValoracionPorTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaValoracionPorTiendaActionPerformed
       System.out.println("id jefe : "+mod.getIdUsuario());
        try {
            
            // TODO add your handling code here:
            
            //El Informe de valoración por  Tienda se realizara segun
            //a la tienda que el usuario(jefe de Tienda)que esta en sesión  pertenesca
            
            JavaConnectDb obj = new JavaConnectDb();
            Connection cn = obj.ConnectBd();
            
            JasperReport report=null;
            String path="src\\Reportes\\ReporteValoracionesPorTienda.jasper";
            Map parametro=new HashMap();
            
            
            parametro.put("idJefeTienda",mod.getIdUsuario());
            //lo cargamos
            report=(JasperReport) JRLoader.loadObjectFromFile(path);
            //para mandarle variables al reporte 
            JasperPrint jprint=JasperFillManager.fillReport(report,parametro,cn);
           
            //para ver el reporte
            JasperViewer view=new JasperViewer(jprint,false);
            
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultaValoracionPorTiendaActionPerformed

    private void btnReporteResumenPorTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteResumenPorTiendaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            //El Informe de valoración por  Tienda se realizara segun
            //a la tienda que el usuario(jefe de Tienda)que esta en sesión  pertenesca
            
            JavaConnectDb obj = new JavaConnectDb();
            Connection cn = obj.ConnectBd();
            
            JasperReport report=null;
            String path="src\\Reportes\\ReporteNumericoPorTienda.jasper";
          //  Map parametro=new HashMap();
            
            
          //  parametro.put("idJefeTienda",mod.getIdUsuario());
            //lo cargamos
            report=(JasperReport) JRLoader.loadObjectFromFile(path);
            //para mandarle variables al reporte 
            JasperPrint jprint=JasperFillManager.fillReport(report,null,cn);
           
            //para ver el reporte
            JasperViewer view=new JasperViewer(jprint,false);
            
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteResumenPorTiendaActionPerformed

    private void btnMantenedorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorProductoActionPerformed
        /*PRODUCTOS*/
        this.setVisible(false);
        readProductos rp = new readProductos(mod);
        rp.setVisible(true);
        rp.pack();
    }//GEN-LAST:event_btnMantenedorProductoActionPerformed

    

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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new menuPrincipal().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaValoracionPorTienda;
    private javax.swing.JButton btnDescargaArchivosBI;
    private javax.swing.JButton btnMantenedoRubro;
    private javax.swing.JButton btnMantenedorDescuento;
    private javax.swing.JButton btnMantenedorEmpresa;
    private javax.swing.JButton btnMantenedorOferta;
    private javax.swing.JButton btnMantenedorProducto;
    private javax.swing.JButton btnMantenedorTienda;
    private javax.swing.JButton btnMantenedorUsuario1;
    private javax.swing.JButton btnReporteResumenPorTienda;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}

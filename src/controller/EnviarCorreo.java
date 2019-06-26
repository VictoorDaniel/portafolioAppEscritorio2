/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conectorBD.JavaConnectDb;
import groovy.sql.ResultSetMetaDataWrapper;
import java.awt.Image;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import model.Empresas.Empresa;



/**
 *
 * @author muzaka
 */
public class EnviarCorreo {
    JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
    public void EnviarCorreo(int idtienda,Image foto,String ruta,String NombreOfert,String precio,String Descuento) 
    {
            
        
          
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
        " where USUARIO.IDTIENDA="+idtienda+" AND USUARIO.ACEPTAOFERTASEMAIL='si'";
             
              String[] correos_destinos = null;
              
             try{
             PreparedStatement ps;
            ps=cn.prepareStatement(sql);
             //Statement st = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            ResultSetMetaData rd = rs.getMetaData(); // Obtenemos el metadata desde el resulset
                int filas = rd.getColumnCount();
                
                correos_destinos = new String[filas + 1];
                String[] nombre=new String[20];
                int indice = 0;

                while (rs.next()) {
                    ///correos_destinos[indice] = rs.getString("EMAILUSUARIO");
                    //indice++;
                correos_destinos[indice]=rs.getString("EMAILUSUARIO");
                nombre[0]=rs.getString(3);
                nombre[1]=rs.getString(4);
                nombre[2]=rs.getString(5);
                  
                       try {
            Properties props=new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            
            
            Session session=Session.getDefaultInstance(props);
            
            String correoRemitente="misofertasderetail@gmail.com";
            String passwordRemitente="Misofertas123";
            String asunto="Se a publicado una nueva Oferta";
            String mensaje="Hola  "+nombre[0]+" "+nombre[1]+" "+nombre[2]+" "+
                    " <br> <br> Te presentamos una nueva oferta <br><br>"+" "
                    +NombreOfert+"<br>"+" precio : $"+precio+ "<br>"+" "+Descuento;
                   // + "<img src=\"cid:foto\">";
            
            BodyPart texto=new MimeBodyPart();
            texto.setContent(mensaje,"text/html");
            
            BodyPart adjunto=new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
            adjunto.setFileName("Imagen.png");
            
            MimeMultipart mimeMulti=new MimeMultipart();
            mimeMulti.addBodyPart(texto);
            mimeMulti.addBodyPart(adjunto);
            
            
           MimeMessage message=new MimeMessage(session);
           message.setFrom(new InternetAddress(correoRemitente));
          
          // Address[] receptores=new Address[correos_destinos.length];
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse( correos_destinos[indice]));
            message.setSubject(asunto);
            message.setContent(mimeMulti);
          //  message.setText(mensaje, "ISO-8859-1", "html");
            
            
            Transport t=session.getTransport("smtp");
            t.connect(correoRemitente,passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
         } catch (AddressException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
                   System.out.println("correo enviado a : "+correos_destinos[indice]);
                   indice++;
                   ActualizarCantidadDeCorreos(idtienda);
             
                
                   
                }
          JOptionPane.showMessageDialog(null, "Correos Electronicos enviados ");

            } catch (SQLException ex) {
                Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
            }

           
          
    
    }
    
    
      public void ActualizarCantidadDeCorreos(int idTienda) {
        
        String sql = "UPDATE TIENDA SET correosenviados=correosenviados+1 where IDTIENDA= ?";
           PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            pst.setInt(1,idTienda);
          
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
             
            try{
                pst.close();
             
            }catch(Exception ex){}
        }
              
    }

    
    
    
}

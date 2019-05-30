/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Usuarios.Usuario;
import view.crudUsuarios.readUsuario;

/**
 *
 * @author muzaka
 */
public class udUsuario {
  
    
    
    
  /*Metodo Validar*/
    public int ExisteRut(String usu) {
        JavaConnectDb obj = new JavaConnectDb();
        ResultSet rs=null;
         Connection cn = obj.ConnectBd();
        String sql = "SELECT COUNT(IDUSUARIO)FROM USUARIO"
                + " WHERE RUTUSUARIO =? ";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
         
            pst.setString(1,usu);
            rs=pst.executeQuery();
         
            if(rs.next())
            {
              return  rs.getInt(1);
            }
            return 1;
          
            
             

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
            return 1;
        }
              
    }
   /*Metodo Validar*/
    public int ExisteEmail(String usu) {
        JavaConnectDb obj = new JavaConnectDb();
        ResultSet rs=null;
         Connection cn = obj.ConnectBd();
        String sql = "SELECT COUNT(IDUSUARIO)FROM USUARIO"
                + " WHERE EMAILUSUARIO =? ";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
         
            pst.setString(1, usu);
            rs=pst.executeQuery();
         
            if(rs.next())
            {
              return  rs.getInt(1);
            }
            return 1;
          
            
             

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
            return 1;
        }
              
    }
/*Metodo Modificar*/
    public void Modificar_Usuario(Usuario usu) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE USUARIO SET IDROL= ?, NombreUsuario = ?,"
                + "APELLIDOPATERNO= ?, APELLIDOMATERNO = ?,EMAILUSUARIO= ?,RUTUSUARIO= ?,"
                + "FECHANACIMIENTO= ?,ACEPTAOFERTASEMAIL= ?,IDESTADO= ?,PASSWORD = ?"
                + " WHERE IDUSUARIO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            pst.setInt(1, usu.getIdRol());
            pst.setString(2, usu.getNombreUsuario());
            pst.setString(3, usu.getApellidoPaterno());
            pst.setString(4, usu.getApellidoMaterno());
            pst.setString(5, usu.getEmailUsuario());
            pst.setString(6, usu.getRutUsuario());
            pst.setString(7, usu.getFechaNacimiento());
            pst.setString(8, usu.getAceptaOfertasEmail());
            pst.setInt(9, usu.getIdEstado());
            pst.setString(10, usu.getPassword());
             pst.setInt(11, usu.getIdUsuario());
             
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
             JOptionPane.showMessageDialog(null, "Datos Actualizados...");
                   
            try{
                pst.close();
               
                
            }catch(Exception ex){}
        }
              
    }


/*Metodo Eliminar*/
    public void Eliminar_USUARIO(Usuario usu) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            
            pst.setInt(1, usu.getIdUsuario());
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

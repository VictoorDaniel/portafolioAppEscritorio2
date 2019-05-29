/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.LoginUser;
import model.Usuarios.Usuario;

/**
 *
 * @author fernandacancinoreyes
 */
public class Login {
    
    
    public boolean login (LoginUser user) {
       
        
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
         ResultSet rs =null;
            PreparedStatement pst = null;
        
        String sql = "select IDUSUARIO\n" +
                        "        ,Rol.IDROL\n" +
                        "        ,NOMBREUSUARIO\n" +
                        "        ,APELLIDOPATERNO\n" +
                        "        ,APELLIDOMATERNO\n" +
                        "        ,EMAILUSUARIO\n" +
                        "        ,RUTUSUARIO\n" +
                       "        ,IDESTADO \n" +
                        "        ,PASSWORD \n" +
                       "        ,ROL.NOMBREROL \n" +
                          "from USUARIO INNER JOIN ROL\n" +
                        "ON USUARIO.IDROL = ROL.IDROL\n" +
                "where RUTUSUARIO=?";
         
        try{
         
          
            pst = cn.prepareStatement(sql);
             //pst.setString(2, user.getEmailUsuario());//compravamos que el usuario
           pst.setString(1, user.getRutUsuario());
            rs = pst.executeQuery();
             if(rs.next()){
                //JOptionPane.showMessageDialog(null, ""+rs.getString(9)+""+rs.getString(3));
                if(user.getPassword().equals(rs.getString(9))==true)
                {
                  user.setIdUsuario(rs.getInt(1));
                  user.setIdRol(rs.getInt(2));
                  user.setNombreUsuario(rs.getString(3));
                  user.setApellidoPaterno(rs.getString(4));
                  user.setApellidoMaterno(rs.getString(5));
                  user.setEmailUsuario(rs.getString(6));
                  user.setRutUsuario(rs.getString(7));
                  user.setIdEstado(rs.getInt(8));
                  user.setNombreRol(rs.getString(10));
                  
                   return true;
                  
                }
                else
                {
                    //JOptionPane.showMessageDialog(null, "contraseña incorreta");
                return false;
                }
               }
           return false;
      }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        
      }
      
        
        
        
        
    }
    


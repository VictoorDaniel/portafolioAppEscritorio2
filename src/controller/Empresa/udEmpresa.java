/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Empresa;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Empresas.Empresa;


/**
 *
 * @author muzaka
 */
public class udEmpresa {
    
    /*Metodo Modificar*/
    public void Modificar_Empresa(Empresa empre) {
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE EMPRESA SET  NOMBREEMPRESA = ?,"
                + "IDUSUARIO= ?,IDCOMUNA = ?,CALLEDIRECCION= ?,NUMERODIRECCION= ?,"
                + "OBSERVACIONDIRECCION= ? WHERE IDEMPRESA = ?";
           PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            pst.setString(1, empre.getNombreEmpresa());
            pst.setInt(2, empre.getIdUsuario());
            pst.setInt(3, empre.getIDComuna());
            pst.setString(4, empre.getCalleDireccion());
            pst.setString(5, empre.getNumeroDireccion());
            pst.setString(6, empre.getObservacionDireccion());
             pst.setInt(7, empre.getIdEmpresa());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
             
            try{
                pst.close();
                
                JOptionPane.showMessageDialog(null, "Datos Actualizados...");
               
                
            }catch(Exception ex){}
        }
              
    }


/*Metodo Eliminar*/
    public void Eliminar_Empresa(Empresa eli) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "DELETE FROM Empresa WHERE IDEMPRESA = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            
            pst.setInt(1, eli.getIdEmpresa());
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

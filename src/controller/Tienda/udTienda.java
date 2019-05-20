/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Tienda;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Tienda.Tienda;

/**
 *
 * @author muzaka
 */
public class udTienda {
    
    
    
  /*Metodo Modificar*/
    public void Modificar_Tienda(Tienda tie) {
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE Tienda SET  NOMBRETIENDA = ?,"
                + "IDEMPRESA= ?,IDUSUARIO= ?,IDCOMUNA = ?,CALLEDIRECCION= ?,NUMERODIRECCION= ?,"
                + "OBSERVACIONDIRECCION= ?,TELEFONO= ? WHERE IDTIENDA = ?";
           PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            pst.setString(1, tie.getNombreTienda());
             pst.setInt(2, tie.getIdEmpresa());
            pst.setInt(3, tie.getIdUsuario());
            pst.setInt(4, tie.getIDComuna());
            pst.setString(5, tie.getCalleDireccion());
            pst.setString(6, tie.getNumeroDireccion());
            pst.setString(7, tie.getObservacionDireccion());
            pst.setInt(8, tie.getNumeroTelefono());
             pst.setInt(9, tie.getIdTienda());
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
    public void Eliminar_Tienda(Tienda tie) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "DELETE FROM TIENDA WHERE IDTIENDA = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            
            pst.setInt(1, tie.getIdTienda());
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

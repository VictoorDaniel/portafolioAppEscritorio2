/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rubro;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import model.Rubro.Rubro;
import model.descuento.Descuento;
import oracle.jdbc.OracleResultSet;
import view.crudDescuento.readDescuento;
import view.crudRubro.readRubro;

/**
 *
 * @author fernandacancinoreyes
 */
public class CrudRubro {
    
    OracleResultSet rs = null;
    
    /*Metodo AGREGAR*/
    public void agregarDescuento(Rubro rub) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        String sql = "INSERT INTO RUBRO (NOMBRERUBRO, IDCATEGORIA)"
                   + "VALUES (?, ?)";
        
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            //pst.setInt(1, rub.getIdrubro());
            pst.setString(1, rub.getNombreRubro());
            pst.setInt(2, rub.getIdCategoria());
            
            cn.commit();
                
            rs = (OracleResultSet) pst.executeQuery();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            
            JOptionPane.showMessageDialog(null, "Datos Actualizados..." );
            
            
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
    }
    
    
    /*Metodo Modificar*/
    public void modificarRubro(Rubro rub) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        String sql = "UPDATE RUBRO "
                   + "SET NOMBRERUBRO= ?, "
                       + "IDCATEGORIA = ?"
                   + "WHERE IDRUBRO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, rub.getNombreRubro());
            pst.setInt(2, rub.getIdCategoria());
            pst.setInt(3, rub.getIdrubro());
            
            System.out.println("getNombreRubro" + rub.getNombreRubro());   
            System.out.println("getIdCategoria" + rub.getIdCategoria());
            System.out.println("getIdrubro" + rub.getIdrubro());
            
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
    public void eliminarRubro (Rubro rub) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
         
        String sql = "DELETE FROM RUBRO WHERE IDRUBRO = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        
        try{
            pst.setInt(1, rub.getIdrubro());
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

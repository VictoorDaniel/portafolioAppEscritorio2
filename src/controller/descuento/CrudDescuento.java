/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.descuento;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.descuento.Descuento;
import model.producto.Producto;
import oracle.jdbc.OracleResultSet;
import view.crudDescuento.readDescuento;
import view.crudProductos.readProductos;

/**
 *
 * @author fernandacancinoreyes
 */
public class CrudDescuento {
    
    OracleResultSet rs = null;
    
    /*Metodo AGREGAR*/
    public void agregarDescuento(Descuento dscto) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        String sql = "INSERT INTO DESCUENTO (MINPUNTOS, MAXPUNTOS, PORCENTAJEDESCUENTO, TOPEDESCUENTO)"
                   + "VALUES (?, ?, ?, ?)";
        
        System.out.println("MINPUNTOS: " + dscto.getMinPuntos());
        System.out.println("MAXPUNTOS: " + dscto.getMaxPuntos());
        System.out.println("PORCENTAJEDESCUENTO: " + dscto.getPorcentajeDescuento());
        System.out.println("TOPEDESCUENTO: " + dscto.getTopeDescuento());
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, dscto.getMinPuntos());
            pst.setInt(2, dscto.getMaxPuntos());
            pst.setInt(3, dscto.getPorcentajeDescuento());
            pst.setInt(4, dscto.getTopeDescuento());
            
            cn.commit();
                
            rs = (OracleResultSet) pst.executeQuery();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            
            JOptionPane.showMessageDialog(null, "Datos Actualizados..." );
            
            readDescuento rd = new readDescuento();
            rd.setVisible(true); 
            rd.pack();
        
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
              
    }
    
    /*Metodo Modificar*/
    public void modificarDescuento(Descuento dscto) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE DESCUENTO "
                   + "SET MINPUNTOS= ?, "
                       + "MAXPUNTOS = ?,"
                       + "PORCENTAJEDESCUENTO= ?, "
                       + "TOPEDESCUENTO = ?"
                   + "WHERE IDDESCUENTO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, dscto.getMinPuntos());
            pst.setInt(2, dscto.getMaxPuntos());
            pst.setInt(3, dscto.getPorcentajeDescuento());
            pst.setInt(4, dscto.getTopeDescuento());
            
            pst.setInt(5, dscto.getIdDescuento());
            
            /*
            System.out.println("nombre " + prod.getNombreProducto() + "rubro " + prod.getRubroProducto() + "precio " + prod.getPrecioProducto()
                                + "stock " + prod.getStockProducto() + "id " + prod.getIdProducto());
             */
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
            JOptionPane.showMessageDialog(null, "Datos Actualizados...");
            
            readDescuento rd = new readDescuento();
            rd.setVisible(true); 
            rd.pack();
        
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
              
    }
    
    
    /*Metodo Eliminar*/
    public void eliminarDescuento (Descuento dscto) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "DELETE FROM DESCUENTO WHERE IDDESCUENTO = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            
            pst.setInt(1, dscto.getIdDescuento());
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

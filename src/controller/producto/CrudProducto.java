/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.producto;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.producto.Producto;
import view.crudProductos.readProductos;
import view.crudProductos.updateProductos;

/**
 *
 * @author fernandacancinoreyes
 */
public class CrudProducto {
    
    
    
/*Metodo Modificar*/
    public void modificarProducto(Producto prod) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE PRODUCTO "
                   + "SET NOMBREPRODUCTO= ?, "
                       + "RUBROPRODUCTO = ?,"
                       + "PRECIOPRODUCTO= ?, "
                       + "STOCKPRODUCTO = ?,"
                       + "FECHAEXPIRACION= ?"
                      // + "IMAGENPRODUCTO= ?,"
                   + "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, prod.getNombreProducto());
            pst.setInt(2, prod.getRubroProducto());
            pst.setInt(3, prod.getPrecioProducto());
            pst.setInt(4, prod.getStockProducto());
            pst.setString(5, prod.getFechaExpiracion());
            //pst.setBinaryStream(6, fi);
            
            pst.setInt(6, prod.getIdProducto());
            
            System.out.println("nombre : " + prod.getNombreProducto() + "rubro : " + prod.getRubroProducto()
                              + "precio :" + prod.getPrecioProducto()
                               + "stock :" + prod.getStockProducto() + " id :" + prod.getIdProducto());
             
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
            JOptionPane.showMessageDialog(null, "Datos Actualizados...");
            
            readProductos rp = new readProductos();
            rp.setVisible(true); 
            rp.pack();
        
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
              
    }


/*Metodo Eliminar*/
    public void eliminarProducto (Producto prod) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "DELETE FROM PRODUCTO WHERE IDPRODUCTO = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            
            pst.setInt(1, prod.getIdProducto());
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

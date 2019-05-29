/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.oferta;

import conectorBD.JavaConnectDb;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Oferta.Oferta;
import model.Oferta.Oferta2BI;
import model.descuento.Descuento;
import oracle.jdbc.OracleResultSet;
import view.crudOferta.createOferta;
import view.crudOferta.readOferta;

/**
 *
 * @author fernandacancinoreyes
 */
public class CrudOferta {
    
    OracleResultSet rs = null;    
    
     private void volverMenu(){
        
        readOferta rd = new readOferta();
        rd.setVisible(true); 
        rd.pack();
    }
    
    /*Metodo AGREGAR*/
    public void agregarOferta(Oferta oferta) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        String sql = "INSERT INTO OFERTA (IDTIENDA, IDPRODUCTO, NOMBREOFERTA, MINIMOPRODUCTO, MAXIMOPRODUCTO, "
                   + "PRECIOOFERTA, DESCUENTOOFERTA, STOCKPRODUCTOOFERTA, IDESTADO, IMAGENOFERTA)\n" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, oferta.getIdTienda());
            pst.setInt(2, oferta.getIdProducto());
            pst.setString(3, oferta.getNombreOferta());
            pst.setInt(4, oferta.getMinProducto());
            pst.setInt(5, oferta.getMaxProducto());
            pst.setInt(6, oferta.getPrecioOferta());
            pst.setInt(7, oferta.getDescuentoOferta());
            pst.setInt(8, oferta.getStockProductoOferta());
            pst.setInt(9, oferta.getIdEstado());
            pst.setBinaryStream(10, (InputStream) oferta.getImagenOferta());
            
            System.out.println("getIdTienda" + oferta.getIdTienda());
            System.out.println("getIdProducto" + oferta.getIdProducto());
            System.out.println("getNombreOferta" + oferta.getNombreOferta());
            System.out.println("getMinProducto" + oferta.getMinProducto());
            System.out.println("getMaxProducto" + oferta.getMaxProducto());
            System.out.println("getPrecioOferta" + oferta.getPrecioOferta());
            System.out.println("getDescuentoOferta" + oferta.getDescuentoOferta());
            System.out.println("getStockProductoOferta" + oferta.getStockProductoOferta());
            System.out.println("getIdEstado" + oferta.getIdEstado());
            //System.out.println("getImagenOferta" + oferta.getImagenOferta());
            
            cn.commit();
                
            rs = (OracleResultSet) pst.executeQuery();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            
            JOptionPane.showMessageDialog(null, "Datos Actualizados..." );
            //co.limpiarDatos();
            //volverMenu();
        
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
              
    }
    
   /*Metodo Eliminar*/
    public void eliminarOferta (Oferta ofert) throws SQLException{
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE OFERTA SET IDESTADO = 1 WHERE IDOFERTA = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        try{
            pst.setInt(1, ofert.getIdOferta());
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
    
    
    /*Metodo Modificar*/
    /*
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
    */
    
    
    
    
}

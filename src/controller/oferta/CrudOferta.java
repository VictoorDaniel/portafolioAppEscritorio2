/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.oferta;

import conectorBD.JavaConnectDb;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Oferta.Oferta;
import model.Oferta.Oferta2BI;
import model.descuento.Descuento;
import model.producto.Producto;
import oracle.jdbc.OracleResultSet;
import view.crudOferta.createOferta;
import view.crudOferta.readOferta;
import static view.crudOferta.updateOferta.lblImagenMod;

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
     
      public  void mostrarImagen(Oferta ofert) throws SQLException{
        
       
        //System.out.println(""+prod.getIdProducto());
         JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "select IMAGENOFERTA\n" +
                    "from OFERTA WHERE IDOFERTA ="+ofert.getIdOferta()+"";
            ResultSet rs = st.executeQuery(sql);
            
            Object datos[] = new Object[40];
            
            while (rs.next()) {     
                
                
                
                  
                Blob blob = rs.getBlob(1);//llamamos la imagen

                if(blob != null)//mandamos un mensaje de no imagen si es null
                {
                    try{
                        byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                        try{
                            img = ImageIO.read(new ByteArrayInputStream(data));
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        
                        
                        //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
                        Image foto = img;

                        //Le damos dimension a nuestro label que tendra la imagen
                        foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                        ImageIcon icono = new ImageIcon(foto);
                        
                        lblImagenMod.setIcon(icono);
                        
                        
                        
                        ///datos[0] = new JLabel(icono);
                    }catch(Exception ex){
                        datos[0] = "No Imagen";
                    }
                }
                else{
                    datos[0] = "No Imagen";
                } 
            }
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
    public void modificarOferta(Oferta ofert) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE OFERTA "
                   + "SET IDTIENDA= ?, "
                       + "IDPRODUCTO = ?,"
                       + "NOMBREOFERTA= ?, "
                       + "MINIMOPRODUCTO = ?,"
                       + "MAXIMOPRODUCTO = ?,"
                       + "PRECIOOFERTA = ?,"
                        + "DESCUENTOOFERTA = ?,"
                       + "STOCKPRODUCTOOFERTA= ?,"
                       + "IDESTADO= ?"
                       //+ "IMAGENOFERTA= ?,"
                       + "WHERE IDOFERTA = ?";
        
        PreparedStatement pst = null;
     
        try{
            System.out.println("..............Modificando........");
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, ofert.getIdTienda());
            pst.setInt(2, ofert.getIdProducto());
            pst.setString(3, ofert.getNombreOferta());
            pst.setInt(4, ofert.getMinProducto());
            pst.setInt(5, ofert.getMaxProducto());
           // pst.setBinaryStream(6, fi);
            pst.setInt(6, ofert.getPrecioOferta());
            pst.setInt(7,ofert.getDescuentoOferta());
            pst.setInt(8,ofert.getStockProductoOferta());
            pst.setInt(9,ofert.getIdEstado());
             pst.setInt(10,ofert.getIdOferta());
            
          
             
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            
             System.out.println("IdTienda : "+ofert.getIdTienda()+"\n "
                     + "idProducto : "+ofert.getIdProducto()+"\n "+
                     "Stock Producto : "+ofert.getStockProductoOferta()+"\n"
                 +"IdOferta : "+ofert.getIdOferta());
            JOptionPane.showMessageDialog(null, "Datos Actualizados...");
            
           
        
            try{
                pst.close();
               
            }catch(Exception ex){}
        }
              
    }

    public void modificarOfertaConImagen(Oferta ofert,FileInputStream fi) throws SQLException{
        
        
       
         JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE OFERTA "
                   + "SET IDTIENDA= ?, "
                       + "IDPRODUCTO = ?,"
                       + "NOMBREOFERTA= ?, "
                       + "MINIMOPRODUCTO = ?,"
                       + "MAXIMOPRODUCTO = ?,"
                       + "PRECIOOFERTA = ?,"
                        + "DESCUENTOOFERTA = ?,"
                       + "STOCKPRODUCTOOFERTA= ?,"
                       + "IDESTADO= ?,"
                       + "IMAGENOFERTA= ?"
                       + "WHERE IDOFERTA = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, ofert.getIdTienda());
            pst.setInt(2, ofert.getIdProducto());
            pst.setString(3, ofert.getNombreOferta());
            pst.setInt(4, ofert.getMinProducto());
            pst.setInt(5, ofert.getMaxProducto());
            pst.setInt(6, ofert.getPrecioOferta());
            pst.setInt(7,ofert.getDescuentoOferta());
            pst.setInt(8,ofert.getStockProductoOferta());
            pst.setInt(9,ofert.getIdEstado());
             pst.setBinaryStream(10, fi);
             pst.setInt(11,ofert.getIdOferta());
             
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            System.out.println("IdTienda : "+ofert.getIdTienda()+"/n "
                     + "idTienda : "+ofert.getIdProducto());
            JOptionPane.showMessageDialog(null, "Datos Actualizados...");
             
            
            try{
                pst.close();
               
            }catch(Exception ex){}
        }   
    }
}

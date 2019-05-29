/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.producto;

import conectorBD.JavaConnectDb;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.producto.Producto;
import view.crudProductos.readProductos;
import view.crudProductos.updateProductos;
import static view.crudProductos.updateProductos.lblImagenMod;

/**
 *
 * @author fernandacancinoreyes
 */
public class CrudProducto {
    
    
    
    public  void mostrarImagen(Producto prod) throws SQLException{
        
       
        //System.out.println(""+prod.getIdProducto());
         JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "select IMAGENPRODUCTO\n" +
                    "from PRODUCTO WHERE IDPRODUCTO ="+prod.getIdProducto()+"";
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
/*Metodo Modificar*/
    public void modificarProducto(Producto prod) throws SQLException{
        
        JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE PRODUCTO "
                   + "SET NOMBREPRODUCTO= ?, "
                       + "RUBROPRODUCTO = ?,"
                       + "PRECIOPRODUCTO= ?, "
                       + "STOCKPRODUCTO = ?,"
                       + "FECHAEXPIRACION= ?,"
                       //+ "IMAGENPRODUCTO= ?,"
                       + "IDTIENDA= ?"
                       + "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, prod.getNombreProducto());
            pst.setInt(2, prod.getRubroProducto());
            pst.setInt(3, prod.getPrecioProducto());
            pst.setInt(4, prod.getStockProducto());
            pst.setString(5, prod.getFechaExpiracion());
           // pst.setBinaryStream(6, fi);
            pst.setInt(6, prod.getIdtienda());
            
            pst.setInt(7, prod.getIdProducto());
            
            System.out.println("nombre : " + prod.getNombreProducto() + "rubro : " + prod.getRubroProducto()
                               + "precio :" + prod.getPrecioProducto()
                               + "stock :" + prod.getStockProducto()  + "IDTIENDA :" + prod.getIdtienda()
                               + " id :" + prod.getIdProducto());
             
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

    public void modificarProductoConImagen(Producto prod,FileInputStream fi) throws SQLException{
        
        
       
         JavaConnectDb obj = new JavaConnectDb();
         Connection cn = obj.ConnectBd();
        String sql = "UPDATE PRODUCTO "
                   + "SET NOMBREPRODUCTO= ?, "
                       + "RUBROPRODUCTO = ?,"
                       + "PRECIOPRODUCTO= ?, "
                       + "STOCKPRODUCTO = ?,"
                       + "FECHAEXPIRACION= ?,"
                       + "IMAGENPRODUCTO= ?,"
                       + "IDTIENDA= ?"
                       + "WHERE IDPRODUCTO = ?";
        
        PreparedStatement pst = null;
     
        try{
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, prod.getNombreProducto());
            pst.setInt(2, prod.getRubroProducto());
            pst.setInt(3, prod.getPrecioProducto());
            pst.setInt(4, prod.getStockProducto());
            pst.setString(5, prod.getFechaExpiracion());
            pst.setBinaryStream(6, fi);
            pst.setInt(7, prod.getIdtienda());
            
            pst.setInt(8, prod.getIdProducto());
            
            System.out.println("nombre : " + prod.getNombreProducto() + "rubro : " + prod.getRubroProducto()
                               + "precio :" + prod.getPrecioProducto()
                               + "stock :" + prod.getStockProducto()  + "IDTIENDA :" + prod.getIdtienda()
                               + " id :" + prod.getIdProducto());
             
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

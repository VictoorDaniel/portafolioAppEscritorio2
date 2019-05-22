/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Oferta;

import conectorBD.JavaConnectDb;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.GenerarArchivoBItxt;
import model.TablaImagen;

/**
 *
 * @author muzaka
 */
public class Oferta2BI {
    
   private int IdOferta;
   private String Tienda;
   private String Producto;
   private String NombreOferta;
   private int MinimoProducto;
   private int MaximoProducto;
   private int PrecioOferta;
   private int DescuentoOferta;
   private int StockProductoOferta;
   private String Estado;
   private int Visita;
   private String FechaVisita;

   public Oferta2BI()
   {}

    public Oferta2BI(int IdOferta, String Tienda, String Producto, String NombreOferta, int MinimoProducto, int MaximoProducto, int PrecioOferta, int DescuentoOferta, int StockProductoOferta, String Estado, int Visita, String FechaVisita) {
        this.IdOferta = IdOferta;
        this.Tienda = Tienda;
        this.Producto = Producto;
        this.NombreOferta = NombreOferta;
        this.MinimoProducto = MinimoProducto;
        this.MaximoProducto = MaximoProducto;
        this.PrecioOferta = PrecioOferta;
        this.DescuentoOferta = DescuentoOferta;
        this.StockProductoOferta = StockProductoOferta;
        this.Estado = Estado;
        this.Visita = Visita;
        this.FechaVisita = FechaVisita;
    }

    public int getIdOferta() {
        return IdOferta;
    }

    public void setIdOferta(int IdOferta) {
        this.IdOferta = IdOferta;
    }

    public String getTienda() {
        return Tienda;
    }

    public void setTienda(String Tienda) {
        this.Tienda = Tienda;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getNombreOferta() {
        return NombreOferta;
    }

    public void setNombreOferta(String NombreOferta) {
        this.NombreOferta = NombreOferta;
    }

    public int getMinimoProducto() {
        return MinimoProducto;
    }

    public void setMinimoProducto(int MinimoProducto) {
        this.MinimoProducto = MinimoProducto;
    }

    public int getMaximoProducto() {
        return MaximoProducto;
    }

    public void setMaximoProducto(int MaximoProducto) {
        this.MaximoProducto = MaximoProducto;
    }

    public int getPrecioOferta() {
        return PrecioOferta;
    }

    public void setPrecioOferta(int PrecioOferta) {
        this.PrecioOferta = PrecioOferta;
    }

    public int getDescuentoOferta() {
        return DescuentoOferta;
    }

    public void setDescuentoOferta(int DescuentoOferta) {
        this.DescuentoOferta = DescuentoOferta;
    }

    public int getStockProductoOferta() {
        return StockProductoOferta;
    }

    public void setStockProductoOferta(int StockProductoOferta) {
        this.StockProductoOferta = StockProductoOferta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getVisita() {
        return Visita;
    }

    public void setVisita(int Visita) {
        this.Visita = Visita;
    }

    public String getFechaVisita() {
        return FechaVisita;
    }

    public void setFechaVisita(String FechaVisita) {
        this.FechaVisita = FechaVisita;
    }
    
  
    
    public static  void EscribirOfertas(){
        
     
   JavaConnectDb obj = new JavaConnectDb();
      
        ArrayList listaOferta = new ArrayList<>();
        try {
            Connection cn = obj.ConnectBd();
            Statement st = cn.createStatement();
            String sql = "SELECT\n" +
"     to_char(OFERTA.\"FECHAVISITA\",'DAY','NLS_DATE_LANGUAGE=SPANISH')||  to_CHAR(OFERTA.\"FECHAVISITA\",'DD-MON-YYYY HH:MI AM') AS FECHAVISITA,\n" +
"     OFERTA.\"IDOFERTA\" AS IDOFERTA,\n" +
"     OFERTA.\"NOMBREOFERTA\" AS NOMBRE_OFERTA,\n" +
"     OFERTA.\"MINIMOPRODUCTO\" AS MINIMOPRODUCTO,\n" +
"     OFERTA.\"MAXIMOPRODUCTO\" AS MAXIMOPRODUCTO,\n" +
"     OFERTA.\"PRECIOOFERTA\" AS PRECIOOFERTA,\n" +
"     OFERTA.\"DESCUENTOOFERTA\" AS DESCUENTOOFERTA,\n" +
"     OFERTA.\"STOCKPRODUCTOOFERTA\" AS STOCKPRODUCTOOFERTA,\n" +
"     OFERTA.\"VISITAS\" AS VISITAS,\n" +
"     PRODUCTO.\"NOMBREPRODUCTO\" AS NOMBREPRODUCTO,\n" +
"     TIENDA.\"IDTIENDA\"||' '||\n" +
"     TIENDA.\"NOMBRETIENDA\" AS TIENDA,\n" +
"     ESTADO.\"GLOSAESTADO\" AS ESTADO\n" +
"FROM\n" +
"     \"MISOFERTAS\".\"PRODUCTO\" PRODUCTO INNER JOIN \"MISOFERTAS\".\"OFERTA\" OFERTA ON PRODUCTO.\"IDPRODUCTO\" = OFERTA.\"IDPRODUCTO\"\n" +
"     INNER JOIN \"MISOFERTAS\".\"TIENDA\" TIENDA ON OFERTA.\"IDTIENDA\" = TIENDA.\"IDTIENDA\"\n" +
"     INNER JOIN \"MISOFERTAS\".\"ESTADO\" ESTADO ON OFERTA.\"IDESTADO\" = ESTADO.\"IDESTADO\"\n" +
"     AND OFERTA.\"IDESTADO\" = ESTADO.\"IDESTADO\"\n" +
"WHERE\n" +
"     OFERTA.\"FECHAVISITA\" BETWEEN to_date(to_char(sysdate-7,'dd/mm/yyyy'),'dd/mm/yyyy')AND to_date(to_char(sysdate,'dd/mm/yyyy'),'dd/mm/yyyy')";
            ResultSet rs = st.executeQuery(sql);
            
           
            
            while (rs.next()) {     
               Oferta2BI oferta=new Oferta2BI();
               oferta.setFechaVisita(rs.getString(1));
               oferta.setIdOferta(Integer.parseInt(rs.getString(2)));
               oferta.setNombreOferta(rs.getString(3));
               oferta.setMinimoProducto(Integer.parseInt(rs.getString(4)));
                oferta.setMaximoProducto(Integer.parseInt(rs.getString(5)));
                 oferta.setPrecioOferta(Integer.parseInt(rs.getString(6)));
                 oferta.setDescuentoOferta(Integer.parseInt(rs.getString(7)));
                 oferta.setStockProductoOferta(Integer.parseInt(rs.getString(8)));
                 oferta.setVisita(Integer.parseInt(rs.getString(9)));
                 oferta.setProducto(rs.getString(10));
                 oferta.setTienda(rs.getString(11));
                 oferta.setEstado(rs.getString(12));
                // crea el archivo estudiantes
	      listaOferta.add(oferta);
            }
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        GenerarArchivoBItxt.crearArchivo(listaOferta);
    }


   
    
}

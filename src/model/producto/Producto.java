/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

/**
 *
 * @author fernandacancinoreyes
 */
public class Producto {
    
    public int idProducto;
    public String nombreProducto;
    public int rubroProducto;
    public int precioProducto;
    public byte[] imagenProducto;
    public int stockProducto;
    public String fechaExpiracion;
    public int categoriaProducto;

    public Producto () {
        
    }
            /*
            (int idProducto, String nombreProducto, int rubroProducto, int precioProducto, byte[] imagenProducto, int stockProducto, String fechaExpiracion) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.rubroProducto = rubroProducto;
        this.precioProducto = precioProducto;
        this.imagenProducto = imagenProducto;
        this.stockProducto = stockProducto;
        this.fechaExpiracion = fechaExpiracion;
    }
    */

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getRubroProducto() {
        return rubroProducto;
    }

    public void setRubroProducto(int rubroProducto) {
        this.rubroProducto = rubroProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    

    public int getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(int categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }
    
            
    
}

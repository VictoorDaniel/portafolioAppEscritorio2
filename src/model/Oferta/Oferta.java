/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Oferta;

import java.io.FileInputStream;
import java.sql.Blob;

/**
 *
 * @author fernandacancinoreyes
 */
public class Oferta {
    
    private int idOferta;
    private int idTienda;
    private int idProducto;
    private String nombreOferta;
    private int minProducto;
    private int maxProducto;
    private int precioOferta;
    private int descuentoOferta;
    private int stockProductoOferta;
    private int idEstado;
    private Blob imagenOferta;
    private int visitas;
    private String fechaVisita;
    
    public void oferta(){}
    
    
    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public int getMinProducto() {
        return minProducto;
    }

    public void setMinProducto(int minProducto) {
        this.minProducto = minProducto;
    }

    public int getMaxProducto() {
        return maxProducto;
    }

    public void setMaxProducto(int maxProducto) {
        this.maxProducto = maxProducto;
    }

    public int getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(int precioOferta) {
        this.precioOferta = precioOferta;
    }

    public int getDescuentoOferta() {
        return descuentoOferta;
    }

    public void setDescuentoOferta(int descuentoOferta) {
        this.descuentoOferta = descuentoOferta;
    }

    public int getStockProductoOferta() {
        return stockProductoOferta;
    }

    public void setStockProductoOferta(int stockProductoOferta) {
        this.stockProductoOferta = stockProductoOferta;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Blob getImagenOferta() {
        return imagenOferta;
    }

    public void setImagenOferta(Blob imagenOferta) {
        this.imagenOferta = imagenOferta;
    }

   

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public void setImagenOferta(FileInputStream fi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Tienda;

/**
 *
 * @author muzaka
 */
public class Tienda {
    
    
    private int IdTienda;
    private String NombreTienda;
    private int IdEmpresa;
    private int IdUsuario;
    private String FechaInscripcion; 
    private int IDComuna;
    private String CalleDireccion;
    private String NumeroDireccion;
    private String observacionDireccion;
    private int NumeroTelefono;

    public Tienda(int IdTienda, String NombreTienda, int IdEmpresa, int IdUsuario, String FechaInscripcion, int IDComuna, String CalleDireccion, String NumeroDireccion, String observacionDireccion, int NumeroTelefono) {
        this.IdTienda = IdTienda;
        this.NombreTienda = NombreTienda;
        this.IdEmpresa = IdEmpresa;
        this.IdUsuario = IdUsuario;
        this.FechaInscripcion = FechaInscripcion;
        this.IDComuna = IDComuna;
        this.CalleDireccion = CalleDireccion;
        this.NumeroDireccion = NumeroDireccion;
        this.observacionDireccion = observacionDireccion;
        this.NumeroTelefono = NumeroTelefono;
    }
    
    public Tienda(){}

    public int getIdTienda() {
        return IdTienda;
    }

    public void setIdTienda(int IdTienda) {
        this.IdTienda = IdTienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String NombreTienda) {
        this.NombreTienda = NombreTienda;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getFechaInscripcion() {
        return FechaInscripcion;
    }

    public void setFechaInscripcion(String FechaInscripcion) {
        this.FechaInscripcion = FechaInscripcion;
    }

    public int getIDComuna() {
        return IDComuna;
    }

    public void setIDComuna(int IDComuna) {
        this.IDComuna = IDComuna;
    }

    public String getCalleDireccion() {
        return CalleDireccion;
    }

    public void setCalleDireccion(String CalleDireccion) {
        this.CalleDireccion = CalleDireccion;
    }

    public String getNumeroDireccion() {
        return NumeroDireccion;
    }

    public void setNumeroDireccion(String NumeroDireccion) {
        this.NumeroDireccion = NumeroDireccion;
    }

    public String getObservacionDireccion() {
        return observacionDireccion;
    }

    public void setObservacionDireccion(String observacionDireccion) {
        this.observacionDireccion = observacionDireccion;
    }

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(int NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }
    
    
    
}

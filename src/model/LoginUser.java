/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fernandacancinoreyes
 */
public class LoginUser {
    
    //estos datos del usuario estaran activos durante toda la sesón
   private int IdUsuario;
    private int IdRol;
    private String NombreUsuario;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String EmailUsuario;
    private String RutUsuario;
    private String FechaNacimiento;
    private String AceptaOfertasEmail;
    private int IdEstado;
    private String Password;
    private String NombreRol;

    
    public LoginUser (){}
    
    
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getEmailUsuario() {
        return EmailUsuario;
    }

    public void setEmailUsuario(String EmailUsuario) {
        this.EmailUsuario = EmailUsuario;
    }

    public String getRutUsuario() {
        return RutUsuario;
    }

    public void setRutUsuario(String RutUsuario) {
        this.RutUsuario = RutUsuario;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getAceptaOfertasEmail() {
        return AceptaOfertasEmail;
    }

    public void setAceptaOfertasEmail(String AceptaOfertasEmail) {
        this.AceptaOfertasEmail = AceptaOfertasEmail;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }
    
    
    
    
}

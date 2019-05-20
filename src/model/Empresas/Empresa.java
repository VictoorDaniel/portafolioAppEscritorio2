/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Empresas;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import model.Comuna.Comuna;
import model.Usuarios.Usuario;

/**
 *
 * @author muzaka
 */
public class Empresa extends JavaConnectDb {
    
    
    private int IdEmpresa;
    private String NombreEmpresa;
    private int IdUsuario;
    private String FechaInscripcion; 
    private int IDComuna;
    private String CalleDireccion;
    private String NumeroDireccion;
    private String observacionDireccion;
    
    public Empresa () {}

    public Empresa(int IdEmpresa, String NombreEmpresa) {
        this.IdEmpresa = IdEmpresa;
        this.NombreEmpresa = NombreEmpresa;
    }

  
 
    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
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

    
    
     
    
  //metodo para cargar el cmxUusario
   
   public  void getValuesEmpresa(JComboBox<Empresa>cbModelEmpresa){
        
      
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select * from Empresa";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                cbModelEmpresa.addItem(new Empresa (Integer.parseInt(rs.getString("IDEMPRESA")),
                rs.getString("NOMBREEMPRESA")));
            }
           
            cn.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
   
   //con el toString elegimos las cosas a mandar po el cmbx
    @Override
   public String toString()
   {
   return NombreEmpresa;
   };
    

    
    
    
    
    
}

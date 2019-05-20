/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import conectorBD.JavaConnectDb;

/**
 *
 * @author muzaka
 */
public class Usuario extends JavaConnectDb{
    //simpre colocar el extends JavaConnect para obtener el metodo de conexión
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

    
    public Usuario (){}

    public Usuario(int IdUsuario, String NombreUsuario,String ApellidoPaterno,
            String ApellidoMaterno,String RutUsuario,String EmailUsuario) {
         this.IdUsuario = IdUsuario;
         this.NombreUsuario = NombreUsuario;
         this.ApellidoPaterno = ApellidoPaterno;
         this.ApellidoMaterno = ApellidoMaterno;
         this.RutUsuario = RutUsuario;
         this.EmailUsuario= EmailUsuario;
         
    }
    
    

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
 
     
  //metodo para cargar el cmxUusario
   
   public  void getValuesUsuario(JComboBox<Usuario>cbModelUsuario){
        
      
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select * from USUARIO where idrol=4";
      // para que solo muestre los usuario tipo cliente le damos el id 4
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                cbModelUsuario.addItem(new Usuario (Integer.parseInt( rs.getString("IdUsuario")),
                rs.getString("NombreUsuario"),rs.getString("ApellidoPaterno"),rs.getString("ApellidoMaterno")
                ,rs.getString("RutUsuario"),rs.getString("EmailUsuario")));
            }
           
            cn.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
   
   
   public  void getValuesUsuarioEncargado(JComboBox<Usuario>cbModelUsuario){
        
      
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select * from USUARIO where idrol=3";
      // para que solo muestre los usuario tipo cliente le damos el id 4
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                cbModelUsuario.addItem(new Usuario (Integer.parseInt( rs.getString("IdUsuario")),
                rs.getString("NombreUsuario"),rs.getString("ApellidoPaterno"),rs.getString("ApellidoMaterno")
                ,rs.getString("RutUsuario"),rs.getString("EmailUsuario")));
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
   return NombreUsuario+"  "+ApellidoPaterno+"  "+ApellidoMaterno+" / "+RutUsuario
           +" / "+EmailUsuario;
   };
   
    
    
    
}

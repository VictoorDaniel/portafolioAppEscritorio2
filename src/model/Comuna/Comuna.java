/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Comuna;

import conectorBD.JavaConnectDb;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author muzaka
 */
public class Comuna extends JavaConnectDb{
    
    private int IDCOMUNA;
    private String NOMBRECOMUNA;
    private int IDREGION;
    private String NOMBREREGION;
    private String NUMEROREGION;

    public Comuna (){};
    public Comuna(int IDCOMUNA, String NOMBRECOMUNA, int IDREGION, String NOMBREREGION, String NUMEROREGION) {
        this.IDCOMUNA = IDCOMUNA;
        this.NOMBRECOMUNA = NOMBRECOMUNA;
        this.IDREGION = IDREGION;
        this.NOMBREREGION = NOMBREREGION;
        this.NUMEROREGION = NUMEROREGION;
    }
    
    

    public int getIDCOMUNA() {
        return IDCOMUNA;
    }

    public void setIDCOMUNA(int IDCOMUNA) {
        this.IDCOMUNA = IDCOMUNA;
    }

    public String getNOMBRECOMUNA() {
        return NOMBRECOMUNA;
    }

    public void setNOMBRECOMUNA(String NOMBRECOMUNA) {
        this.NOMBRECOMUNA = NOMBRECOMUNA;
    }

    public int getIDREGION() {
        return IDREGION;
    }

    public void setIDREGION(int IDREGION) {
        this.IDREGION = IDREGION;
    }

    public String getNOMBREREGION() {
        return NOMBREREGION;
    }

    public void setNOMBREREGION(String NOMBREREGION) {
        this.NOMBREREGION = NOMBREREGION;
    }

    public String getNUMEROREGION() {
        return NUMEROREGION;
    }

    public void setNUMEROREGION(String NUMEROREGION) {
        this.NUMEROREGION = NUMEROREGION;
    }
    
    
     
  //metodo para cargar el cmxUusario
   
   public  void getValuesComuna(JComboBox<Comuna>cbModelComuna){
        
      
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select * from COMUNA,REGION where COMUNA.IDREGION=REGION.IDREGION";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                cbModelComuna.addItem(new Comuna (Integer.parseInt( rs.getString("IDCOMUNA")),
                rs.getString("NOMBRECOMUNA"),Integer.parseInt( rs.getString("IDREGION")),
                        rs.getString("NOMBREREGION"),rs.getString("NUMEROREGION")));
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
   return NOMBRECOMUNA+" / "+NOMBREREGION+" / "+NUMEROREGION;
   };

    
    
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.comboBox;

import conectorBD.JavaConnectDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author fernandacancinoreyes
 */
public class CbxProducto {
    
    private int IDPRODUCTO;
    private String NOMBREPRODUCTO;
    
    public CbxProducto (){};
    public CbxProducto(int IDPRODUCTO, String NOMBREPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
        this.NOMBREPRODUCTO = NOMBREPRODUCTO;
    }

    public int getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(int IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public String getNOMBREPRODUCTO() {
        return NOMBREPRODUCTO;
    }

    public void setNOMBREPRODUCTO(String NOMBREPRODUCTO) {
        this.NOMBREPRODUCTO = NOMBREPRODUCTO;
    }
    
    
    
    
    
    
    //recibe combobox de tipo cbx
    public  void getValuesProducto(JComboBox<CbxProducto>bla){
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        
        try {
            
            String sql = "select IDPRODUCTO, NOMBREPRODUCTO from PRODUCTO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                bla.addItem(new CbxProducto (Integer.parseInt(rs.getString("IDPRODUCTO")),
                                     rs.getString("NOMBREPRODUCTO")));
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
   { return NOMBREPRODUCTO  ;
    };

   
   
   
}

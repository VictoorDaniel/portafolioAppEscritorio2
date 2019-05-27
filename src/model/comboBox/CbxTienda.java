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
public class CbxTienda {
    
    private int IDTIENDA;
    private String NOMBRETIENDA;

    public CbxTienda (){};
    public CbxTienda(int IDTIENDA, String NOMBRETIENDA) {
        this.IDTIENDA = IDTIENDA;
        this.NOMBRETIENDA = NOMBRETIENDA;
    }
    
    public int getIDTIENDA() {
        return IDTIENDA;
    }

    public void setIDTIENDA(int IDTIENDA) {
        this.IDTIENDA = IDTIENDA;
    }

    public String getNOMBRETIENDA() {
        return NOMBRETIENDA;
    }

    public void setNOMBRETIENDA(String NOMBRETIENDA) {
        this.NOMBRETIENDA = NOMBRETIENDA;
    }
    
    //recibe combobox de tipo cbxTienda
    public  void getValuesTienda(JComboBox<CbxTienda>bla){
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        
        try {
            
            String sql = "select IDTIENDA, NOMBRETIENDA from TIENDA";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                bla.addItem(new CbxTienda (Integer.parseInt(rs.getString("IDTIENDA")),
                                     rs.getString("NOMBRETIENDA")));
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
   { return NOMBRETIENDA ;
    };
    
}

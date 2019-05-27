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
public class CbxEstado {
    
    private int IDESTADO;
    private String GLOSAESTADO;

    public CbxEstado() {
    }
    
    public CbxEstado(int IDESTADO, String GLOSAESTADO) {
        this.IDESTADO = IDESTADO;
        this.GLOSAESTADO = GLOSAESTADO;
    }

    
    
    public int getIDESTADO() {
        return IDESTADO;
    }

    public void setIDESTADO(int IDESTADO) {
        this.IDESTADO = IDESTADO;
    }

    public String getGLOSAESTADO() {
        return GLOSAESTADO;
    }

    public void setGLOSAESTADO(String GLOSAESTADO) {
        this.GLOSAESTADO = GLOSAESTADO;
    }
    
    //recibe combobox de tipo cbxTienda
    public  void getValuesEstado(JComboBox<CbxEstado>bla){
        
        JavaConnectDb obj = new JavaConnectDb();
        Connection cn = obj.ConnectBd();
        
        try {
            
            String sql = "select IDESTADO, GLOSAESTADO from ESTADO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {   
                //aqui van los campos del contructor que le dimos al usuario arriba
                bla.addItem(new CbxEstado (Integer.parseInt(rs.getString("IDESTADO")),
                                     rs.getString("GLOSAESTADO")));
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
   { return GLOSAESTADO ;
    };
    
}

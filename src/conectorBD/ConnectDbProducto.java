/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectorBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author fernandacancinoreyes
 */
public class ConnectDbProducto extends JavaConnectDb{
    
    static Connection con = null;
    /*
    public DefaultComboBoxModel getValuesRubro(){
        
        DefaultComboBoxModel cbModelRubro = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select idrubro, nombrerubro from RUBRO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idrubro"); //rs.getInt("idrubro");
                registros[1] = rs.getString("nombrerubro");
               // cbModelRubro.addElement(rs.getString(1));
               cbModelRubro.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        /*
        try {
            Connection cn = this.ConnectDb();
            String sql = "select nombrerubro from RUBRO";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                cbModelRubro.addElement(rs.getString(1));
            }
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }*/
        /*
        return cbModelRubro;
    }
    */

    public DefaultComboBoxModel getValuesCategoria(){
        
        DefaultComboBoxModel cbModelCatgeoria = new DefaultComboBoxModel();
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select nombrecategoria from CATEGORIA";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                cbModelCatgeoria.addElement(rs.getString(1));
            }
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return cbModelCatgeoria;
    }
    
    
    public  ResultSet listProductos(ResultSet rs) throws SQLException{
        
        try {
            Connection cn = this.ConnectDb();
            String sql = "select nombrecategoria from PRODUCTO";
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
             
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return rs;
    }
    
    
    
    
}

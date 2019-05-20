/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fernandacancinoreyes
 */
public class JavaConnectDb {
    
  
    
    public Connection ConnectBd(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MisOfertas", "misofertas");
            
            if(con !=null){
                System.out.println("Se ha conectado a bd portafolio");
            }else{
                System.out.println("NO Se ha conectado a bd portafolio");
            }
            
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            
        }
        return null;
    }
    
     protected Connection ConnectDb(){
         Connection con = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MisOfertas", "misofertas");
            
            if(con !=null){
                System.out.println("Se ha conectado a bd portafolio");
            }else{
                System.out.println("NO Se ha conectado a bd portafolio");
            }
            
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    /*
    public void insertData() throws SQLException, Exception {
        Connection conn = null;
        try{
             conn = getConexion();
             String sql = "";
            conn.prepareStatement(sql, columnNames)
            
                
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
        
    }
    */
    
    
}

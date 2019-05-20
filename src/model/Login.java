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
public class Login {
    
    private int USER_ID;
    private String Password;

    public Login(int USER_ID, String Password) {
        this.USER_ID = USER_ID;
        this.Password = Password;
    }
    public Login(){}
    
    
    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}

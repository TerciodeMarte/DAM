/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
public class User implements Serializable {

    private String email,password,name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", name=" + name + '}';
    }
    
    
}

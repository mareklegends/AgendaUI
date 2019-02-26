/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioDatos;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Users implements Serializable{
    
    private String usuario;
    private String clave;

    public Users(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public String toString() {
        return ""+usuario+""+clave; //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}

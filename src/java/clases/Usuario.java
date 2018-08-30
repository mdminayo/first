/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.ConectorBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Diana
 */

public class Usuario {
    
    public String usuario;
    public String clave;
    public String rol;

    public Usuario() {
    }

    public Usuario(String usuario) {
        
        String cadenaSQL="select usuario, clave, rol from usuario where usuario = "+usuario;
        ConectorBD conector = new ConectorBD();
        conector.conectar();
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                this.usuario=usuario;
                this.clave=resultado.getString("clave");
                this.rol=resultado.getString("rol");
                
            } 
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar "+cadenaSQL +" "+e.getMessage());
        }
    }

    public Usuario(String usuario, String clave) {
        String cadenaSQL="select clave, rol from usuario where usuario = "+usuario+" and clave = "+clave;
        String datos[][]=ConectorBD.getDatos(cadenaSQL);
        if (datos.length>0) {
            this.usuario = usuario;
            this.clave = datos[0][0];
            this.rol = datos[0][1];
        }
        
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void grabar(){ 
        String cadenaSQL="insert into usuario (usuario,clave, rol) values ('"+this.usuario+"','"+this.clave+"','"+this.rol+"')";
        ConectorBD.actualizarDatos(cadenaSQL);
    }
    
    public static String [][] getDatos(String filtro){
        String cadenaSQL="select usuario, clave, rol from usuario";
        if(filtro!=null) cadenaSQL +=" where "+filtro;
        String [][] datos = ConectorBD.getDatos(cadenaSQL);
        return datos;
    }
    
    public static Usuario [] getDatosEnObjetos(String filtro){
        String datos [][] = Usuario.getDatos(filtro);
        Usuario usuarios [] = new Usuario[datos.length];
        for (int i = 0; i < datos.length; i++) {
            if(datos[i][0]!=null){
                Usuario usuario = new Usuario();
                usuario.setUsuario(datos[i][0]);
                usuario.setClave(datos[i][1]);
                usuario.setRol(datos[i][2]);
                usuarios[i]=usuario;                
            }    
        }
        return usuarios;
    }
    
    
 
    
    
}

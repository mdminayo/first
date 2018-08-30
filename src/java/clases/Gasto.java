/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Diana
 */
public class Gasto {
    public String id;
    public String fecha;
    public String detalle;
    public String valor;
    public String usuario;

    public Gasto() {
    }

    public Gasto(String id) {
        String cadenaSQL="select * from gasto where id="+id;
        ConectorBD conector=new ConectorBD();
        conector.conectar();
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL);
            ResultSet resultado=sentencia.executeQuery();
            if (resultado.next()) {
                this.id=id;
                this.fecha=resultado.getString("fecha");
                this.detalle=resultado.getString("detalle");
                this.valor=resultado.getString("valor");
                this.usuario=resultado.getString("usuario");
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar "+cadenaSQL+" "+e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
    public static String [][] getDatos(String filtro){
        String cadenaSQL="select * from gasto";
        if(filtro!=null)cadenaSQL+=" where "+filtro;
        String datos[][]=ConectorBD.getDatos(cadenaSQL);
        return datos;
    }
    
    public static Gasto[] getDatosEnObjetos(String filtro){
        String[][] datos=Gasto.getDatos(filtro);
        Gasto[] gastos=new Gasto[datos.length];
        for (int i = 0; i < datos.length; i++) {
            Gasto gasto=new Gasto();
            gasto.setId(datos[i][0]);
            gasto.setFecha(datos[i][1]);
            gasto.setDetalle(datos[i][2]);
            gasto.setValor(datos[i][3]);
            gasto.setUsuario(datos[i][4]);
            gastos[i]=gasto;
            
        }
        return gastos;
    }
    
    public void grabar(){
        String cadenaSQL="INSERT INTO gasto(fecha,detalle,valor,usuario)values('"+this.getFecha()+"','"+this.detalle+"',"+this.valor+",'"+this.usuario+"')";
        ConectorBD.actualizarDatos(cadenaSQL);
    }
    
    
}

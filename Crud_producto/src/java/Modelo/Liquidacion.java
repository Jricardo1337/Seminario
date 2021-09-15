/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author Usuario
 */
public class Liquidacion {
    private int id_liquidacion;
    private String nombre_liquidacion;
    Conexion cn;
    
    public Liquidacion(){
    }

    public Liquidacion(int id_liquidacion, String nombre_liquidacion) {
        this.id_liquidacion = id_liquidacion;
        this.nombre_liquidacion = nombre_liquidacion;
    }
    

    public int getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(int id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }

    public String getNombre_liquidacion() {
        return nombre_liquidacion;
    }

    public void setNombre_liquidacion(String nombre_liquidacion) {
        this.nombre_liquidacion = nombre_liquidacion;
    }
    
    
    public HashMap drop_liquidacion(){
    HashMap<String,String> drop2 = new HashMap();
    try{
        String query ="select id_liquidacion as id,nombre_liquidacion from liquidacion";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop2.put(consulta.getString("id"),consulta.getString("nombre_liquidacion") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop2;
    }
}

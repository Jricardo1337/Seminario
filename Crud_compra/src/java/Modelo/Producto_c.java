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
public class Producto_c {
    private int id_producto;
    private String nombre_prod;
    Conexion cn;
    
    public Producto_c(){
    }

    public Producto_c(int id_producto, String nombre_prod) {
        this.id_producto = id_producto;
        this.nombre_prod = nombre_prod;
    }
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }
    
    
    public HashMap drop_producto_c(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="select id_producto as id, nombre_prod from producto";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("nombre_prod") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
}

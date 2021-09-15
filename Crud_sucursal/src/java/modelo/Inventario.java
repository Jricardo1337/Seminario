/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author Usuario
 */
public class Inventario {
    private int id_inventario;
    private String nombre_inventario;
    Conexion cn;

    
    public Inventario(){}
    
    public Inventario(int id_inventario, String nombre_inventario) {
        this.id_inventario = id_inventario;
        this.nombre_inventario = nombre_inventario;
    }

   
    
    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getNombre_inventario() {
        return nombre_inventario;
    }

    public void setNombre_inventario(String nombre_inventario) {
        this.nombre_inventario = nombre_inventario;
    }
    
    
     public HashMap drop_inventario(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="SELECT id_inventario AS id,nombre_inventario FROM inventario";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("nombre_inventario") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    } 
    
    
    
}

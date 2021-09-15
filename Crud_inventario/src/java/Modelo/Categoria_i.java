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
public class Categoria_i {
    private int id_categoria;
    private String nombre_cat;
    Conexion cn;
    
    public Categoria_i(){
    }

    public Categoria_i(int id_categoria, String nombre_cat) {
        this.id_categoria = id_categoria;
        this.nombre_cat = nombre_cat;
    }
    

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }
    
    
    public HashMap drop_categoria_i(){
    HashMap<String,String> drop2 = new HashMap();
    try{
        String query ="select id_categoria as id,nombre_cat from categoria";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop2.put(consulta.getString("id"),consulta.getString("nombre_cat") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop2;
    }
}

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
public class Oferta {
    private int id_oferta;
    private String tipo_oferta;
    Conexion cn;
    
    public Oferta(){
    }

    public Oferta(int id_oferta, String tipo_oferta) {
        this.id_oferta = id_oferta;
        this.tipo_oferta = tipo_oferta;
    }
    

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public String getTipo_oferta() {
        return tipo_oferta;
    }

    public void setTipo_oferta(String tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
    }
    
    
    public HashMap drop_oferta(){
    HashMap<String,String> drop1 = new HashMap();
    try{
        String query ="select id_oferta as id,tipo_oferta from oferta";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop1.put(consulta.getString("id"),consulta.getString("tipo_oferta") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop1;
    }
}

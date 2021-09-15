/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import Modelo.Conexion;
import Modelo.Datos5;
/**
 *
 * @author Usuario
 */
public class Inventario extends Datos5 {
    private int id_producto,id_categoria;
    Conexion cn;

    public Inventario() {
    }

    public Inventario(int id_producto, int id_categoria, int id, String nombre_inventario) {
        super(id, nombre_inventario);
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
    }
    
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select i.id_inventario as id,i.nombre_inventario,p.nombre_prod,p.existencia,p.id_producto,cat.nombre_cat,cat.id_categoria from inventario as i inner join producto as p on i.id_producto = p.id_producto inner join categoria as cat on i.id_categoria = cat.id_categoria;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_inventario","nombre_prod","existencia","id_producto","nombre_cat","id_categoria"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_inventario");
          datos[2] = consulta.getString("nombre_prod");
          datos[3] = consulta.getString("existencia");
          datos[4] = consulta.getString("id_producto");
          datos[5] = consulta.getString("nombre_cat");
          datos[6] = consulta.getString("id_categoria");
          tabla.addRow(datos);
      }
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    
    
    @Override
    public int agregar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into inventario (nombre_inventario,id_producto,id_categoria) values (?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_inventario());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getId_categoria());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int modificar (){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update inventario set nombre_inventario = ?,id_producto = ?,id_categoria = ? where id_inventario = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_inventario());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getId_categoria());
            parametro.setInt(4,getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from inventario where id_inventario = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
}

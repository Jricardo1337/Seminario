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
import Modelo.Producto_c;
import Modelo.Compra;

/**
 *
 * @author Usuario
 */
public class Compra extends Datos2 {
    private int id_producto;
    Conexion cn;

    public Compra() {
    }

    public Compra(int id_producto, int id, int cantidad_compra, String nombre_compra, String fecha_compra) {
        super(id, cantidad_compra, nombre_compra, fecha_compra);
        this.id_producto = id_producto;
    }
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select c.id_compra as id, c.nombre_compra, c.cantidad_compra, c.fecha_compra, p.nombre_prod, p.id_producto from compra as c inner join producto as p on c.id_producto = p.id_producto;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_compra","cantidad_compra","fecha_compra","nombre_prod","id_producto"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[6];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_compra");
          datos[2] = consulta.getString("cantidad_compra");
          datos[3] = consulta.getString("fecha_compra");
          datos[4] = consulta.getString("nombre_prod");
          datos[5] = consulta.getString("id_producto");
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
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into compra (nombre_compra,cantidad_compra,fecha_compra,id_producto) values (?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_compra());
            parametro.setInt(2,getCantidad_compra());
            parametro.setString(3,getFecha_compra());
            parametro.setInt(4,getId_producto());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update compra set nombre_compra = ?,cantidad_compra = ?,fecha_compra = ?,id_producto = ? where id_compra = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_compra());
            parametro.setInt(2,getCantidad_compra());
            parametro.setString(3,getFecha_compra());
            parametro.setInt(4,getId_producto());
            parametro.setInt(5,getId());
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
            String query = "delete from compra where id_compra = ?;";
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

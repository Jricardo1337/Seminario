/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Producto_v;
import modelo.Venta;




/**
 *
 * @author Usuario
 */
public class Venta extends Operacion{
    private int id_producto; 
    Conexion cn;

    public Venta() { }

    public Venta(int id_producto, int id, int cantidad_venta, String nombre_venta, String fecha_venta) {
        super(id, cantidad_venta, nombre_venta, fecha_venta);
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
      String query = "select v.id_venta as id, v.nombre_venta, v.cantidad_venta, v.fecha_venta, p.nombre_prod, p.id_producto from venta as v inner join producto as p on v.id_producto = p.id_producto;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_venta","cantidad_venta","fecha_venta","nombre_prod","id_producto"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[6];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_venta");
          datos[2] = consulta.getString("cantidad_venta");
          datos[3] = consulta.getString("fecha_venta");
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
            String query = "INSERT INTO venta (nombre_venta,cantidad_venta,fecha_venta,id_producto) VALUES (?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_venta());
            parametro.setInt(2, getCantidad_venta());
            parametro.setString(3, getFecha_venta());
            parametro.setInt(4, getId_producto());
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
            String query = "UPDATE venta SET nombre_venta = ?,cantidad_venta= ?,fecha_venta= ?,id_producto= ? WHERE id_venta = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre_venta());
            parametro.setInt(2,getCantidad_venta());
            parametro.setString(3, getFecha_venta());
            parametro.setInt(4, getId_producto());
            parametro.setInt(5, getId());
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
            String query = "DELETE FROM venta WHERE id_venta = ?;";
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


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
import modelo.Inventario;
import modelo.Sucursal;


/**
 *
 * @author Usuario
 */
public class Sucursal extends Tienda {
    private int id_inventario;
    Conexion cn; 

    public Sucursal() {}

    public Sucursal(int id_inventario, int id, int telefono, String nombre_sucursal, String direccion) {
        super(id, telefono, nombre_sucursal, direccion);
        this.id_inventario = id_inventario;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
     try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select s.id_sucursal as id, s.nombre_sucursal, s.direccion, s.telefono, i.nombre_inventario, i.id_inventario from sucursal as s inner join inventario as i on s.id_inventario = i.id_inventario;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_sucursal","direccion","telefono","nombre_inventario","id_inventario"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[6];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_sucursal");
          datos[2] = consulta.getString("direccion");
          datos[3] = consulta.getString("telefono");
          datos[4] = consulta.getString("nombre_inventario");
          datos[5] = consulta.getString("id_inventario");
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
            String query = "INSERT INTO sucursal (nombre_sucursal,direccion,telefono,id_inventario) VALUES (?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre_sucursal());
            parametro.setString(2, getDireccion());
            parametro.setInt(3, getTelefono());
            parametro.setInt(4, getId_inventario());
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
            String query = "UPDATE sucursal SET nombre_sucursal = ?,direccion= ?,telefono= ?,id_inventario= ? WHERE id_sucursal = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre_sucursal());
            parametro.setString(2, getDireccion());
            parametro.setInt(3, getTelefono());
            parametro.setInt(4, getId_inventario());
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
            String query = "DELETE FROM sucursal WHERE id_sucursal = ?;";
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

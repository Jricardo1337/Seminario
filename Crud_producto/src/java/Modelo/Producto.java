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
import Modelo.Liquidacion;
import Modelo.Oferta;
import Modelo.Datos4;
import Modelo.Producto;
/**
 *
 * @author Usuario
 */
public class Producto extends Datos4 {
    private int id_oferta,id_liquidacion;
    Conexion cn;

    public Producto() {
    }

    public Producto(int id_oferta, int id_liquidacion, int id, int precio_costo, int precio_venta, int existencia, String nombre_prod, String descripcion, String marca) {
        super(id, precio_costo, precio_venta, existencia, nombre_prod, descripcion, marca);
        this.id_oferta = id_oferta;
        this.id_liquidacion = id_liquidacion;
    }
    

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public int getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(int id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select p.id_producto as id,p.nombre_prod,p.descripcion,p.precio_costo,p.precio_venta,p.marca,p.existencia,o.tipo_oferta,o.id_oferta,l.nombre_liquidacion,l.id_liquidacion from producto as p inner join oferta as o on p.id_oferta = o.id_oferta inner join liquidacion as l on p.id_liquidacion = l.id_liquidacion;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_prod","descripcion","precio_costo","precio_venta","marca","existencia","tipo_oferta","id_oferta","nombre_liquidacion","id_liquidacion"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[11];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_prod");
          datos[2] = consulta.getString("descripcion");
          datos[3] = consulta.getString("precio_costo");
          datos[4] = consulta.getString("precio_venta");
          datos[5] = consulta.getString("marca");
          datos[6] = consulta.getString("existencia");
          datos[7] = consulta.getString("tipo_oferta");
          datos[8] = consulta.getString("id_oferta");
          datos[9] = consulta.getString("nombre_liquidacion");
          datos[10] = consulta.getString("id_liquidacion");
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
            String query = "insert into producto (nombre_prod,descripcion,precio_costo,precio_venta,marca,existencia,id_oferta,id_liquidacion) values (?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_prod());
            parametro.setString(2,getDescripcion());
            parametro.setInt(3,getPrecio_costo());
            parametro.setInt(4,getPrecio_venta());
            parametro.setString(5,getMarca());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_oferta());
            parametro.setInt(8,getId_liquidacion());
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
            String query = "update producto set nombre_prod = ?,descripcion= ?,precio_costo = ?,precio_venta = ?,marca = ?,existencia= ?,id_oferta = ?,id_liquidacion = ? where id_producto = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_prod());
            parametro.setString(2,getDescripcion());
            parametro.setInt(3,getPrecio_costo());
            parametro.setInt(4,getPrecio_venta());
            parametro.setString(5,getMarca());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_oferta());
            parametro.setInt(8,getId_liquidacion());
            parametro.setInt(9,getId());
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
            String query = "delete from producto where id_producto = ?;";
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

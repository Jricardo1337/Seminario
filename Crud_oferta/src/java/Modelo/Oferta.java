/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Oferta extends Datos{
    Conexion cn;

    public Oferta() {
    }

    public Oferta(int id, String nombre_oferta, String tipo_oferta, String fecha_inicio_o, String fecha_fin_o) {
        super(id, nombre_oferta, tipo_oferta, fecha_inicio_o, fecha_fin_o);
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
        try{
        cn = new Conexion();
        cn.abrir_conexion();
      String query = "select o.id_oferta as id, o.nombre_oferta, o.tipo_oferta, o.fecha_inicio_o, o.fecha_fin_o from oferta as o;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_oferta","tipo_oferta","fecha_inicio_o","fecha_fin_o"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[5];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_oferta");
          datos[2] = consulta.getString("tipo_oferta");
          datos[3] = consulta.getString("fecha_inicio_o");
          datos[4] = consulta.getString("fecha_fin_o");
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
            String query ="insert into oferta(nombre_oferta,tipo_oferta,fecha_inicio_o,fecha_fin_o) values(?,?,?,?);"; 
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString((1), getNombre_oferta());
            parametro.setString((2), getTipo_oferta());
            parametro.setString((3), getFecha_inicio_o());
            parametro.setString((4), getFecha_fin_o());
            
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
            String query = "update oferta set nombre_oferta = ?, tipo_oferta = ?, fecha_inicio_o = ?, fecha_fin_o = ? where id_oferta = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre_oferta());
            parametro.setString(2, getTipo_oferta());
            parametro.setString(3, getFecha_inicio_o());
            parametro.setString(4, getFecha_fin_o());
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
            String query = "delete from oferta where id_oferta = ?;";
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

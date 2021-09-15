/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Liquidacion extends Objeto {
Conexion cn;

    public Liquidacion() {
    }

    public Liquidacion(int id, String nombre_liquidacion, String fecha_inicio_l, String fecha_fin_l) {
        super(id, nombre_liquidacion, fecha_inicio_l, fecha_fin_l);
    }



    
      public DefaultTableModel leer(){
      DefaultTableModel tabla = new DefaultTableModel();
      try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select l.id_liquidacion as id,l.nombre_liquidacion, l.fecha_inicio_l, l.fecha_fin_l from liquidacion as l;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_liquidacion","fecha_inicio_l","fecha_fin_l"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[4];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_liquidacion");
          datos[2] = consulta.getString("fecha_inicio_l");
          datos[3] = consulta.getString("fecha_fin_l");
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
            String query ="insert into liquidacion(nombre_liquidacion, fecha_inicio_l, fecha_fin_l) values(?,?,?);"; 
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString((1),getNombre_liquidacion());
            parametro.setString((2),getFecha_inicio_l());
            parametro.setString((3),getFecha_fin_l());
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
            String query = "update liquidacion set nombre_liquidacion= ?, fecha_inicio_l= ?, fecha_fin_l= ? where id_liquidacion = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre_liquidacion());
            parametro.setString(2, getFecha_inicio_l());
            parametro.setString(3, getFecha_fin_l());
            parametro.setInt(4, getId());
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
            String query = "delete from liquidacion where id_liquidacion = ?;";
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


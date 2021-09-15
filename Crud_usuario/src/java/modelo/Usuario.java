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
public class Usuario extends Persona {
    Conexion cn;

    public Usuario() {
    }

    public Usuario(int id, String nombre_usuario, String contrasena, String rol) {
        super(id, nombre_usuario, contrasena, rol);
    }
    
    
        public DefaultTableModel leer(){
      DefaultTableModel tabla = new DefaultTableModel();
      try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select u.id_usuario as id,u.nombre_usuario, u.contrasena, u.rol from usuario as u;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_usuario","contrasena","rol"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[4];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_usuario");
          datos[2] = consulta.getString("contrasena");
          datos[3] = consulta.getString("rol");
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
            String query ="insert into usuario(nombre_usuario, contrasena, rol) values(?,?,?);"; 
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString((1),getNombre_usuario());
            parametro.setString((2),getContrasena());
            parametro.setString((3),this.getRol());
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
            String query = "update usuario set nombre_usuario= ?, contrasena= ?, rol= ? where id_usuario = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_usuario());
            parametro.setString(2,getContrasena());
            parametro.setString(3, getRol());
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
            String query = "delete from usuario where id_usuario= ?;";
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

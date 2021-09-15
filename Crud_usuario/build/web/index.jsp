<%-- 
    Document   : index
    Created on : 14/09/2021, 06:39:50 PM
    Author     : Usuario
--%>
<%@page import="modelo.Usuario" %>
<%@page import="modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario de liquidacion</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_usuario" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_usuario" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_usuario" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                
                <label for="lbl_nombre_usuario" ><b>Nombre usuario</b></label>
                <input type="text" name="txt_nombre_usuario" id="txt_nombre_usuario" class="form-control" placeholder="" required>
                
                <label for="lbl_contrasena" ><b>Contraseña</b></label>
                <input type="password" name="txt_contrasena" id="txt_contrasena" class="form-control" placeholder="" required>
                
                <label for="lbl_rol" ><b>Rol de usuario </b></label>
                <input type="text" name="txt_rol" id="txt_rol" class="form-control" placeholder="" required>
                
                <br>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-success btn-lg">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar"  value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
                <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
            </div>
            </div>
            </div>
            </div>
        
        
           
    <table class="table table-striped">
    <thead>
      <tr>
        <th>nombre usuario</th>
        <th>contraseña</th>
        <th>rol</th>
      </tr>
    </thead>
    <tbody id="tbl_usuario">
        <% 
        Usuario usuario = new Usuario();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = usuario.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id="+ tabla.getValueAt(t,0) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("</tr>");
        
        }
        %>
      
    </tbody>
  </table>
  </div>
      

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript">
    function limpiar(){
       $("#txt_id").val(0);
       $("#txt_nombre_usuario").val('');
       $("#txt_contrasena").val('');
       $("#txt_rol").val('');
        
    }
    
    $('#tbl_usuario').on('click','tr td',function(evt){
       var target,id,nombre_usuario,contrasena,rol; 
       target = $(event.target);
       id = target.parent().data('id');
       nombre_usuario = target.parent("tr").find("td").eq(0).html();
       contrasena = target.parent("tr").find("td").eq(1).html();
       rol = target.parent("tr").find("td").eq(2).html();
       $("#txt_id").val(id);
       $("#txt_nombre_usuario").val(nombre_usuario);
       $("#txt_contrasena").val(contrasena);
       $("#txt_rol").val(rol);
       $("#modal_usuario").modal('show');
    });
    
</script>
    </body>
</html>

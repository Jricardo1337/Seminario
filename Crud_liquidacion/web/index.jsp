<%-- 
    Document   : index
    Created on : 14/09/2021, 02:44:58 PM
    Author     : Usuario
--%>
<%@page import="modelo.Liquidacion" %>
<%@page import="modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario de liquidacion</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_liquidacion" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_liquidacion" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_liquidacion" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                
                <label for="lbl_nombre_liquidacion" ><b>Nombre de liquidacion</b></label>
                <input type="text" name="txt_nombre_liquidacion" id="txt_nombre_liquidacion" class="form-control" placeholder="" required>
                
                <label for="lbl_fecha_inicio_l" ><b>fecha inicio de liquidacion</b></label>
                <input type="date" name="txt_fecha_inicio_l" id="txt_fecha_inicio_l" class="form-control" placeholder="" required>
                
                <label for="lbl_fecha_fin_l" ><b>fecha fin de liquidacion </b></label>
                <input type="date" name="txt_fecha_fin_l" id="txt_fecha_fin_l" class="form-control" placeholder="año-mes-dia" required>
                
                <br>
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
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
        <th>nombre liquidacion</th>
        <th>fecha inicio</th>
        <th>feccha fin</th>
      </tr>
    </thead>
    <tbody id="tbl_liquidacion">
        <% 
        Liquidacion liquidacion = new Liquidacion();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = liquidacion.leer();
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
       $("#txt_nombre_liquidacion").val('');
       $("#txt_fecha_inicio_l").val('');
       $("#txt_fecha_fin_l").val('');
        
    }
    
    $('#tbl_liquidacion').on('click','tr td',function(evt){
       var target,id,nombre_liquidacion,fecha_inicio_l,fecha_fin_l; 
       target = $(event.target);
       id = target.parent().data('id');
       nombre_liquidacion = target.parent("tr").find("td").eq(0).html();
       fecha_inicio_l = target.parent("tr").find("td").eq(1).html();
       fecha_fin_l = target.parent("tr").find("td").eq(2).html();
       $("#txt_id").val(id);
       $("#txt_nombre_liquidacion").val(nombre_liquidacion);
       $("#txt_fecha_inicio_l").val(fecha_inicio_l);
       $("#txt_fecha_fin_l").val(fecha_fin_l);
       $("#modal_liquidacion").modal('show');
    });
    
</script>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 8/09/2021, 06:06:23 PM
    Author     : Usuario
--%>
<%@page import="Modelo.Oferta" %>
<%@page import="Modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario de Ofertas</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_oferta" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_oferta" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_oferta" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly>
                
                <label for="lbl_nombre_oferta" ><b>nombre oferta</b></label>
                <input type="text" name="txt_nombre_oferta" id="txt_nombre_oferta" class="form-control" required>
                
                <label for="lbl_tipo_oferta" ><b>tipo de oferta</b></label>
                <input type="text" name="txt_tipo_oferta" id="txt_tipo_oferta" class="form-control" required>
                
                <label for="lbl_fecha_inicio_o" ><b>inicio de oferta</b></label>
                <input type="date" name="txt_fecha_inicio_o" id="txt_fecha_inicio_o" class="form-control" required>
                
                <label for="lbl_fecha_fin_o" ><b>final de oferta</b></label>
                <input type="date" name="txt_fecha_fin_o" id="txt_fecha_fin_o" class="form-control" required>
                
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
        <th>nombre oferta</th>
        <th>tipo de oferta</th>
        <th>inicio de oferta</th>
        <th>final de oferta</th>
      </tr>
    </thead>
    <tbody id="tbl_oferta">
        <% 
        Oferta oferta = new Oferta();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = oferta.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + ">");
            out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
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
       $("#txt_nombre_oferta").val('');
       $("#txt_tipo_oferta").val('');
       $("#txt_fecha_inicio_o").val('');
       $("#txt_fecha_fin_o").val('');
    }
    
    $('#tbl_oferta').on('click','tr td',function(evt){
       var target,id,nombre_oferta,tipo_oferta,fecha_inicio_o,fecha_fin_o; 
       target = $(event.target);
       id = target.parent().data('id');
       nombre_oferta = target.parent("tr").find("td").eq(0).html();
       tipo_oferta = target.parent("tr").find("td").eq(1).html();
       fecha_inicio_o = target.parent("tr").find("td").eq(2).html();
       fecha_fin_o = target.parent("tr").find("td").eq(3).html();
       $("#txt_id").val(id);
       $("#txt_nombre_oferta").val(nombre_oferta);
       $("#txt_tipo_oferta").val(tipo_oferta);
       $("#txt_fecha_inicio_o").val(fecha_inicio_o);
       $("#txt_fecha_fin_o").val(fecha_fin_o);
       $("#modal_oferta").modal('show');
    });
    
</script>
    </body>
</html>

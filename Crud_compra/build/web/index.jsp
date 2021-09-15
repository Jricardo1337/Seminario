<%-- 
    Document   : index
    Created on : 9/09/2021, 11:35:15 AM
    Author     : Usuario
--%>
<%@page import="Modelo.Compra" %>
<%@page import="Modelo.Producto_c" %>
<%@page import="Modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario de Compras</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_compra" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_compra" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_compra" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                
                <label for="lbl_nombre_compra" ><b>nombre de la compra</b></label>
                <input type="text" name="txt_nombre_compra" id="txt_nombre_compra" class="form-control" placeholder="Ejemplo: compra 1" required>
                
                <label for="lbl_cantidad_compra" ><b>cantidad comprada</b></label>
                <input type="number" name="txt_cantidad_compra" id="txt_cantidad_compra" class="form-control" placeholder="Ejemplo: 15" required>
                
                <label for="lbl_fecha_compra" ><b>fecha compra</b></label>
                <input type="date"  name="txt_fecha_compra" id="txt_fecha_compra" class="form-control" placeholder="Ejemplo: 2021-09-01" required>
                
                <label for="lbl_producto_c" ><b>producto</b></label>
                <select name="drop_producto_c" id="drop_producto_c" class="form-control">
                    <% 
                        Producto_c producto_c = new Producto_c();
                        HashMap<String,String> drop = producto_c.drop_producto_c();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                    %>
                </select>
                
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
        <th>nombre de la compra</th>
        <th>cantidad comprada</th>
        <th>fecha compra</th>
        <th>producto</th>
      </tr>
    </thead>
    <tbody id="tbl_compra">
        <% 
        Compra compra = new Compra();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = compra.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,5) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
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
       $("#txt_nombre_compra").val('');
       $("#txt_cantidad_compra").val('');
       $("#txt_fecha_compra").val('');
       $("#drop_producto_c").val(0);
       
    }
    
    $('#tbl_compra').on('click','tr td',function(evt){
       var target,id,id_p,nombre_compra,cantidad_compra,fecha_compra; 
       target = $(event.target);
       id = target.parent().data('id');
       id_p = target.parent().data('id_p'); 
       nombre_compra = target.parent("tr").find("td").eq(0).html();
       cantidad_compra = target.parent("tr").find("td").eq(1).html();
       fecha_compra = target.parent("tr").find("td").eq(2).html();
       $("#txt_id").val(id);
       $("#txt_nombre_compra").val(nombre_compra);
       $("#txt_cantidad_compra").val(cantidad_compra);
       $("#txt_fecha_compra").val(fecha_compra);
       $("#drop_producto_c").val(id_p);
       $("#modal_compra").modal('show');
    });
    
</script>
    </body>
</html>

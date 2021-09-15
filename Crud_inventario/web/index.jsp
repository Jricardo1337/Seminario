<%-- 
    Document   : index
    Created on : 14/09/2021, 05:01:45 PM
    Author     : Usuario
--%>
<%@page import="Modelo.Inventario" %>
<%@page import="Modelo.Categoria_i" %>
<%@page import="Modelo.Producto_i" %>
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
        <h1>Formulario de Inventarios</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_inventario" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_inventario" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_inventario" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly>
                
                <label for="lbl_nombre_inventario" ><b>Nombre del Inventario</b></label>
                <input type="text" name="txt_nombre_inventario" id="txt_nombre_inventario" class="form-control" placeholder="Ejemplo: Mermelada" required>
                
                <label for="lbl_producto_i" ><b>Productos del inventario</b></label>
                <select name="drop_producto_i" id="drop_producto_i" class="form-control">
                    <% 
                        Producto_i producto_i = new Producto_i();
                        HashMap<String,String> drop1 = producto_i.drop_producto_i();
                         for (String i:drop1.keySet()){
                             out.println("<option value='" + i + "'>" + drop1.get(i) + "</option>");
                         }
                    %>
                </select>
                
                <label for="lbl_categoria_i" ><b>Categoria de producto</b></label>
                <select name="drop_categoria_i" id="drop_categoria_i" class="form-control">
                    <% 
                        Categoria_i categoria_i = new Categoria_i();
                        HashMap<String,String> drop2 = categoria_i.drop_categoria_i();
                         for (String i:drop2.keySet()){
                             out.println("<option value='" + i + "'>" + drop2.get(i) + "</option>");
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
        <th>Nombre inventario</th>
        <th>Producto</th>
        <th>Existencia</th>
        <th>Categoria</th>
      </tr>
    </thead>
    <tbody id="tbl_producto">
        <% 
        Inventario inventario = new Inventario();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = inventario.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,4) + " data-id_cat=" + tabla.getValueAt(t,6) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
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
       $("#txt_nombre_inventario").val('');
       $("#drop_producto_i").val(0);
       $("#drop_categoria_i").val(0);
       
    }
    
    $('#tbl_producto').on('click','tr td',function(evt){
       var target,id,id_p,id_cat,nombre_inventario; 
       target = $(event.target);
       id = target.parent().data('id');
       id_p = target.parent().data('id_p');
       id_cat = target.parent().data('id_cat'); 
       nombre_inventario = target.parent("tr").find("td").eq(0).html();
       $("#txt_id").val(id);
       $("#txt_nombre_inventario").val(nombre_inventario);
       $("#drop_producto_i").val(id_p);
       $("#drop_categoria_i").val(id_cat);
       $("#modal_inventario").modal('show');
    });
    
</script>
    </body>
</html>

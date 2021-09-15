<%-- 
    Document   : index
    Created on : 9/09/2021, 11:35:02 AM
    Author     : Usuario
--%>
<%@page import="modelo.Venta" %>
<%@page import="modelo.Producto_v" %>
<%@page import="modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario de ventas</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_venta" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_venta" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_venta" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                
                <label for="lbl_nombre_venta" ><b>Nombre de la venta</b></label>
                <input type="text" name="txt_nombre_venta" id="txt_nombre_venta" class="form-control" placeholder="" required>
                
                <label for="lbl_cantidad_venta" ><b>Cantidad de productos </b></label>
                <input type="number" name="txt_cantidad_venta" id="txt_cantidad_venta" class="form-control" placeholder="" required>
                
                <label for="lbl_fecha_venta" ><b>fecha </b></label>
                <input type="date" name="txt_fecha_venta" id="txt_fecha_venta" class="form-control" placeholder="año-mes-dia" required>
                
                <label for="lbl_producto" ><b>Producto</b></label>
                <select name="drop_producto_v" id="drop_producto_v" class="form-control">
                    <% 
                        Producto_v producto_v = new Producto_v();
                        HashMap<String,String> drop = producto_v.drop_producto_v();
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
        <th>nombre venta</th>
        <th>cantidad de producto</th>
        <th>fecha</th>
        <th>producto</th>
      </tr>
    </thead>
    <tbody id="tbl_venta">
        <% 
        Venta venta = new Venta();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = venta.leer();
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
       $("#txt_nombre_venta").val('');
       $("#txt_cantidad_venta").val('');
       $("#txt_fecha_venta").val('');
       $("#drop_producto_v").val(1);
       
    }
    
    $('#tbl_venta').on('click','tr td',function(evt){
       var target,id,id_p,nombre_venta,cantidad_venta,fecha_venta; 
       target = $(event.target);
       id = target.parent().data('id');
       id_p = target.parent().data('id_p'); 
       nombre_venta = target.parent("tr").find("td").eq(0).html();
       cantidad_venta = target.parent("tr").find("td").eq(1).html();
       fecha_venta = target.parent("tr").find("td").eq(2).html();
       $("#txt_id").val(id);
       $("#txt_nombre_venta").val(nombre_venta);
       $("#txt_cantidad_venta").val(cantidad_venta);
       $("#txt_fecha_venta").val(fecha_venta);
       $("#drop_producto_v").val(id_p);
       $("#modal_venta").modal('show');
    });
    
</script>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 14/09/2021, 12:22:54 PM
    Author     : Usuario
--%>
<%@page import="Modelo.Producto" %>
<%@page import="Modelo.Oferta" %>
<%@page import="Modelo.Liquidacion" %>
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
        <h1>Formulario Productos</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_producto" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_producto" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_producto2" method="post" class="form-group">
                
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly>
                
                <label for="lbl_nombre_prod" ><b>Nombre del Producto</b></label>
                <input type="text" name="txt_nombre_prod" id="txt_nombre_prod" class="form-control" placeholder="Ejemplo: Mermelada" required>
                
                <label for="lbl_descripcion" ><b>Descripcion</b></label>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: Condimento" required>
                
                <label for="lbl_precio_costo" ><b>Precio Costo</b></label>
                <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control" placeholder="Ejemplo: 15" required>
                
                <label for="lbl_precio_venta" ><b>Precio Venta</b></label>
                <input type="number"  name="txt_precio_venta" id="txt_precio_venta" class="form-control" placeholder="Ejemplo: 20" required>
                
                <label for="lbl_marca" ><b>Marca</b></label>
                <input type="text" name="txt_marca" id="txt_marca" class="form-control" placeholder="Ejemplo: B&B" required>
                
                <label for="lbl_existencia" ><b>Existencia</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Ejemplo: 555" required>
                
                <label for="lbl_oferta" ><b>Oferta</b></label>
                <select name="drop_oferta" id="drop_oferta" class="form-control">
                    <% 
                        Oferta oferta = new Oferta();
                        HashMap<String,String> drop1 = oferta.drop_oferta();
                         for (String i:drop1.keySet()){
                             out.println("<option value='" + i + "'>" + drop1.get(i) + "</option>");
                         }
                    %>
                </select>
                
                <label for="lbl_liquidacion" ><b>Liquidacion</b></label>
                <select name="drop_liquidacion" id="drop_liquidacion" class="form-control">
                    <% 
                        Liquidacion liquidacion = new Liquidacion();
                        HashMap<String,String> drop2 = liquidacion.drop_liquidacion();
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
        <th>Nombre producto</th>
        <th>Descripcion</th>
        <th>Precio costo</th>
        <th>Precio venta</th>
        <th>Marca</th>
        <th>Existencia</th>
        <th>Oferta</th>
        <th>Liquidacion</th>
      </tr>
    </thead>
    <tbody id="tbl_producto">
        <% 
        Producto producto = new Producto();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = producto.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_o=" + tabla.getValueAt(t,8) + " data-id_l=" + tabla.getValueAt(t,10) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,9) + "</td>");
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
       $("#txt_nombre_prod").val('');
       $("#txt_descripcion").val('');
       $("#txt_precio_costo").val('');
       $("#txt_precio_venta").val('');
       $("#txt_marca").val('');
       $("#txt_existencia").val('');
       $("#drop_oferta").val(0);
       $("#drop_liquidacion").val(0);
       
    }
    
    $('#tbl_producto').on('click','tr td',function(evt){
       var target,id,id_o,id_l,nombre_prod,descripcion,precio_costo,precio_venta,marca,existencia; 
       target = $(event.target);
       id = target.parent().data('id');
       id_o = target.parent().data('id_o');
       id_l = target.parent().data('id_l'); 
       nombre_prod = target.parent("tr").find("td").eq(0).html();
       descripcion= target.parent("tr").find("td").eq(1).html();
       precio_costo = target.parent("tr").find("td").eq(2).html();
       precio_venta = target.parent("tr").find("td").eq(3).html();
       marca = target.parent("tr").find("td").eq(4).html();
       existencia = target.parent("tr").find("td").eq(5).html();
       $("#txt_id").val(id);
       $("#txt_nombre_prod").val(nombre_prod);
       $("#txt_descripcion").val(descripcion);
       $("#txt_precio_costo").val(precio_costo);
       $("#txt_precio_venta").val(precio_venta);
       $("#txt_marca").val(marca);
       $("#txt_existencia").val(existencia);
       $("#drop_oferta").val(id_o);
       $("#drop_liquidacion").val(id_l);
       $("#modal_producto").modal('show');
    });
    
</script>
    </body>
</html>

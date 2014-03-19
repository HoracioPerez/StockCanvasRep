<%-- 
    Document   : new_product
    Created on : Feb 24, 2014, 10:59:27 AM
    Author     : Liam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String id = request.getParameter("id");
%>
<script>
    $(document).ready(function(){ 
        $( "#button_<%out.print(id);%>" ).button();
        $("#form_<%out.print(id);%>").submit(function(e) {
            e.preventDefault(); //STOP default action
            var result = $(this).next("div");
            var formFiels = $(this).serializeArray();
            $.ajax({
                url: "ProductServiceInsert",
                type: "POST",
                data: formFiels,
                success: function(data) {
                    var highlight="<div class='ui-state-highlight ui-corner-all' style='margin-top: 20px; padding: 0 .7em;'>"
                        +"<p><span class='ui-icon ui-icon-info' style='float: left; margin-right: .3em;'></span>"
                        +"<strong>Producto creado</strong> Codigo "+data+"</p>"
                        +"</div>";
                    result.html(highlight);
                },
                error: function() {
                    var error="<div class='ui-widget'><div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>"
                        +"<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span>"
                        +"<strong>Alerta:</strong> Error ajax</p></div></div>";
                    result.html(error);
                }
            });
            $(this)[0].reset();    
        });  
    });
</script>

<form id="form_<%out.print(id);%>" action="#" method="POST">
    <input class="text_input" type="text" name="name"  placeholder="Nombre" /><br/>
    <input class="text_input" type="text" name="price"  placeholder="Precio" /><br/>
    <textarea class="text_input" type="textarea" name="summary"  placeholder="Detalle" ></textarea><br/>
    <select class="combo_box" name="category" id="combo_<%out.print(id);%>">
        <option value=""  placeholder="Categoria"></option>
        <option value="1">Placas</option>
        <option value="2">Sensores</option>
        <option value="3">Cables</option>
        <option value="4">Modulos</option>
    </select>
    <input class="button"  id="button_<%out.print(id);%>" type="submit" name="submit" value="Crear" />
</form>

<div></div>

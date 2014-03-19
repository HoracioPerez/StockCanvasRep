<%-- 
    Document   : new_category
    Created on : Feb 24, 2014, 11:00:08 AM
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
                url: "CategoryServiceInsert",
                type: "POST",
                data: formFiels,
                dataType: "json",
                success: function(data) {
                    var highlight="<div class='ui-state-highlight ui-corner-all' style='margin-top: 20px; padding: 0 .7em;'>"
                        +"<p><span class='ui-icon ui-icon-info' style='float: left; margin-right: .3em;'></span>"
                        +"<strong>Categoria creada</strong> Codigo "+data.id+"</p>"
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
    <textarea class="text_input" type="textarea" name="summary"  placeholder="Detalle" ></textarea><br/>
    <input class="button" id="button_<%out.print(id);%>" type="submit" name="submit" value="Crear" />
</form>

<div></div>
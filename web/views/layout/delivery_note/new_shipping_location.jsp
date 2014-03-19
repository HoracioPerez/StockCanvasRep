<%-- 
    Document   : neW_shipping_location
    Created on : 15-mar-2014, 2:31:40
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id_win = request.getParameter("id_win");
    String id_client = request.getParameter("id_client");
%>
<script>
    $(document).ready(function(){
        $(".hide").prop('disabled', true);
        $("#button_<%out.print(id_win);%>").button();
        $("#form_<%out.print(id_win);%>").submit(function(e) {
            e.preventDefault(); //STOP default action
            var result = $(this).next("div");
            var formFiels = $(this).serializeArray();
            $.ajax({
                url: "ShippingLocationServiceInsert",
                type: "POST",
                data: formFiels,
                success: function(data) {
                    var highlight="<div class='ui-state-highlight ui-corner-all' style='margin-top: 20px; padding: 0 .7em;'>"
                        +"<p><span class='ui-icon ui-icon-info' style='float: left; margin-right: .3em;'></span>"
                        +"<strong>Datos de envio creados</strong> Codigo "+data+"</p>"
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

<form id="form_<%out.print(id_win);%>" action="#" method="POST">
    <input class="hide" type="text" name="client_id" value="<%out.print(id_client);%>"/><br/>
    <input class="text_input" type="text" name="contact_name"  placeholder="Nombre de contacto"/><br/>
    <input class="text_input" type="text" name="street"  placeholder="Direccion"/><br/>   
    <input class="text_input" type="text" name="cp"  placeholder="Codigo postal"/><br/> 
    <input class="text_input" type="text" name="province"  placeholder="Provincia"/><br/>
    <input class="text_input" type="text" name="country"  placeholder="Pais"/><br/> 
    <input class="text_input" type="text" name="time"  placeholder="Horario"/><br/> 
    <input class="button" id="button_<%out.print(id_win);%>" type="submit" name="submit" value="Crear" />
</form>


<div class="ui-widget">

</div>
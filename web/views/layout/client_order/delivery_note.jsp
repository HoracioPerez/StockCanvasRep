<%-- 
    Document   : new_delivery_note
    Created on : 28-feb-2014, 0:08:15
    Author     : Horacio Perez
--%>

<%@page import="entity.simple.ShippingMethod"%>
<%@page import="form.DeliveryNote"%>
<%@page import="entity.ShippingLocation"%>
<%@page import="entity.Client"%>
<%@page import="form.ClientOrder"%>
<%@page import="dao.form.DAOClientOrder"%>
<%@page import="java.sql.Date"%>
<%@page import="form.Reservation"%>
<%@page import="dao.form.DAOReservation"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAOClientOrder dAOClientOrder = new DAOClientOrder(user);
    ClientOrder clientOrder = dAOClientOrder.getById(id_order);
    DeliveryNote deliveryNote = clientOrder.getDeliveryNote();
    Client client = clientOrder.getClient();
    String clientId = "";
    String deliveryNoteId = "";
    if (client != null) {
        clientId = client.getId();
    }
    if (deliveryNote != null) {
        deliveryNoteId=deliveryNote.getId();
    }

%>
<script>  
    $(document).ready(function(){ 
        
        //////HIDE//////
        $(".camp").prop('disabled', true);
        $("#delivery_note_alert_<%out.print(id_win);%>").css('display', 'none');       
        $("#delivery_note_information_<%out.print(id_win);%>").css('display', 'none');
        $("#create_delivery_note_<%out.print(id_win);%>").css('display', 'none'); 
        $("#set_delivery_note_<%out.print(id_win);%>").css('display', 'none'); 
        
        //////VALIDATION-SHOW//////
        
        if("<%out.print(clientId);%>"==""){
            $("#alert_<%out.print(id_win);%>").html("No hay un cliente seleccionado"); 
            $("#delivery_note_alert_<%out.print(id_win);%>").css('display', 'block');
        }else{
            $("#set_delivery_note_<%out.print(id_win);%>").css('display', 'block'); 
            if("<%out.print(deliveryNoteId);%>"==""){
                $("#create_delivery_note_<%out.print(id_win);%>").css('display', 'block');
            }else{
                $( "#delivery_note_information_<%out.print(id_win);%>").css('display', 'block'); 
            }
        }
        
        //////BUTTONS//////
        
        $("#select_shipping_location_<%out.print(id_win);%>").button();
        $("#add_shipping_location_<%out.print(id_win);%>").button();
        $("#select_shipping_method_<%out.print(id_win);%>").button();
        $("#new_delivery_note_<%out.print(id_win);%>").button();
        
        //////SELECT SHIPPING LOCATION//////      
        
        $("#select_shipping_location_<%out.print(id_win);%>").click(function() {
            var subWinId=0;
            var url2="views/layout/detail_product/client_order_product_detail.jsp"; 
            $.newModal(
            '<%out.print(id_win);%>'+subWinId++, 
            "Detalle", 
            url2+"?id_father_win="+'<%out.print(id_win);%>'+"&id_order="+"<%out.print(id_order);%>"+"&id_win="+'<%out.print(id_win);%>'+subWinId);    
        });
        
        //////NEW SHIPPING LOCATION//////      
        
        $("#add_shipping_location_<%out.print(id_win);%>").click(function() {
            var subWinId=0;
            var url2="views/layout/delivery_note/new_shipping_location.jsp";  
            $.newModal(
            '<%out.print(id_win);%>'+subWinId++, 
            "Datos de envio", 
            url2+"?id_father_win="+'<%out.print(id_win);%>'+"&id_order="+"<%out.print(id_order);%>"+"&id_win="+'<%out.print(id_win);%>'+subWinId);  
        });
        
        
        //////SHIPPING METHOD//////      
        
        $("#select_shipping_method_<%out.print(id_win);%>").click(function() {
            var subWinId=0;
            var url2="views/layout/detail_product/client_order_product_detail.jsp";  
            $.newModal(
            '<%out.print(id_win);%>'+subWinId++, 
            "Detalle", 
            url2+"?id_father_win="+'<%out.print(id_win);%>'+"&id_order="+"<%out.print(id_order);%>"+"&id_win="+'<%out.print(id_win);%>'+subWinId);  
        });
        
        
        //////NEW//////      
        
        $("#new_delivery_note_<%out.print(id_win);%>").click(function() {
            $.ajax( {
                "type": "POST",
                "url": "DeliveryNoteServiceInsert?idOrder=<%out.print(id_order);%>",                           
                "success": function (code){
                    alert(code);            
                } 
            } );  
        });
        
       
       
    });   
</script>  

<div id="delivery_note_alert_<%out.print(id_win);%>">
    <div class='ui-widget'>
        <div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>
            <p>
                <span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span>
                <strong>Alerta:</strong> <div id="alert_<%out.print(id_win);%>"></div>
            </p>
        </div>
    </div>
</div>
<div id="create_delivery_note_<%out.print(id_win);%>">   
    <input class="button" id="new_delivery_note_<%out.print(id_win);%>" type="button" value="Crear Remito" />    
</div>

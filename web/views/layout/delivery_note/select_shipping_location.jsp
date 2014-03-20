<%-- 
    Document   : select_shipping_location
    Created on : 15-mar-2014, 2:31:05
    Author     : Horacio Perez
--%>
<%@page import="entity.ShippingLocation"%>
<%@page import="form.DeliveryNote"%>
<%@page import="dao.form.DAODeliveryNote"%>
<%@page import="entity.User"%>
<%
    String id_delivery_note = request.getParameter("id_delivery_note");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAODeliveryNote dAODeliveryNote = new DAODeliveryNote(user);
    DeliveryNote deliveryNote = dAODeliveryNote.getById(id_delivery_note);
    ShippingLocation shippingLocation = deliveryNote.getShippingLocation();
    String shipping_location_id = shippingLocation.getId();
    String shipping_location_contact_name = shippingLocation.getContactName();
    String shipping_location_street = shippingLocation.getStreet();
    String shipping_location_cp = shippingLocation.getCp();
    String shipping_location_province = shippingLocation.getProvince();
    String shipping_location_country = shippingLocation.getCountry();
    String shipping_location_time = shippingLocation.getTime();
%>
<script>
    
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
</script>
<form id="form_shipping_location_<%out.print(id_win);%>" action="#" method="POST">
    <input class="camp" type="text" name="shipping_location_id"  placeholder="ID" value="<%out.print(shipping_location_id);%>"/><br/>
    <input class="text_input" type="text" name="shipping_location_contact_name"  placeholder="Nombre de contacto" value="<%out.print(shipping_location_contact_name);%>"/><br/>
    <input class="text_input" type="text" name="shipping_location_street"  placeholder="Direccion" value="<%out.print(shipping_location_street);%>"/><br/>   
    <input class="text_input" type="text" name="shipping_location_cp"  placeholder="Codigo postal" value="<%out.print(shipping_location_cp);%>"/><br/> 
    <input class="text_input" type="text" name="shipping_location_province"  placeholder="Provincia" value="<%out.print(shipping_location_province);%>"/><br/>
    <input class="text_input" type="text" name="shipping_location_country"  placeholder="Pais" value="<%out.print(shipping_location_country);%>"/><br/> 
    <input class="text_input" type="text" name="shipping_location_time"  placeholder="Horario" value="<%out.print(shipping_location_time);%>"/><br/> 
</form>
<input class="button" id="select_shipping_location_<%out.print(id_win);%>" type="button" value="Seleccionar datos de envio" />  
<input class="button" id="add_shipping_location_<%out.print(id_win);%>" type="button" value="Nueva informacion de envio" />
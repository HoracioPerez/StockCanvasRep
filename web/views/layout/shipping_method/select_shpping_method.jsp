<%-- 
    Document   : select_shpping_method
    Created on : 15-mar-2014, 2:32:38
    Author     : Horacio Perez
--%>
<%@page import="entity.simple.ShippingMethod"%>
<%@page import="dao.form.DAODeliveryNote"%>
<%@page import="form.DeliveryNote"%>
<%@page import="entity.User"%>
<%
    String id_delivery_note = request.getParameter("id_delivery_note");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAODeliveryNote dAODeliveryNote = new DAODeliveryNote(user);
    DeliveryNote deliveryNote = dAODeliveryNote.getById(id_delivery_note);
    ShippingMethod shippingMethod = deliveryNote.getShippingMethod();
    String shipping_method_id = shippingMethod.getId();
    String shipping_method_name = shippingMethod.getName();
    String shipping_method_summary = shippingMethod.getSummary();

%>
<script>
       
        //////SHIPPING METHOD//////      
        
        $("#select_shipping_method_<%out.print(id_win);%>").click(function() {
            var subWinId=0;
            var url2="views/layout/detail_product/client_order_product_detail.jsp";  
            $.newModal(
            '<%out.print(id_win);%>'+subWinId++, 
            "Detalle", 
            url2+"?id_father_win="+'<%out.print(id_win);%>'+"&id_order="+"<%out.print(id_order);%>"+"&id_win="+'<%out.print(id_win);%>'+subWinId);  
        });
    
</script>
<input class="camp" type="text" name="shipping_method_id"  placeholder="ID" value="<%out.print(shipping_method_id);%>"/><br/>
<input class="camp" type="text" name="shipping_method_name"  placeholder="Tipo" value="<%out.print(shipping_method_name);%>"/><br/>
<input class="camp" type="text" name="shipping_method_summary"  placeholder="Detalle" value="<%out.print(shipping_method_summary);%>"/><br/> 
<input class="button" id="select_shipping_method_<%out.print(id_win);%>" type="button" value="Seleccionar forma de envio" />    


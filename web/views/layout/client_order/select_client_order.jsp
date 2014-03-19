<%-- 
    Document   : select_client_order
    Created on : 05-mar-2014, 16:48:10
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id");
%>
<script>
    $(document).ready(function() {        
        var folder="views/layout/client_order/";
        var para1="?id_win="+'<%out.print(id_win);%>';
        var aux_client_order=folder+"client_order.jsp";
        var aux_reserve=folder+"reserve.jsp";
        var aux_delivery_note=folder+"delivery_note.jsp";
        var aux_bill=folder+"bill.jsp";        
        var url_client_order=aux_client_order + para1;
        var url_reserve=aux_reserve + para1;
        var url_delivery_note=aux_delivery_note + para1;
        var url_bill=aux_bill + para1;       
        var id_order="<%out.print(id_order);%>";
        var par2="&id_order="+id_order;
        url_client_order+=par2;
        url_reserve+=par2;
        url_delivery_note+=par2;
        url_bill+=par2;
        $("#link_client_order_"+'<%out.print(id_win);%>').prop("href", url_client_order);
        $("#link_reserve_"+'<%out.print(id_win);%>').prop("href", url_reserve);
        $("#link_delivery_note_"+'<%out.print(id_win);%>').prop("href", url_delivery_note);
        $("#link_bill_"+'<%out.print(id_win);%>').prop("href", url_bill);
        $("#tabs_<%out.print(id_win);%>").tabs();
    });
</script>


<div id="tabs_<%out.print(id_win);%>">
    <ul>
        <li><a id="link_client_order_<%out.print(id_win);%>" href="#" >Pedido</a></li>
        <li><a id="link_reserve_<%out.print(id_win);%>" href="#">Reserva</a></li>
        <li><a id="link_delivery_note_<%out.print(id_win);%>" href="#">Remito</a></li>
        <li><a id="link_bill_<%out.print(id_win);%>" href="#">Factura</a></li>
    </ul>
</div>
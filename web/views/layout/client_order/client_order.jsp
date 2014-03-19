<%-- 
    Document   : client_order
    Created on : 28-feb-2014, 0:09:06
    Author     : Horacio Perez
--%>


<%@page import="entity.Client"%>
<%@page import="java.sql.Date"%>
<%@page import="form.ClientOrder"%>
<%@page import="entity.User"%>
<%@page import="dao.form.DAOClientOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = "views/layout/client_order/";
    String id_order = request.getParameter("id_order");
    String id = request.getParameter("id_win");
%>
<script>
    $(document).ready(function(){
        $("#print_<%out.print(id);%>").printPage({
            url: "views/layout/client_order/client_order_print.jsp?id_order=<%out.print(id_order);%>",
            message:"Your document is being created"
        });       
        $( "#tabs_v_<%out.print(id);%>" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
        $( "#tabs_v_<%out.print(id);%> li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );        
        $("#tabs_v_<%out.print(id);%>").tabs();     
    });
</script>



<div id="tabs_v_<%out.print(id);%>">
    <ul>
        <li><a href="<%out.print(path);%>information.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id);%>">Información</a></li>
        <li><a href="<%out.print(path);%>client.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id);%>">Cliente</a></li>       
        <li><a href="<%out.print(path);%>product_detail.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id);%>">Detalles</a></li>
        <li><a href="views/layout/printing.jsp" id="print_<%out.print(id);%>" ><span class="ui-icon ui-icon-print"></span>Imprimir</a></li>
    </ul>
</div>


<%-- 
    Document   : delivery_note
    Created on : 17-mar-2014, 23:49:32
    Author     : Horacio Perez
--%>
<%
    String path = "views/layout/delivery_note/";
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
%>
<script>
    $(document).ready(function(){
        $("#print_<%out.print(id_win);%>").printPage({
            url: "views/layout/delivery_note/delivery_note_print.jsp?id_order=<%out.print(id_order);%>",
            message:"Your document is being created"
        });       
        $( "#tabs_v1_<%out.print(id_win);%>" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
        $( "#tabs_v1_<%out.print(id_win);%> li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );        
        $("#tabs_v1_<%out.print(id_win);%>").tabs();     
    });
</script>
<div id="tabs_v1_<%out.print(id_win);%>">
    <ul>
        <li><a href="<%out.print(path);%>information.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id_win);%>">Información</a></li>
        <li><a href="<%out.print(path);%>select_shipping_location.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id_win);%>">Datos de envio</a></li>       
        <li><a href="<%out.print(path);%>select_shipping_method.jsp?id_order=<%out.print(id_order);%>&id_win=<%out.print(id_win);%>">Forma de Envio</a></li>
        <li><a href="views/layout/printing.jsp" id="print_<%out.print(id_win);%>" ><span class="ui-icon ui-icon-print"></span>Imprimir</a></li>
    </ul>
</div>

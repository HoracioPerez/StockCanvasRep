<%-- 
    Document   : search_client_order
    Created on : 06-mar-2014, 1:59:02
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id_win = request.getParameter("id");
%>
<script>  
    $(document).ready(function(){   
        searchClientOrder();
        function searchClientOrder(){
            var url="views/layout/client_order/table_client_order.jsp";  
            var url2="views/layout/client_order/select_client_order.jsp";  
            $('#example_<%out.print(id_win);%>').dataTable( {        
                "sAjaxSource": url,
                "bProcessing": true,
                "fnServerData": function ( sSource, aoData, fnCallback) {       
                    $.ajax( {
                        "dataType": 'json',
                        "type": "POST",
                        "url": sSource,
                        "data": aoData,                    
                        "success": function (code){
                            fnCallback(code);
                            var subWinId=0;
                            $('#example_<%out.print(id_win);%> .open').click(function() {                                                   
                                var td=$(this).closest( "tr" ).children(":first")
                                var client_order_id=td.html();                       
                                $.newWindow('<%out.print(id_win);%>'+subWinId++, "Pedido", url2+"?id_order="+client_order_id+"&id="+'<%out.print(id_win);%>'+subWinId);
                            });                      
                        } 
                    } );  
                } ,
                "bPaginate": false,
                "bLengthChange": true,
                "bFilter": true,
                "bSort": true,
                "bInfo": false,
                "bAutoWidth": true,            
                "bJQueryUI": true
            } );  
        }  
    });
       
</script>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example_<%out.print(id_win);%>">
    <thead>
        <tr>
            <th width="5%">ID</th>
            <th width="15%">Usuario</th>
            <th width="15%">Estado</th>
            <th width="15%">Fecha</th>
            <th width="15%">Nombre</th>
            <th width="15%">Apellido</th>
            <th width="10%"></th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>








<%-- 
    Document   : select_client
    Created on : 01-mar-2014, 16:13:29
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
    String id_father_win = request.getParameter("id_father_win");
%>
<script>  
    $(document).ready(function(){        
        var url="views/layout/client/table_select_client.jsp";  
        $('#client_<%out.print(id_win);%>').dataTable( {        
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
                        $('#client_<%out.print(id_win);%> .select').click(function() {                                                   
                            var td=$(this).closest( "tr" ).children(":first")
                            var client_id=td.html();
                            $.ajax({
                                url: "SelectClientService?idClient="+client_id+"&idOrder=<%out.print(id_order);%>",
                                data: "idClient="+client_id+"&idOrder="+<%out.print(id_order);%>,
                                type: "POST",                
                                success: function (data){
                                    $("#tabs_v_<%out.print(id_father_win);%>").tabs('load',1);  
                                    var dialog_ui=$('#client_<%out.print(id_win);%>').closest(".ui-dialog");
                                    var dialog_cont=dialog_ui.children("div.dialog_window"); 
                                    dialog_cont.empty();
                                    dialog_cont.remove();
                                },
                                error: function() {
                                    alert("Error ajax");
                                }
                            });                         
                            
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
    });
       
</script>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="client_<%out.print(id_win);%>">
    <thead>
        <tr>
            <th width="5%">ID</th>
            <th width="15%">Nombre</th>
            <th width="15%">Apellido</th>
            <th width="15%">EMAIL</th>
            <th width="25%">Direccion</th>
            <th width="15%">Telefono</th>
            <th width="10%"></th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>







<%-- 
    Document   : product_detail
    Created on : 06-mar-2014, 1:30:30
    Author     : Horacio Perez
--%>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
%>
<script>  
    $(document).ready(function(){    
        product_detail();
        product_detail_total();
        function product_detail_total(){
            $.ajax( {                        
                url: "ClientOrderTotalService",
                data: "idOrder="+"<%out.print(id_order);%>",
                type: "POST",                     
                "success": function (data){
                    $("#total_<%out.print(id_win);%>").html(data);
                }
            });    
        }
        function product_detail(){
            var url="views/layout/client_order/table_detail.jsp";  
            $('#product_table_<%out.print(id_win);%>').dataTable( {        
                "sAjaxSource": url,
                "bProcessing": true,
                "fnServerData": function ( sSource, aoData, fnCallback) {
                    aoData.push( { "name": "idOrder", "value": "<%out.print(id_order);%>" } );               
                    $.ajax( {
                        "dataType": 'json',
                        "type": "POST",
                        "url": sSource,                    
                        "data": aoData,                    
                        "success": function (code){
                            fnCallback(code);
                            $('#product_table_<%out.print(id_win);%> .remove').button();
                            $('#product_table_<%out.print(id_win);%> .remove').click(function() {                                                   
                                var td=$(this).closest( "tr" ).children(":first");
                                var detail_id=td.html();
                                $.ajax({
                                    url: "ProductDetailClientOrderServiceDelete",
                                    data: "idDetail="+detail_id,
                                    type: "POST",                
                                    success: function (data){
                                        $("#tabs_v_<%out.print(id_win);%>").tabs('load',2);                                      
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
            var subWinId=0;
            var url2="views/layout/detail_product/client_order_product_detail.jsp";  
            $("#add_<%out.print(id_win);%>").button().click(function() {  
                $.newModal(
                '<%out.print(id_win);%>'+subWinId++, 
                "Detalle", 
                url2+"?id_father_win="+'<%out.print(id_win);%>'+"&id_order="+"<%out.print(id_order);%>"+"&id_win="+'<%out.print(id_win);%>'+subWinId);
                                           
            });
        }
    });
       
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
    <thead>
        <tr class="ui-state-default">
            <th> Total</th>
        </tr>
    </thead>
    <tbody>
        <tr class="odd"><td><h1 style="text-align: center" id="total_<%out.print(id_win);%>"></h1></tr>
    </tbody>
</table>
<input class="button" id="add_<%out.print(id_win);%>" type="button" value="Agregar" />
<table cellpadding="0" cellspacing="0" border="0" class="display" id="product_table_<%out.print(id_win);%>">
    <thead>
        <tr>
            <th>ID</th>
            <th>Categoria</th>
            <th>Nombre</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>SubTotal</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>




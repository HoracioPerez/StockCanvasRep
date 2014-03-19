<%-- 
    Document   : client_order_product_detail
    Created on : 10-mar-2014, 10:45:02
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
    String id_father_win = request.getParameter("id_father_win");
%>
<script>  
    $(document).ready(function(){        
        var url="views/layout/product/table_product.jsp";  
        $('#table_product_<%out.print(id_win);%>').dataTable( {        
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
                        $('#table_product_<%out.print(id_win);%> .amount').spinner();
                        $('#table_product_<%out.print(id_win);%> .add').click(function() {                                                   
                            var td=$(this).closest( "tr" ).children(":first");
                            var product_id=td.html();
                            var spinnerInput=td.next().children(":first").children(":first");
                            var amount=spinnerInput.val();
                            spinnerInput.val("");
                            //alert(amount);
                            $.ajax({
                                url: "ProductDetailClientOrderServiceInsert",
                                data: "idProduct="+product_id+"&idOrder="+<%out.print(id_order);%>+"&amount="+amount,
                                type: "POST",                
                                success: function (data){
                                    $("#tabs_v_<%out.print(id_father_win);%>").tabs('load',2);                                     
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

<table cellpadding="0" cellspacing="0" border="0" class="display" id="table_product_<%out.print(id_win);%>">
    <thead>
        <tr>
            <th>ID</th>
            <th>Cantidad</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Detalle</th>
            <th>Categoria</th>
            <th>Stock</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
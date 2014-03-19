<%-- 
    Document   : client
    Created on : 01-mar-2014, 13:55:22
    Author     : Horacio Perez
--%>

<%@page import="entity.Client"%>
<%@page import="java.sql.Date"%>
<%@page import="form.ClientOrder"%>
<%@page import="dao.form.DAOClientOrder"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAOClientOrder daoClientOrder = new DAOClientOrder(user);
    ClientOrder clientOrder = daoClientOrder.getById(id_order);

    //Client
    String clientName = "";
    String clientLastName = "";
    String clientEmail = "";
    String clientAddress = "";
    String clientPhone = "";
    String clientId = "";
    Client client = clientOrder.getClient();
    if (client != null) {
        clientId = client.getId();
        clientName = client.getName();
        clientLastName = client.getLastName();
        clientEmail = client.getEmail();
        clientAddress = client.getAddress();
        clientPhone = client.getPhone();
    }
%>
<script>
    $(document).ready(function(){      
        var winClientNumber=0;
        $(".camp").prop('disabled', true);
        var button=$("#button_<%out.print(id_win);%>").button();
        
        button.click(function() {
            var fatherId='<%out.print(id_win);%>';
            var subWinId='select_client_'+winClientNumber+fatherId;
            var idOrder='<%out.print(id_order);%>';
            $('body').append('<div class="dialog_window" id="'+ subWinId +'"></div>');
             $('#'+subWinId).dialog({
                width: '60%',
                modal:true,
                position:['top',0],
                height: 'auto',
                maxHeight: '1000px',
                title: "Cliente",
                autoOpen: true
            });            
            $.ajax({
                url: "views/layout/client/select_client.jsp",
                data: "id_father_win="+fatherId+"&id_win="+subWinId+"&id_order="+idOrder,
                type: "POST",
                
                success: function(data) {
                    $('#'+subWinId).html(data);
                },
                error: function() {
                    $('#'+subWinId).html("Error ajax");
                }
            });
           
            //$("#tabs_<%out.print(id_win);%>").tabs('load',1);  
            winClientNumber++;           
        });
     
    });
</script>
<div>
    <input class="camp" type="text" name="id"  placeholder="ID" value="<%out.print(clientId);%>"/><br/>
    <input class="camp" type="text" name="name"  placeholder="Nombre" value="<%out.print(clientName);%>"/><br/>
    <input class="camp" type="text" name="lastName"  placeholder="Apellido" value="<%out.print(clientLastName);%>"/><br/>   
    <input class="camp" type="text" name="email"  placeholder="EMAIL" value="<%out.print(clientEmail);%>"/><br/> 
    <input class="camp" type="text" name="address"  placeholder="Dirección" value="<%out.print(clientAddress);%>"/><br/>
    <input class="camp" type="text" name="phone"  placeholder="Telefono" value="<%out.print(clientPhone);%>"/><br/> 
    <input class="button" id="button_<%out.print(id_win);%>" type="button" value="Seleccionar" />
</div>
<div id="sarasa">
</div>
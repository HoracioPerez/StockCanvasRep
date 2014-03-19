<%-- 
    Document   : delivery_note_print
    Created on : 17-mar-2014, 23:56:54
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
    User user = (User) session.getAttribute("user");
    DAOClientOrder daoClientOrder = new DAOClientOrder(user);
    ClientOrder clientOrder = daoClientOrder.getById(id_order);
    String user_name = clientOrder.getUser().getId();
    String state = clientOrder.getState();
    Date date = clientOrder.getDate();
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>         
        <div>
            <h2>Numero <%out.print(id_order);%></h2>
            <h2>Fecha <%out.print(date);%></h2>
            <h2>Estado <%out.print(state);%></h2>
            <h2>Usuario <%out.print(user_name);%></h2>
        </div>
        <div>
            <input class="camp" type="text" name="id"  placeholder="ID" value="<%out.print(clientId);%>"/><br/>
            <input class="camp" type="text" name="name"  placeholder="Nombre" value="<%out.print(clientName);%>"/><br/>
            <input class="camp" type="text" name="lastName"  placeholder="Apellido" value="<%out.print(clientLastName);%>"/><br/>   
            <input class="camp" type="text" name="email"  placeholder="EMAIL" value="<%out.print(clientEmail);%>"/><br/> 
            <input class="camp" type="text" name="address"  placeholder="Dirección" value="<%out.print(clientAddress);%>"/><br/>
            <input class="camp" type="text" name="phone"  placeholder="Telefono" value="<%out.print(clientPhone);%>"/><br/> 


        </div>
        <div>
            <h2>Detalle_1</h2>
            <h2>Detalle_2</h2>
            <h2>Detalle_3</h2>
        </div>
    </body>
</html>

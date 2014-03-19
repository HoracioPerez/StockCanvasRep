<%-- 
    Document   : search_client_order
    Created on : 06-mar-2014, 1:43:24
    Author     : Horacio Perez
--%>

<%@page import="dao.form.DAOClientOrder"%>
<%@page import="form.ClientOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.entity.DAOClient"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("user");
    DAOClientOrder dAOClientOrder = new DAOClientOrder(user);
    ArrayList<ClientOrder> clientOrders = dAOClientOrder.getAll();
    int last_position=clientOrders.size()-1;
    String start = "{\"aaData\": [";
    String body = "";

    for (int i = 0; i < clientOrders.size(); i++) {
        ClientOrder clientOrder = clientOrders.get(i);
        if (i != last_position) {
            body = body + clientOrder.toOpenJsonTable() + ",";            
        } else {
            body = body + clientOrder.toOpenJsonTable();
        }
    }
    String end = "]}";


    out.print(start + body + end);
%>

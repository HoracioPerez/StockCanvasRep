<%-- 
    Document   : table_select_client
    Created on : 06-mar-2014, 1:55:23
    Author     : Horacio Perez
--%>

<%@page import="entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.entity.DAOClient"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    User user = (User) session.getAttribute("user");
    DAOClient dAOClient = new DAOClient(user);
    ArrayList<Client> clients = dAOClient.getAll();
    int last_position=clients.size()-1;
    String start = "{\"aaData\": [";
    String body = "";

    for (int i = 0; i < clients.size(); i++) {
        Client client = clients.get(i);
        if (i != last_position) {
            body = body + client.toSelectJsonTable() + ",";            
        } else {
            body = body + client.toSelectJsonTable();
        }
    }
    String end = "]}";
    out.print(start + body + end);
%>

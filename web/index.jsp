<%-- 
    Document   : index
    Created on : Feb 21, 2014, 6:16:40 PM
    Author     : Horacio Perez
--%>
<%@page import="entity.User"%>
<%
    User user = new User("Horacio", "1234", true);
// Construye un objeto del tipo persona
    if (user.validate()) {
// Guarda los datos en session
        session.setAttribute("user", user);
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="views/head.jsp" %>      
    </head>
    <body>
        <button id="menu_button">INICIO</button><div id="dialog_window_minimized_container" class="ui-widget-header ui-corner-all"></div>
        
        <%@ include file="views/layout/menu.jsp" %>
    </body>
</html>

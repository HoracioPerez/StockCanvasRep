<%-- 
    Document   : menu
    Created on : 22-feb-2014, 15:59:57
    Author     : Horacio Perez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul id="menu">
    <li><a href="#"><%out.print(iconSales);%>Ventas</a>
        <%@ include file="menu_sales.jsp" %> 
    </li>
    <li><a href="#"><%out.print(iconAdmin);%>Administración</a>
        <%@ include file="menu_admin.jsp" %> 
    </li>           
    <li><a href="#"><%out.print(iconWareHouse);%>Deposito</a>
        <%@ include file="menu_ware_house.jsp" %> 
    </li>
    <li><a href="#"><%out.print(iconStatistics);%>Estadísticas</a>
        <%@ include file="menu_statistics.jsp" %> 
    </li>

</ul>

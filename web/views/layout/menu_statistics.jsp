<%-- 
    Document   : menu_statistics
    Created on : 22-feb-2014, 18:44:54
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!
    public String buildIconStatistics(String name) {
        String classes = "";
        String folder = "media/images/icons/";
        return "<img " + classes + " src='" + folder + name + "'/>";
    }
     //------------------------------------------------------------------
    String iconStatistics = buildIconStatistics("iconStatistics.png");
        //------------------------------------------------------------------
        String iconExpenses = buildIconStatistics("iconExpenses.png");
        //------------------------------------------------------------------  
            //String iconExpenses = buildIcon("iconNew.png");
            //String iconExpenses = buildIcon("iconSearch.png");
        String iconSales2 = buildIconStatistics("iconSales.png");
        //------------------------------------------------------------------  
            //String iconExpenses = buildIcon("iconNew.png");
            //String iconExpenses = buildIcon("iconSearch.png");
        String iconEarnings = buildIconStatistics("iconEarnings.png");
        //------------------------------------------------------------------  
            //String iconExpenses = buildIcon("iconNew.png");
            //String iconExpenses = buildIcon("iconSearch.png");
 
%>
<ul class="menu-internal">
    <li><a href="#"><%out.print(iconExpenses);%>Gastos</a>
        <ul>
            <li><a href="#">Mis Gastos</a></li>
            <li><a href="#">Buscar Gastos</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconSales2);%>Ventas</a>
        <ul>
            <li><a href="#">Mis Ventas</a></li>
            <li><a href="#">Buscar Ventas</a></li>                    
        </ul>
    </li>

    <li><a href="#"><%out.print(iconEarnings);%>Ganacias</a>
        <ul>
            <li><a href="#">Mis  Ganacias</a></li>
            <li><a href="#">Buscar Ganacias</a></li>                    
        </ul>
    </li>
</ul>

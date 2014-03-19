<%-- 
    Document   : table_detail_product
    Created on : 10-mar-2014, 14:30:23
    Author     : Horacio Perez
--%>

<%@page import="entity.Product"%>
<%@page import="dao.entity.DAOProduct"%>
<%@page import="entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.entity.DAOClient"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    User user = (User) session.getAttribute("user");
    DAOProduct dAOProduct = new DAOProduct(user);
    ArrayList<Product> products = dAOProduct.getAll();
    int last_position=products.size()-1;
    String start = "{\"aaData\": [";
    String body = "";

    for (int i = 0; i < products.size(); i++) {
        Product product = products.get(i);
        if (i != last_position) {
            body = body + product.toAddJsonTable() + ",";            
        } else {
            body = body + product.toAddJsonTable();
        }
    }
    String end = "]}";
    out.print(start + body + end);
%>

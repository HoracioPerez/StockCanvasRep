<%-- 
    Document   : table_detail
    Created on : 09-mar-2014, 14:23:21
    Author     : Horacio Perez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.ProductDetail"%>
<%@page import="dao.form.DAOProductDetailClientOrder"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String idOrder = request.getParameter("idOrder");
    User user = (User) session.getAttribute("user");
    DAOProductDetailClientOrder dAOClient = new DAOProductDetailClientOrder(user);
    ArrayList<ProductDetail> productDetails = dAOClient.getByOrder(idOrder);
    int last_position = productDetails.size() - 1;
    String start = "{\"aaData\": [";
    String body = "";

    for (int i = 0; i < productDetails.size(); i++) {
        ProductDetail productDetail = productDetails.get(i);
        if (i != last_position) {
            body = body + productDetail.toEditJsonTable() + ",";
        } else {
            body = body + productDetail.toEditJsonTable();
        }
    }
    String end = "]}";
    System.out.println(start + body + end);

    out.print(start + body + end);
%>

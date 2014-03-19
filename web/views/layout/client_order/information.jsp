<%-- 
    Document   : information
    Created on : 06-mar-2014, 1:33:31
    Author     : Horacio Perez
--%>
<%@page import="java.sql.Date"%>
<%@page import="form.ClientOrder"%>
<%@page import="dao.form.DAOClientOrder"%>
<%@page import="entity.User"%>
<%
    String id_order = request.getParameter("id_order");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAOClientOrder daoClientOrder = new DAOClientOrder(user);
    ClientOrder clientOrder = daoClientOrder.getById(id_order);
    String user_name = clientOrder.getUser().getId();
    String state = clientOrder.getState();
    Date date = clientOrder.getDate();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    $(document).ready(function(){       
        
        radio("<%out.print(state);%>");
        function radio(state){
            if(state=="Pendiente"){
                $("#pen_<%out.print(id_win);%>").attr('checked', 'checked');
            }
            if(state=="Cancelado"){
                $("#can_<%out.print(id_win);%>").attr('checked', 'checked');
            }
            if(state=="Cerrado"){
                $("#ter_<%out.print(id_win);%>").attr('checked', 'checked');
            }
        }
        
        function ajax(new_state){
            $.ajax( {
                "type": "POST",
                "url": "ServiceClientOrderChangeStatus?status="+new_state+"&idOrder=<%out.print(id_order);%>",                           
                "success": function (code){
                    radio(new_state);                    
                } 
            } );  
        }
      
        $( "#buttons_<%out.print(id_win);%>" ).buttonset();
        $( "#pen_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-pencil"}});
        $( "#can_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-closethick"}});
        $( "#ter_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-locked"}});
        
        $( "#pen_<%out.print(id_win);%>" ).click(function() {
            ajax("Pendiente");
        });          
        $( "#can_<%out.print(id_win);%>" ).click(function() { 
            ajax("Cancelado");
        });          
        $( "#ter_<%out.print(id_win);%>" ).click(function() {
            ajax("Cerrado");
        });          
        
    });
</script>
<div id="info_<%out.print(id_win);%>">
    <div id="buttons_<%out.print(id_win);%>">
        <input name="status" type="radio" id="pen_<%out.print(id_win);%>"/><label for="pen_<%out.print(id_win);%>">Pendiente</label>
        <input name="status" type="radio" id="can_<%out.print(id_win);%>"/><label for="can_<%out.print(id_win);%>">Cancelado</label>
        <input name="status" type="radio" id="ter_<%out.print(id_win);%>"/><label for="ter_<%out.print(id_win);%>">Cerrado</label>
    </div>
    <h3>Numero <%out.print(id_order);%></h3>
    <h3>Fecha <%out.print(date);%></h3>   
    <h3>Usuario <%out.print(user_name);%></h3>    
</div>


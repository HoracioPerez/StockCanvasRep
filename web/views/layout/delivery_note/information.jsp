<%-- 
    Document   : information
    Created on : 17-mar-2014, 23:50:40
    Author     : Horacio Perez
--%>
<%@page import="form.DeliveryNote"%>
<%@page import="dao.form.DAODeliveryNote"%>
<%@page import="entity.User"%>
<%@page import="dao.form.DAOReservation"%>
<%
    String id_delivery_note = request.getParameter("id_delivery_note");
    String id_win = request.getParameter("id_win");
    User user = (User) session.getAttribute("user");
    DAODeliveryNote dAODeliveryNote = new DAODeliveryNote(user);
    DeliveryNote deliveryNote = dAODeliveryNote.getById(id_delivery_note);
    String state = deliveryNote.getState();
    String date = deliveryNote.getDate().toString();
    String user_name = deliveryNote.getUser().getId();
%>
<script>
    $(document).ready(function(){ 
        
         //////TOTAL//////
        
        product_detail_total();
        function product_detail_total(){
            $.ajax( {                        
                url: "ClientOrderTotalService",
                data: "idOrder="+"<%out.print(id_delivery_note);%>",
                type: "POST",                     
                "success": function (data){
                    $("#total_delivery_<%out.print(id_win);%>").html(data);
                }
            });    
        }
        
        //////STATUS//////
        
        function ajax(new_state){
            $.ajax( {
                "type": "POST",
                "url": "ServiceClientOrderChangeStatus?status="+new_state+"&idOrder=<%out.print(id_delivery_note);%>",                           
                "success": function (code){
                    radio(new_state);                    
                } 
            } );  
        }
        
        radio("<%out.print(state);%>");
        function radio(state){
            if(state=="Pendiente"){
                $("#pen_delivery_<%out.print(id_win);%>").attr('checked', 'checked');
            }
            if(state=="Cancelado"){
                $("#can_delivery_<%out.print(id_win);%>").attr('checked', 'checked');
            }
            if(state=="Cerrado"){
                $("#ter_delivery_<%out.print(id_win);%>").attr('checked', 'checked');
            }
        }
        
        $( "#state_buttons_<%out.print(id_win);%>" ).buttonset();
        
        $( "#pen_delivery_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-pencil"}});
        $( "#can_delivery_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-closethick"}});
        $( "#ter_delivery_<%out.print(id_win);%>" ).button({icons:{primary: "ui-icon-locked"}});
        
        $( "#pen_delivery_<%out.print(id_win);%>" ).click(function() {
            ajax("Pendiente");
        });          
        $( "#can_delivery_<%out.print(id_win);%>" ).click(function() { 
            ajax("Cancelado");
        });          
        $( "#ter_delivery_<%out.print(id_win);%>" ).click(function() {
            ajax("Cerrado");
        });
          
            
        
         
    });   
     
</script>  


<div id="delivery_note_information_<%out.print(id_win);%>">
    <div id="state_buttons_<%out.print(id_win);%>">
        <input name="status" type="radio" id="pen_delivery_<%out.print(id_win);%>"/><label for="pen_delivery_<%out.print(id_win);%>">Pendiente</label>
        <input name="status" type="radio" id="can_delivery_<%out.print(id_win);%>"/><label for="can_delivery_<%out.print(id_win);%>">Cancelado</label>
        <input name="status" type="radio" id="ter_delivery_<%out.print(id_win);%>"/><label for="ter_delivery_<%out.print(id_win);%>">Entregado</label>
    </div>
    <h3>Numero <%out.print(id_delivery_note);%></h3>
    <h3>Fecha <%out.print(date);%></h3>   
    <h3>Usuario <%out.print(user_name);%></h3>    
    <table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
        <thead>
            <tr class="ui-state-default">
                <th> Total</th>
            </tr>
        </thead>
        <tbody>
            <tr class="odd"><td><h1 style="text-align: center" id="total_delivery_<%out.print(id_win);%>"></h1></tr>
        </tbody>
    </table>
</div>

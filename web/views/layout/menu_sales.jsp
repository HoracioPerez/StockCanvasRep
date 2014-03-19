<%-- 
    Document   : menu_sales
    Created on : 22-feb-2014, 18:43:21
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<%!
    public String buildIconSales(String name) {
        String classes = "";
        String folder = "media/images/icons/";
        return "<img " + classes + " src='" + folder + name + "'/>";
    }

     //------------------------------------------------------------------    
    String iconSales = buildIconSales("iconSales.png");
        //------------------------------------------------------------------    
        String iconClientOrder = buildIconSales("iconClientOrder.png");
            //------------------------------------------------------------------  
            String iconNewClientOrder = buildIconSales("iconNew.png");
            String iconMyClientOrder = buildIconSales("iconMy.png");
            String iconSearchClientOrder = buildIconSales("iconSearch.png");  
        //------------------------------------------------------------------ 
        String iconReserve = buildIconSales("iconReserve.png");
            //------------------------------------------------------------------             
            String iconMyReserve = buildIconSales("iconMy.png");
            String iconSearchReserve = buildIconSales("iconSearch.png");    
        //------------------------------------------------------------------    
        String iconProduct = buildIconSales("iconProduct.png");
            //------------------------------------------------------------------          
            String iconSearchProduct = buildIconSales("iconSearch.png");    
        //------------------------------------------------------------------  
        String iconClient = buildIconSales("iconClient.png");
            //------------------------------------------------------------------  
            String iconNewClient = buildIconSales("iconNew.png");
            String iconSearchClient = buildIconSales("iconSearch.png");    
            String iconShippingLocation = buildIconSales("iconShippingLocation.png"); 
%>
<ul class="menu-internal">
    <li><a href="#"><%out.print(iconClientOrder);%> Pedidos</a>
        <ul>
            <li class="new_client_order_button"><a href="#"><%out.print(iconNewClientOrder);%> Nuevo Pedido</a></li>
            <li class="my_client_order_button"><a href="#"><%out.print(iconMyClientOrder);%>Mis Pedidos</a></li>
            <li class="search_client_order_button"><a href="#"><%out.print(iconSearchClientOrder);%>Buscar Pedido</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconReserve);%>Reservas</a>
        <ul>                    
            <li class="my_reserve_button"><a href="#"><%out.print(iconMyReserve);%>Mis Reservas</a></li>
            <li class="search_reserve_button"><a href="#"><%out.print(iconSearchReserve);%>Buscar Reserva</a></li>  
        </ul>
    </li>            
    <li><a href="#"><%out.print(iconProduct);%> Productos</a>
        <ul>
            <li class="search_product_button"><a href="#"><%out.print(iconSearchProduct);%>Buscar Producto</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconClient);%> Clientes</a>
        <ul>
            <li class="search_client_button"><a href="#"><%out.print(iconSearchClient);%>Buscar Cliente</a></li>
            <li class="new_client_button"><a href="#"><%out.print(iconNewClient);%>Nuevo Cliente</a></li>  
            <li class="new_shipping_location_button"><a href="#"><%out.print(iconShippingLocation);%>Datos de envio</a></li> 
        </ul>
    </li>

</ul>

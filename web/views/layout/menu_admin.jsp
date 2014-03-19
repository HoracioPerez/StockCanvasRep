<%-- 
    Document   : menu_admin
    Created on : 22-feb-2014, 18:43:36
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!   
    public String buildIconAdmin(String name) {
        String classes = "";
        String folder = "media/images/icons/";
        return "<img " + classes + " src='" + folder + name + "'/>";
    }
    //------------------------------------------------------------------    
    String iconAdmin = buildIconAdmin("iconAdmin.png");
        //------------------------------------------------------------------ 
        String iconDeliveryNote = buildIconAdmin("iconDeliveryNote.png");
            //------------------------------------------------------------------  
            String iconMyDeliveryNote = buildIconAdmin("iconMy.png");
            String iconSearchDeliveryNote = buildIconAdmin("iconSearch.png");    
        //------------------------------------------------------------------  
        String iconBill = buildIconAdmin("iconBill.png");
            //------------------------------------------------------------------  
            String iconMyBill = buildIconAdmin("iconMy.png");
            String iconSearchBill = buildIconAdmin("iconSearch.png");
        //------------------------------------------------------------------             
        String iconDiscount = buildIconAdmin("iconDiscount.png");
            //------------------------------------------------------------------  
            String iconNewDiscount = buildIconAdmin("iconNew.png");
            String iconSearchDiscount = buildIconAdmin("iconSearch.png");
        //------------------------------------------------------------------ 
        String iconShippingMethod = buildIconAdmin("iconShippingMethod.png");
            //------------------------------------------------------------------  
            String iconNewShippingMethod = buildIconAdmin("iconNew.png");
            String iconSearchShippingMethod = buildIconAdmin("iconSearch.png");
        //------------------------------------------------------------------  
        String iconPaymentType = buildIconAdmin("iconPaymentType.png");
            //------------------------------------------------------------------  
            String iconNewPaymentType = buildIconAdmin("iconNew.png");
            String iconSearchPaymentType = buildIconAdmin("iconSearch.png");
 
%>
<ul class="menu-internal">
    <li><a href="#"><%out.print(iconDeliveryNote);%>Remitos</a>
        <ul>
            <li class="my_delivery_note_button"><a href="#"><%out.print(iconMyDeliveryNote);%>Mis Remitos</a></li>
            <li class="search_delivery_note_button"><a href="#"><%out.print(iconSearchDeliveryNote);%>Buscar Remito</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconBill);%>Facturas</a>
        <ul>
            <li class="my_bill_button"><a href="#"><%out.print(iconMyBill);%>Mis Facturas</a></li>
            <li class="search_bill_order_button"><a href="#"><%out.print(iconSearchBill);%>Buscar Factura</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconDiscount);%>Descuentos</a>
        <ul>
            <li class="new_discount_button"><a href="#"><%out.print(iconNewDiscount);%>Nuevo Descuento</a></li>
            <li class="search_discount_button"><a href="#"><%out.print(iconSearchDiscount);%>Buscar Descuento</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconShippingMethod);%>Formas de envio</a>
        <ul>
            <li class="new_shipping_method_button"><a href="#"><%out.print(iconNewShippingMethod);%>Nueva Forma de envio</a></li>
            <li class="search_shipping_method_button"><a href="#"><%out.print(iconSearchShippingMethod);%>Buscar Formas de envio</a></li>                  
        </ul>
    </li>
    <li><a href="#"><%out.print(iconPaymentType);%>Formas de pago</a>
        <ul>
            <li class="new_payment_type_button"><a href="#"><%out.print(iconNewPaymentType);%>Nueva Forma de pago</a></li>
            <li class="search_payment_type_button"><a href="#"><%out.print(iconSearchPaymentType);%>Buscar Formas de pago</a></li>                  
        </ul>
    </li>
</ul>
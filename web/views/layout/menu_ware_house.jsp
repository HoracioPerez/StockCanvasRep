<%-- 
    Document   : menu_ware_house
    Created on : 22-feb-2014, 18:43:55
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!
    public String buildIconWareHouse(String name) {
        String classes = "";
        String folder = "media/images/icons/";
        return "<img " + classes + " src='" + folder + name + "'/>";
    }
     //------------------------------------------------------------------    
    String iconWareHouse = buildIconWareHouse("iconWareHouse.png");
        //------------------------------------------------------------------ 
        String iconProduct2 = buildIconWareHouse("iconProduct.png");
        //------------------------------------------------------------------  
            String iconNewProduct2 = buildIconWareHouse("iconNew.png");
            String iconSearchProduct2 = buildIconWareHouse("iconSearch.png");
        //------------------------------------------------------------------  
        String iconProvider = buildIconWareHouse("iconProvider.png");
            //------------------------------------------------------------------  
            String iconNewProvider = buildIconWareHouse("iconNew.png");
            String iconSearchProvider = buildIconWareHouse("iconSearch.png");
        //------------------------------------------------------------------  
        String iconCategory = buildIconWareHouse("iconCategory.png");
            //------------------------------------------------------------------  
            String iconNewCategory = buildIconWareHouse("iconNew.png");
            String iconSearchCategory = buildIconWareHouse("iconSearch.png");
        //------------------------------------------------------------------  
        String iconStock = buildIconWareHouse("iconStock.png");
            //------------------------------------------------------------------  
            String iconNewStock = buildIconWareHouse("iconNew.png");
            String iconSearchStock = buildIconWareHouse("iconSearch.png");
 
%>
<ul class="menu-internal">
    <li><a href="#"><%out.print(iconProduct2);%>Productos</a>
        <ul>
            <li class="new_product_button"><a href="#"><%out.print(iconNewProduct2);%>Nuevo Producto</a></li>
            <li class="search_product_button"><a href="#"><%out.print(iconSearchProduct2);%>Buscar Producto</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconProvider);%>Proveedores</a>
        <ul class="menu-internal">
            <li class="new_provider_button"><a href="#"><%out.print(iconNewProvider);%>Nuevo Proveedor</a></li>
            <li class="search_provider_button"><a href="#"><%out.print(iconSearchProvider);%>Buscar Proveedores</a></li>                    
        </ul>
    </li>        
    <li><a href="#"><%out.print(iconCategory);%>Categorias</a>
        <ul>
            <li class="new_category_button"><a href="#"><%out.print(iconNewCategory);%>Nueva Categoria</a></li>
            <li class="search_category_button"><a href="#"><%out.print(iconSearchCategory);%>Buscar Categorias</a></li>                    
        </ul>
    </li>
    <li><a href="#"><%out.print(iconStock);%>Ingreso de Stock</a>
        <ul>
            <li class="new_incoming_button"><a href="#"><%out.print(iconNewStock);%>Nuevo Ingreso</a></li>
            <li class="search_incoming_button"><a href="#"><%out.print(iconSearchStock);%>Buscar Ingresos</a></li>                  
        </ul>
    </li>
</ul>

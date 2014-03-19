$(document).ready(function() {
    var win_number = 0;
    var service_location = "views/layout/";
    
    $.newModal = function(win_id, win_title, service) {
        $('body').append('<div class="dialog_window" id="' + win_id + '"></div>');
        $.ajax({
            url: service,
            data: "id=" + win_number,
            type: "POST",
            success: function(data) {
                $('#' + win_id).html(data);
            },
            error: function() {
                $('#' + win_id).html("Error ajax");
            }
        });
        $('#' + win_id).dialog({
            modal:true,
            width: 'auto',
            height: 'auto',
            position:[300,50],
            title: win_title,
            autoOpen: true

        });
    };
    
    $.newWindow = function(win_id, win_title, service) {
        $('body').append('<div class="dialog_window" id="' + win_id + '"></div>');
        $.ajax({
            url: service,
            data: "id=" + win_number,
            type: "POST",
            success: function(data) {
                $('#' + win_id).html(data);
            },
            error: function() {
                $('#' + win_id).html("Error ajax");
            }
        });
        $('#' + win_id).dialog({
            width: 'auto',
            height: 'auto',
            position:[300,0],
            title: win_title,
            autoOpen: true

        });
    };



    $.clickButton = function(action, service, title) {
        var object = $("." + action + "_button");
        object.click(function() {
            var win_id = action + "_window_" + win_number++;
            $.newWindow(win_id, title, service);
        });

    };



    $.Search = function(name) {
        return "search_" + name;
    };
    $.New = function(name) {
        return "new_" + name;
    };
    $.My = function(name) {
        return "my_" + name;
    };

    $.new_service = function(name) {
        return service_location + name + "/"+ $.New(name) + ".jsp";
    };
    $.search_service = function(name) {
        return service_location + name + "/"+ $.Search(name) + ".jsp";
    };
    $.my_service = function(name) {
        return service_location + name + "/"+ $.My(name) + ".jsp";
    };
    var entity = "";

    entity = "client_order";
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Pedido");
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Pedido");
    $.clickButton($.My(entity), $.my_service(entity), "Mis Pedidos");


    entity = "reserve";
    $.clickButton($.My(entity), $.my_service(entity), "Mis Reservas");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Reserva");

    entity = "product";
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Producto");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Producto");

    entity = "client";
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Cliente");
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Cliente");
    $.clickButton($.New("shipping_location"), "/shipping_location", "Datos de envio");

    entity = "delivery_note";
    $.clickButton($.My(entity), $.my_service(entity), "Mis Remitos");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Remito");

    entity = "bill";
    $.clickButton($.My(entity), $.my_service(entity), "Mis Facturas");
    $.clickButton($.Search(entity), "/search_" + entity, "Buscar Factura");

    entity = "discount";
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Descuento");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Descuento");

    entity = "shipping_method";
    $.clickButton($.New(entity), $.new_service(entity), "Nueva Forma de envio");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Descuento");

    entity = "payment_type";
    $.clickButton($.New(entity), $.new_service(entity), "Nueva Forma de pago");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Forma de pago");

    entity = "provider";
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Proveedor");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Proveedor");

    entity = "category";
    $.clickButton($.New(entity), $.new_service(entity), "Nueva Categoria");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Categoria");

    entity = "incoming";
    $.clickButton($.New(entity), $.new_service(entity), "Nuevo Ingreso");
    $.clickButton($.Search(entity), $.search_service(entity), "Buscar Ingreso");
});


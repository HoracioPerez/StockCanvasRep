
var _init = $.ui.dialog.prototype._init;
$.ui.dialog.prototype._init = function() {
    //Run the original initialization code
    _init.apply(this, arguments);

    //set some variables for use later
    var dialog_element = this;
    var dialog_id = this.uiDialogTitlebar.next().attr('id');

    //append our minimize icon
    this.uiDialogTitlebar.append('<a href="#" id="' + dialog_id +
            '-minbutton" class="ui-dialog-titlebar-minimize ui-corner-all">' +
            '<span class="ui-icon ui-icon-minusthick"></span></a>');

    //append our minimized state
    $('#dialog_window_minimized_container').append(
            '<div class="dialog_window_minimized ui-widget ui-state-default ui-corner-all" id="' +
            dialog_id + '_minimized">' + this.uiDialogTitlebar.find('.ui-dialog-title').text() +
            '<span class="ui-icon ui-icon-newwin"></div>');

    //create a hover event for the minimize button so that it looks good
    $('#' + dialog_id + '-minbutton').hover(function() {
        $(this).addClass('ui-state-hover');
    }, function() {
        $(this).removeClass('ui-state-hover');
    }).click(function() {
        //add a click event as well to do our "minimalization" of the window
        dialog_element.close();
        /* dialog_element.css({
         display: "none"
         });*/
        $('#' + dialog_id + '_minimized').show();
    });

    //create another click event that maximizes our minimized window
    $('#' + dialog_id + '_minimized').click(function() {
        $(this).hide();
        dialog_element.open();
        /*dialog_element.css({
         display: "block"
         });*/
    });
};

$(function() {
    //initialize the button and add a click function to our button so that it"ll open the window
    $("#create_button").button().click(function() {
        var create_dialog = $("#dialog_window_1");
        var create_button = $(this);

        //if the window is already open, then close it and replace the label of the button
        if (create_dialog.dialog("isOpen")) {
            create_button.button("option", "label", "Create a new window");
            create_dialog.dialog("close");
        } else {
            //otherwise, open the window and replace the label again
            create_button.button("option", "label", "Close window");
            create_dialog.dialog("open");
        }
    });

    //open our dialog window, but set autoOpen to false so it doesn"t automatically open when initialized
    $('#dialog_window_1').dialog({
        width: 'auto',
        height: 'auto',
        autoOpen: false,
        buttons: [
            {
                text: 'Create',
                click: function() {
                    //get the total number of existing dialog windows plus one (1)
                    var div_count = $('.dialog_window').length + 1;

                    //generate a unique id based on the total number
                    var div_id = 'dialog_window_' + div_count;

                    //get the title of the new window from our form, as well as the content
                    var div_title = $('#new_window_title').val();
                    var div_content = $('#new_window_content').val();

                    //generate a buttons array based on which ones of our checkboxes are checked
                    var buttons = new Array();
                    if ($('#alertbutton').is(':checked')) {
                        buttons.push({
                            text: 'ALERT',
                            click: function() {
                                alert('ALERTING from Dialog Widnow: ' + div_title);
                            }
                        });
                    }

                    if ($('#closebutton').is(':checked')) {
                        buttons.push({
                            text: 'CLOSE',
                            click: function() {
                                $('#' + div_id).dialog('close');
                            }
                        });
                    }

                    //append the dialog window HTML to the body
                    $('body').append('<div class="dialog_window" id="' + div_id + '">' + div_content + '</div>');

                    //initialize our new dialog
                    var dialog = $('#' + div_id).dialog({
                        width: 'auto',
                        height: 'auto',
                        title: div_title + div_id,
                        autoOpen: true,
                        buttons: buttons
                    });
                }
            }
        ]
    });

    //initialize our buttonset so our checkboxes are changed
    $("#buttonlist").buttonset();
});





<%-- 
    Document   : neWinSample
    Created on : 23-feb-2014, 4:42:59
    Author     : Horacio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <button id="create_button">Create a new window</button>


        <div id="dialog_window_1" class="dialog_window" title="This is our first dialog window">
            <h3>Create a new <code>Dialog</code> Window</h3>
            <table class="dialog_form">
                <tr>
                    <th>window Title</th>
                </tr>
                <tr>
                    <td><input type="text" id="new_window_title" /></td>
                </tr>
                <tr>
                    <th>
                        window Content
                    </th>
                </tr>
                <tr>
                    <td>
                        <textarea id="new_window_content"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>
                        window Buttons
                    </th>
                </tr>
                <tr>
                    <td id="buttonlist">
                        <input type="checkbox" id="alertbutton" /><label for="alertbutton">ALERT</label>
                        <input type="checkbox" id="closebutton" /><label for="closebutton">CLOSE</label>
                        <input type="checkbox" id="clonebutton" /><label for="clonebutton">CLONE</label>
                    </td>
                </tr>
            </table>
        </div>
</html>

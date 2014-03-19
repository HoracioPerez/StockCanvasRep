/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.insert;

import generic.IdObject;
import generic.Request;
import java.util.ArrayList;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
public abstract class RequestServiceInsert  extends ServiceInsert{
     
    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        
        Request request1 = new Request(
                this.request.getParameter("idOrder"),  //String id,
                this.user, // User user,
                "Pendiente", // String state,
                new java.sql.Date(new java.util.Date().getTime())); // Date date
        return request1;
    }
}

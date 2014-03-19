/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.update;

import generic.IdObject;
import generic.Request;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class RequestServiceUpdate  extends ServiceUpdate{
     
    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        
        Request request = new Request(
                parameters.get(0),  //String id,
                this.user, // User user,
                "pending", // String state,
                new java.sql.Date(new java.util.Date().getTime())); // Date date
        return request;
    }
}

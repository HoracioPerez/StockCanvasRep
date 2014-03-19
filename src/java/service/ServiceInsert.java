/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import dao.DAOObject;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class ServiceInsert extends HttpService {   

    protected String okResponse(IdObject entity) {
        Gson gson = new Gson(); 
        String json = gson.toJson(entity);
        return json;
    }

    protected abstract IdObject getEntity(ArrayList<String> parameters) throws SQLException;

    protected abstract DAOObject getDao(User user);

    @Override
    public String execute(ArrayList<String> parameters, User user) {
        try {
            IdObject entity = this.getEntity(parameters);
            if(entity!=null){
                DAOObject daoObject = this.getDao(user);
                daoObject.insert(entity);
            }            
            return this.okResponse(entity);
        } catch (SQLException ex) {
            return this.errorDBResponse();
        }
    }

    protected String errorDBResponse() {
        return "Error DB";
    }
}

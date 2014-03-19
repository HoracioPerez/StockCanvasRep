/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DAOObject;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class ServiceDelete extends HttpService{
    protected abstract DAOObject getDao(User user);

    @Override
    public String execute(ArrayList<String> parameters, User user) {
        try {
            String objId=parameters.get(0);
            DAOObject daoObject = this.getDao(user);
            daoObject.delete(objId);
            return objId;
        } catch (SQLException ex) {
            return this.errorDBResponse();
        }
    }

    protected String errorDBResponse() {
        return "Error DB";
    }
}

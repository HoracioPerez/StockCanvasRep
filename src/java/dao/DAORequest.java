package dao;

import dao.entity.DAOUser;
import entity.User;
import generic.IdObject;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAORequest extends DAOObject {

    protected DAOUser daoUser;

    public DAORequest(User user) {
        super(user);
        this.daoUser = new DAOUser(user);
    }
    
     @Override
     protected String getInsertSQL(IdObject object) {
        String query = "CALL " + this.table + "_insert("+ object.getId() + "," +  this.getIUAtr(object);
        return query;
    }
}

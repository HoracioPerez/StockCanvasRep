package dao;

import dao.entity.DAOUser;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAOOrder extends DAOObject {

    protected DAOUser daoUser;

    public DAOOrder(User user) {
        super(user);
        this.daoUser = new DAOUser(user);
    }

    protected abstract String getUAtr(IdObject object);

    protected abstract String getIAtr(IdObject object);
    
   @Override
    protected String getIUAtr(IdObject object) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
    @Override
    protected String getInsertSQL(IdObject object) {
        String query = "CALL " + this.table + "_insert(" + this.getIAtr(object);
        return query;
    }

    @Override
    protected String getUpdateSQL(IdObject object) {
        String query = "CALL " + this.table + "_update(" + object.getId() + "," + this.getUAtr(object);
        return query;
    }
}

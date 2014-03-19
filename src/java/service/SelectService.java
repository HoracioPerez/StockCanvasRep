package service;

import dao.DAOObject;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class SelectService extends HttpService{

    protected abstract DAOObject getDao(User user);

    @Override
    public String execute(ArrayList<String> parameters, User user) {
        try {
           return this.select(user);
        } catch (SQLException ex) {
            return this.errorDBResponse();
        }
    }

    protected String errorDBResponse() {
        return "Error DB";
    }

    public abstract String select(User user) throws SQLException;
}

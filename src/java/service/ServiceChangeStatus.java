package service;

import dao.DAOObject;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class ServiceChangeStatus extends HttpService {

    @Override
    public String execute(ArrayList<String> parameters, User user) {
        try {
           return this.change(user);
        } catch (SQLException ex) {
            return this.errorDBResponse();
        }
    }

    protected abstract DAOObject getDao(User user);

    protected String errorDBResponse() {
        return "Error DB";
    }

    protected abstract String change(User user) throws SQLException;
}

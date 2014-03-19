package service;

import dao.DAOObject;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class ServiceUpdate extends HttpService {

    protected String okResponse(IdObject entity) {
        return entity.getId();
    }

    protected abstract IdObject getEntity(ArrayList<String> parameters) throws SQLException;

    protected abstract DAOObject getDao(User user);

    @Override
    public String execute(ArrayList<String> parameters, User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected String errorDBResponse() {
        return "Error DB";
    }
}

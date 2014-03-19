package service.insert.entity;

import dao.DAOObject;
import dao.entity.DAOClient;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.PersonServiceInsert;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "ClientServiceInsert", urlPatterns = {"/ClientServiceInsert"})
public class ClientService extends PersonServiceInsert {  

    @Override
    protected DAOObject getDao(User user) {
        DAOClient daoClient = new DAOClient(user);
        return daoClient;
    }
}

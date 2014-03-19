package service.update.entity;

import dao.DAOObject;
import dao.entity.DAOClient;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.PersonServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ClientServiceUpdate", urlPatterns = {"/ClientServiceUpdate"})
public class ClientService extends PersonServiceUpdate {  

    @Override
    protected DAOObject getDao(User user) {
        DAOClient daoClient = new DAOClient(user);
        return daoClient;
    }
}

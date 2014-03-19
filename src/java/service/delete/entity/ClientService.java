package service.delete.entity;

import dao.DAOObject;
import dao.entity.DAOClient;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "ClientServiceDelete", urlPatterns = {"/ClientServiceDelete"})
public class ClientService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        DAOClient daoClient = new DAOClient(user);
        return daoClient;
    }
    
}

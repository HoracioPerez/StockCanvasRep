package service.delete.entity;

import dao.DAOObject;
import dao.entity.DAOProvider;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "ProviderServiceDelete", urlPatterns = {"/ProviderServiceDelete"})
public class ProviderService extends ServiceDelete{
    @Override
    protected DAOObject getDao(User user) {
        DAOProvider daoProvider = new DAOProvider(user);
        return daoProvider;
    }
}

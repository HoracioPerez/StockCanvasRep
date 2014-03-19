package service.insert.entity;

import dao.DAOObject;
import dao.entity.DAOProvider;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.PersonServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProviderServiceInsert", urlPatterns = {"/ProviderServiceInsert"})
public class ProviderService extends PersonServiceInsert{

    @Override
    protected DAOObject getDao(User user) {
        DAOProvider daoProvider = new DAOProvider(user);
        return daoProvider;
    }
}

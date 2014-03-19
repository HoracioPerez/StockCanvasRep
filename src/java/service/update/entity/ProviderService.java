package service.update.entity;

import dao.DAOObject;
import dao.entity.DAOProvider;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.PersonServiceInsert;
import service.update.PersonServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProviderServiceUpdate", urlPatterns = {"/ProviderServiceUpdate"})
public class ProviderService extends PersonServiceUpdate{

    @Override
    protected DAOObject getDao(User user) {
        DAOProvider daoProvider = new DAOProvider(user);
        return daoProvider;
    }
}

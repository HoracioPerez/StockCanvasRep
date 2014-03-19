package service.delete.entity;

import dao.entity.DAOUser;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "UserServiceDelete", urlPatterns = {"/UserServiceDelete"})
public class UserService extends ServiceDelete{

    @Override
    protected DAOUser getDao(User user) {
        return new DAOUser(user);
    }
}

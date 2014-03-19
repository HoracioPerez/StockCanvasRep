package service.update.entity;

import dao.entity.DAOUser;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "UserServiceUpdate", urlPatterns = {"/UserServiceUpdate"})
public class UserService extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {

        User entity = new User(
                parameters.get(0), // String id, 
                parameters.get(1), // String pass,         
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOUser getDao(User user) {
        return new DAOUser(user);
    }
}

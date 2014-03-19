package service.insert.entity;

import dao.entity.DAOUser;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "UserServiceInsert", urlPatterns = {"/UserServiceInsert"})
public class UserService extends ServiceInsert{

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

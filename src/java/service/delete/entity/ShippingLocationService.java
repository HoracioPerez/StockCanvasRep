package service.delete.entity;

import dao.DAOObject;
import dao.entity.DAOShippingLocation;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "ShippingLocationServiceDelete", urlPatterns = {"/ShippingLocationServiceDelete"})
public class ShippingLocationService extends ServiceDelete {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOShippingLocation(user);
    }
}

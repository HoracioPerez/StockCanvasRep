package service.delete.simple;

import dao.DAOObject;
import dao.simple.DAOShippingMethod;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ShippingMethodServiceDelete", urlPatterns = {"/ShippingMethodServiceDelete"})
public class ShippingMethodService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOShippingMethod(user);
    }
}

package service.update.simple;

import dao.DAOObject;
import dao.simple.DAOShippingMethod;
import entity.User;
import entity.simple.ShippingMethod;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ShippingMethodServiceUpdate", urlPatterns = {"/ShippingMethodServiceUpdate"})
public class ShippingMethodService extends ServiceUpdate{

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        ShippingMethod entity = new ShippingMethod(
                parameters.get(0), //String name,
                parameters.get(1), //String sumary, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOShippingMethod(user);
    }
}

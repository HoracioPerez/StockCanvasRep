package service.insert.simple;

import dao.DAOObject;
import dao.simple.DAOShippingMethod;
import entity.User;
import entity.simple.ShippingMethod;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ShippingMethodServiceInsert", urlPatterns = {"/ShippingMethodServiceInsert"})
public class ShippingMethodService extends ServiceInsert{

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

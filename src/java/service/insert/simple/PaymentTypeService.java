package service.insert.simple;

import dao.DAOObject;
import dao.simple.DAOPaymentType;
import entity.User;
import entity.simple.PaymentType;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentTypeServiceInsert", urlPatterns = {"/PaymentTypeServiceInsert"})
public class PaymentTypeService extends ServiceInsert{

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        PaymentType entity = new PaymentType(
                parameters.get(0), //String name,
                parameters.get(1), //String sumary, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentType(user);
    }
    
}

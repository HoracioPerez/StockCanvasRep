package service.insert.simple;

import dao.DAOObject;
import dao.simple.DAODiscountClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.DiscountServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountClientOrderServiceInsert", urlPatterns = {"/DiscountClientOrderServiceInsert"})
public class DiscountClientOrderService extends DiscountServiceInsert{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountClientOrder(user);
    }
    
}

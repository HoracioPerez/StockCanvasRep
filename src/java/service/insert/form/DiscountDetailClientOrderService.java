package service.insert.form;

import dao.DAOObject;
import dao.form.DAODiscountDetailClientOrder;
import dao.simple.DAODiscount;
import dao.simple.DAODiscountClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.DiscountDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountDetailClientOrderServiceInsert", urlPatterns = {"/DiscountDetailClientOrderServiceInsert"})
public class DiscountDetailClientOrderService extends DiscountDetailServiceInsert {

    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountDetailClientOrder(user);
    }

    @Override
    protected DAODiscount getDAODiscount() {
        return new DAODiscountClientOrder(user);
    }

}

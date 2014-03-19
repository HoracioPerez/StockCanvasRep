package service.update.form;

import dao.DAOObject;
import dao.form.DAODiscountDetailClientOrder;
import dao.simple.DAODiscount;
import dao.simple.DAODiscountClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.DiscountDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountDetailClientOrderServiceUpdate", urlPatterns = {"/DiscountDetailClientOrderServiceUpdate"})
public class DiscountDetailClientOrderService extends DiscountDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountDetailClientOrder(user);
    }

    @Override
    protected DAODiscount getDAODiscount() {
        return new DAODiscountClientOrder(user);
    }
}

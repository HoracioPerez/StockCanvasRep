package service.update.form;

import dao.DAOObject;
import dao.form.DAOProductDetailClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.ProductDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProductDetailClientOrderServiceUpdate", urlPatterns = {"/ProductDetailClientOrderServiceUpdate"})
public class ProductDetailClientOrderService extends ProductDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProductDetailClientOrder(user);
    }
}

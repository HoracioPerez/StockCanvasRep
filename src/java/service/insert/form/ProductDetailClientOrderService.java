package service.insert.form;

import dao.DAOObject;
import dao.form.DAOProductDetailClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.ProductDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProductDetailClientOrderServiceInsert", urlPatterns = {"/ProductDetailClientOrderServiceInsert"})
public class ProductDetailClientOrderService extends ProductDetailServiceInsert {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProductDetailClientOrder(user);
    }

}

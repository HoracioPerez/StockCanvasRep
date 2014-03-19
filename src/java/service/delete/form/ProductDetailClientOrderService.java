
package service.delete.form;

import dao.DAOObject;
import dao.form.DAOProductDetailClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "ProductDetailClientOrderServiceDelete", urlPatterns = {"/ProductDetailClientOrderServiceDelete"})
public class ProductDetailClientOrderService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProductDetailClientOrder(user);
    }

}

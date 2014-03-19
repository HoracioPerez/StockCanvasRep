package service.update.form;

import dao.DAOObject;
import dao.form.DAOProductDetailPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.ProductDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProductDetailPurchaseOrderServiceUpdate", urlPatterns = {"/ProductDetailPurchaseOrderServiceUpdate"})
public class ProductDetailPurchaseOrderService extends ProductDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProductDetailPurchaseOrder(user);
    }
}

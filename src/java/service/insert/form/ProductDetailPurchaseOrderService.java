package service.insert.form;

import dao.DAOObject;
import dao.form.DAOProductDetailPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.ProductDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProductDetailPurchaseOrderServiceInsert", urlPatterns = {"/ProductDetailPurchaseOrderServiceInsert"})
public class ProductDetailPurchaseOrderService extends ProductDetailServiceInsert {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProductDetailPurchaseOrder(user);
    }

}

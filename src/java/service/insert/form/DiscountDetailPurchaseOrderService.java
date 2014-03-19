package service.insert.form;

import dao.DAOObject;
import dao.form.DAODiscountDetailPurchaseOrder;
import dao.simple.DAODiscount;
import dao.simple.DAODiscountPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.DiscountDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountDetailPurchaseOrderServiceInsert", urlPatterns = {"/DiscountDetailPurchaseOrderServiceInsert"})
public class DiscountDetailPurchaseOrderService extends DiscountDetailServiceInsert{

     @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountDetailPurchaseOrder(user);
    }

    @Override
    protected DAODiscount getDAODiscount() {
        return new DAODiscountPurchaseOrder(user);
    }
    
}

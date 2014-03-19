package service.update.form;

import dao.DAOObject;
import dao.form.DAODiscountDetailPurchaseOrder;
import dao.simple.DAODiscount;
import dao.simple.DAODiscountPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.DiscountDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountDetailPurchaseOrderServiceUpdate", urlPatterns = {"/DiscountDetailPurchaseOrderServiceUpdate"})
public class DiscountDetailPurchaseOrderService extends DiscountDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountDetailPurchaseOrder(user);
    }

    @Override
    protected DAODiscount getDAODiscount() {
        return new DAODiscountPurchaseOrder(user);
    }
}

package service.insert.simple;

import dao.DAOObject;
import dao.simple.DAODiscountPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.DiscountServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountPurchaseOrderServiceInsert", urlPatterns = {"/DiscountPurchaseOrderServiceInsert"})
public class DiscountPurchaseOrderService extends DiscountServiceInsert{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountPurchaseOrder(user);
    }
    
}
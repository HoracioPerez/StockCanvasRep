
package service.delete.form;

import dao.DAOObject;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "DiscountDetailPurchaseOrderServiceDelete", urlPatterns = {"/DiscountDetailPurchaseOrderServiceDelete"})
public class DiscountDetailPurchaseOrderService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

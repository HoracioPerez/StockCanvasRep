
package service.delete.form;

import dao.DAOObject;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */

@WebServlet(name = "PaymentDetailPurchaseOrderServiceDelete", urlPatterns = {"/PaymentDetailPurchaseOrderServiceDelete"})
public class PaymentDetailPurchaseOrderService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

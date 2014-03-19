package service.update.form;

import dao.DAOObject;
import dao.form.DAOPaymentDetailPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.PaymentDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentDetailPurchaseOrderServiceUpdate", urlPatterns = {"/PaymentDetailPurchaseOrderServiceUpdate"})
public class PaymentDetailPurchaseOrderService extends PaymentDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentDetailPurchaseOrder(user);
    }
}

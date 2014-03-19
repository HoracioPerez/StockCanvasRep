package service.insert.form;

import dao.DAOObject;
import dao.form.DAOPaymentDetailPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.PaymentDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentDetailPurchaseOrderServiceInsert", urlPatterns = {"/PaymentDetailPurchaseOrderServiceInsert"})
public class PaymentDetailPurchaseOrderService extends PaymentDetailServiceInsert{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentDetailPurchaseOrder(user);
    }
    
}

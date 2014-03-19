package service.update.form;

import dao.DAOObject;
import dao.form.DAOPaymentDetailClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.entity.PaymentDetailServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentDetailClientOrderServiceUpdate", urlPatterns = {"/PaymentDetailClientOrderServiceUpdate"})
public class PaymentDetailClientOrderService extends PaymentDetailServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentDetailClientOrder(user);
    }
}

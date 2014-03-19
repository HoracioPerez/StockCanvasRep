package service.insert.form;
import dao.DAOObject;
import dao.form.DAOPaymentDetailClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.entity.PaymentDetailServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentDetailClientOrderServiceInsert", urlPatterns = {"/PaymentDetailClientOrderServiceInsert"})
public class PaymentDetailClientOrderService extends PaymentDetailServiceInsert{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentDetailClientOrder(user);
    }
    
}

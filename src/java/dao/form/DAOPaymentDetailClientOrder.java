package dao.form;

import dao.entity.DAOPaymentDetail;
import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOPaymentDetailClientOrder extends DAOPaymentDetail {

    public DAOPaymentDetailClientOrder(User user) {
        super(user);
        this.table = "PAYMENT_DETAIL_CLIENT_ORDER";
    }
}

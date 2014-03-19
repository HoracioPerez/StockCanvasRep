package dao.form;

import dao.entity.DAOPaymentDetail;
import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOPaymentDetailAdvance extends DAOPaymentDetail{

    public DAOPaymentDetailAdvance(User user) {
        super(user);
        this.table = "PAYMENT_DETAIL_ADVANCE";
    }
    
}

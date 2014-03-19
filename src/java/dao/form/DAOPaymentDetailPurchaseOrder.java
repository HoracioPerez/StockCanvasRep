package dao.form;

import dao.entity.DAOPaymentDetail;
import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOPaymentDetailPurchaseOrder extends DAOPaymentDetail {

    public DAOPaymentDetailPurchaseOrder(User user) {
        super(user);
        this.table = "PAYMENT_DETAIL_PURCHASE_ORDER";
    }
}

package dao.form;

import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOBillPurchaseOrder extends DAOBill {

    public DAOBillPurchaseOrder(User user) {
        super(user);
        this.table = "BILL_PURCHASE_ORDER";
    }
}

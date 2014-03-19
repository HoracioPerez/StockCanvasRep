package dao.simple;

import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAODiscountPurchaseOrder extends DAODiscount {

    public DAODiscountPurchaseOrder(User user) {
        super(user);
        this.table = "DISCOUNT_PURCHASE_ORDER";
    }
}

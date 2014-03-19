package dao.simple;

import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAODiscountClientOrder extends DAODiscount {

    public DAODiscountClientOrder(User user) {
        super(user);
        this.table = "DISCOUNT_CLIENT_ORDER";
    }
}

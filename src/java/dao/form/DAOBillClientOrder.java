package dao.form;

import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOBillClientOrder extends DAOBill {

    public DAOBillClientOrder(User user) {
        super(user);
        this.table = "BILL_CLIENT_ORDER";
    }
}

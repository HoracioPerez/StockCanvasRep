package dao.form;

import dao.entity.DAODiscountDetail;
import dao.simple.DAODiscountClientOrder;
import entity.User;
import entity.simple.Discount;
import java.sql.SQLException;

/**
 *
 * @author Horacio Perez
 */
public class DAODiscountDetailClientOrder extends DAODiscountDetail {

    private DAODiscountClientOrder daoDiscountClientOrder;

    public DAODiscountDetailClientOrder(User user) {
        super(user);
        this.table = "DISCOUNT_DETAIL_CLIENT_ORDER";
    }

    @Override
    protected Discount getDiscount(String idDiscount) throws SQLException {
        Discount discount = this.daoDiscountClientOrder.getById(idDiscount);
        return discount;
    }
}

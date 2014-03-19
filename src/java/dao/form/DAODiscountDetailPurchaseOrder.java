package dao.form;

import dao.entity.DAODiscountDetail;
import dao.simple.DAODiscountPurchaseOrder;
import entity.User;
import entity.simple.Discount;
import java.sql.SQLException;

/**
 *
 * @author Horacio Perez
 */
public class DAODiscountDetailPurchaseOrder extends DAODiscountDetail {

    private DAODiscountPurchaseOrder daoDiscountPurchaseOrder;

    public DAODiscountDetailPurchaseOrder(User user) {
        super(user);
        this.table = "DISCOUNT_DETAIL_PURCHASE_ORDER";
    }

    @Override
    protected Discount getDiscount(String idDiscount) throws SQLException {
        Discount discount = this.daoDiscountPurchaseOrder.getById(idDiscount);
        return discount;
    }
}

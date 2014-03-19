package service.update.entity;

import dao.simple.DAODiscount;
import entity.DiscountDetail;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class DiscountDetailServiceUpdate extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {     
        DiscountDetail discountDetail = new DiscountDetail(
                parameters.get(0), // String idOrder,
                Double.parseDouble(parameters.get(1)), // double amount,
                this.getDAODiscount().getById(parameters.get(2))); // Discount discount 
        return discountDetail;
    }

    protected abstract DAODiscount getDAODiscount();
}

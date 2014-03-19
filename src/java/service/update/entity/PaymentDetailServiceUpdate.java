package service.update.entity;

import dao.simple.DAOPaymentType;
import entity.PaymentDetail;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class PaymentDetailServiceUpdate extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {     
        PaymentDetail paymentDetail = new PaymentDetail(
                parameters.get(0), // String idOrder,
                Double.parseDouble(parameters.get(1)), // double amount,
                this.getDAOPaymentType().getById(parameters.get(2))); // PaymentType paymentType
        return paymentDetail;
    }

    protected DAOPaymentType getDAOPaymentType(){
        return new DAOPaymentType(user);
    }

}

package dao.simple;

import dao.DAOSimpleClass;
import entity.User;
import entity.simple.PaymentType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOPaymentType extends DAOSimpleClass {

    public DAOPaymentType(User usuario) {
        super(usuario);
        this.table = "PAYMENT_TYPE";
    }

    @Override
    public ArrayList<PaymentType> getLikeList(String id, String name, String summary, String active) throws SQLException {
        ArrayList<PaymentType> payments = super.getLikeList(id, name, summary, active);
        return payments;
    }

    @Override
    public PaymentType getById(String id) throws SQLException {
        return (PaymentType) super.getById(id);
    }

    @Override
    public ArrayList<PaymentType> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected PaymentType buildObject(ResultSet resultSet) throws SQLException {
        return (PaymentType) super.buildObject(resultSet);
    }
}

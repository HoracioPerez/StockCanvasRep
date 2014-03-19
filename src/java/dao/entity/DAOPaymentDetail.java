package dao.entity;

import dao.DAOObject;
import dao.simple.DAOPaymentType;
import entity.PaymentDetail;
import entity.User;
import entity.simple.PaymentType;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOPaymentDetail extends DAOObject {

    private DAOPaymentType daoPaymentType;

    public DAOPaymentDetail(User user) {
        super(user);
        this.daoPaymentType = new DAOPaymentType(user);
        this.field = new String[]{
            "id",
            "id_order",
            "amount",
            "id_payment_type"};
    }

    public ArrayList<PaymentDetail> getLikeList(String id, String amount, String idPaymentType, String idOrder) throws SQLException {
        String[] data = {id, amount, idPaymentType, idOrder};
        ArrayList<PaymentDetail> paymentDetails = this.queryObjectList(this.likeQuery(data));
        return paymentDetails;
    }

    public ArrayList<PaymentDetail> getByOrder(String orderId) throws SQLException {
        ArrayList<PaymentDetail> paymentDetails = this.queryObjectList("SELECT * FROM " + this.table + " WHERE id_order=" + orderId);
        return paymentDetails;
    }

    @Override
    public PaymentDetail getById(String id) throws SQLException {
        return (PaymentDetail) super.getById(id);
    }

    @Override
    public ArrayList<PaymentDetail> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected PaymentDetail buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String idOrder = resultSet.getString(this.field[1]);
        double amount = resultSet.getDouble(this.field[2]);
        String idPaymentType = resultSet.getString(this.field[2]);
        PaymentType paymentType = this.daoPaymentType.getById(idPaymentType);
        PaymentDetail paymentDetail = new PaymentDetail(id, idOrder, amount, paymentType);
        return paymentDetail;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        PaymentDetail paymentDetail = (PaymentDetail) object;
        return this.sqlText(paymentDetail.getAmount()) + ","
                + this.sqlTextID(paymentDetail.getPaymentType().getId()) + ")";
    }
}

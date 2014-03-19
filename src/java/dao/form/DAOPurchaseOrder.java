package dao.form;

import dao.DAOOrder;
import dao.entity.DAOProvider;
import entity.*;
import form.Bill;
import form.PurchaseOrder;
import generic.IdObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOPurchaseOrder extends DAOOrder {

    private DAOProvider daoProvider;
    private DAOProductDetailPurchaseOrder daoDetailPurchaseOrder;
    private DAOPaymentDetailPurchaseOrder daoPaymentDetailPurchaseOrder;
    private DAODiscountDetailPurchaseOrder daoDiscountDetailPurchaseOrder;
    private DAOBillPurchaseOrder daoBillPurchaseOrder;

    public DAOPurchaseOrder(User user) {
        super(user);
        this.daoProvider = new DAOProvider(user);
        this.daoDetailPurchaseOrder = new DAOProductDetailPurchaseOrder(user);
        this.daoPaymentDetailPurchaseOrder = new DAOPaymentDetailPurchaseOrder(user);
        this.daoDiscountDetailPurchaseOrder = new DAODiscountDetailPurchaseOrder(user);
        this.daoBillPurchaseOrder = new DAOBillPurchaseOrder(user);
        this.table = "PURCHASE_ORDER";
        this.field = new String[]{
            "id",
            "state",
            "date",
            "id_user",
            "id_provider"};
    }

    @Override
    public PurchaseOrder getById(String id) throws SQLException {
        return (PurchaseOrder) super.getById(id);
    }

    @Override
    public ArrayList<PurchaseOrder> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<PurchaseOrder> getLikeList(String id, String state, String date, String idUser, String idProvider) throws SQLException {
        String[] data = {id, state, date, idUser, idProvider};
        ArrayList<PurchaseOrder> purchaseOrders = this.queryObjectList(this.likeQuery(data));
        return purchaseOrders;
    }

    @Override
    protected PurchaseOrder buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String state = resultSet.getString(this.field[1]);
        Date date = resultSet.getDate(this.field[2]);
        String idUser = resultSet.getString(this.field[3]);
        String idProvider = resultSet.getString(this.field[4]);
        User user = this.daoUser.getById(idUser);
        Provider provider = this.daoProvider.getById(idProvider);
        ArrayList<ProductDetail> details = this.daoDetailPurchaseOrder.getByOrder(id);
        ArrayList<PaymentDetail> paymentDetails = this.daoPaymentDetailPurchaseOrder.getByOrder(id);
        ArrayList<DiscountDetail> discountDetails = this.daoDiscountDetailPurchaseOrder.getByOrder(id);
        Bill bill = this.daoBillPurchaseOrder.getById(id);
        PurchaseOrder purchaseOrder = new PurchaseOrder(id, user, state, date, details, paymentDetails, discountDetails, bill, provider);
        return purchaseOrder;
    }

    @Override
    protected String getUAtr(IdObject object) {
        PurchaseOrder purchaseOrder = (PurchaseOrder) object;
        return this.sqlText(purchaseOrder.getState()) + ","
                + this.sqlText(purchaseOrder.getDate()) + ","
                + this.sqlText(purchaseOrder.getUser().getId()) + ","
                + this.sqlTextID(purchaseOrder.getProvider().getId()) + ")";
    }

    @Override
    protected String getIAtr(IdObject object) {
        PurchaseOrder purchaseOrder = (PurchaseOrder) object;
        return this.sqlText(purchaseOrder.getState()) + ","
                + this.sqlText(purchaseOrder.getDate()) + ","
                + this.sqlText(purchaseOrder.getUser().getId()) + ")";
    }
}

package dao.form;

import dao.DAOOrder;
import dao.entity.DAOClient;
import entity.*;
import form.Bill;
import form.ClientOrder;
import form.DeliveryNote;
import form.Reservation;
import generic.IdObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOClientOrder extends DAOOrder {

    private DAOClient daoClient;
    private DAOProductDetailClientOrder daoDetailClientOrder;
    private DAOPaymentDetailAdvance daoPaymentDetailAdvance;
    private DAOPaymentDetailClientOrder daoPaymentDetailClientOrder;
    private DAODiscountDetailClientOrder daoDiscountDetailClientOrder;
    private DAOBillClientOrder daoBillClientOrder;
    private DAODeliveryNote daoDeliveryNote;
    private DAOReservation daoReservation;

    public DAOClientOrder(User user) {
        super(user);
        this.daoClient = new DAOClient(user);
        this.daoDetailClientOrder = new DAOProductDetailClientOrder(user);
        this.daoPaymentDetailAdvance = new DAOPaymentDetailAdvance(user);
        this.daoPaymentDetailClientOrder = new DAOPaymentDetailClientOrder(user);
        this.daoDiscountDetailClientOrder = new DAODiscountDetailClientOrder(user);
        this.daoBillClientOrder = new DAOBillClientOrder(user);
        this.daoDeliveryNote = new DAODeliveryNote(user);
        this.daoReservation = new DAOReservation(user);

        this.table = "CLIENT_ORDER";
        this.field = new String[]{
            "id",
            "state",
            "date",
            "id_user",
            "id_client"};
    }

    @Override
    public ClientOrder getById(String id) throws SQLException {
        return (ClientOrder) super.getById(id);
    }  
    
    
    @Override
    public ArrayList<ClientOrder> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<ClientOrder> getLikeList(String id, String state, String date, String idUser, String idClient) throws SQLException {
        String[] data = {id, state, date, idUser, idClient};
        ArrayList<ClientOrder> clientOrders = this.queryObjectList(this.likeQuery(data));
        return clientOrders;
    }

    @Override
    protected ClientOrder buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String state = resultSet.getString(this.field[1]);
        Date date = resultSet.getDate(this.field[2]);
        String idUser = resultSet.getString(this.field[3]);
        String idClient = resultSet.getString(this.field[4]);
        User user = this.daoUser.getById(idUser);
        Client client = this.daoClient.getById(idClient);
        ArrayList<ProductDetail> details = this.daoDetailClientOrder.getByOrder(id);
        ArrayList<PaymentDetail> paymentDetails = this.daoPaymentDetailClientOrder.getByOrder(id);
        ArrayList<PaymentDetail> paymentDetailsAdvance = this.daoPaymentDetailAdvance.getByOrder(id);
        ArrayList<DiscountDetail> discountDetails = this.daoDiscountDetailClientOrder.getByOrder(id);
        Bill bill = this.daoBillClientOrder.getById(id);
        DeliveryNote deliveryNote = this.daoDeliveryNote.getById(id);
        Reservation reservation = this.daoReservation.getById(id);
        ClientOrder clientOrder = new ClientOrder(id, user, state, date, details, paymentDetails, paymentDetailsAdvance, discountDetails, bill, client, deliveryNote, reservation);
        return clientOrder;
    }

    
  

    

    @Override
    protected String getIAtr(IdObject object) {
        ClientOrder clientOrder = (ClientOrder) object;
        return this.sqlText(clientOrder.getState()) + ","
                + this.sqlText(clientOrder.getDate()) + ","
                + this.sqlText(clientOrder.getUser().getId()) + ")";
    }

    @Override
    protected String getUAtr(IdObject object) {
         ClientOrder clientOrder = (ClientOrder) object;
        return this.sqlText(clientOrder.getState()) + ","
                + this.sqlText(clientOrder.getDate()) + ","
                + this.sqlText(clientOrder.getUser().getId()) + ","
                + this.sqlTextID(clientOrder.getClient().getId()) + ")";
    }

    public void selectClient(ClientOrder clientOrder, String parameter) throws SQLException {
        Client client=this.daoClient.getById(parameter);
        clientOrder.setClient(client);
        this.update(clientOrder);
    }

    public void changeStatus(ClientOrder clientOrder, String parameter)throws SQLException {        
        clientOrder.setState(parameter);
        this.update(clientOrder);
    }
 
  

}

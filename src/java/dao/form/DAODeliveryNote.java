package dao.form;

import dao.DAORequest;
import dao.entity.DAOShippingLocation;
import dao.simple.DAOShippingMethod;
import entity.ShippingLocation;
import entity.User;
import entity.simple.ShippingMethod;
import form.DeliveryNote;
import generic.IdObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAODeliveryNote extends DAORequest {

    private DAOShippingLocation daoShippingLocation;
    private DAOShippingMethod daoShippingMethod;

    public DAODeliveryNote(User user) {
        super(user);
        this.daoShippingLocation = new DAOShippingLocation(user);
        this.daoShippingMethod = new DAOShippingMethod(user);
        this.table = "DELIVERY_NOTE";
        this.field = new String[]{
            "id",
            "state",
            "date",
            "id_user",
            "id_shipping_method",
            "id_shipping_location",};
    }

    @Override
    public DeliveryNote getById(String id) throws SQLException {
        return (DeliveryNote) super.getById(id);
    }

    @Override
    public ArrayList<DeliveryNote> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<DeliveryNote> getLikeList(String id, String state, String date, String idUser, String idShippingMethod, String idShippingLocation) throws SQLException {
        String[] data = {id, state, date, idUser, idShippingMethod, idShippingLocation};
        ArrayList<DeliveryNote> deliveryNotes = this.queryObjectList(this.likeQuery(data));
        return deliveryNotes;
    }

    @Override
    protected DeliveryNote buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String state = resultSet.getString(this.field[1]);
        Date date = resultSet.getDate(this.field[2]);
        String idUser = resultSet.getString(this.field[3]);
        String idShippingMethod = resultSet.getString(this.field[4]);
        String idShippingLocation = resultSet.getString(this.field[5]);
        User user = this.daoUser.getById(idUser);
        ShippingMethod shippingMethod = this.daoShippingMethod.getById(idShippingMethod);
        ShippingLocation shippingLocation = this.daoShippingLocation.getById(idShippingLocation);
        DeliveryNote deliveryNote = new DeliveryNote(id, state, date, user, shippingMethod, shippingLocation);
        return deliveryNote;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        DeliveryNote deliveryNote = (DeliveryNote) object;
        return this.sqlText(deliveryNote.getState()) + ","
                + this.sqlText(deliveryNote.getDate()) + ","
                + this.sqlText(deliveryNote.getUser().getId()) + ","
                + this.sqlTextID(deliveryNote.getShippingMethod().getId()) + ","
                + this.sqlTextID(deliveryNote.getShippingLocation().getId()) + ")";
    }
}

package dao.entity;

import dao.DAOObject;
import entity.ShippingLocation;
import entity.User;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOShippingLocation extends DAOObject {

    public DAOShippingLocation(User usuario) {
        super(usuario);
        this.table = "SHIPPING_LOCATION";
        this.field = new String[]{
            "id",           
            "contact_name",
            "street",
            "cp",
            "province",
            "country",
            "time",  
            "id_client",
            "active"};
    }

    public ArrayList<ShippingLocation> getLikeList(String id, String contactName, String street, String cp, String province, String country, String time, String idClient, String active) throws SQLException {
        String[] data = {id, contactName, street, cp, province, country, time, idClient, active};
        ArrayList<ShippingLocation> shippingLocations = this.queryObjectList(this.likeQuery(data));
        return shippingLocations;
    }

    ArrayList<ShippingLocation> getByClient(String idClient) throws SQLException {
        return this.queryObjectList("SELECT * FROM " + this.table + " WHERE id_client=" + idClient);
    }

    @Override
    public ShippingLocation getById(String id) throws SQLException {
        return (ShippingLocation) super.getById(id);
    }

    @Override
    public ArrayList<ShippingLocation> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected String getIUAtr(IdObject object) {
        ShippingLocation shippingLocation = (ShippingLocation) object;
        return this.sqlText(shippingLocation.getContactName()) + ","
                + this.sqlText(shippingLocation.getStreet()) + ","
                + this.sqlText(shippingLocation.getCp()) + ","
                + this.sqlText(shippingLocation.getProvince()) + ","
                + this.sqlText(shippingLocation.getCountry()) + ","
                + this.sqlText(shippingLocation.getTime()) + ","
                + this.sqlText(shippingLocation.getActive()) + ")";
        
    }

    @Override
    protected ShippingLocation buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);        
        String contactName = resultSet.getString(this.field[1]);
        String street = resultSet.getString(this.field[2]);
        String cp = resultSet.getString(this.field[3]);
        String province = resultSet.getString(this.field[4]);
        String country = resultSet.getString(this.field[5]);
        String time = resultSet.getString(this.field[6]);
        String idClient= resultSet.getString(this.field[7]);
        boolean active = (resultSet.getInt(this.field[8]) == 1);
        ShippingLocation shippingLocation= new ShippingLocation(id, idClient,contactName, street, cp, province, country, time, active);
        return shippingLocation;
    }
}

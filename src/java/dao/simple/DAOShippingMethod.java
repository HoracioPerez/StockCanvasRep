package dao.simple;

import dao.DAOSimpleClass;
import entity.User;
import entity.simple.ShippingMethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOShippingMethod extends DAOSimpleClass {

    public DAOShippingMethod(User usuario) {
        super(usuario);
        this.table = "SHIPPING_METHOD";
    }

    @Override
    public ArrayList<ShippingMethod> getLikeList(String id, String name, String summary, String active) throws SQLException {
        ArrayList<ShippingMethod> shippingMethod = super.getLikeList(id, name, summary, active);
        return shippingMethod;
    }

    @Override
    public ShippingMethod getById(String id) throws SQLException {
        return (ShippingMethod) super.getById(id);
    }

    @Override
    public ArrayList<ShippingMethod> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected ShippingMethod buildObject(ResultSet resultSet) throws SQLException {
        return (ShippingMethod) super.buildObject(resultSet);
    }
}

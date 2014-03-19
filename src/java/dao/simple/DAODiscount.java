package dao.simple;

import dao.DAOObject;
import entity.User;
import entity.simple.Discount;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAODiscount extends DAOObject {

    public DAODiscount(User user) {
        super(user);
        this.field = new String[]{
            "id",
            "name",
            "summary",
            "percentage",
            "active"};
    }

    public ArrayList<Discount> getLikeList(String id, String name, String summary, String percentage, String active) throws SQLException {
        String[] data = {id, name, summary, percentage, active};
        ArrayList<Discount> discounts = this.queryObjectList(this.likeQuery(data));
        return discounts;
    }

    @Override
    public Discount getById(String id) throws SQLException {
        return (Discount) super.getById(id);
    }

    @Override
    public ArrayList<Discount> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected Object buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String name = resultSet.getString(this.field[1]);
        String summary = resultSet.getString(this.field[2]);
        int percentage = resultSet.getInt(this.field[3]);
        boolean active = (resultSet.getInt(this.field[4]) == 1);
        Discount discount = new Discount(id, name, summary, percentage, active);
        return discount;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        Discount discount = (Discount) object;
        return this.sqlText(discount.getName()) + ","
                + this.sqlText(discount.getSummary()) + ","
                + this.sqlText(discount.getPercentage()) + ","
                + this.sqlText(discount.isActive()) + ")";
    }
}

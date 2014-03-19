package dao.form;

import dao.DAORequest;
import entity.User;
import form.Bill;
import generic.IdObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOBill extends DAORequest {

    public DAOBill(User user) {
        super(user);
        this.field = new String[]{
            "id",
            "type",
            "cuit",
            "state",
            "date",
            "id_user"};
    }  

    @Override
    public Bill getById(String id) throws SQLException {
        return (Bill) super.getById(id);
    }

    @Override
    public ArrayList<Bill> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<Bill> getLikeList(String id, String type, String cuit, String state, String date, String idUser, String idOrder) throws SQLException {
        String[] data = {id, type, cuit, state, date, idUser, idOrder};
        ArrayList<Bill> bills = this.queryObjectList(this.likeQuery(data));
        return bills;
    }

    @Override
    protected Bill buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String type = resultSet.getString(this.field[1]);
        String cuit = resultSet.getString(this.field[2]);
        String state = resultSet.getString(this.field[3]);
        Date date = resultSet.getDate(this.field[4]);
        String userId = resultSet.getString(this.field[5]);
        User user = this.daoUser.getById(userId);
        Bill bill = new Bill(id, type, cuit, state, date, user);
        return bill;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        Bill bill = (Bill) object;
        return this.sqlText(bill.getType()) + ","
                + this.sqlText(bill.getCuit()) + ","
                + this.sqlText(bill.getState()) + ","
                + this.sqlText(bill.getDate()) + ","
                + this.sqlText(bill.getUser().getId()) + ")";
    }  
    
}

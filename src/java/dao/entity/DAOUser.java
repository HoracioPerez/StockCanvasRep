package dao.entity;

import dao.DAOObject;
import entity.User;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOUser extends DAOObject {

    public DAOUser(User user) {
        super(user);
        this.table = "USER";
        this.field = new String[]{
            "id",
            "pass",
            "active"};
    }

    @Override
    public User getById(String id) throws SQLException {      
        return (User)this.queryObject("SELECT * FROM " + this.table + " WHERE " + this.field[0] + "=" + this.sqlText(id));
    }

    public ArrayList<User> getLikeList(String id, String pass, String active) throws SQLException {
        String[] data = {id, pass, active};
        ArrayList<User> users = this.queryObjectList(this.likeQuery(data));
        return users;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected User buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String pass = resultSet.getString(this.field[1]);
        boolean active = (resultSet.getInt(this.field[2]) == 1);
        User user = new User(id, pass, active);
        return user;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        User user = (User) object;
        return this.sqlText(user.getPass()) + ","
                + this.sqlText(user.isActive()) + ")";
    }
}

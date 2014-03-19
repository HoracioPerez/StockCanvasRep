package dao.entity;

import dao.DAOPerson;
import entity.Provider;
import entity.User;
import generic.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOProvider extends DAOPerson {

    public DAOProvider(User user) {
        super(user);
        this.table = "PROVIDER";
        this.field = new String[]{
            "id",
            "name",
            "last_name",
            "email",
            "phone",
            "address",
            "active"};
    }

    @Override
    public ArrayList<Provider> getLikeList(String id, String name, String lastName, String email, String phone, String address, String active) throws SQLException {
        ArrayList<Provider> providers = super.getLikeList(id, name, lastName, email, phone, address, active);
        return providers;
    }

    @Override
    public Provider getById(String id) throws SQLException {
        return (Provider) super.getById(id);
    }

    @Override
    public ArrayList<Provider> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected Provider buildObject(ResultSet resultSet) throws SQLException {
        Person person = super.buildObject(resultSet);
        Provider provider = new Provider(person.getId(), person.getName(), person.getLastName(), person.getEmail(), person.getPhone(), person.getAddress(), person.isActive());
        return provider;
    }
}

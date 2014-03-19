package dao.entity;

import DB.DB;
import dao.DAOPerson;
import entity.Client;
import entity.ShippingLocation;
import entity.User;
import generic.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOClient extends DAOPerson {

    DAOShippingLocation daoShippingLocation;

    public DAOClient(User user) {
        super(user);
        this.daoShippingLocation = new DAOShippingLocation(user);
        this.table = "CLIENT";
        this.field = new String[]{
            "id",
            "name",
            "last_name",
            "email",
            "phone",
            "address",
            "active"};
    }

    public void addShippingLocation(Client client, ShippingLocation shippingLocation) throws SQLException {        
        String query = "CALL " + this.table + "_add_ShippingLocaction(" + client.getId() + "," + shippingLocation.getId() + ")";
        DB db=new DB(this.connection);
        db.execute(query);
    }

    public void removeShippingLocation(Client client, ShippingLocation shippingLocation) throws SQLException {
        String query = "CALL " + this.table + "_remove_ShippingLocaction(" + client.getId() + "," + shippingLocation.getId() + ")";
        DB db=new DB(this.connection);
        db.execute(query);
    }

    @Override
    public ArrayList<Client> getLikeList(String id, String name, String lastName, String email, String phone, String address, String active) throws SQLException {
        ArrayList<Client> clients = super.getLikeList(id, name, lastName, email, phone, address, active);
        return clients;
    }

    @Override
    public Client getById(String id) throws SQLException {
        return (Client) super.getById(id);
    }

    @Override
    public ArrayList<Client> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected Client buildObject(ResultSet resultSet) throws SQLException {
        Person person = super.buildObject(resultSet);
        ArrayList<ShippingLocation> shippingLocations = this.daoShippingLocation.getByClient(person.getId());
        Client client = new Client(person.getId(), person.getName(), person.getLastName(), person.getEmail(), person.getPhone(), person.getAddress(), person.isActive(), shippingLocations);
        return client;
    }
}

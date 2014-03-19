package dao;

import entity.User;
import generic.IdObject;
import generic.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOPerson extends DAOObject{

    public DAOPerson(User user) {
        super(user);
    }      
    
    public ArrayList getLikeList(String id, String name, String lastName, String email, String phone, String address, String active) throws SQLException {
        String[] data = {id, name, lastName, email, phone, address, active};
        ArrayList persons = this.queryObjectList(this.likeQuery(data));
        return persons;
    }    
    
    @Override
    protected String getIUAtr(IdObject object) {
        Person person = (Person) object;
        return this.sqlText(person.getName()) + ","
                + this.sqlText(person.getLastName()) + ","
                + this.sqlText(person.getEmail()) + ","
                + this.sqlText(person.getAddress()) + ","
                + this.sqlText(person.getPhone()) + ","
                + this.sqlText(person.isActive()) + ")";
    }
    
    @Override
    protected Person buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String name = resultSet.getString(this.field[1]);
        String lastName = resultSet.getString(this.field[2]);
        String email = resultSet.getString(this.field[3]);
        String phone = resultSet.getString(this.field[4]);
        String address = resultSet.getString(this.field[5]);
        boolean active = (resultSet.getInt(this.field[6]) == 1);
        Person person= new Person(id, name, lastName, email, address, phone, active);
        return person;
    }

    
}

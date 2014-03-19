package entity;

import generic.Person;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class Client extends Person {

    ArrayList<ShippingLocation> shippingLocations;

    public Client(String id, String name, String lastName, String email, String address, String phone, boolean active, ArrayList<ShippingLocation> shippingLocations) {
        super(id, name, lastName, email, address, phone, active);
        this.shippingLocations = shippingLocations;
    }

    public Client(String name, String lastName, String email, String address, String phone, boolean active, ArrayList<ShippingLocation> shippingLocations) {
        super(name, lastName, email, address, phone, active);
        this.shippingLocations = shippingLocations;
    }

    public ArrayList<ShippingLocation> getShippingLocations() {
        return shippingLocations;
    }

    public void setShippingLocations(ArrayList<ShippingLocation> shippingLocations) {
        this.shippingLocations = shippingLocations;
    }

    @Override
    public String toString() {
        return "Client{" + this.id + '}';
    }

    public String toSelectJsonTable() {
        String result = "[\"" + id + "\",\"" + name + "\",\"" + lastName + "\",\"" + email + "\",\"" + phone + "\",\"" + address + "\",\"" + "<input class='select ui-button ui-widget ui-state-default ui-corner-all' type='button' value='Seleccionar' />" + "\"]";
        return result;
    }
}

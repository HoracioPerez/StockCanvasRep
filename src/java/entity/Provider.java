package entity;

import generic.Person;

/**
 *
 * @author Horacio Perez
 */
public class Provider extends Person {

    public Provider(String id, String name, String lastName, String email, String address, String phone, boolean active) {
        super(id, name, lastName, email, address, phone, active);
    }

    public Provider(String name, String lastName, String email, String address, String phone, boolean active) {
        super(name, lastName, email, address, phone, active);
    }
}

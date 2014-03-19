package service.update;

import generic.IdObject;
import generic.Person;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class PersonServiceUpdate extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
    
        Person entity = new Person(
                parameters.get(0), // String name,
                parameters.get(1),// String lastName,
                parameters.get(2),// String email,
                parameters.get(3),// String address,
                parameters.get(4),//  String phone,
                true); // boolean active
        return entity;
    }
}

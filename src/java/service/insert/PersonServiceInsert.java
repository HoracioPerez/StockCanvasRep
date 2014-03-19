package service.insert;

import generic.IdObject;
import generic.Person;
import java.util.ArrayList;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
public abstract class PersonServiceInsert extends ServiceInsert {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
    
        Person entity = new Person(
                this.request.getParameter("name"),// String name,
                this.request.getParameter("lastName"),// String lastName,
                this.request.getParameter("email"),// String email,
                this.request.getParameter("address"),// String address,
                this.request.getParameter("phone"),//  String phone,
                true); // boolean active
        return entity;
    }
}

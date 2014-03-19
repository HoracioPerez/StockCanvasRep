package form;

import entity.User;
import generic.Request;
import java.sql.Date;

/**
 *
 * @author Horacio Perez
 */
public class Reservation extends Request {

    public Reservation(String id, String state, Date date, User user) {
        super(id, user, state, date);
    }
}

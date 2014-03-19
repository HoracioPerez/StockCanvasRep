package generic;

import entity.User;
import java.sql.Date;

/**
 *
 * @author Horacio Perez
 */
public class Request extends IdObject {

    protected User user;
    protected String state;
    protected Date date;   

    public Request(String id, User user, String state, Date date) {
        super(id);
        this.user = user;
        this.state = state;
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

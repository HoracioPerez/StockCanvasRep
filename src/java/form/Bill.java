package form;

import entity.User;
import generic.Request;
import java.sql.Date;

/**
 *
 * @author Horacio Perez
 */
public class Bill extends Request {

    private String type;
    private String cuit;

    public Bill(String id, String type, String cuit, String state, Date date, User user) {
        super(id, user, state, date);
        this.type = type;
        this.cuit = cuit;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}

package form;

import entity.ShippingLocation;
import entity.User;
import entity.simple.ShippingMethod;
import generic.Request;
import java.sql.Date;

/**
 *
 * @author Horacio Perez
 */
public class DeliveryNote extends Request {

    private ShippingMethod shippingMethod;
    private ShippingLocation shippingLocation;

    public DeliveryNote(String id, User user, String state, Date date) {
        super(id, user, state, date);
    }   

    public DeliveryNote(String id, String state, Date date, User user, ShippingMethod shippingMethod, ShippingLocation shippingLocation) {
        super(id, user, state, date);
        this.shippingMethod = shippingMethod;
        this.shippingLocation = shippingLocation;
    }

    public ShippingLocation getShippingLocation() {
        return shippingLocation;
    }

    public void setShippingLocation(ShippingLocation shippingLocation) {
        this.shippingLocation = shippingLocation;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}

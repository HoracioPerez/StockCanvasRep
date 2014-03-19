package form;

import entity.*;
import generic.Order;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class PurchaseOrder extends Order {

    private Provider provider;

    public PurchaseOrder(User user) {
        super(user);
    }

    public PurchaseOrder(User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<DiscountDetail> discountDetails, Bill bill, Provider provider) {
        super(user, state, date, details, paymentDetails, discountDetails, bill);
        this.provider = provider;
    }

    public PurchaseOrder(String id, User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<DiscountDetail> discountDetails, Bill bill, Provider provider) {
        super(id, user, state, date, details, paymentDetails, discountDetails, bill);
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}

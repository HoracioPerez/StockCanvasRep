package generic;

import entity.DiscountDetail;
import entity.PaymentDetail;
import entity.ProductDetail;
import entity.User;
import form.Bill;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class Order extends IdObject {

    protected User user;
    protected String state;
    protected Date date;
    protected ArrayList<ProductDetail> details;
    protected ArrayList<PaymentDetail> paymentDetails;
    protected ArrayList<DiscountDetail> discountDetails;
    protected Bill bill;

    public Order(String id, User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<DiscountDetail> discountDetails, Bill bill) {
        super(id);
        this.user = user;
        this.state = state;
        this.date = date;
        this.details = details;
        this.paymentDetails = paymentDetails;
        this.discountDetails = discountDetails;
        this.bill = bill;
    }

    public Order(User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<DiscountDetail> discountDetails, Bill bill) {
        this.user = user;
        this.state = state;
        this.date = date;
        this.details = details;
        this.paymentDetails = paymentDetails;
        this.discountDetails = discountDetails;
        this.bill = bill;
    }

    public Order(User user) {
        this.user = user; 
        this.date = new java.sql.Date(new java.util.Date().getTime());
        this.state = "Pendiente";
    }

    public ArrayList<ProductDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<ProductDetail> details) {
        this.details = details;
    }

    public ArrayList<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(ArrayList<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ArrayList<DiscountDetail> getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(ArrayList<DiscountDetail> discountDetails) {
        this.discountDetails = discountDetails;
    }

    public String getState() {
        return state;
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

    public void setState(String state) {
        this.state = state;
    }
}

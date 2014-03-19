package form;

import entity.*;
import generic.Order;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class ClientOrder extends Order {

    private Client client;
    private ArrayList<PaymentDetail> paymentDetailAdvance;
    private DeliveryNote deliveryNote;
    private Reservation reservation;

    public ClientOrder(User user) {
        super(user);
    }

    public ClientOrder(User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<PaymentDetail> paymentDetailsAdvance, ArrayList<DiscountDetail> discountDetails, Bill bill, Client client, DeliveryNote deliveryNote, Reservation reservation) {
        super(user, state, date, details, paymentDetails, discountDetails, bill);
        this.client = client;
        this.paymentDetailAdvance = paymentDetailsAdvance;
        this.deliveryNote = deliveryNote;
        this.reservation = reservation;
    }

    public ClientOrder(String id, User user, String state, Date date, ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<PaymentDetail> paymentDetailsAdvance, ArrayList<DiscountDetail> discountDetails, Bill bill, Client client, DeliveryNote deliveryNote, Reservation reservation) {
        super(id, user, state, date, details, paymentDetails, discountDetails, bill);
        this.client = client;
        this.paymentDetailAdvance = paymentDetailsAdvance;
        this.deliveryNote = deliveryNote;
        this.reservation = reservation;
    }
    
    public double getTotal(){
        double total=0;
        for (ProductDetail productDetail : details) {
            total+=productDetail.getSubtotal();
        }
        return total;
    }
    
    
    public String toOpenJsonTable(){
        String clientName="";
        String clientLastName="";
        if(this.client!=null){
            clientName=client.getName();
            clientLastName=client.getLastName();
        }
        return "[\""+id+"\",\""+user.getId()+"\",\""+state+"\",\""+date+"\",\""+clientName+"\",\""+clientLastName+"\",\""+"<input class='open ui-button ui-widget ui-state-default ui-corner-all' type='button' value='Abrir' />"+"\"]";
    
    }
    public DeliveryNote getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(DeliveryNote deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<PaymentDetail> getPaymentDetailAdvance() {
        return paymentDetailAdvance;
    }

    public void setPaymentDetailAdvance(ArrayList<PaymentDetail> paymentDetailAdvance) {
        this.paymentDetailAdvance = paymentDetailAdvance;
    }
}

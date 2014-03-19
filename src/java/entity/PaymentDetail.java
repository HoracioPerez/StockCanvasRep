package entity;

import entity.simple.PaymentType;
import generic.Detail;

/**
 *
 * @author Horacio Perez
 */
public class PaymentDetail extends Detail {
    
    private PaymentType paymentType;

      public PaymentDetail(String idOrder, double amount, PaymentType paymentType) {      
        super(idOrder, amount);
        this.paymentType = paymentType;        
    }

    public PaymentDetail(String id,String idOrder, double amount, PaymentType paymentType) {
        super(id, idOrder, amount);
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}

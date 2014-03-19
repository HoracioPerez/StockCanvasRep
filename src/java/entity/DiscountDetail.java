package entity;

import entity.simple.Discount;
import generic.Detail;

/**
 *
 * @author Horacio Perez
 */
public class DiscountDetail extends Detail {
    
    private Discount discount;

    public DiscountDetail(String idOrder, double amount, Discount discount) {      
        super(idOrder, amount);
        this.discount = discount;        
    }

    public DiscountDetail(String id,String idOrder, double amount, Discount discount) {
        super(id, idOrder, amount);
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }   
    
}

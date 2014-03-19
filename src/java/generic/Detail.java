/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic;

/**
 *
 * @author Horacio Perez
 */
public class Detail extends IdObject {

    protected String idOrder;
    protected double amount;

    public Detail(String id,String idOrder, double amount) {
        super(id);
        this.idOrder = idOrder;
        this.amount = amount;
    }

    public Detail(String idOrder, double amount) {
        this.idOrder = idOrder;
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }
}

package entity;

import entity.simple.Category;
import generic.Detail;

/**
 *
 * @author Horacio Perez
 */
public class ProductDetail extends Detail {

    private double price;
    private Product product;

    public ProductDetail(String idOrder, double amount, Product product) {
        super(idOrder, amount);
        this.product = product;
        this.price = product.getPrice();
    }

    public ProductDetail(String id, String idOrder, double amount, Product product) {
        super(id, idOrder, amount);
        this.product = product;
        this.price = product.getPrice();
    }

    public ProductDetail(String id, String idOrder, double amount, double price, Product product) {
        super(id, idOrder, amount);
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExistencia() {
        return this.product.getStock().getAvailableStock() >= this.amount;
    }

    public double getSubtotal() {
        return this.price * this.amount;
    }

    public String toEditJsonTable() {
       
        Category category = this.product.getCategory();
        String categoryName = category.getName();
        String name = this.product.getName();
        String deleteButton = "<div class='remove'><span class='ui-icon ui-icon-closethick'></span></div>";
        String result = "[\"" + this.id + "\",\""                 
                + categoryName + "\",\"" 
                + name + "\",\"" 
                + this.amount + "\",\"" 
                + this.price + "\",\"" 
                + this.getSubtotal() + "\",\"" 
                + deleteButton + "\"]";
        return result;
    }
}

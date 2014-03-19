package entity;

import entity.simple.Category;
import generic.IdObject;

/**
 *
 * @author Horacio Perez
 */
public class Product extends IdObject {

    private String name;
    private Double price;
    private String detail;
    private Category category;
    private Stock stock;
    private boolean active;

    public Product(String id, String name, Double price, String detail, Category category, Stock stock, boolean active) {
        super(id);
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.category = category;
        this.stock = stock;
        this.active = active;
    }

    public Product(String name, Double price, String detail, Category category, Stock stock, boolean active) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.category = category;
        this.stock = stock;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
     public String toAddJsonTable() {
          String amountSpinner = "<input class='amount' name='value'>";
         String button="<input class='add ui-button ui-widget ui-state-default ui-corner-all' type='button' value='Agregar' />";
        String result = "[\"" + id + "\",\"" 
                + amountSpinner + "\",\"" 
                + name + "\",\"" 
                + price + "\",\"" 
                + detail + "\",\"" 
                + category.getName() + "\",\"" 
                + stock.getAvailableStock() + "\",\"" 
                + button + "\"]";
        return result;
    }
}

 
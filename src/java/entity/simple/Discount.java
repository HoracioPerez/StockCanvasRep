package entity.simple;

import generic.SimpleClass;

/**
 *
 * @author Horacio Perez
 */
public class Discount extends SimpleClass {

    private int percentage;

    public Discount(String id, String name, String summary, int percentage, boolean active) {
        super(id, name, summary, active);
        this.percentage = percentage;
    }

    public Discount(String id, String name, String sumary, int percentage) {
        super(id, name, sumary);
        this.percentage = percentage;
    }

    public Discount(String name, String sumary, int percentage, boolean active) {
        super(name, sumary);
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}

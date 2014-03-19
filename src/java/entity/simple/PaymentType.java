package entity.simple;

import generic.SimpleClass;

/**
 *
 * @author Horacio Perez
 */
public class PaymentType extends SimpleClass {

    public PaymentType(String id, String name, String summary, boolean active) {
        super(id, name, summary, active);
    }

    public PaymentType(String id, String name, String sumary) {
        super(id, name, sumary);
    }

    public PaymentType(String name, String sumary, boolean active) {
        super(name, sumary);
    }

    public PaymentType() {
    }
}

package entity.simple;

import generic.SimpleClass;

/**
 *
 * @author Horacio Perez
 */
public class ShippingMethod extends SimpleClass {

    public ShippingMethod(String id, String name, String summary, boolean active) {
        super(id, name, summary, active);
    }

    public ShippingMethod(String id, String name, String sumary) {
        super(id, name, sumary);
    }

    public ShippingMethod(String name, String sumary, boolean active) {
        super(name, sumary);
    }

    public ShippingMethod() {
    }
}

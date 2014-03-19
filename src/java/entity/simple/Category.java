package entity.simple;

import generic.SimpleClass;

/**
 *
 * @author Horacio Perez
 */
public class Category extends SimpleClass {

    public Category(String id, String name, String summary, boolean active) {
        super(id, name, summary, active);
    }

    public Category(String id, String name, String sumary) {
        super(id, name, sumary);
    }

    public Category(String name, String sumary, boolean active) {
        super(name, sumary);
    }

    public Category() {
    }
}

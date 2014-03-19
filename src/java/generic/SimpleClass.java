package generic;

/**
 *
 * @author Horacio Perez
 */
public class SimpleClass extends IdObject {

    protected String name;
    protected String summary;
    protected boolean active;

    public SimpleClass() {
    }

    public SimpleClass(String name, String sumary) {
        this.name = name;
        this.summary = sumary;
        this.active = true;
    }

    public SimpleClass(String id, String name, String sumary) {
        super(id);
        this.name = name;
        this.summary = sumary;
    }

    public SimpleClass(String id, String name, String summary, boolean active) {
        super(id);
        this.name = name;
        this.summary = summary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getActive() {
        if (this.isActive()) {
            return 1;
        } else {
            return 0;
        }
    }
}

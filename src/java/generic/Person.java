package generic;

/**
 *
 * @author Horacio Perez
 */
public class Person extends IdObject {

    protected String name;
    protected String lastName;
    protected String email;
    protected String address;
    protected String phone;
    protected boolean active;

    public Person(String name, String lastName, String email, String address, String phone, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }

    public Person(String id, String name, String lastName, String email, String address, String phone, boolean active) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String apellido) {
        this.lastName = apellido;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
       
    public String toJsonTable(){
        return "[\""+id+"\",\""+name+"\",\""+lastName+"\",\""+email+"\",\""+address+"\",\""+phone+"\"]";
    }
    
}

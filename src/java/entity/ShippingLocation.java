package entity;

import form.DeliveryNote;
import generic.IdObject;

/**
 *
 * @author Horacio Perez
 */
public class ShippingLocation extends IdObject {
    
    private String idClient;
    private String contactName;
    private String street;
    private String cp;
    private String province;
    private String country;
    private String time;
    private boolean active;

    public ShippingLocation() {
    }

    public ShippingLocation(String idClient, String contactName, String street, String cp, String province, String country, String time,boolean active) {
        this.idClient=idClient;
        this.contactName = contactName;
        this.street = street;
        this.cp = cp;
        this.province = province;
        this.country = country;
        this.time = time;
        this.active = active;
    }

    public ShippingLocation(String id,String idClient, String contactName, String street, String cp, String province, String country, String time, boolean active) {
        this.id = id;
        this.idClient=idClient;
        this.contactName = contactName;
        this.street = street;
        this.cp = cp;
        this.province = province;
        this.country = country;
        this.time = time;
        this.active = active;
    }   

    public String getCountry() {
        return country;
    }

    public void setCountry(String Country) {
        this.country = Country;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getActive() {
        if (this.active) {
            return 1;
        } else {
            return 0;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author simon
 */
@Entity
public class BiManyToManyAddresses5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;

    @ManyToMany(mappedBy = "addresses")
    List<BiManyToManyCustomers5> customers = new ArrayList();
    private BiManyToManyCustomers5 customer;

    public BiManyToManyAddresses5() {
    }

    public BiManyToManyAddresses5(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BiManyToManyCustomers5 getCustomer() {
        return customer;
    }

    public void setCustomer(BiManyToManyCustomers5 customer) {
        this.customer = customer;
    }

}

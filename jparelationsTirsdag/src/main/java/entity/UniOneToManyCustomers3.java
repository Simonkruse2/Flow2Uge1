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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author simon
 */
@Entity
public class UniOneToManyCustomers3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @JoinColumn(name = "customer_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    List<UniOneToManyAddresses3> addresses = new ArrayList();

    public UniOneToManyCustomers3() {
    }

    public void addAddress(UniOneToManyAddresses3 address) {
        addresses.add(address);
    }

    public UniOneToManyCustomers3(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<UniOneToManyAddresses3> getAddresses() {
        return addresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

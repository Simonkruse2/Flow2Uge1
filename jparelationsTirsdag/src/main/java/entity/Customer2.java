/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author simon
 */
@Entity
public class Customer2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Customer2() {
    }

    public Customer2(String name) {
        this.name = name;
    }
    @ElementCollection
    private List<String> hobbies = new ArrayList();

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public String getHobbies() {
        return String.join(",", hobbies);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer2{" + "id=" + id + ", name=" + name + ", hobbies=" + hobbies + '}';
    }
    
}

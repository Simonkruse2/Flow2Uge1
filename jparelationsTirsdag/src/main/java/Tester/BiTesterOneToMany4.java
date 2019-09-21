/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import entity.BiOneToManyAddresses4;
import entity.BiOneToManyCustomers4;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class BiTesterOneToMany4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BiOneToManyCustomers4 cust = new BiOneToManyCustomers4("kunde", "kunde");
        BiOneToManyAddresses4 address = new BiOneToManyAddresses4("vej", "vej");
        BiOneToManyAddresses4 address1 = new BiOneToManyAddresses4("vej", "vej");
        cust.addAddress(address);
        cust.addAddress(address1);

        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

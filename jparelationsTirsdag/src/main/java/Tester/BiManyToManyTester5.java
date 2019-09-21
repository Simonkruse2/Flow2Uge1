/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import entity.BiManyToManyAddresses5;
import entity.BiManyToManyCustomers5;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class BiManyToManyTester5 {
        public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BiManyToManyCustomers5 cust = new BiManyToManyCustomers5("kunde1", "kunde1");
        BiManyToManyCustomers5 cust1 = new BiManyToManyCustomers5("kunde2", "kunde2");
        BiManyToManyAddresses5 address = new BiManyToManyAddresses5("vej1", "vej1");
        BiManyToManyAddresses5 address1 = new BiManyToManyAddresses5("vej2", "vej2");
        cust1.addAddress(address1);
        cust1.addAddress(address);
        cust.addAddress(address);
        cust.addAddress(address1);

        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.persist(cust1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

package Tester;

import entity.Customer2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer2 cust = new Customer2("Kurt");
        cust.addHobby("Curling");
        cust.addHobby("Dart");
        cust.addHobby("Movies");
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        em = emf.createEntityManager();
        Customer2 found = em.find(Customer2.class, cust.getId());
        System.out.println(found);
    }
}

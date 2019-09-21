package Tester;

import entity.UniOneToManyAddresses3;
import entity.UniOneToManyCustomers3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UniTesterOneToMany3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        UniOneToManyCustomers3 cust = new UniOneToManyCustomers3("kunde", "kunde");
        UniOneToManyAddresses3 address = new UniOneToManyAddresses3("vej", "vej");
        UniOneToManyAddresses3 address1 = new UniOneToManyAddresses3("vej", "vej");
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

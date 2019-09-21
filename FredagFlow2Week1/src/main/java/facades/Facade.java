/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Customer;
import entities.ItemType;
import entities.OrderLine;
import entities.Orderm;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author simon
 */
public class Facade {

    public static Facade facade = new Facade();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Customer addCustomer(String name, String email) {
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer(name, email);
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    public Customer getCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer c = em.find(Customer.class, id);
            return c;
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public ItemType createItemType(String name, String description, double price) {
        EntityManager em = emf.createEntityManager();
        ItemType i = new ItemType(name, description, price);
        try {
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            return i;
        } finally {
            em.close();
        }
    }

    public ItemType getItemType(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            ItemType i = em.find(ItemType.class, id);
            return i;
        } finally {
            em.close();
        }
    }

    public Customer createOrderm(Customer c, Orderm orderm) {
        EntityManager em = emf.createEntityManager();
        Customer cust = em.find(Customer.class, c.getId());
        cust.setOrderm(orderm);

        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }
    public Orderm getOrderm(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Orderm o = em.find(Orderm.class, id);
            return o;
        } finally {
            em.close();
        }
    }
    public void addOrderLine(Orderm orderm, OrderLine orderline) {
        EntityManager em = emf.createEntityManager();
        Orderm orderFound = em.find(Orderm.class, orderm.getId());
        orderFound.setOrderline(orderline);
        try {
            em.getTransaction().begin();
            em.persist(orderFound);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Orderm> getAllOrders(Customer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Orderm> query = em.createQuery("SELECT o FROM Customer c JOIN c.ordermList o WHERE c.id = :customerID", Orderm.class);
            return query.setParameter("customerID", cust.getId()).getResultList();
        } finally {
            em.close();
        }
    }
}

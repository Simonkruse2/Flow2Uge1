package facades;

import utils.EMF_Creator;
import entities.Person;
import facades.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    private static Person p1, p2;

    public FacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/jpa_RESTjax_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = PersonFacade.getPersonFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        p1 = new Person("Simon", "Kruse", "22548884");
        p2 = new Person("John", "Jensen", "55555555");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(p1);
            em.persist(p2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testAddPerson() {
        facade.addPerson("Simon", "John", "111");
        assertEquals(3, facade.getAllPersons().size());
    }
    
    @Test
    public void testGetPerson(){
        Person p = facade.getPerson(p1.getId());
        assertEquals(p1.getFirstname(), p.getFirstname());
        System.out.println(p1.getFirstname() + "" + p.getFirstname());
    }
    
    @Test
    public void testDeletePerson(){
        facade.deletePerson(p1.getId());
        assertEquals(facade.getPerson(p1.getId()), null);
    }
    
    @Test
    public void testGetAllPersons(){
        facade.addPerson("", "", "");
        int amount = facade.getAllPersons().size();
        assertEquals(3, amount);
    }
    
    @Test
    public void testEditPerson(){
        p1.setFirstname("john");
        facade.editPerson(p1);
        assertEquals(p1.getFirstname(), facade.getPerson(p1.getId()).getFirstname());
    }
}
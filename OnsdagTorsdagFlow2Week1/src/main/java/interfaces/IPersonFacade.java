/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exception.PersonNotFoundException;
import entities.Person;
import java.util.List;

/**
 *
 * @author simon
 */
public interface IPersonFacade {

    public Person addPerson(String fName, String lName, String phone);

    public Person deletePerson(int id) throws PersonNotFoundException;

    public Person getPerson(int id) throws PersonNotFoundException;

    public List<Person> getAllPersons();

    public Person editPerson(Person p) throws PersonNotFoundException;
}

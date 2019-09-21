/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dto.PersonDTO;
import dto.PersonsDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import exception.PersonNotFoundException;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author simon
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/jpa_RESTjax",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final PersonFacade FACADE = PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private Person p;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("fill")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String Fill() {
        FACADE.addPerson("Simon", "Kruse", "22548884");
        FACADE.addPerson("John", "Jensen", "55555555");
        return GSON.toJson("Database filled");
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllPersons() {
        List<Person> list = FACADE.getAllPersons();
        PersonsDTO personsDTO = new PersonsDTO(list);
        return GSON.toJson(personsDTO);
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonById(@PathParam("id") int id) throws PersonNotFoundException {
        Person p = FACADE.getPerson(id);
        if (p == null) {
            throw new PersonNotFoundException("No person with provided id found");
        }
        PersonDTO pDTO = new PersonDTO(p);
        return GSON.toJson(pDTO);
    }

    @Path("add")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPerson(String person) {
        Person p = GSON.fromJson(person, Person.class);
        FACADE.addPerson(p.getFirstname(), p.getLastName(), p.getPhone());
        return Response.ok().entity(GSON.toJson(p)).build();
    }

    @Path("edit")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editPerson(String person) {
        Person p = GSON.fromJson(person, Person.class);
        FACADE.editPerson(p);
        return Response.ok().entity(GSON.toJson(p)).build();

    }

    @Path("delete")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deletePerson(String person) throws PersonNotFoundException {
        Person p = GSON.fromJson(person, Person.class);
        if (FACADE.getPerson(p.getId()) == null) {
            throw new PersonNotFoundException("Could not delete, provided id does not exist");
        }else{
            FACADE.deletePerson(p.getId());
        }
        return Response.ok().entity(GSON.toJson(p)).build();
    }

}

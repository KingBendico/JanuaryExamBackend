/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDTO;
import dtos.CoursesDTO;
import errorhandling.NotFoundException;
import facades.CourseFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Bendico
 */
@Path("course")
public class CourseResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    private static final CourseFacade FACADE = CourseFacade.getFacadeCourse(EMF);

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of ContactResource
     */
    public CourseResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    

    @Path("/add")
    @POST
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addCourse(String course) {
        CourseDTO co = GSON.fromJson(course, CourseDTO.class);
        CourseDTO newContact = FACADE.addCourse(co);
        return GSON.toJson(newContact);
    }
    
    @Path("/edit/{course}")
    @PUT  
// @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes({MediaType.APPLICATION_JSON})
    public String editCourse(@PathParam("course") String course, String description) throws NotFoundException {
        CourseDTO co = GSON.fromJson(course, CourseDTO.class);
        co.setCourseName(course);   
        CourseDTO newCourse = FACADE.editCourse(co);
        return GSON.toJson(newCourse);
    }



    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        CoursesDTO courses = FACADE.getAllCourses();
        return GSON.toJson(courses);
    }

    @Path("/{course}")
    @GET
    // @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public String getContact(@PathParam("course") String course) throws NotFoundException {
        CourseDTO c = FACADE.getCourse(course);
        return GSON.toJson(c);
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CourseDTO;
import entities.Course;
import errorhandling.NotFoundException;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Nicol
 */
public class CourseFacadeTest {

//Uncomment the line below, to temporarily disable this test
//@Disabled
    private static EntityManagerFactory emf;
    private static CourseFacade facade;
    private static Course r1, r2;

    public CourseFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = CourseFacade.getFacadeCourse(emf);

        EntityManager em = emf.createEntityManager();
        r1 = new Course ("02312 Indledende programmering", "The goal of the course is to make");
        r2 = new Course ("62588 Operativ-systemer", "The purpose of this course is to provide the");;
        try {
            em.getTransaction().begin();
            em.persist(r1);
            em.persist(r2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterAll
    public static void tearDownClass() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    // TODO: Delete or change this method 
    @Test
    public void testCreate() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Course c = em.createQuery("SELECT c FROM Course c WHERE c.courseName = :courseName", Course.class).setParameter("courseName", r1.getCourseName()).getSingleResult();
            System.out.println(c);
            em.getTransaction().commit();
            assertEquals(r1.getCourseName(), c.getCourseName());
        } finally {
            em.close();
        }
    }



    @Test
    public void testCreateFromFacade() throws NotFoundException {
        Course co = new Course("02312: Indledende programmering", "The goal of the course is to make");
        CourseDTO c1 = new CourseDTO(co);
        CourseDTO c = facade.addCourse(c1);
        assertEquals("02312: Indledende programmering", c.getCourseName());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ClassDTO;
import dtos.CourseDTO;
import entities.Course;
import entities.Class;
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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Bendico
 */
public class CourseFacadeTest {

//Uncomment the line below, to temporarily disable this test
//@Disabled
    private static EntityManagerFactory emf;
    private static CourseFacade facade;
    private static ClassFacade facade1;    
    private static Course r1, r2;

    public CourseFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = CourseFacade.getFacadeCourse(emf);
        facade1 = ClassFacade.getFacadeClass(emf);

        EntityManager em = emf.createEntityManager();
        r1 = new Course ("02312 Indledende programmering", "The goal of the course is to make");
        r2 = new Course ("62588 Operativ-systemer", "The purpose of this course is to provide the");
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
            em.createNamedQuery("Class.deleteAllRows").executeUpdate();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


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
    public void testReadFromFacade() throws NotFoundException {
        CourseDTO c = facade.getCourse(r1.getCourseName());
        System.out.println(c);
        assertEquals(r1.getDescription(), c.getDescription(), "Expects that description from Facade and r1 are the same");
    }

    @Test
    public void testCreateFromFacade() throws NotFoundException {
        Course co = new Course("02323 Introduktion til statistik", "The goal of the course is to make");
        CourseDTO c1 = new CourseDTO(co);
        CourseDTO c = facade.addCourse(c1);
        assertEquals("02323 Introduktion til statistik", c.getCourseName());
    }
    
    @Test
    public void testUpdateFromFacade() throws NotFoundException {
        Course co = new Course("62588 Operativ-systemer", "The purpose of this course is blah blah blah blah");
        CourseDTO c1 = new CourseDTO(co);
        CourseDTO c = facade.editCourse(c1);
        assertNotEquals(r2.getDescription(), c.getDescription());
    }
    
//        @Test
//        @Disabled
//        public void testUpdateFromFacade1() throws NotFoundException {
//        Course co = new Course("62588 Operativ-systemer", "The purpose of this course is blah blah blah blah");
//        CourseDTO c1 = new CourseDTO(co);
//        CourseDTO c = facade.editCourse(c1);
//        assertNotEquals(r2.getDescription(), c.getDescription());
//    }
    
        @Test
        public void testAddClassToCourse() {   
         EntityManager em = emf.createEntityManager();
             try {
        Class cl = new Class("semester 3", 30);
        ClassDTO c1DTO = new ClassDTO(cl);
        facade1.addClassToCourse("62588 Operativ-systemer", c1DTO);
         em.getTransaction().begin();
            Course c = em.createQuery("SELECT c FROM Course c WHERE c.courseName = :courseName", Course.class).setParameter("courseName", r2.getCourseName()).getSingleResult();
            em.getTransaction().commit();    
        assertEquals(c.getClassList().isEmpty(), false);  
             
             } finally {
            em.close();
        }
        
        }      
        
}

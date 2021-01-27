package facades;

import dtos.CourseDTO;
import dtos.CoursesDTO;
import entities.Course;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class CourseFacade {

    private static CourseFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CourseFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CourseFacade getFacadeCourse(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

 
        
        public CourseDTO addCourse (CourseDTO c) {
        if ((c.getCourseName().length() == 0) || (c.getDescription().length() == 0)) {
        }
        EntityManager em = emf.createEntityManager();
        Course con = new Course(c.getCourseName(), c.getDescription());
        try {
            em.getTransaction().begin();
            em.persist(con);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new CourseDTO(con);
    }
    
        public CoursesDTO getAllCourses() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
            return new CoursesDTO(query.getResultList());
        } finally {
            em.close();
        }

    }
    
    
    
}

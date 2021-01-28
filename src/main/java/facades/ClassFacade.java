package facades;

import dtos.ClassDTO;
import dtos.ClassesDTO;
import dtos.CourseDTO;
import entities.Class;
import entities.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class ClassFacade {

    private static ClassFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private ClassFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade c1
     */
    public static ClassFacade getFacadeClass(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ClassFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    
    public ClassDTO addClassToCourse(String courseName, ClassDTO clDTO) {
        EntityManager em = emf.createEntityManager();     
        try {
            
            Class cl = new Class(clDTO.getSemester(), clDTO.getNumberOfStudents());
            Course course = em.createQuery("SELECT c FROM Course c WHERE c.courseName = :courseName", Course.class)
            .setParameter("courseName", courseName).getSingleResult();
            course.addClass(cl);
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return new ClassDTO(cl);
        } finally {
            em.close();
        }

    }

    
    
   
}

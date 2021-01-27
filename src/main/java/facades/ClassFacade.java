package facades;

import dtos.ClassDTO;
import dtos.ClassesDTO;
import entities.Class;
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
     * @return an instance of this facade class.
     */
    public static ClassFacade getFacadeContact(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ClassFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    
   
}

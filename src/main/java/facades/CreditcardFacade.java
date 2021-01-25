package facades;

import dtos.HotelsDTO;
import entities.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CreditcardFacade {

    private static CreditcardFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CreditcardFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CreditcardFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CreditcardFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public HotelsDTO getAllHotels(){
        EntityManager em = emf.createEntityManager();
     //   "Hotel.findAll", query = "SELECT h FROM Hotel h")

        try {
            TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel h", Hotel.class);
            return new HotelsDTO(query.getResultList());
        } finally{  
            em.close();
        }
        
    }

}

package facades;

import dtos.HotelDTO;
import dtos.HotelsDTO;
import entities.Hotel;
import errorhandling.NotFoundException;
import static facades.DataFetcherFacade.HotelsDTO;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class HotelFacade {

    private static HotelFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private HotelFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static HotelFacade getHotelFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HotelFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public HotelsDTO getAllHotels() throws IOException{
        EntityManager em = emf.createEntityManager();
        
        
     // if(DataFetcherFacade.enums == null) {
        try {
            HotelsDTO(); 
        } catch (Exception e) {
            System.out.println("Problem/exception: " + e);
        }
        
        
    
    // }
        try {
            TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel h", Hotel.class);
            return new HotelsDTO(query.getResultList());
        } finally{  
            em.close();
        }
        
    }
    
     public HotelDTO getHotelById(int id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();

        Hotel hotel;
        
// query = "SELECT h FROM Hotel h WHERE h.id = :id")
        try {
            hotel = em.find(Hotel.class, id);
            if (hotel == null) {
                throw new NotFoundException("Invalid id");
            }
        } finally {
            em.close();
        }
        return new HotelDTO(hotel);

    }
    
    
    

}

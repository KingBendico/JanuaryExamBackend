package facades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dtos.HotelDTO;
import dtos.HotelsDTO;
import entities.Hotel;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;
import utils.HttpUtils;

/**
 *
 * @author Bendico
 */
public class DataFetcherFacade {
    
    private static DataFetcherFacade instance;
    private static EntityManagerFactory emf;
    protected static Collection<Hotel> enums;

    public DataFetcherFacade() {

    }
    
        public static DataFetcherFacade getDataFetcherFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DataFetcherFacade();
        }
        return instance;
    }


      public static void HotelsDTO() throws IOException {
          
        
          EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
          EntityManager em = emf.createEntityManager();
          
        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("http://exam.cphdat.dk:8000/hotel/all");
        java.lang.reflect.Type collectionType = new TypeToken<Collection<Hotel>>(){}.getType();
        enums = gson.fromJson(jasonString, collectionType); 
        
        try {
        em.getTransaction().begin();                  
        for (Hotel hs : enums) {                 
            em.persist(hs);
            System.out.println(hs);
        }
    em.getTransaction().commit();
        } finally {
            em.close();
        }
    }   
      
//      public static void main(String[] args) throws IOException {
//       
//          
//          HotelsDTO();
//        
//    }
      
        
//    public BoredDTO getBoredDTO() throws IOException {
//
//        Gson gson = new Gson();
//        String jasonString = HttpUtils.fetchData("https://www.boredapi.com/api/activity/");
//        BoredDTO boredDTO = gson.fromJson(jasonString, BoredDTO.class);
//
//        return boredDTO;
//    }

}


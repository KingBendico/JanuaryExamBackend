package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HotelsDTO;
import errorhandling.NotFoundException;
import utils.EMF_Creator;
import facades.FacadeExample;
import facades.HotelFacade;
import java.io.IOException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hotel")
public class HotelResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final HotelFacade FACADE =  HotelFacade.getHotelFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello Hotel!\"}";
    }
    
    
    @Path("/all")
    @GET
   // @RolesAllowed("user")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllHotels() throws IOException {
      
        HotelsDTO hotels = FACADE.getAllHotels();
        return GSON.toJson(hotels);
    }
    
        @Path("/{id}")
        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public String getHotelById(@PathParam("id") int id) throws NotFoundException {

            return GSON.toJson(FACADE.getHotelById(id));
        }
    
}

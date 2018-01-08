
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Event;
import entity.Owner;
import entity.Pet;
import facader.PetFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author MartinLodahl
 */
@Path("pets")
public class PetsResource {
                                 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
    PetFacade pf = new PetFacade(emf);

    @Context
    private UriInfo context;

    public PetsResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Pet> lp = pf.getAllPets();
        int petCount = lp.size();
        Gson gson = new Gson();
        return gson.toJson(petCount);
    }

    @GET
    @Path("getDetailed")
    @Produces(MediaType.APPLICATION_JSON)
    public String detailedPets() {
        List<Pet> lp = pf.getAllPets();
        Gson gson = new Gson();
        // id, name, birth, species and the first_name and last_name of the owner
        List<Pet> lp2 = new ArrayList();
        for (int i = 0; i < lp.size(); i++) {
            String species = lp.get(i).getSpecies();
            String name = lp.get(i).getName();
            Date birth = lp.get(i).getBirth();
            String firstName = lp.get(i).getOwnerId().getFirstName();
            String lastName = lp.get(i).getOwnerId().getLastName();
            lp2.add(new Pet(i, name, birth, species, new Owner(firstName, lastName)));
        }
    return gson.toJson(lp2);
    }
    @GET
    @Path("getAllLiving")
    @Produces(MediaType.APPLICATION_JSON)
    public String livingPets(){
        List<Pet> lp = pf.getAllPets();
        //Builder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
        Gson gson=  new Gson();
        List<Pet> lp2 = new ArrayList();
        for (int i = 0; i < lp.size(); i++) {
            Pet currentPet = lp.get(i);
            if(currentPet.getDeath()==null){   
            //  lp2.add(lp.get(i));
            //Får stackoverflow hvis jeg bare smider ejer ind (currentPet.getOwnerid())     (Gson related)
            //Får stackoverflow hvis jeg bare smider dyrene direkte over i den anden liste. (Gson related)
            lp2.add(new Pet(i, currentPet.getName(), currentPet.getBirth(), currentPet.getSpecies(), new Owner(currentPet.getOwnerId().getId(),currentPet.getOwnerId().getFirstName(),currentPet.getOwnerId().getLastName(), currentPet.getOwnerId().getAddress())));
            }
        }
        return gson.toJson(lp2);
    }
    @GET
    @Path("getOnEvent/{day}/{month}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public String eventOnDay(@PathParam("day") int day, @PathParam("month") int month,@PathParam("year") int year){
        Gson gson=  new Gson();
        List<Event> le = pf.findEventByDate(day, month, year);
        List<Pet> lp = new ArrayList();
        for (int i = 0; i < le.size(); i++) {
            Pet currentPet = le.get(i).getPetId();
           lp.add(new Pet(i, currentPet.getName(), currentPet.getBirth(), currentPet.getSpecies(), new Owner(currentPet.getOwnerId().getId(),currentPet.getOwnerId().getFirstName(),currentPet.getOwnerId().getLastName(), currentPet.getOwnerId().getAddress()))); 
        }
        return gson.toJson(lp);
    }
    

    @POST
    @Path("createEvent/{petId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content, @PathParam("petId") long petId) {
        Gson gson = new Gson();
        Event e = gson.fromJson(content, Event.class);
        List<Pet> lp = pf.getAllPets();
        for (int i = 0; i < lp.size(); i++) {
            if(petId==lp.get(i).getId()){
                e.setPetId(lp.get(i));
                break;
            }
        }
        pf.createEvent(e);
    }
}

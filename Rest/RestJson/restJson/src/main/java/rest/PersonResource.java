package rest;

import entity.Generator;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("data")
public class PersonResource {

    @Context
    private UriInfo context;

    public PersonResource() {
    }

     @Path("{amount}/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("amount") int amount, @PathParam("id") int id) {
        String testData = Generator.generatePerson(amount, id);
        
        return testData;
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson2() {
        String testData = Generator.generatePerson(2, 4);
        
        return testData;
    }
}

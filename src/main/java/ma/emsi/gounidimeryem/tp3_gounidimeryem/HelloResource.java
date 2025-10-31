package ma.emsi.gounidimeryem.tp3_gounidimeryem;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")  // Chemin de base pour la ressource
public class HelloResource {

    @GET
    @Path("/personnes/{nom}")  // {nom} est un paramètre variable
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("nom") String nom) {  // "nom" doit correspondre à {nom}
        return "Hello, " + nom + "!";
    }
}
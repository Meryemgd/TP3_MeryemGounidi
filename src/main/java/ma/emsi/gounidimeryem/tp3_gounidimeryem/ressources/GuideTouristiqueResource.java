package ma.emsi.gounidimeryem.tp3_gounidimeryem.ressources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getLieux(@PathParam("ville_ou_pays") String lieu) {
        switch (lieu.toLowerCase()) {
            case "paris":
                return new String[]{"Tour Eiffel", "Musée du Louvre"};
            case "maroc":
                return new String[]{"Mosquée Hassan II", "Médina de Fès"};
            case "londres":
                return new String[]{"Big Ben", "Tower Bridge"};
            case "rome":
                return new String[]{"Colisée", "Vatican"};
            default:
                return new String[]{"Aucun lieu touristique trouvé pour " + lieu};
        }
    }
}
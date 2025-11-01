package ma.emsi.gounidimeryem.tp3_gounidimeryem.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.gounidimeryem.tp3_gounidimeryem.llm.LlmService;

@Path("tourisme")
public class GuideTouristiqueResource {
    
    @Inject
    private LlmService llmService;

    @GET
    @Path("{ville}")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String getInformationTouristique(@PathParam("ville") String ville) {
        if (ville == null || ville.trim().isEmpty()) {
            return "La ville doit être spécifiée";
        }
        return llmService.obtenirInformations(ville);
    }

    @GET
    @Path("{ville}/{nombre}")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String getInformationTouristiqueAvecNombre(
            @PathParam("ville") String ville,
            @PathParam("nombre") int nombre) {
        if (ville == null || ville.trim().isEmpty()) {
            return "La ville doit être spécifiée";
        }
        if (nombre <= 0 || nombre > 10) {
            return "Le nombre de lieux doit être entre 1 et 10";
        }
        return llmService.obtenirInformations(ville, nombre);
    }
}
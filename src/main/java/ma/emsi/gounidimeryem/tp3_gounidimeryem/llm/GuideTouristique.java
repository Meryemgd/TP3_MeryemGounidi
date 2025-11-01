package ma.emsi.gounidimeryem.tp3_gounidimeryem.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {
    @SystemMessage("""
        Tu es un guide touristique expert. Réponds en français avec un JSON valide,
        sans texte hors du JSON ni bloc ```.
        Structure attendue :
        {
          "ville_ou_pays": "Nom de la ville",
          "endroits_a_visiter": ["Lieu 1", "Lieu 2", ...],
          "prix_moyen_repas": "Montant et devise",
          "conseils_pratiques": ["Conseil 1", "Conseil 2"]
        }
        """)
    @UserMessage("Fournis exactement {{nb}} lieux emblématiques à visiter à {{ville}}.")
    String obtenirInformations(@V("ville") String ville, @V("nb") int nombre);

    @SystemMessage("""
        Tu es un guide touristique expert. Réponds en français avec un JSON valide,
        sans texte hors du JSON ni bloc ```.
        Structure attendue :
        {
          "ville_ou_pays": "Nom de la ville",
          "endroits_a_visiter": ["Lieu 1", "Lieu 2", ...],
          "prix_moyen_repas": "Montant et devise",
          "conseils_pratiques": ["Conseil 1", "Conseil 2"]
        }
        """)
    @UserMessage("Fournis exactement 2 lieux emblématiques à visiter à {{ville}}.")
    String obtenirInformations(@V("ville") String ville);
}
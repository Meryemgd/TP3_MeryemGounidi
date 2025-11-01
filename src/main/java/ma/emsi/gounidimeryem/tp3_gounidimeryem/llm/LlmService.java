package ma.emsi.gounidimeryem.tp3_gounidimeryem.llm;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LlmService {
    private final GuideTouristique guideTouristique;

    public LlmService() {
        var model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GeminiKey"))
                .modelName("gemini-2.5-flash")
                .build();

        this.guideTouristique = AiServices.create(GuideTouristique.class, model);
    }

    public String obtenirInformations(String ville) {
        return guideTouristique.obtenirInformations(ville);
    }

    public String obtenirInformations(String ville, int nombre) {
        return guideTouristique.obtenirInformations(ville, nombre);
    }
}
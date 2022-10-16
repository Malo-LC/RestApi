package REST;

import Model.Commentaire;

import java.util.HashMap;
import java.util.Map;

public enum ComDao {
    instance;

    private final Map<String, Commentaire> contentProvider = new HashMap<>();

    ComDao() {
        Commentaire com1 = new Commentaire("1", "dvd", "1", "Très bon film !!");
        contentProvider.put("1", com1);

        Commentaire com2 = new Commentaire("2", "videogame", "1", "+rep ce jeu de dingue!!!");
        contentProvider.put("2", com2);

        Commentaire com3 = new Commentaire("3", "book", "1", "On se régaleeeee");
        contentProvider.put("3", com3);
    }

    public Map<String, Commentaire> getModel() {
        return contentProvider;
    }
}

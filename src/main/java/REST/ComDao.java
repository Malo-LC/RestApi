package REST;

import Model.Commentaire;

import java.util.HashMap;
import java.util.Map;

public enum ComDao {
    instance;

    private Map<String, Commentaire> contentProvider = new HashMap<>();

    private ComDao() {
        Commentaire com = new Commentaire("1", "dvd", "1", "Très bon film !!");
        contentProvider.put("1", com);
    }

    public Map<String, Commentaire> getModel() {
        return contentProvider;
    }
}

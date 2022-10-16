package REST;

import Model.User;

import java.util.HashMap;
import java.util.Map;

public enum UserDao {
    instance;

    private Map<String, User> contentProvider = new HashMap<>();

    private UserDao() {
        User user1 = new User("1", "LE CORVEC", "Malo", "ermont");
        contentProvider.put("1", user1);
        User user2 = new User("2", "KEUNEBROEK", "Baptiste", "beauchamp");
        contentProvider.put("2", user2);

    }

    public Map<String, User> getModel() {
        return contentProvider;
    }
}



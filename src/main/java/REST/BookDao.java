package REST;

import Model.Book;

import java.util.HashMap;
import java.util.Map;

public enum BookDao {
    instance;

    private final Map<String, Book> contentProvider = new HashMap<>();

    BookDao() {
        Book book1 = new Book("1", "1", "Tolkien", "The Hobbit", "Fantasy", "A hobbit going on an adventure with Gandalf", "1890", "Tolkien", "5");
        contentProvider.put("1", book1);
        Book book2 = new Book("2", "2", "Ray Bradbury", " Fahrenheit 451", "dystopia", "Fahrenheit 451 presents an American society where books have been outlawed and firemen burn any that are found." +
                "The novel follows Guy Montag, a fireman who becomes disillusioned with his role of censoring literature and destroying knowledge, eventually quitting his job and committing himself to the preservation of literary and cultural writings."
                , "1953", "Ballantine Books", "5");
        contentProvider.put("2", book2);

    }

    public Map<String, Book> getModel() {
        return contentProvider;
    }
}



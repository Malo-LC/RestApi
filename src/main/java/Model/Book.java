package Model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {
    private String bookId;
    private String userId;
    private String author;
    private String title;
    private String type;
    private String description;
    private String releaseDate;
    private String editor;
    private String rating;

    public Book() {

    }

    public Book(String bookId, String userId, String author, String title, String type, String description, String releaseDate, String editor, String rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.author = author;
        this.title = title;
        this.type = type;
        this.description = description;
        this.releaseDate = releaseDate;
        this.editor = editor;
        this.rating = rating;
    }

    public String getId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getEditor() {
        return editor;
    }

    public String getRating(){return rating;}

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setUserId(String userId) {
        this.description = userId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }


    public void setRating(String rating) {
        this.rating = rating;
    }
}


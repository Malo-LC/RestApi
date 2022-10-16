package Model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class VideoGames {
    private String videogameId;
    private String userId;
    private String name;
    private String type;
    private String resume;
    private String editor;
    private String releaseDate;
    private String rating;

    public VideoGames() {

    }

    public VideoGames(String videogameId, String userId, String name, String type, String resume, String editor, String releaseDate, String rating) {
        this.videogameId = videogameId;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.resume = resume;
        this.editor = editor;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public String getId() {
        return videogameId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getResume() {
        return resume;
    }

    public String getEditor() {
        return editor;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setVideogameId(String videogameId) {
        this.videogameId = videogameId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}


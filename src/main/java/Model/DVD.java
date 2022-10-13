package Model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class DVD {
    private static final int DEFAULT_RATING = 0;
    private static final int MINIMUM_RATING = 0;
    private static final int MAXIMUM_RATING = 5;
    private String dvdId;
    private String userId;
    private String duration;
    private String title;
    private String description;
    private String director;
    private String releaseDate;
    private String rating;

    public DVD() {

    }

    public DVD(String dvdId, String userId, String duration, String title, String description, String releaseDate, String director, String rating) {
        this.dvdId = dvdId;
        this.userId = userId;
        this.duration = duration;
        this.title = title;
        this.director = director;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public String getId() {
        return dvdId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDvdId(String dvdId) {
        this.dvdId = dvdId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}


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
    private int rating;

    public void setRating(int rating) {
        if(rating >= MINIMUM_RATING && rating <= MAXIMUM_RATING) {
            this.rating = rating;
        }
    }

    public DVD(){

    }
    public DVD(String dvdId, String userId, String duration, String title, String description, String releaseDate, String director, int rating) {
        this.dvdId = dvdId;
        this.userId = userId;
        this.duration = duration;
        this.title = title;
        this.director = director;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating >= MINIMUM_RATING && rating <= MAXIMUM_RATING ? rating : DEFAULT_RATING;
    }
    public String getId(){
        return dvdId;
    }
    public String getUserId(){
        return userId;
    }

    public String getDuration(){
        return duration;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }



}


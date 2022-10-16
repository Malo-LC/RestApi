package Model;

public class User {
    private String userId;
    private String name;
    private String firstname;

    private String city;


    public User(String userId, String name, String firstname, String city) {
        this.userId = userId;
        this.name = name;
        this.firstname = firstname;
        this.city = city;
    }

    public String getId() {
        return userId;
    }

    public void setId(String userId) {
        this.userId = userId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(){
        this.firstname = firstname;
    }

    public String getCity(){return city;}

    public void setCity(){this.city=city;}

}
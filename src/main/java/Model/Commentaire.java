package Model;

public class Commentaire {
    private String ItemID;
    private String UserID;
    private String ItemType;
    private String text;

    public Commentaire(){

    }
    public Commentaire(String UserID,String ItemType, String ItemID, String text){
        this.ItemType = ItemType;
        this.UserID = UserID;
        this.text = text;
        this.ItemID = ItemID;
    }

    public String getItemType() {
        return ItemType;
    }

    public String getText() {
        return text;
    }

    public String getUserID() {
        return UserID;
    }

    public void setItemType(String ItemType) {
        ItemType = ItemType;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getItemID() {
        return ItemID;
    }
}


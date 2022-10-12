package REST;

import Model.DVD;

import java.util.HashMap;
import java.util.Map;

public enum DvDDao{
    instance;

    private Map<String, DVD> contentProvider = new HashMap<>();

    private DvDDao(){
        DVD dvd = new DVD("1","1","1","Lord of the Rings","Jeter anneau dans feu","2001","Peter Jackson",5);
        contentProvider.put("1", dvd);

    }
    public Map<String, DVD> getModel(){
        return contentProvider;
    }
}



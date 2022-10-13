package REST;

import Model.DVD;

import java.util.HashMap;
import java.util.Map;

public enum DvDDao{
    instance;

    private Map<String, DVD> contentProvider = new HashMap<>();

    private DvDDao(){
        DVD dvd1 = new DVD("1","1","1","Lord of the Rings","Jeter anneau dans feu","2001","Peter Jackson","5");
        contentProvider.put("1", dvd1);
        DVD Fightclub = new DVD("3","1","2:40","Fight Club", "Fight Club is a 1999 American film directed by David " +
                "Fincher and starring Brad Pitt, Edward Norton, and Helena Bonham Carter. It is based on the 1996 novel of the same name by Chuck Palahniuk." +
                " Norton plays the unnamed narrator, who is discontented with his white-collar job","1999","David Fincher","4");

        DVD LOTR = new DVD("2","2","2:40","Lord of The Rings", "Fight Club is a 1999 American film directed by David " +
                "Fincher and starring Brad Pitt, Edward Norton, and Helena Bonham Carter. It is based on the 1996 novel of the same name by Chuck Palahniuk." +
                " Norton plays the unnamed narrator, who is discontented with his white-collar job","1999","David Fincher","4");
        contentProvider.put("2", Fightclub);
        contentProvider.put("3", LOTR);

    }
    public Map<String, DVD> getModel(){
        return contentProvider;
    }
}



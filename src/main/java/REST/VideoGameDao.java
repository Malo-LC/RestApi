package REST;

import Model.VideoGames;

import java.util.HashMap;
import java.util.Map;

public enum VideoGameDao {
    instance;

    private Map<String, VideoGames> contentProvider = new HashMap<>();

    private VideoGameDao() {
        VideoGames videogames1 = new VideoGames("1", "1", "Counter Strike", "FPS", "5v5 online game, defuse or plant the bomb", "Valve", "2001", "5");
        contentProvider.put("1", videogames1);
        VideoGames videogames2 = new VideoGames("2", "2", "World Of Warcraft", "MMORPG", "Intent on settling in Durotar, Thrall's Horde expanded its ranks by inviting the undead" +
                "Forsaken to join orcs, tauren, and trolls. Meanwhile, dwarves, gnomes, and the ancient night elves pledged" +
               " their loyalties to the Alliance, guided by the human kingdom of Stormwind. After Stormwind's king, Varian Wrynn,"+
                "mysteriously disappeared, Highlord Bolvar Fordragon served as Regent but his service was affected by the mind control of the black dragon Onyxia, "+
                "who ruled in disguise as a human noblewoman. As heroes investigated Onyxia's manipulations, the ancient elemental lord Ragnaros resurfaced to endanger both the Horde and Alliance."+
                "The heroes of the Horde and Alliance defeated Onyxia and sent Ragnaros back to the Elemental Plane."
                , "Blizzard", "2004", "4");
        contentProvider.put("2", videogames2);

    }

    public Map<String, VideoGames> getModel() {
        return contentProvider;
    }
}



package ADTs_Sets_Maps_BSTs;

import java.util.Map;
import java.util.TreeMap;

public class ADTsAndMaps {
    Map<String, Integer> m = new TreeMap<>();
    String[] text = {"sumomo", "momo", "mo", "momo", "no", "uchi"};

    public ADTsAndMaps() {
        for (String s : text) {
            int currentCount = m.getOrDefault(s, 0);
            m.put(s, currentCount + 1);
        }
    }
}


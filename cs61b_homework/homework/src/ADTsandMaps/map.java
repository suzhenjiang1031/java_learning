package ADTsandMaps;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class map {
    Map<String, Integer> m = new TreeMap<>();
    String[] text = {"sumomo", "mo", "momo", "mo", "momo", "no", "uchi"};

    for (String s : text) {
        int currentCount = m.getOrDefault(s, 0);
        m.put(s, currentCount + 1);
    }

//    m = {}
//    text  = ["sumomo", "mo", "momo", "mo", "momo", "no", "uchi"];
//    for s in text:
//        current_count = m.get(s, 0)
//    m[s] = current_count + 1

}
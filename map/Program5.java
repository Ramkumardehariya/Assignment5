import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Program5 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("Ram", 5);
        map.put("Shyam", 4);
        map.put("sundar", 3);
        map.put("Maharathi", 2);
        map.put("yes", 1);
        map.put("no", 0);


        Map<String,Integer> sortedMap = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (e1,e2) -> e1, LinkedHashMap::new));

        sortedMap.forEach((key,value) ->{
            System.out.println(key+" "+value);
        });

        System.out.println(map);

    }
}

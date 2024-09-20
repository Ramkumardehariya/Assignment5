import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Program5 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(1, 5);
        map.put(2, 4);
        map.put(3, 3);
        map.put(4, 2);
        map.put(5, 1);
        map.put(6, 0);

        Collections.sort(map,Comparator< >);

        System.out.println(map);

    }
}

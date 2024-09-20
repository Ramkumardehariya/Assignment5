// package set;
import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        HashSet<Integer> hashset = new HashSet<>();
        LinkedHashSet<Integer> linkedhashset = new LinkedHashSet<>();
        TreeSet<Integer> treeset = new TreeSet<>();

        // [5, 3, 5, 1, 2].
        hashset.add(5);

        hashset.add(5);
        hashset.add(3);
        hashset.add(5);
        hashset.add(1);
        hashset.add(2);

        linkedhashset.add(5);
        linkedhashset.add(3);
        linkedhashset.add(5);
        linkedhashset.add(1);
        linkedhashset.add(2);

        treeset.add(5);
        treeset.add(3);
        treeset.add(5);
        treeset.add(1);
        treeset.add(2);

        System.out.println("HashSet is: "+hashset);
        System.out.println("linked HashSet is: "+linkedhashset);
        System.out.println("treset is: "+treeset);


    }
}

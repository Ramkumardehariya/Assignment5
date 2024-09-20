package set;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Program4 {
    public static void main(String[] args) {
        // [7, 2, 9, 1, 2, 9]
        List<Integer> list = new ArrayList<>();

        list.add(7);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(2);
        list.add(9);

        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(list);

        System.out.println(set);
    }
}

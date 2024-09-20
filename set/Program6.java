package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class Program6 {

    boolean checkContain(Set<Integer> set1, Set<Integer> set2){
        return set1.containsAll(set2);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Program6 p = new Program6();

        list.add(7);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(2);
        list.add(9);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new TreeSet<>();

        set1.addAll(list);
        set2.addAll(list);
        set3.addAll(list);

        if(p.checkContain(set1, set2)){
            System.out.println("yes set 1 contains set2: ");
        }
        else{
            System.out.println("set1 no contains set2");
        }

        if(p.checkContain(set1, set3)){
            System.out.println("yes set 1 contains set2: ");
        }
        else{
            System.out.println("set1 no contains set2");
        }

        if(p.checkContain(set2, set3)){
            System.out.println("yes set 1 contains set2: ");
        }
        else{
            System.out.println("set1 no contains set2");
        }

        if(p.checkContain(set1, set2)){
            System.out.println("yes set 1 contains set2: ");
        }
        else{
            System.out.println("set1 no contains set2");
        }
    }
}

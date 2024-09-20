package set;


import java.util.ArrayList;
import java.util.HashSet;

public class Program8 {

    ArrayList<Integer> interSection(ArrayList<HashSet<Integer>> list){
        
        ArrayList<Integer> result = new ArrayList<>();

        if(list.size() == 0){
            return result;
        }

        result.addAll(list.get(0));

        for(int i = 1; i<list.size();i++){
            result.retainAll(list.get(i));
        }

        return result;
    }
    public static void main(String[] args) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        Program8 p = new Program8();

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(2);
        set2.add(3);

        HashSet<Integer> set3 = new HashSet<>();
        set3.add(5);
        set3.add(4);
        set3.add(3);

        list.add(set1);
        list.add(set2);
        list.add(set3);

        ArrayList<Integer> result = p.interSection(list);

        System.out.println(result);
    }
}

package set;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Program3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // [4, 5, 6, 4, 7, 8, 5].

        list.add(4);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(7);
        list.add(8);
        list.add(5);
        list.add(10);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        Integer ans = 0;

        for(int i = list.size()-1; i>=0; i--){
            int n = set.size();
            set.add(list.get(i));
            if(n != set.size()){
                ans = list.get(i);
            }
        }

        System.out.println("first non duplicate is: "+ans);
    }
}

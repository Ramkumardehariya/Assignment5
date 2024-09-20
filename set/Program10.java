package set;


import java.util.Iterator;
import java.util.TreeSet;

public class Program10 {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
    
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);


        Iterator<Integer> it = set.iterator();
        int i = 3;

        while (it.hasNext()) {
          int  x = it.next();
            if(x < i){
                it.remove();
            }
        }

        System.out.println(set);
    }
}

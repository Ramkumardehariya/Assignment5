package set;
// package Assignment5;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

public class Program7 {

    void addcheckTime(Set<Integer> set){
        long startTime = System.nanoTime();

        for(int i = 0; i<=1000000; i++){
            set.add(i);
        }

        long endTime = System.nanoTime();

        long duration = endTime-startTime;

        System.out.println("The add Execution time is: "+duration/1_000_000 + " ms");
    }
    void removecheckTime(Set<Integer> set){
        long startTime = System.nanoTime();

        Iterator<Integer> iterator = set.iterator();

        for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
            it.next(); 
            it.remove(); 
        }

        long endTime = System.nanoTime();

        long duration = endTime-startTime;

        System.out.println("The remove Execution time is: "+duration/1_000_000 + " ms");
        System.out.println();
    }
    void containcheckTime(Set<Integer> set){
        long startTime = System.nanoTime();

        for(Integer it: set){
            set.contains(it);
        }

        long endTime = System.nanoTime();

        long duration = endTime-startTime;

        System.out.println("The contain Execution time is: "+duration/1_000_000 + " ms");
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> set3 = new TreeSet<>();

        Program7 p = new Program7();

        System.out.println("hashSet time is: ");
        p.addcheckTime(set1);
        p.containcheckTime(set1);
        p.removecheckTime(set1);

        System.out.println("LinkedhashSet time is: ");
        p.addcheckTime(set2);
        p.containcheckTime(set2);
        p.removecheckTime(set2);

        System.out.println("TreeSet time is: ");
        p.addcheckTime(set3);
        p.containcheckTime(set3);
        p.removecheckTime(set3);
        
    }
}

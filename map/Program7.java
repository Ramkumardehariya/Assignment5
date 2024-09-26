import java.util.HashMap;
import java.util.Map;

public class Program7 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,5,6,7,8,9,6,7,8,4,3,3,2,4,7,8,2,6,8,9,10};

        Map<Integer,Integer> map = new HashMap<>();

        for(int it: arr){
            if(!map.containsKey(it)){
                map.put(it, 0);
            }
            map.put(it, map.get(it)+1);
        }

        map.forEach((key,value) -> {
            if(value > 1){
                System.out.println(key+" -> "+value);
            }
        });
    }
}

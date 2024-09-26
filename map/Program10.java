import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Program10 {
    void intersection(int arr1[], int arr2[], Map<Integer,Integer> map){
        for(int i = 0; i<arr1.length; i++){
            map.put(arr1[i], 1);
        }

        for(int i = 0; i<arr2.length; i++){
            if(map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
            }
        }
    }
    public static void main(String[] args) {
        Program10 p = new Program10();

        Map<Integer,Integer> map = new HashMap<>();

        int arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int arr2[] = {2,4,6,8,10,12,14,16,18,20,22,24,26};

        p.intersection(arr1, arr2, map);
    }
}

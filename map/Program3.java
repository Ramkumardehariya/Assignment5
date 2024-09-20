
import java.util.*;

import set.Program3;

public class Program3 {

    public List<List<String>> anagrampGroup(String strs[]){

        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedStr = new String(charArray);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String str[] = {"ate", "map","eat","amp", "tea","pam","ram", "mar"};

        Program3 p = new Program3();

        System.out.println(p.anagrampGroup(str));
    }
}

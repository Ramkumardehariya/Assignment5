import java.util.HashMap;
import java.util.Map;

public class Program1 {
    public static void main(String[] args) {
        String st = "Strings fsfsfsf";
        String str = st.toLowerCase();

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }

        System.out.println(map);
    }
}

import java.util.HashMap;

public class Program2 {
    public static void main(String[] args) {
        String str = "This is a ram This is a ram This is han han na na";

        HashMap<String,Integer> map = new HashMap<>();

        String words[] = str.split(" ");

        for(int i = 0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i])+1);
            }
            else{
                map.put(words[i], 1);
            } 
        }

        System.out.println(map);
    }
}

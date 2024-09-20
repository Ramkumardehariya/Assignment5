import java.util.HashMap;

import set.Program4;

public class Program4 {

    char nonReaptedCharacter(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
            }
            else{
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
        }

        // Character ans = new 

        for(int i = 0; i<str.length(); i++){
            Integer integer = map.get(str.charAt(i));
            if(integer == 1){
                return str.charAt(i);
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        String str = "strsstring";
        Program4 p =new Program4();

        System.out.println("First non repeating character : "+p.nonReaptedCharacter(str));

    }
}

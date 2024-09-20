package set;
import java.util.LinkedHashSet;

public class Program2 {
    public static void main(String[] args) {
        // : ["apple", "banana", "apple", "orange"].

        LinkedHashSet<String> st = new LinkedHashSet<>();

        st.add("apple");
        st.add("banana");
        st.add("apple");
        st.add("orange");

        System.out.println(st);
    }
}

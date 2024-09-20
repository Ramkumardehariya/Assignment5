package set;
import java.util.Objects;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override equals to compare based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    // Override hashCode to match equals logic
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // Implement compareTo for TreeSet ordering (sort by name first, then by age)
    @Override
    public int compareTo(Person other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        } else {
            return Integer.compare(this.age, other.age);
        }
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}


public class Program9 {

    // Union of two sets
    public static TreeSet<Person> union(TreeSet<Person> set1, TreeSet<Person> set2) {
        TreeSet<Person> unionSet = new TreeSet<>(set1);
        unionSet.addAll(set2);  // Adds all elements from set2 (TreeSet handles duplicates automatically)
        return unionSet;
    }

    // Difference of two sets (set1 - set2)
    public static TreeSet<Person> difference(TreeSet<Person> set1, TreeSet<Person> set2) {
        TreeSet<Person> differenceSet = new TreeSet<>(set1);
        differenceSet.removeAll(set2);  // Removes all elements from set2 that exist in set1
        return differenceSet;
    }

    public static void main(String[] args) {
        // Create two TreeSets of Person objects
        TreeSet<Person> set1 = new TreeSet<>();
        set1.add(new Person("Alice", 30));
        set1.add(new Person("Bob", 25));

        TreeSet<Person> set2 = new TreeSet<>();
        set2.add(new Person("Bob", 25));
        set2.add(new Person("Charlie", 35));

        // Perform union and difference
        TreeSet<Person> unionSet = union(set1, set2);
        TreeSet<Person> differenceSet = difference(set1, set2);

        // Print results
        System.out.println("Union: " + unionSet);
        System.out.println("Difference: " + differenceSet);
    }
}

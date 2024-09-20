package set;
import java.util.HashSet;
import java.util.Objects;

class Person{
    String name;
    int age;

    public  Person(String name, int age){
        this.name = name; 
        this.age = age;
    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Person person = (Person) obj;

        return age == person.age && Objects.equals(name, person.name);
    }

    public int hashCode(){
        return Objects.hash(name, age);
    }

    public String toString(){
        return "Person{name = '"+ name+ "' , age = " +age + "}";
    }
}

public class Program5 {
    public static void main(String[] args) {
        HashSet<Person> peopleSet = new HashSet<>();

        peopleSet.add(new Person("Alice", 30));
        peopleSet.add(new Person("Bob", 25));

        System.out.println(checkPersonInSet(peopleSet, new Person("alice", 30)));
        System.out.println(checkPersonInSet(peopleSet, new Person("Charlie", 35)));
    }

    public static void addPersonToSet(HashSet<Person> set, Person person){
        set.add(person);
    }
    public static boolean checkPersonInSet(HashSet<Person> set, Person person){
        return set.contains(person);
    }
}

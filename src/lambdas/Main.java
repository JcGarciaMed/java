package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String name, int age) {
        @Override
        public String toString() {
            return name + " " + age;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(new Person("Juan", 25), new Person("Maria", 30), new Person("Pedro", 22)));

        var comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };

        people.sort(comparator.reversed());
        people.forEach(System.out::println);


        people.sort((o1, o2) -> o1.name.compareTo(o2.name));
        people.forEach(System.out::println);
    }
}

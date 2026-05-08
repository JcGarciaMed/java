package lambdas.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {

    private static Random random = new Random();

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }

        @Override
        public String toString() {
            return first;
        }
    }

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Cameron", "Donald", "Eva", "Francis"};

        Person tim = new Person("Tim");

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar() + ".",
                s -> s += " " + reverse(s, s.indexOf(" ")),
                Main::reverse,
                String::new,
                s -> new String("Howdy " + s),
                String::valueOf,
                tim::last,
                (new Person("MARY"))::last

        ));

        applyChanges(names, list);

        String name = "Tim";
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply(name));

        Function<String, String> function2 = s -> s.concat(" Garcia Medina");
        Function<String, String> function3 = s -> function.andThen(function2).apply(s);
        System.out.println(function3.apply(name));

        function3 = function.compose(function2);
        System.out.println(function3.apply(name));

        Function<String, String[]> function4 = function
                .andThen(function2)
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(function4.apply(name)));

        Function<String, String> function5 = function
                .andThen(function2)
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + " " + s[0].toLowerCase());
        System.out.println(function5.apply(name));

        Function<String, Person> function6 = function
                .andThen(function2)
                .andThen(s -> s.split(" "))
                .andThen(s -> new Person( s[1].toLowerCase()+
                         " " + s[0]));
        System.out.println(function6.apply(name));

        String[] namesReloaded = {"Anna", "Bob", "Cameron", "Donald", "Eva", "Francis"};
        Consumer<String> consumer = s-> System.out.print(s.charAt(0));
        Consumer<String> consumer2 = System.out::println;

        Arrays.asList(namesReloaded).forEach(consumer
                .andThen(s -> System.out.print(" - "))
                .andThen(consumer2));

        Predicate<String> predicate = s -> s.length() > 4;
        Predicate<String> predicate2 = s -> s.length() < 4;
        Predicate<String> predicate3 = s -> s.length() == 4;
        Predicate<String> predicate4 = s -> s.length() != 4;

        Predicate<String> predicate5 = predicate.or(predicate2);
        Predicate<String> predicate6 = predicate.and(predicate2);
        Predicate<String> predicate7 = predicate.negate();
        Predicate<String> predicate8 = predicate.or(predicate3).or(predicate4);



    }

    private static void applyChanges(String[] names,
                                     List<UnaryOperator<String>> stringFunctions) {

        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getRandomChar() {
        return (char) random.nextInt('D', (int) 'M' + 1);
    }

    private static String reverse(String s) {
        return reverse(s, s.length());
    }

    private static String reverse(String s, int end) {
        return new StringBuilder(s.substring(0, end)).reverse().toString();
    }

}

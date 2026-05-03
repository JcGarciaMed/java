package lambdas.custom;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-------");
        list.forEach((var myString) -> System.out.println(myString));

        System.out.println("-------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        int result = calculadora((a, b) -> {
                var sum = a + b;
                return sum*200;
                },
                10, 20);
        String result2 = calculadora((a, b) -> {
            var sum = a + b;
            return STR."\{sum} hola mundo".toUpperCase();}, "10", "20");

    }

    public static <T> T calculadora(Operation<T> operation, T a, T b) {
        T result = operation.operate(a, b);
        System.out.println("Resultado: " + result);
        return result;
    }


    



}

package lambdas.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

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

        var resultBinario = binaryCalculator((a, b)->a*b, 15.23, 18.23);

        var coordenadas = Arrays.asList(
                new Double[]{42.2355, -95.2398},
                new Double[]{41.2331, -96.2112},
                new Double[]{43.2355, -94.2398},
                new Double[]{40.2331, -91.2112}
        );

        coordenadas.forEach(element -> System.out.println(Arrays.toString(element)));

        BiConsumer<Double, Double> biconsumer = (x, y) -> System.out.printf("[lat:%.3f, lon:.%3f]%n", x, y);

        coordenadas.forEach(element -> processPoint(element[0], element[1], biconsumer));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "empty");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i-> STR."\{i + 1}. \{switch (i) {
                    case 0 -> "zero";
                    case 1 -> "one";
                    case 2 -> "two";
                    default -> "empty";
                }}"
        );
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Jorge", "Carlos", "Ana", "Maria", "Carolina", "Daniela"};
        String[] randomList = randomlySelectedValues(15, names, ()-> new Random().nextInt(names.length));
        System.out.println(Arrays.toString(randomList));


    }

    public static <T> T calculadora(Operation<T> operation, T a, T b) {
        T result = operation.operate(a, b);
        System.out.println("Resultado: " + result);
        return result;
    }

    public static <T> T binaryCalculator(BinaryOperator<T> operation, T a, T b) {
        T result = operation.apply(a, b);
        System.out.println("Resultado: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> random){
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[random.get()];
        }
        return selectedValues;
    }


    



}

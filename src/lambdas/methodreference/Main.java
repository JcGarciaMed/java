package lambdas.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld{
    private static int last_id=1;
    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println( "New Plain Old Object created with id: " + id);
    }

    @Override
    public String toString() {
        return "PlainOld [id=" + id + "]";
    }
}

public class Main {
    static void main() {
        List<String> names = new ArrayList<>(List.of("Ralph", "John", "Jane"));
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        names.forEach(System.out::println);

        calculator(Integer::sum, 2, 14);
        calculator((a,n)-> a-n, 4, 54);
        calculator((x, y) -> x * y, 172, 122);

        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld po1 = reference1.get();

        System.out.println(po1);

        PlainOld[] array = seedArray(PlainOld::new, 10);
    }

    public static <T> void calculator(BinaryOperator<T> operator, T t1, T t2) {
        System.out.println(operator.apply(t1, t2));
    }

    public static PlainOld[] seedArray(Supplier<PlainOld> supplier, int size){
        PlainOld[] array = new PlainOld[size];
        Arrays.setAll(array, i -> supplier.get());
        return array;

    }
}

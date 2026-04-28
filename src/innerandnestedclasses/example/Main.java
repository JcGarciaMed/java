package innerandnestedclasses.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015, LocalDate.of(1989, 12,12)),
                new Employee(10005, "Carole", 2021, LocalDate.of(1991, 11,10)),
                new Employee(10022, "Jane", 2013, LocalDate.of(1999, 5,19)),
                new Employee(13151, "Laura", 2020, LocalDate.of(2010, 12,12)),
                new Employee(10050, "Jim", 2018, LocalDate.of(1979, 12,12)) ));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("dateStarted")
                .reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }

    }
}

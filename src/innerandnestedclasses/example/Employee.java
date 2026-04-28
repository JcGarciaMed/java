package innerandnestedclasses.example;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator <T extends Employee>
            implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }

            if( sortType.equalsIgnoreCase("dateStarted")){
                return Math.toIntExact(o1.dateStarted.toEpochDay() - o2.dateStarted.toEpochDay());
            }

            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;
    private LocalDate dateStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }


    public Employee(int employeeId, String name, int yearStarted, LocalDate dateStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
        this.dateStarted = dateStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d %s".formatted(employeeId, name, yearStarted, dateStarted);
    }
}

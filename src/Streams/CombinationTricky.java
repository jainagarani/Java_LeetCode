package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CombinationTricky {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "HR", 50000, 28, "Female", Arrays.asList("9876543210", "9123456789")),
                new Employee(101, "AliceA", "HR", 50000, 28, "Female", Arrays.asList("9876543210", "9123456789")),
                new Employee(102, "Bob", "IT", 75000, 32, "Male", Arrays.asList("9123456789")), // duplicate phone with Alice
                new Employee(103, "Charlie", "Finance", 60000, 28, "Male", Arrays.asList("9988776655")),
                new Employee(104, "David", "IT", 75000, 35, "Male", Arrays.asList("8877665544")), // duplicate salary with Bob
                new Employee(105, "Eva", "HR", 50000, 30, "Female", Arrays.asList("7788996655")), // duplicate salary with Alice
                new Employee(106, "Frank", "Finance", 85000, 32, "Male", Arrays.asList("6677889900")), // duplicate age with Bob
                new Employee(107, "Grace", "IT", 95000, 28, "Female", Arrays.asList("5566778899")), // duplicate age with Alice/Charlie
                new Employee(108, "Hannah", "Marketing", 55000, 30, "Female", Arrays.asList("4455667788")), // duplicate age with Eva
                new Employee(109, "Ian", "IT", 75000, 40, "Male", Arrays.asList("3344556677")), // duplicate salary with Bob/David
                new Employee(110, "Jane", "Finance", 60000, 28, "Female", Arrays.asList("2233445566")) // duplicate salary+age with Charlie
        );


        /*employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet().stream().filter(Map.Entry::getValue >1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());*/

    }
}

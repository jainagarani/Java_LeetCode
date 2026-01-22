package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedTransformations {

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

        //get list of employee name in uppercase
        List<String> employeeList = employees.stream().map(e-> e.getName().toUpperCase()).toList();
        //employeeList.forEach(System.out::println);

        //peek Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.
        //List<Employee> employeeList2 =employees.stream().peek(e-> e.setName(e.getName().toUpperCase())).toList();
       // employeeList2.forEach(System.out::println);

        //Returns a stream consisting of the results of applying the given function to the elements of this stream.
        //List<Employee> employeeList3 = employees.stream().map(Employee::toUpperCase).toList();
        //employeeList3.forEach(System.out::println);

        //Get a comma separated String of all employees
        String names = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        //System.out.println(" names "+ names);


        //get list of employee's salary after applying 10% bonus
        List<Double> salaryList = employees.stream().map(e-> e.getSalary()+e.getSalary()*10/100).toList();
       // salaryList.forEach(System.out::println);

        //get list of employee names sorted by length
        List<Employee> nameSorted = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();
        //nameSorted.forEach(System.out::println);

        //find the second highest salary
        Employee employee =employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().orElseThrow();
        //System.out.println("employee sencond highest salary "+ employee.getSalary());

        //get top 3 highest paid employees
        List<Employee> topEmpList = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
       // topEmpList.forEach(System.out::println);

        double thresholdSalary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();

        List<Employee> topPaidIncludingTies = employees.stream().filter(e-> e.getSalary() >= thresholdSalary).sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
        //topPaidIncludingTies.forEach(System.out::println);

        //skip first 5 employees and collect the rest
        List<Employee> employeeList4 = employees.stream().skip(5).toList();
        //employeeList4.forEach(System.out::println);

        //Flatten all phonenumbers of an employee into a singleList

        List<String> phoneNumbers = employees.stream().flatMap(e-> e.getPhoneNumbers().stream()).toList();
       // phoneNumbers.forEach(System.out::println);

        //create a map of id -> name

       Map<Integer, String> empMap = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (a,b)-> b, HashMap::new));
       //empMap.entrySet().forEach(System.out::println);

        Map<Integer, List<Employee>> empMap1 = employees.stream().collect(Collectors.groupingBy(Employee::getId));
        //empMap1.entrySet().forEach(System.out::println);

        Map<Integer, List<String>> empMap2 = employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getName,Collectors.toList())));
        //.entrySet().forEach(System.out::println);

        //find employees whose name starts with A
        List<Employee> employeeList5 = employees.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
        //employeeList5.stream().forEach(System.out::println);

        //find employees in IT department earning more than 70k
        List<Employee> employeeList6 = employees.stream().filter(e-> e.getDepartment().equalsIgnoreCase("IT") && e.getSalary() > 70000).toList();
        //employeeList6.stream().forEach(System.out::println);

        //find the oldest employee
        Employee oldestEmp = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst().orElseThrow();
       // System.out.println("oldestEmp "+oldestEmp);

        Employee oldestEmp1 = employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        //System.out.println("oldestEmp "+oldestEmp1);

        //find the youngest employee in each department

        Map<String, Optional<Employee>> empMap3 =employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getAge))));
        empMap3.entrySet().forEach(System.out::println);

        //Find the department with highest average salary
        String department = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey).get();

        //System.out.println("Department "+department);

        //Find employee sorted by multiple fields age , salary then name

        List<Employee> employeeList7 = employees.stream().sorted(Comparator.comparingInt(Employee::getAge)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary))
                .thenComparing(Comparator.comparing(Employee::getName))).toList();
        employeeList7.stream().forEach(System.out::println);

        //che


















    }
}

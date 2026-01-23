package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class ExtremelyAdvanced {
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

        double sumOfSalary = employees.stream().map(Employee::getSalary).reduce(0.0, (a,b) -> a+b);
        //System.out.println("sumOfSalary "+sumOfSalary);

        double sumOfSalary1 = employees.stream().mapToDouble(Employee::getSalary).sum();
        //System.out.println("sumOfSalary1 "+sumOfSalary1);

        //Collect employees into a LinkedHashMap <Dept, List<Employees>>
        LinkedHashMap<String, List<Employee>> empMap =employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.toList()));
       // empMap.entrySet().forEach(System.out::println);


        employees.stream().collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                (minSalOp, maxSalOp) ->
                        new MinMaxSalary(minSalOp.map(Employee::getSalary).orElse(0.0),
                                maxSalOp.map(Employee::getSalary).orElse(0.0)
                                )
                ));

        //Find median salary of employees
       List<Double> salaryList = employees.stream().map(Employee::getSalary).sorted().toList();
       Double medianSalary = 0.0;
       if(employees.size() %2 == 0){
           int median = employees.size()/2;
           medianSalary = salaryList.get(median) + salaryList.get(median+1)/2;

       }else{
           int median = employees.size()/2;
           medianSalary =  salaryList.get(median+1);
       }


       //Find top N Salaries in each department

        Map<String, List<Employee>> empMap1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(), list->
                      list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(2).collect(Collectors.toList()) )));

        //empMap1.entrySet().forEach(System.out::println);

        //create a nested map : Department, Gender, Average Salary
        Map<String, Map<String, Double>> empMap2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(), list->
                   list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
                 )));
        //empMap2.entrySet().forEach(System.out::println);

        //Find the count of male and female employees present in the organization

        Map<String, Long> empMap3 = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        //empMap3.entrySet().forEach(System.out::println);

        //Find the count of male and female employees present in each Department

        Map<String, Map<String, Long>> empMap4 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(), list->
                        list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())))));
       //
        // empMap4.entrySet().forEach(System.out::println);

        List<String> uniqueDepartment = employees.stream().map(Employee::getDepartment).distinct().toList();
        uniqueDepartment.forEach(System.out::println);

        //print average age of male and female in the organization
        Map<String, Double> empMap5 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        //empMap5.entrySet().forEach(System.out::println);

        Map<String, Map<String, Double>> empMap6 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(), list->
                        list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))))));

        empMap6.entrySet().forEach(System.out::println);








    }
}


class MinMaxSalary{

    double minSalary;
    double maxSalary;

    public MinMaxSalary(double minSalary, double maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
}


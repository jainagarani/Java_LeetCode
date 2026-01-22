package Streams;

import java.util.List;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private String gender;
    private List<String> phoneNumbers;

    public Employee(int id, String name, String department, double salary, int age, String gender, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Employee employee = (Employee) o;
        return (this.id == employee.getId() && Double.compare(salary, employee.salary) == 0 &&
                age == employee.getAge()
                && Objects.equals(name, employee.getName())&&
                Objects.equals(department, employee.department) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(phoneNumbers, employee.getPhoneNumbers())
        );
    }



    @Override
    public int hashCode(){
        return Objects.hash(id, name, department,salary,age, gender, phoneNumbers);
    }

    public static Employee   toUpperCase(Employee employee){
        employee.setName(employee.getName().toUpperCase());
        return employee;
    }
}

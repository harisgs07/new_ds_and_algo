import java.util.List;
import java.util.ArrayList;
import java.util.*;

class Employee {
    public int salary;
    public String name;

    Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}

public class java8new {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee(100, "hari"));
        emp.add(new Employee(200, "shambhu"));
        // List<Employee> empone = emp.stream().collect();
        // Map<String, List<Employee>> empmap = emp.stream();
    }
}

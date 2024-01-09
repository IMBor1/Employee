package Pro.Sky.Employeebook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    static List<Employee> employes = new ArrayList<>(List.of(new Employee("kolya", "tor")));

    final static int MAX_EMPLOYES = 10;

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employes.add(employee);
        return employee;

    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);

        for (Employee employee : employes) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getlastName().equals(lastName)) {
                e = employee;
                employes.remove(employee);
            }
        }
        return e;
    }

    public Employee searchEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);

        for (Employee employee : employes) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getlastName().equals(lastName)) {
                e = employee;
                System.out.println(employee);

            }
        }
        return e;
    }

    public String allEmployes() {
        return employes.toString();
    }
}

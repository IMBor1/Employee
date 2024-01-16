package Pro.Sky.Employeebook;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    public static Map<Employee, String> employes;

    public EmployeeService(Map<Employee, String> employes) {
        this.employes = new HashMap<>();
    }

    final static int MAX_EMPLOYES = 10;

    public Map<Employee, String> addEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName);
        Map<Employee, String> map = new HashMap<>(Map.of(employee, passport));
        employes.put(employee, passport);
        return map;

    }

    public Map<Employee, String> removeEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName);
        Map<Employee, String> map = new HashMap<>();
        for (Employee employee1 : employes.keySet()) {
            if (employee1.getFirstName().equals(employee.getFirstName()) &&
                    employee1.getlastName().equals(employee.getlastName())) {

                employee1 = employee;
                employes.remove(employee1);
                map.put(employee1, passport);
            }
        }
        return map;
    }

    public Map<Employee, String> searchEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName);
        Map<Employee, String> map = new HashMap<>();
        for (Employee employee1 : employes.keySet()) {
            if (employee1.getFirstName().equals(employee.getFirstName()) &&
                    employee1.getlastName().equals(employee.getlastName())) {
                employee1 = employee;
                map.put(employee1, passport);
                System.out.println(map);

            }
        }
        return map;
    }

    public String allEmployes() {
        return employes.toString();
    }
}

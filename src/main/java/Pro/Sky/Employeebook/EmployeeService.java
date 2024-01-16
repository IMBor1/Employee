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
        if (employes.containsKey(employee)) {
            employes.remove(employee);
            map.put(employee, passport);
        }
        return map;
    }

    public Map<Employee, String> searchEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName);
        Map<Employee, String> map = new HashMap<>();
        if (employes.containsKey(employee)) {
            employes.remove(employee);
            map.put(employee, passport);
        }

        System.out.println(map);


        return map;
    }

    public String allEmployes() {
        return employes.toString();
    }
}

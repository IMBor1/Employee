package Pro.Sky.Employeebook;

import Pro.Sky.Employeebook.Exception.EmployeeAlreadyAddedException;
import Pro.Sky.Employeebook.Exception.EmployeeNotFoundException;
import Pro.Sky.Employeebook.Exception.InvalidException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {
    public static Map<String, Employee> employes;

    public EmployeeService(Map<String, Employee> employes) {
        this.employes = new HashMap<>();
    }


    final static int MAX_EMPLOYES = 10;

    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        isAlpha(firstName, lastName);
        Employee employee = new Employee(capitalizeFirstName(firstName), capitalizeLastName(lastName), department, salary);
        if (employes.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employes.put(employee.getFullName(), employee);

        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, int department, double salary) {
        isAlpha(firstName, lastName);
        Employee employee = new Employee(capitalizeFirstName(firstName), capitalizeLastName(lastName), department, salary);
        if (employes.containsKey(employee.getFullName())) {
            employes.remove(employee.getFullName());

            return employee;
        }
        throw new EmployeeNotFoundException("человек не найден");
    }

    public Employee searchEmployee(String firstName, String lastName, int department, double salary) {
        isAlpha(firstName, lastName);
        Employee employee = new Employee(capitalizeFirstName(firstName), capitalizeLastName(lastName), department, salary);
        if (employes.containsKey(employee.getFullName())) {
            return employes.get(employee.getFullName());

        }

        throw new EmployeeNotFoundException("человек не найден");
    }

    public List<Employee> allEmployes() {
        List<Employee> list = new ArrayList<>();
        list.addAll(employes.values());
        return list;
    }

    public void isAlpha(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new InvalidException();
        }
    }

    public String capitalizeFirstName(String firstName) {
        String firstNameCopy = StringUtils.capitalize(firstName);
        return firstNameCopy;
    }

    public String capitalizeLastName(String lastName) {
        lastName = StringUtils.capitalize(lastName);
        return lastName;
    }
}

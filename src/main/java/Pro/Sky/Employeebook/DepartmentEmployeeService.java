package Pro.Sky.Employeebook;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentEmployeeService {

    private final EmployeeService employeeService;

    public DepartmentEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee minDepartment(int department) {
        return employeeService.allEmployes().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }


    public Employee maxDepartment(int department) {
        return employeeService.allEmployes().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

    }

    public double sumSalaryByDepartment(int department) {
        return employeeService.allEmployes().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public List<Employee> listByDepartment(int department) {
        return employeeService.allEmployes().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> allByDepartments() {
        return employeeService.allEmployes().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}

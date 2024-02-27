package Pro.Sky.Employeebook;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static Pro.Sky.Employeebook.EmployeeService.employes;

@Service
public class DepartmentEmployeeService {

    private final EmployeeService employeeService;

    public DepartmentEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> minDepartment(int department) {
        return employes.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> (int) e.getSalary()));


    }

    public Optional<Employee> maxDepartment(int department) {
        return employes.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> (int) e.getSalary()));

    }

    public double sumSalaryByDepartment(Double department) {
        return employes.values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public List<Employee> listByDepartment(int department) {
        return employes.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> allByDepartment() {
        return employeeService.allEmployes().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}

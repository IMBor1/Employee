package Pro.Sky.Employeebook;

import Pro.Sky.Employeebook.Exception.EmployeeAlreadyAddedException;
import Pro.Sky.Employeebook.Exception.EmployeeNotFoundException;
import Pro.Sky.Employeebook.Exception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static Pro.Sky.Employeebook.EmployeeService.MAX_EMPLOYES;
import static Pro.Sky.Employeebook.EmployeeService.employes;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        if (employes.size() >= MAX_EMPLOYES) {
            throw new EmployeeStorageIsFullException("Список заполнен");
        }
        for (Employee employee : employes) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getlastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
            }
        }
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName) {

        int count = 0;
        for (Employee employee : employes) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getlastName().equals(lastName)) {
                count++;
            }
        }
        if (count <= 0) throw new EmployeeNotFoundException("человек не найден");
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/search")
    public Employee searchEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        int count = 0;
        for (Employee employee : employes) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getlastName().equals(lastName)) {
                count++;
            }
        }
        if (count <= 0) throw new EmployeeNotFoundException("человек не найден");

        return employeeService.searchEmployee(firstName, lastName);
    }

    @GetMapping(path = "/allEmployes")
    public String allEmployes() {
        return employeeService.allEmployes();
    }
}


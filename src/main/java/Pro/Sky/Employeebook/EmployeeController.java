package Pro.Sky.Employeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Double salary) {

        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName,
                                   @RequestParam("department") Integer department,
                                   @RequestParam("salary") Double salary) {


        return employeeService.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/search")
    public Employee searchEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") Integer department,
                                   @RequestParam("salary") Double salary) {

        return employeeService.searchEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/allEmployes")
    public List<Employee> allEmployes() {
        return employeeService.allEmployes();
    }
}


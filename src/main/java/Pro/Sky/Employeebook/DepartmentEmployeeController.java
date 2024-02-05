package Pro.Sky.Employeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentEmployeeController {
    private final DepartmentEmployeeService departmentEmployeeService;

    public DepartmentEmployeeController(DepartmentEmployeeService departmentEmployeeService) {
        this.departmentEmployeeService = departmentEmployeeService;
    }


    @GetMapping(path = "/max-salary")
    public Optional<Employee> printMaxSalaryByDep(@RequestParam("department") Integer department) {
        return departmentEmployeeService.maxDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Optional<Employee> printMinSalaryByDep(@RequestParam("department") Integer department) {
        return departmentEmployeeService.minDepartment(department);
    }

    @GetMapping(path = "all-by-department")
    public List<Employee> printListByDepartment(@RequestParam("department") Integer department) {

        return departmentEmployeeService.listByDepartment(department);
    }

    @GetMapping(path = "all")
    public Map<Integer, List<Employee>> printAllDepartments() {
        return departmentEmployeeService.allByDepartment();
    }
}


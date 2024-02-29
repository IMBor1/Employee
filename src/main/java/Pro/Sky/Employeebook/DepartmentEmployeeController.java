package Pro.Sky.Employeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentEmployeeController {
    private final DepartmentEmployeeService departmentEmployeeService;

    public DepartmentEmployeeController(DepartmentEmployeeService departmentEmployeeService) {
        this.departmentEmployeeService = departmentEmployeeService;
    }


    @GetMapping(path = "/{department}/salary/max")
    public Employee printMaxSalaryByDep(@RequestParam("department") Integer department) {
        return departmentEmployeeService.maxDepartment(department);
    }

    @GetMapping(path = "/{department}/salary/min")
    public Employee printMinSalaryByDep(@RequestParam("department") Integer department) {
        return departmentEmployeeService.minDepartment(department);
    }

    @GetMapping(path = "/{department}/salary/sum")
    public Double printSumSalaryByDep(@RequestParam("department") Integer department) {
        return departmentEmployeeService.sumSalaryByDepartment(department);
    }

    @GetMapping(path = "/{department}/employees")
    public List<Employee> printListByDepartment(@RequestParam("department") Integer department) {

        return departmentEmployeeService.listByDepartment(department);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> printAllDepartments() {
        return departmentEmployeeService.allByDepartments();
    }
}


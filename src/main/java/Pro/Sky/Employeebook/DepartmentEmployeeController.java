package Pro.Sky.Employeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @GetMapping(path = "/{id}/salary/max")
    public Employee printMaxSalaryByDep(@PathVariable("department") Integer department) {
        return departmentEmployeeService.maxDepartment(department);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee printMinSalaryByDep(@PathVariable("department") Integer department) {
        return departmentEmployeeService.minDepartment(department);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Double printSumSalaryByDep(@PathVariable("department") Integer department) {
        return departmentEmployeeService.sumSalaryByDepartment(department);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> printListByDepartment(@PathVariable("department") Integer department) {

        return departmentEmployeeService.listByDepartment(department);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> printAllDepartments() {
        return departmentEmployeeService.allByDepartments();
    }
}


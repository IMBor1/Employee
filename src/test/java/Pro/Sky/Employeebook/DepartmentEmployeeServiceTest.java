package Pro.Sky.Employeebook;

import Pro.Sky.Employeebook.Exception.DepartmentIsEmpty;
import Pro.Sky.Employeebook.Exception.NotFoundDepartment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentEmployeeServiceTest {
    @Mock
    private EmployeeService mockEmployeeService;
    @InjectMocks
    private DepartmentEmployeeService departmentEmployeeService;
    public static final Employee MAX_SALARY = new Employee("Andrey", "Moroz", 1, 10000);
    public static final Employee MIN_SALARY = new Employee("Bob", "Red", 1, 5000);
    public static List<Employee> EMPLOYEE = new ArrayList<>(List.of(MAX_SALARY, MIN_SALARY));

    @Test
    void minSalaryTest() {

        when(mockEmployeeService.allEmployes())
                .thenReturn(EMPLOYEE);
        assertEquals(MIN_SALARY, departmentEmployeeService.minDepartment(1));
    }

    @Test
    void maxSalaryTest() {

        when(mockEmployeeService.allEmployes())
                .thenReturn(EMPLOYEE);
        assertEquals(MAX_SALARY, departmentEmployeeService.maxDepartment(1));
    }


    @Test
    void notFoundDepartment() {

        when(departmentEmployeeService.allByDepartments())
                .thenThrow(NotFoundDepartment.class);
        assertThrows(NotFoundDepartment.class,
                () -> departmentEmployeeService.listByDepartment(8));
    }


    @Test
    void isEmptyDepartament() {
        when(mockEmployeeService.allEmployes())
                .thenThrow(DepartmentIsEmpty.class);
        assertThrows(DepartmentIsEmpty.class,
                () -> departmentEmployeeService.allByDepartments());
    }

    @Test
    void sumSalaryByDepartmentTest() {
        when(mockEmployeeService.allEmployes())
                .thenReturn(EMPLOYEE);
        assertEquals((MIN_SALARY.getSalary() + MAX_SALARY.getSalary()),
                departmentEmployeeService.sumSalaryByDepartment(1));
    }

    @Test
    void allEmployeeByDepartmentTest() {
        when(mockEmployeeService.allEmployes())
                .thenReturn(EMPLOYEE);
        assertEquals(EMPLOYEE, departmentEmployeeService.listByDepartment(1));
    }

    @Test
    void allEmployesByAllDepartmentsTest() {

        when(mockEmployeeService.allEmployes())
                .thenReturn(EMPLOYEE);
        assertEquals(1, departmentEmployeeService.allByDepartments().size());

    }
}

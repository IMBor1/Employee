package Pro.Sky.Employeebook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}

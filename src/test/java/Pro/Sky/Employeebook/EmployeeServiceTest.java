package Pro.Sky.Employeebook;

import Pro.Sky.Employeebook.Exception.EmployeeAlreadyAddedException;
import Pro.Sky.Employeebook.Exception.EmployeeNotFoundException;
import Pro.Sky.Employeebook.Exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    Map<String, Employee> map = new HashMap<>();
    EmployeeService employeeService = new EmployeeService(map);

    Employee ANDREY = new Employee("Andrey", "Moroz", 1, 10000);
    Employee BOB = new Employee("Bob", "Red", 2, 15000);

    @Test
    void addAndrey() {
        Employee result = employeeService.addEmployee(
                "Andrey", "Moroz", 1, 10000);
        assertEquals(result, ANDREY);
    }

    @Test
    void addAndreyButHeIsCreated() {
        map.put("Andrey Moroz", ANDREY);
        Employee result = employeeService.addEmployee("Andrey", "Moroz",
                1, 10000);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Andrey", "Moroz",
                        1, 10000));
    }

    @Test
    void BobSearch() {
        employeeService.addEmployee("Bob", "Red",
                2, 15000);
        Employee result = employeeService.searchEmployee("Bob", "Red",
                2, 15000);
        assertEquals(result, BOB);
    }

    @Test
    void BobNotFound() {
        employeeService.addEmployee("Kolya", "Red",
                2, 15000);

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.searchEmployee("Bob", "Red",
                2, 15000));
    }

    @Test
    void BobRemove() {
        employeeService.addEmployee("Bob", "Red",
                2, 15000);
        Employee result = employeeService.removeEmployee("Bob", "Red",
                2, 15000);
        assertEquals(result, BOB);
    }

    @Test
    void sizeEmployesTest() {
        List<Employee> result = employeeService.allEmployes();
        result.add(ANDREY);
        result.add(BOB);

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee("Karl", "rut", 2, 6000));
        assertNotEquals(2, result.size());
    }

}

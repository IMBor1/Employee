package Pro.Sky.Employeebook;

import Pro.Sky.Employeebook.Exception.EmployeeAlreadyAddedException;
import Pro.Sky.Employeebook.Exception.EmployeeNotFoundException;
import Pro.Sky.Employeebook.Exception.EmployeeStorageIsFullException;
import Pro.Sky.Employeebook.Exception.MyInvalidException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
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
    void notAlphaTest() {
        assertThrows(MyInvalidException.class,
                () -> employeeService.addEmployee("rock1", "lou", 3, 300));
    }
    @Test
    void sizeEmployesTest() {

        assertThrows(EmployeeStorageIsFullException.class,
                () -> {
                    employeeService.addEmployee("Karl", "Rutl", 2, 6000);
                    employeeService.addEmployee("Karlo", "Rutm", 2, 6000);
                    employeeService.addEmployee("Karln", "Rutk", 2, 6000);
                    employeeService.addEmployee("Karls", "Ruta", 2, 6000);
                    employeeService.addEmployee("Karla", "Ruto", 2, 6000);
                    employeeService.addEmployee("Karle", "Ruti", 2, 6000);
                    employeeService.addEmployee("Karly", "Rutu", 2, 6000);
                    employeeService.addEmployee("Karlu", "Ruty", 2, 6000);
                    employeeService.addEmployee("Karli", "Rute", 2, 6000);
                    employeeService.addEmployee("Karlop", "Ruta", 2, 6000);
                    employeeService.addEmployee("Karl", "Rut", 2, 6000);
                    employeeService.addEmployee("Karlуу", "Rut", 2, 6000);

                });
        System.out.println(employeeService.allEmployes().size());
    }

}

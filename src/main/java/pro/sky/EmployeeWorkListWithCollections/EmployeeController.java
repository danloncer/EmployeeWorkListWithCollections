package pro.sky.EmployeeWorkListWithCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return "Сотрудник " + employeeServiceImpl.addEmployee(firstName, lastName) + " добавлен!";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return "Сотрудник " + employeeServiceImpl.removeEmployee(firstName, lastName) + " удален!";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }

    @GetMapping("/get/list")
    public List<Employee> getEmployeeList() {
        return employeeServiceImpl.getEmployeeList();
    }
}

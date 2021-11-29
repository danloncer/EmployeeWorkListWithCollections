package pro.sky.EmployeeWorkListWithCollections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        employeeList.add(worker);
        return worker;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        if (employeeList.remove(worker)) {
            return worker;
        }
        throw new NotFoundEmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        if (employeeList.indexOf(worker) != -1) {
            return worker;
        }
        throw new NotFoundEmployeeException();
    }

    public List<Employee> getEmployeeList () {
        return employeeList;
    }
}

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
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(worker)) {
                employeeList.remove(i);
                return worker;
            }
        }
        throw new NotFoundEmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(worker)) {
                return employeeList.get(i);
            }
        }
        throw new NotFoundEmployeeException();
    }

    public List<Employee> getEmployeeList () {
        return employeeList;
    }
}

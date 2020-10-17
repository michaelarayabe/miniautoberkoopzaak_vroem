package be.intecbrussel.data;

import be.intecbrussel.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

    List<Employee> listAllEmployees();
    List<Employee> listEmployeesByExtension(String extension);
    List<Employee> listEmployeesByJobTitle(String jobtitle);

}

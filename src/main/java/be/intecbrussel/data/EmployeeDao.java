package be.intecbrussel.data;

import be.intecbrussel.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

    void listAllEmployees();
    List<Employee> listEmployeesByExtension(String extension);
    void listEmployeesByJobTitle(String jobtitle);

}

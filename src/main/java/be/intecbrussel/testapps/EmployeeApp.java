package be.intecbrussel.testapps;

import be.intecbrussel.data.EmployeeDao;
import be.intecbrussel.data.EmployeeDaoImpl;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Office;

public class EmployeeApp {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Office office = new Office();
        office.setOfficeCode("1");



        //#################### Creating new employees ###################################

        Employee employee = new Employee(2323,"Dav","Tom","x3001","mdfdf@gmail.com","Software Engineer",office, employeeDao.readEmployee(1002));
        employeeDao.createEmployee(employee);

        //#################### Reading employees from employees table ###################################

        //System.out.println(employeeDao.readEmployee(1056));


        //#################### Updating employees ###################################

        /*Employee employeeTobeUpdated = new Employee();
        employeeTobeUpdated.setEmployeeNumber(1702);

        employeeTobeUpdated.setJobTitle("Hardware Engineer");
        employeeTobeUpdated.setReportsTo(1002);
        employeeTobeUpdated.setOfficeCode("1");
        employeeTobeUpdated.setEmail("solomon@gmail.com");
        employeeTobeUpdated.setExtension("x1113");
        employeeTobeUpdated.setFirstName("vSolomon");
        employeeTobeUpdated.setLastName("vDavid");

        employeeDao.updateEmployee(employeeTobeUpdated);
        System.out.println("updated");

         */

        //#################### Deleting employees ###################################

/*
        Employee employeeTobeDeleted = new Employee();
        employeeTobeDeleted.setEmployeeNumber(2122);

        employeeDao.deleteEmployee(employeeTobeDeleted);
        System.out.println("Employee deleted!");

 */
        //#################### List all employees ###################################

        //employeeDao.listAllEmployees();

        //#################### List employees by extension ###################################


        //System.out.println(employeeDao.listEmployeesByExtension("x5800"));

        //#################### List employees by job title ###################################

        //employeeDao.listEmployeesByJobTitle("Sales Rep");


    }
}

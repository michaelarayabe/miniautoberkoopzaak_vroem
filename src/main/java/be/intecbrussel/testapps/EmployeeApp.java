package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.EmployeeDao;
import be.intecbrussel.data.impl.EmployeeDaoImpl;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Office;

public class EmployeeApp {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Office office = new Office();
        office.setOfficeCode("2");



        //#################### Creating new employees ###################################

        Employee employee = new Employee(1000, office,"AnotherLastName","AnotherFirstName","x1141","1@gmail.com","Record Officer", employeeDao.readEmployee(1002));
        employeeDao.createEmployee(employee);  // ---------------------WORKS



        //#################### Reading employees from employees table ###################################

        System.out.println(employeeDao.readEmployee(1056)); // ---------------------WORKS


        //#################### Updating employees ###################################

        Employee employeeTobeUpdated = new Employee();
        employeeTobeUpdated.setEmployeeNumber(3131);

        //#################### Our office for the employee  ###################################


        //Our options for the update:
        //- We can update the office to an existing office, or
        //- We can create a new office for the employee

        // Let us update the office to an existing office
        Office existingOffice = new Office();
        existingOffice.setOfficeCode("1");

        // We refer to the employee we want him to report to
        Employee employeeToReportTo = employeeDao.readEmployee(1002);


        employeeTobeUpdated.setJobTitle("Secratary");
        employeeTobeUpdated.setReportsTo(employeeToReportTo);
        employeeTobeUpdated.setEmail("awet@gmail.com");
        employeeTobeUpdated.setExtension("y2312");
        employeeTobeUpdated.setFirstName("Meron");
        employeeTobeUpdated.setLastName("Climansou");

        employeeDao.updateEmployee(employeeTobeUpdated);// ---------------------WORKS





        //#################### Deleting employees ###################################


        Employee employeeTobeDeleted = new Employee();
        employeeTobeDeleted.setEmployeeNumber(2923);

        employeeDao.deleteEmployee(employeeTobeDeleted); // ---------------------WORKS



    }
}

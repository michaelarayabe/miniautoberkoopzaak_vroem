package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.CustomerDao;
import be.intecbrussel.data.impl.CustomerDaoImpl;
import be.intecbrussel.data.impl.EmployeeDaoImpl;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Employee;

import java.math.BigDecimal;

public class CustomerApp {

    public static void main(String[] args) {

        CustomerDao customerDao = new CustomerDaoImpl();

        //#################### Creating Customers ###################################

        //First let's refer to the employee that takes care of him

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.readEmployee(1056);
        BigDecimal creditLimit = new BigDecimal("122312.00");

        //set all the attributes needed
        Customer customer1 = new Customer();
        customer1.setCustomerNumber(102);
        customer1.setAddressLine1("Heaven");
        customer1.setCustomerName("Tola");
        customer1.setContactLastName("dfdf");
        customer1.setContactFirstName("dfdfdf");
        customer1.setPhone("1212");
        customer1.setAddressLine2("address two");
        customer1.setCity("Wollo");
        customer1.setState("Vancover");
        customer1.setPostalCode("222");
        customer1.setCountry("Belgie");
        customer1.setSalesRepEmployeeNumber(employee);
        customer1.setCreditLimit(creditLimit);

        //Create the customer
        customerDao.createCustomers(customer1); //----------------WORKS








        //#################### Reading Customers by customer id ###################################

        System.out.println(customerDao.readCustomers(102)); //----------------WORKS

        //#################### Reading Customers by customer name ###################################

        customerDao.readCustomers("Mika"); //----------------WORKS



        //#################### Updating customer data ###################################

        Customer customerToupdate = customerDao.readCustomers(101);

        customerToupdate.setCustomerName("Bert");
        customerToupdate.setAddressLine1("Groene Valley Straat");

        customerDao.updateCustomers(customerToupdate); //----------------WORKS




        //#################### Deleting customer data ###################################

        Customer customer = customerDao.readCustomers(102);
        customerDao.deleteCustomers(customer); //----------------WORKS







        //#################### Listing all customer data ###################################

        customerDao.listAllCustomers(); //----------------WORKS



        //#################### Listing customer data by city ###################################

        customerDao.listCustomersByCity("NYC"); //----------------WORKS



    }
}

package be.intecbrussel.testapps;

import be.intecbrussel.data.CustomerDao;
import be.intecbrussel.data.CustomerDaoImpl;
import be.intecbrussel.entities.Customer;

public class CustomerApp {

    public static void main(String[] args) {

        CustomerDao customerDao = new CustomerDaoImpl();

        //#################### Creating Customers ###################################
/*
        Customer customer = new Customer(621,"Mika","Sol","Micco","00012","Leiekaai","groene valley","Gent","Oost Vlanderen","9000","Belgium",1212);
        customerDao.createCustomers(customer);

 */


        //#################### Reading Customers by customer id ###################################

        //System.out.println(customerDao.readCustomers(521));

        //#################### Reading Customers by customer name ###################################
/*
        customerDao.readCustomers("Mika");

 */

        //#################### Updating customer data ###################################
/*
        Customer customerToupdate = customerDao.readCustomers(621);

        customerToupdate.setCustomerName("MiccoJicco");
        customerToupdate.setAddressLine1("Groene Valley Straat");

        customerDao.updateCustomers(customerToupdate);

 */

        //#################### Deleting customer data ###################################

        Customer customer = customerDao.readCustomers(103);
        customerDao.deleteCustomers(customer);



        //#################### Listing all customer data ###################################
/*
        customerDao.listAllCustomers();

 */

        //#################### Listing customer data by city ###################################

        //customerDao.listCustomersByCity("NYC");

    }
}

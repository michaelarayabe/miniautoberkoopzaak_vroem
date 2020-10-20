package be.intecbrussel.testapps;

import be.intecbrussel.data.CustomerDao;
import be.intecbrussel.data.CustomerDaoImpl;
import be.intecbrussel.data.OrderDao;
import be.intecbrussel.data.OrderDaoImpl;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Office;
import be.intecbrussel.entities.Order;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderApp {
    public static void main(String[] args) {

        OrderDao orderDao = new OrderDaoImpl();

        //#################### Creating new Order ###################################
/*
        Customer customer = new Customer();
        customer.setCustomerNumber(103);
        Order newOrder = new Order(12111,LocalDate.of(2020,01,01),LocalDate.of(2020,02,01),LocalDate.of(2020,03,03),"Shipped","no comments",customer);
        orderDao.createOrder(newOrder);

 */

        //#################### Creating new Order ###################################

        //System.out.println(orderDao.readOrder(10100));


        //#################### Update Order###################################
/*
        Order orderToBeUpdated = orderDao.readOrder(10100);

        orderToBeUpdated.setStatus("confirmed");

        orderDao.updateOrder(orderToBeUpdated);

 */



        //#################### Delete Order ###################################


        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.readCustomers(363);
        customerDao.deleteCustomers(customer);


/*
        Order orderToBeDeleted = orderDao.readOrder(10100);
        orderDao.deleteOrder(orderToBeDeleted);

 */


    }




}

package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.CustomerDao;
import be.intecbrussel.data.impl.CustomerDaoImpl;
import be.intecbrussel.data.dao.OrderDao;
import be.intecbrussel.data.impl.OrderDaoImpl;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Order;
import java.time.LocalDate;

public class OrderApp {
    public static void main(String[] args) {

        OrderDao orderDao = new OrderDaoImpl();

        //#################### Creating new Order ###################################

        //Two options here about customers
        //Option one: Create new Customer
        //Option two: Refer to an existing customer

        //Using option two for this assignment
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.readCustomers(101);

        //Using constructor to create a new order just for a change
        LocalDate orderDate = LocalDate.of(2020, 2,1);
        LocalDate requiredDate = LocalDate.of(2020,2,1);
        LocalDate shippedDate = LocalDate.of(2020,3,3);

        Order newOrder = new Order(10099,orderDate,requiredDate,shippedDate,"Shipped","no comments",customer);
        orderDao.createOrder(newOrder); //------------------WORKS





        //#################### Reading Order by order number ###################################

        System.out.println(orderDao.readOrder(10100)); //------------------WORKS


        //#################### Update Order###################################

        Order orderToBeUpdated = orderDao.readOrder(10099);

        orderToBeUpdated.setStatus("confirmed");

        orderDao.updateOrder(orderToBeUpdated); //------------------WORKS







        //#################### Delete Order ###################################



        Order orderToBeDeleted = orderDao.readOrder(10099);
        orderDao.deleteOrder(orderToBeDeleted);  //------------------WORKS


    }


}

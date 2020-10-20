package be.intecbrussel.data;

import be.intecbrussel.entities.Order;

public interface OrderDao {
    /*
    read, update, delete
     */

    void createOrder(Order order);
    Order readOrder(int orderNumber);
    void updateOrder(Order order);
    void deleteOrder(Order Order);
}

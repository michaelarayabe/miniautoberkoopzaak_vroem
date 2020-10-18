package be.intecbrussel.data;

import be.intecbrussel.entities.Customer;

import java.util.List;

public interface CustomerDao {

    void createCustomers(Customer customer);
    Customer readCustomers(int customerNumber);
    void readCustomers(String customerName);
    void updateCustomers(Customer customer);
    void deleteCustomers(Customer customer);

    void listAllCustomers();
    void listCustomersByCity(String city);

}

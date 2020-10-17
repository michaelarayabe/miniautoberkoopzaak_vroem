package be.intecbrussel.data;

import be.intecbrussel.model.Customer;

import java.util.List;

public interface CustomerDao {

    void createCustomers(Customer customer);
    Customer readCustomers(int customerNumber);
    void readCustomers(String customerName);
    void updateCustomers(Customer customer);
    void deleteCustomers(Customer customer);

    List<Customer> listAllCustomers();
    List<Customer> listCustomersByCity(String city);

}
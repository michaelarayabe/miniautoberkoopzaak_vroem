package be.intecbrussel.data;

import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class CustomerDaoImpl implements CustomerDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createCustomers(Customer customer) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            entityManager.find(Customer.class,customer.getCustomerNumber());
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
            System.out.println("Customer created!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public Customer readCustomers(int customerNumber) {

        EntityManager entityManager = null;
        Customer customer = null;

        try{
            entityManager = emf.createEntityManager();
            customer =  entityManager.find(Customer.class,customerNumber);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

        return customer;

    }

    @Override
    public void readCustomers(String customerName) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            TypedQuery<Customer> query = entityManager.createQuery("select customers from Customer customers", Customer.class);

            for(Customer c : query.getResultList()){
                if(!c.getCustomerName().equalsIgnoreCase(customerName)){
                    System.out.println("No customer by that name");
                    break;
                }else if(c.getCustomerName().equalsIgnoreCase(customerName)){
                    System.out.println(c + "\n");
                }


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public void updateCustomers(Customer customer) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(customer);
            transaction.commit();
            System.out.println("customer data updated!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public void deleteCustomers(Customer customer) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            customer = entityManager.find(Customer.class, customer.getCustomerNumber());

            transaction.begin();
            entityManager.remove(customer);
            transaction.commit();

            System.out.println("customer deleted!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void listAllCustomers() {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            TypedQuery<Customer> query = entityManager.createQuery("select customers from Customer customers", Customer.class);

            for(Customer c : query.getResultList()){
                System.out.printf("First Name: %s, Last Name: %s, City: %s \n", c.getContactFirstName(), c.getContactLastName(), c.getCity());

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public void listCustomersByCity(String city) {
        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            TypedQuery<Customer> query = entityManager.createQuery("select customers from Customer customers", Customer.class);

            for(Customer c : query.getResultList()){
                if(c.getCity().equalsIgnoreCase(city)){
                    System.out.printf("First Name: %s, Last Name: %s, City: %s \n", c.getContactFirstName(), c.getContactLastName(), c.getCity());
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }
}

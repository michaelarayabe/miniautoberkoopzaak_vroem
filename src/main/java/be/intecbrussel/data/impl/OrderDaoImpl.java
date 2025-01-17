package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.OrderDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDaoImpl implements OrderDao {
    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrder(Order order) {
        EntityManager entityManager = null;

        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            entityManager.find(Order.class, order.getOrderNumber());

            transaction.begin();

            entityManager.persist(order);

            transaction.commit();
            System.out.println("Order created!");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }

    }

    @Override
    public Order readOrder(int orderNumber) {
        EntityManager entityManager = null;

        Order order = null;

        try {

            entityManager = emf.createEntityManager();

            order = entityManager.find(Order.class, orderNumber);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {

        EntityManager entityManager = emf.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();

            order.setOrderNumber(order.getOrderNumber());

            transaction.begin();
            entityManager.merge(order);
            transaction.commit();
            System.out.println("Order Updated!!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteOrder(Order order) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            order = entityManager.find(Order.class, order.getOrderNumber() );
            transaction.begin();
            entityManager.remove(order);
            transaction.commit();
            System.out.println("deleted!");

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }

    }

}

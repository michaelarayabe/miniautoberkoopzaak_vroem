package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.OrderDetailDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Office;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderDetailImpl implements OrderDetailDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(OrderDetail orderdetail) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            entityManager.persist(orderdetail);

            transaction.commit();

            System.out.println("OrderDetail created!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public OrderDetail readOrderDetail(OrderDetailPK orderDetailPK) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("classicmodels");
        EntityManager entityManager = null;
        OrderDetail orderDetail = new OrderDetail();

        try{
            entityManager = entityManagerFactory.createEntityManager();
            orderDetail = entityManager.find(OrderDetail.class, orderDetailPK);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }
        return orderDetail;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {

    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {

    }
}

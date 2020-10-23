package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.OrderDetailDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Office;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDetailImpl implements OrderDetailDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(OrderDetailPK orderdetail) {



        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            //ToDo later
            //entityManager.find(Office.class, orderdetail.);

            transaction.begin();

            entityManager.persist(orderdetail);

            transaction.commit();
            System.out.println("Office created!");
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
        return null;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {

    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {

    }
}

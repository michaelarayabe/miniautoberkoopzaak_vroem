package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.PaymentDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PaymentDaoImpl implements PaymentDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createPayment(Payment payment) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(payment);
            transaction.commit();
            System.out.println("Payment Created!");

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public Payment readPayment(String checkNumber) {
        EntityManager entityManager = null;
        Payment payment = null;
        try{
            entityManager = emf.createEntityManager();
            payment = entityManager.find(Payment.class, checkNumber);


        }catch (Exception e){
            e.printStackTrace();

        }finally {

            if(entityManager != null){
                entityManager.close();
            }
        }
        return payment;
    }

    @Override
    public void updatePayment(Payment payment) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.merge(payment);
            transaction.commit();
            System.out.println("Updated!");

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deletePayment(Payment payment) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            payment = entityManager.find(Payment.class,payment.getCheckNumber());
            transaction.begin();
            entityManager.remove(payment);
            transaction.commit();
            System.out.println("Payment deleted");

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            if(entityManager != null){
                entityManager.close();
            }
        }

    }
}

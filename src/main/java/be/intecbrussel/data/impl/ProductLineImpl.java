package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.ProductLineDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.ProductLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProductLineImpl implements ProductLineDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
    @Override
    public void createProductLine(ProductLine productLine) {
        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(productLine);
            transaction.commit();
            System.out.println("Product line created!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public ProductLine readProductLine(String productLineName) {

        EntityManager entityManager = null;
        ProductLine productLine = null;
        try{
            entityManager = emf.createEntityManager();

            productLine = entityManager.find(ProductLine.class, productLineName);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return productLine;
    }

    @Override
    public void updateProductLine(ProductLine productLine) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.merge(productLine);
            transaction.commit();
            System.out.println("Product line updated!");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteProductLine(ProductLine productLine) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            productLine = entityManager.find(ProductLine.class, productLine.getProductLine());
            transaction.begin();
            entityManager.remove(productLine);
            transaction.commit();
            System.out.println("Product line deleted!");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

}

package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.ProductDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProductDaoImpl implements ProductDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createProduct(Product product) {
        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            System.out.println("Product created!");


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public Product readProduct(String productCode) {

        EntityManager entityManager = null;
        Product product = null;

        try{
            entityManager = emf.createEntityManager();

            product = entityManager.find(Product.class, productCode);


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {

        EntityManager entityManager = null;

        try{

            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
            System.out.println("Product Updated!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteProduct(Product product) {

        EntityManager entityManager = null;

        try{

            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            product = entityManager.find(Product.class, product.getProductCode());
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
            System.out.println("Product Deleted!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}

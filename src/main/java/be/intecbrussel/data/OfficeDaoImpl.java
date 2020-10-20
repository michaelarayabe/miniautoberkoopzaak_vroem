package be.intecbrussel.data;

import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class OfficeDaoImpl implements OfficeDao{

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOffice(Office office) {

        EntityManager entityManager = null;

        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            entityManager.find(Office.class, office.getOfficeCode());

            transaction.begin();

            entityManager.persist(office);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public Office readOffice(String officeCode) {
        EntityManager entityManager = null;
        Office office = null;

        try {

            entityManager = emf.createEntityManager();

            office = new Office();
            office.setOfficeCode(officeCode);
            String id = office.getOfficeCode();
            office = entityManager.find(Office.class, id);


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return office;
    }

    @Override
    public void updateOffice(Office office) {

        EntityManager entityManager = emf.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();

            office.setOfficeCode(office.getOfficeCode());

            transaction.begin();
            entityManager.merge(office);
            transaction.commit();
            System.out.println("Updated!!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public void deleteOffice(Office office) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            Office office1 = entityManager.find(Office.class, office.getOfficeCode());
            transaction.begin();
            entityManager.remove(office1);
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

package be.intecbrussel.data.impl;

import be.intecbrussel.data.dao.EmployeeDao;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Employee;

import javax.persistence.*;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createEmployee(Employee employee) {

        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityManager.find(Employee.class,employee.getEmployeeNumber());

            entityTransaction.begin();

            entityManager.persist(employee);

            entityTransaction.commit();
            System.out.println("Employee Created!");
        }catch(Exception e){
            e.printStackTrace();

        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public Employee readEmployee(int employeeNumber) {

        EntityManager entityManager = null;
        Employee employee = null;
        try{
            entityManager = emf.createEntityManager();

            employee = entityManager.find(Employee.class,employeeNumber);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();

            EntityTransaction entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            entityManager.merge(employee);

            entityTransaction.commit();
            System.out.println("updated");



        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }

    @Override
    public void deleteEmployee(Employee employee) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            Employee employee1 = entityManager.find(Employee.class,employee.getEmployeeNumber());
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(employee1);
            transaction.commit();
            System.out.println("Employee is deleted");


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public void listAllEmployees() {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery("select employee from Employee employee", Employee.class);

            for (Employee e : query.getResultList()) {
                System.out.println(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }

    }

    @Override
    public List<Employee> listEmployeesByExtension(String extension) {
        EntityManager entityManager = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            entityManager = emf.createEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery("select employee from Employee employee", Employee.class);


            for (Employee e : query.getResultList()) {
                if (e.getExtension().equalsIgnoreCase(extension)) {
                    employeeList.add(e);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }

        return employeeList;
    }

    @Override
    public void listEmployeesByJobTitle(String jobtitle) {

        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery("select employee from Employee employee", Employee.class);

            List<Employee> employeeList = new ArrayList<>();

            for (Employee employee : query.getResultList()) {
                if (employee.getJobTitle().equalsIgnoreCase(jobtitle)) {

                    employeeList.add(employee);

                }
            }

            //formatting
            for (Employee e : employeeList) {
                System.out.println(e + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }



    }
}

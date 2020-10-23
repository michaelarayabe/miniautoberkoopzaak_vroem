package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.CustomerDao;
import be.intecbrussel.data.dao.PaymentDao;
import be.intecbrussel.data.impl.CustomerDaoImpl;
import be.intecbrussel.data.impl.PaymentDaoImpl;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentApp {

    public static void main(String[] args) {
        PaymentDao paymentDao = new PaymentDaoImpl();


        //#################### Creating payment ###################################
/*
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.readCustomers(103);
        BigDecimal bigD = new BigDecimal("2222");
        LocalDate paymentDate = LocalDate.of(1989,10,11);


        Payment payment = new Payment();
        payment.setCheckNumber("KMN1234");
        payment.setAmount(bigD);
        payment.setPaymentDate(paymentDate);
        payment.setCustomer(customer);

        paymentDao.createPayment(payment); //--------------WORKS

 */



        //#################### Reading payment ###################################

        //System.out.println(paymentDao.readPayment("HQ336336"));

        /*
        //#################### Updating payment ###################################

        Payment paymentToUpdate = paymentDao.readPayment("HJ618252");
        paymentToUpdate.setAmount(new BigDecimal("11111"));
        paymentToUpdate.setPaymentDate(LocalDate.of(2020,2,2));

        paymentDao.updatePayment(paymentToUpdate);//--------------WORKS

         */

        //#################### Deleting payment ###################################

        Payment paymentToDelete = paymentDao.readPayment("KMN1234");
        paymentDao.deletePayment(paymentToDelete);




    }
}

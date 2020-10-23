package be.intecbrussel.data.dao;

import be.intecbrussel.entities.Payment;

public interface PaymentDao {

    void createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
}

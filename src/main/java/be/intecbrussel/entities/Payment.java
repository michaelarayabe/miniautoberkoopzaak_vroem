package be.intecbrussel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private int customerNumber;
    private String checkNumber;
    private LocalDateTime paymentDate;
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(int customerNumber, String checkNumber, LocalDateTime paymentDate, BigDecimal amount) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return customerNumber == payment.customerNumber &&
                Objects.equals(checkNumber, payment.checkNumber) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber, paymentDate, amount);
    }
}

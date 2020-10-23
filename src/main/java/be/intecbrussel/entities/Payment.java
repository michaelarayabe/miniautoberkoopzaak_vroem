package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "classicmodels")
public class Payment {

    private String checkNumber;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private Customer customer;

    public Payment() {
    }

    public Payment(String checkNumber, LocalDate paymentDate, BigDecimal amount) {
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }



    @Id
    @Column(name = "checkNumber", nullable = false, length = 50)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Basic
    @Column(name = "paymentDate", nullable = false)
    public LocalDate getPaymentDate() {
        return paymentDate;
    }


    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
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
        return
                Objects.equals(checkNumber, payment.checkNumber) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash( checkNumber, paymentDate, amount);
    }

    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

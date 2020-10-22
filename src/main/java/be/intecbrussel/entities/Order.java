package be.intecbrussel.entities;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "classicmodels")
public class Order {


    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String status;
    private String comments;

    private Collection<Orderdetail> orderdetails;
    private Customer customer;

    public Order() {
    }

    public Order(int orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, String status, String comments, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customer = customer;
    }

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "orderDate", nullable = false)
    public LocalDate getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "requiredDate", nullable = false)
    public LocalDate getRequiredDate() {
        return requiredDate;
    }


    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Basic
    @Column(name = "shippedDate", nullable = true)
    public LocalDate getShippedDate() {
        return shippedDate;
    }


    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 15)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(requiredDate, order.requiredDate) &&
                Objects.equals(shippedDate, order.shippedDate) &&
                Objects.equals(status, order.status) &&
                Objects.equals(comments, order.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, requiredDate, shippedDate, status, comments);
    }

    @OneToMany(mappedBy = "order")
    public Collection<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(Collection<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
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

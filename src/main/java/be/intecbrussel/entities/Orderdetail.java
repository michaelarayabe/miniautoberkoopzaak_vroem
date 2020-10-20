package be.intecbrussel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
public class Orderdetail {

    @Id
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;

    public Orderdetail() {
    }

    public Orderdetail(int orderNumber, String productCode, int quantityOrdered, BigDecimal priceEach, short orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderdetail that = (Orderdetail) o;
        return orderNumber == that.orderNumber &&
                quantityOrdered == that.quantityOrdered &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }
}

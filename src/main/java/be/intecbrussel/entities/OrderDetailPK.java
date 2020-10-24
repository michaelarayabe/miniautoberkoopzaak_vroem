package be.intecbrussel.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable {

    private String productCode;
    private int orderNumber;

    public OrderDetailPK() {
    }

    public OrderDetailPK(String productCode, int orderNumber) {
        this.productCode = productCode;
        this.orderNumber = orderNumber;
    }
    @Column(name = "productCode", nullable = false)
    @Id
    public String getProduct() {
        return productCode;
    }

    public void setProduct(String ourProduct) {
        this.productCode = ourProduct;
    }

    @Column(name = "orderNumber", nullable = false)
    @Id
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int order) {
        this.orderNumber = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return orderNumber == that.orderNumber &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, orderNumber);
    }
}

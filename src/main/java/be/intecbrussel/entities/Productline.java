package be.intecbrussel.entities;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "productlines", schema = "classicmodels")
public class Productline {

    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;
    private Collection<Product> productsByProductLine;

    public Productline() {
    }

    public Productline(String productLine, String textDescription, String htmlDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
    }

    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Basic
    @Column(name = "textDescription", length = 4000)
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Basic
    @Column(name = "htmlDescription", length = -1)
    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    @Override
    public String toString() {
        return "Productline{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productline that = (Productline) o;
        return Objects.equals(productLine, that.productLine) &&
                Objects.equals(textDescription, that.textDescription) &&
                Objects.equals(htmlDescription, that.htmlDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLine, textDescription, htmlDescription);
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "productline")
    public Collection<Product> getProductsByProductLine() {
        return productsByProductLine;
    }

    public void setProductsByProductLine(Collection<Product> productsByProductLine) {
        this.productsByProductLine = productsByProductLine;
    }
}

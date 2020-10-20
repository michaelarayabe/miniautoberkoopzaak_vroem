package be.intecbrussel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;
import java.util.Objects;

@Entity
@Table
public class Productline {

    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;

    public Productline() {
    }

    public Productline(String productLine, String textDescription, String htmlDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

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
}

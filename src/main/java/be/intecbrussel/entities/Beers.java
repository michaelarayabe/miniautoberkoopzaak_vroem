package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Beers {
    private int id;
    private String name;
    private Double price;
    private Integer stock;
    private Double alcohol;
    private Integer version;
    private byte[] image;
    private Brewers brewersByBrewerId;
    private Category categoriesByCategoryId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "Alcohol", nullable = true, precision = 0)
    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    @Basic
    @Column(name = "Version", nullable = true)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "Image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beers beers = (Beers) o;
        return id == beers.id &&
                Objects.equals(name, beers.name) &&
                Objects.equals(price, beers.price) &&
                Objects.equals(stock, beers.stock) &&
                Objects.equals(alcohol, beers.alcohol) &&
                Objects.equals(version, beers.version) &&
                Arrays.equals(image, beers.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, price, stock, alcohol, version);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BrewerId", referencedColumnName = "Id")
    public Brewers getBrewersByBrewerId() {
        return brewersByBrewerId;
    }

    public void setBrewersByBrewerId(Brewers brewersByBrewerId) {
        this.brewersByBrewerId = brewersByBrewerId;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    public Category getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Category categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}

package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Categories", schema = "BeersDB", catalog = "")
public class Category {
    private int id;
    private String category;
    private Collection<Beers> beersById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Category", nullable = true, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return id == category1.id &&
                Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<Beers> getBeersById() {
        return beersById;
    }

    public void setBeersById(Collection<Beers> beersById) {
        this.beersById = beersById;
    }
}

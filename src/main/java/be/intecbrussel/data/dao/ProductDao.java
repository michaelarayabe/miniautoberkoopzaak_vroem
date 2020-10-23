package be.intecbrussel.data.dao;

import be.intecbrussel.entities.Product;

public interface ProductDao {

    void createProduct(Product product);
    Product readProduct(String productCode);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}

package be.intecbrussel.data.dao;

import be.intecbrussel.entities.ProductLine;

public interface ProductLineDao {

    void createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLineName);
    void updateProductLine(ProductLine productLine);
    void deleteProductLine(ProductLine productLine);
}

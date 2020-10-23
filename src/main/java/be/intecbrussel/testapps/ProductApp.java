package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.ProductDao;
import be.intecbrussel.data.impl.ProductDaoImpl;
import be.intecbrussel.entities.Product;
import be.intecbrussel.entities.ProductLine;

import java.math.BigDecimal;

public class ProductApp {

    public static void main(String[] args) {

        ProductDao productDao = new ProductDaoImpl();


        //#################### Creating new Product ###################################

        ProductLine productLine = new ProductLine();
        productLine.setProductLine("Motorcycles");



        Product product = new Product();
        product.setProductCode("S11_1111");
        product.setProductName("Mobile");
        product.setBuyPrice(new BigDecimal("199.99"));
        product.setProductScale("1:100");
        product.setProductVendor("MikaMicco");
        product.setProductDescription("This product is a fantacy product, not real one");
        product.setQuantityInStock((short)2212);
        product.setMsrp(new BigDecimal(121));
        product.setProductline(productLine);

        productDao.createProduct(product); // ------ WORKS



        //#################### Reading Product ###################################

        System.out.println(productDao.readProduct("S10_1678"));




        //#################### Updating Product ###################################

        Product productToUpdate = productDao.readProduct("S10_1678");
        productToUpdate.setProductName("Ducaki");
        productDao.updateProduct(productToUpdate); //----- WORKS



        //#################### Deleting Product ###################################

        Product productToDelete = productDao.readProduct("S11_1111");
        productDao.deleteProduct(productToDelete);


    }
}

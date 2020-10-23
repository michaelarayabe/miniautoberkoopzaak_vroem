package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.ProductLineDao;
import be.intecbrussel.data.impl.ProductLineImpl;
import be.intecbrussel.entities.ProductLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProductLineApp {
    public static void main(String[] args) {
        ProductLineDao productLineDao = new ProductLineImpl();


        //#################### Creating new Product Line ###################################



        ProductLine productLine = new ProductLine();

        File file = new File("car.jpeg");
        byte[] imageContent = null;
        try {
            imageContent = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        productLine.setProductLine("Anon Category");
        productLine.setTextDescription("An interesting product line");
        productLine.setHtmlDescription("Here is an HTML description");
        productLine.setImage(imageContent);
        productLineDao.createProductLine(productLine);


        //#################### Reading product line ###################################


        //System.out.println(productLineDao.readProductLine("Anon Category")); //---WORKS


        //#################### Updating product line ###################################

        ProductLine productLineToUpdate = productLineDao.readProductLine("Anon Category");
        productLineToUpdate.setTextDescription("Changed it cause we can!");
        productLineDao.updateProductLine(productLineToUpdate);




        //#################### Updating product line ###################################

        ProductLine productLineToDelete = productLineDao.readProductLine("Anon Category");
        productLineDao.deleteProductLine(productLineToDelete);


    }
}

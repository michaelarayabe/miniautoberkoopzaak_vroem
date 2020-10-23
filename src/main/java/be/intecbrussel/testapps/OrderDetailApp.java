package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.OrderDetailDao;
import be.intecbrussel.data.impl.OrderDetailImpl;
import be.intecbrussel.entities.OrderDetailPK;
import be.intecbrussel.entities.Product;

public class OrderDetailApp {

    public static void main(String[] args) {

        OrderDetailPK orderDetailPK = new OrderDetailPK();
        Product product = new Product();
        product.setProductCode("acode");
        orderDetailPK.setProduct(product);

        OrderDetailDao orderDetailDao = new OrderDetailImpl();
        orderDetailDao.createOrderDetail(orderDetailPK);
    }
}

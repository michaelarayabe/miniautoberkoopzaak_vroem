package be.intecbrussel.testapps;

import be.intecbrussel.data.dao.OrderDao;
import be.intecbrussel.data.dao.OrderDetailDao;
import be.intecbrussel.data.dao.ProductDao;
import be.intecbrussel.data.impl.OrderDaoImpl;
import be.intecbrussel.data.impl.OrderDetailImpl;
import be.intecbrussel.data.impl.ProductDaoImpl;
import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;
import be.intecbrussel.entities.Product;

import java.math.BigDecimal;

public class OrderDetailApp {

    public static void main(String[] args) {

        OrderDetailDao orderDetailDao = new OrderDetailImpl();
        ProductDao productDao = new ProductDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        OrderDetailPK orderDetailPK = new OrderDetailPK("S10_1678", 10100);
        System.out.println(orderDetailDao.readOrderDetail(orderDetailPK));

    }
}

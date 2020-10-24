package be.intecbrussel.data.dao;


import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;

public interface OrderDetailDao {

    void createOrderDetail(OrderDetail orderdetail);
    OrderDetail readOrderDetail(OrderDetailPK orderDetailPK);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetail orderDetail);

}

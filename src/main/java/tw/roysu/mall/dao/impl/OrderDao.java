package tw.roysu.mall.dao.impl;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IOrderDao;
import tw.roysu.mall.entity.Order;

@Repository
public class OrderDao extends BaseDao<Order>implements IOrderDao {
    
    public OrderDao() {
        super(Order.class);
    }

}

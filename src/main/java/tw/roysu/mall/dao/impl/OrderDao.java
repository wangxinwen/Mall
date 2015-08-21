package tw.roysu.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IOrderDao;
import tw.roysu.mall.entity.Order;

@Repository
public class OrderDao extends BaseDao<Order>implements IOrderDao {
    
    public OrderDao() {
        super(Order.class);
    }

    @Override
    public List<Order> findListByUserId(int userId) {
        return super.findListBy("userId", userId);
    }

}

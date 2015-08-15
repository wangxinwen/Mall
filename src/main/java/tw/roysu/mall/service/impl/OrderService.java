package tw.roysu.mall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import tw.roysu.mall.dao.IOrderDao;
import tw.roysu.mall.entity.Order;
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.service.IBuyRecordService;
import tw.roysu.mall.service.ICartService;
import tw.roysu.mall.service.IOrderService;

@Service
public class OrderService extends BaseService implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    @Autowired
    private IOrderDao orderDao;
    
    @Autowired
    private ICartService cartService;
    
    @Autowired
    private IBuyRecordService buyRecordService;

    @Override
    public void createOrder(Order order) {
        int userId = order.getUserId();
        
        TransactionStatus status = super.getTransactionStatus();
        try {
            // 儲存訂單
            int orderId = orderDao.save(order);
            // 儲存購買記錄
            List<Product> productList = cartService.getUserCart(userId);
            buyRecordService.saveByOrder(userId, orderId, productList);
            // 清空購物車
            cartService.clearCart(userId);
            super.getTransactionManager().commit(status);
        } catch (Exception e) {
            logger.error("userId = " + userId + ", create order have exception.");
            e.printStackTrace();
            super.getTransactionManager().rollback(status);
            throw e;
        }
    }

}

package tw.roysu.mall.service;

import java.util.List;

import tw.roysu.mall.entity.Order;

/**
 * 訂單Service
 */
public interface IOrderService {
    
    /**
     * 建立訂單
     * 
     * @param order
     *        {@link Order}
     */
    public void createOrder(Order order);
    
    /**
     * 取得會員訂單列表
     * 
     * @param userId
     *        會員編號
     */
    public List<Order> getOrderList(int userId);
    
    /**
     * 取消訂單
     * 
     * @param orderId
     *        訂單編號
     */
    public void cancelOrder(int orderId);

}

package tw.roysu.mall.service;

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

}

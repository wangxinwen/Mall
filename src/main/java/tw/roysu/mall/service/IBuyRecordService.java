package tw.roysu.mall.service;

import java.util.List;

import tw.roysu.mall.entity.Product;

/**
 * 購買記錄Service
 */
public interface IBuyRecordService {
    
    /**
     * 儲存訂單購買商品記錄
     * 
     * @param userId
     *        會員編號
     * @param orderId
     *        訂單編號
     * @param productList
     *        購買商品
     */
    public void saveByOrder(int userId, int orderId, List<Product> productList);

}

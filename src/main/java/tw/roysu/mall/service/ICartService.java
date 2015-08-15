package tw.roysu.mall.service;

import java.util.List;

import tw.roysu.mall.entity.Cart;
import tw.roysu.mall.entity.Product;

/**
 * 購物車Service
 */
public interface ICartService {
    
    /**
     * 取得會員的購物車內容
     * 
     * @param userId
     *        會員編號
     * @return {@link List}<{@link Cart}>
     */
    public List<Product> getUserCart(int userId);
    
    /**
     * 新增商品至購物車
     * 
     * @param userId
     *        會員編號
     * @param productId
     *        商品編號
     */
    public void addProduct(int userId, int productId);
    
    /**
     * 清空購物車
     * 
     * @param userId
     *        會員編號
     */
    public void clearCart(int userId);

}

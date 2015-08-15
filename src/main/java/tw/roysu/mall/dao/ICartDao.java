package tw.roysu.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.entity.Cart;

/**
 * 購物車Dao
 */
@Repository
public interface ICartDao extends IBaseDao<Cart> {
    
    /**
     * 根據會員編號查詢購物車內容
     * 
     * @param userId
     *        會員編號
     * @return {@link List}<{@link Cart}>
     */
    public List<Cart> findByUserId(int userId);
    
    /**
     * 刪除該會員購物車下所有商品
     * 
     * @param userId
     *        會員編號
     */
    public void removeByUserId(int userId);

}

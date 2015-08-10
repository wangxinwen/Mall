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

}

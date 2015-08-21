package tw.roysu.mall.dao;

import java.util.List;

import tw.roysu.mall.entity.Order;

/**
 * 訂單Dao
 */
public interface IOrderDao extends IBaseDao<Order> {
    
    /**
     * 根據會員編號查詢訂單列表
     * 
     * @param userId
     *        會員編號
     * @return {@link List}<{@link Order}>
     */
    public List<Order> findListByUserId(int userId);

}

package tw.roysu.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.entity.Category;

/**
 * 商品類別Dao
 */
@Repository
public interface ICategoryDao extends IBaseDao<Category> {
    
    /**
     * 搜尋所有父類別(parentId = 0)
     * 
     * @return {@link List}<{@link Category}>
     */
    public List<Category> findByParentIdEqZero();
    
    /**
     * 搜尋所有類別, 根據父類別排序
     * 
     * @return {@link List}<{@link Category}>
     */
    public List<Category> findListByOrderByParentId();

    /**
     * 根據父類別編號查詢子類別
     */
    public List<Category> findListByParentId(int id);

}

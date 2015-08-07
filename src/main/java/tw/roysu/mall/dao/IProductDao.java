package tw.roysu.mall.dao;

import java.util.List;

import tw.roysu.mall.entity.Product;

/**
 * 商品Dao
 */
public interface IProductDao extends IBaseDao<Product> {
    
    /**
     * 查詢商品列表
     * 
     * @param begin
     *        開始筆數
     * @param size
     *        資料筆數
     * @return {@link List}<{@link Product}>
     */
    public List<Product> findList(int begin, int size);

}

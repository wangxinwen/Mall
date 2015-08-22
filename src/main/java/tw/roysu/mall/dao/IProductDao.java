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
    
    /**
     * 根據商品類別編號查詢商品列表
     * 
     * @param categoryId
     *        商品類別編號
     * @param begin
     *        開始筆數
     * @param size
     *        資料筆數
     * @return {@link List}<{@link Product}>
     */
    public List<Product> findListByCategoryId(int categoryId, int begin, int size);
    
    /**
     * 計算所屬類別商品數量
     * 
     * @param categoryId
     *        商品類別編號
     * @return 所屬類別商品數量
     */
    public int countByCategory(int categoryId);
    
    /**
     * 根據商品編號列表查詢商品
     * 
     * @param productIdList
     *        商品編號列表
     * @return {@link List}<{@link Product}>
     */
    public List<Product> findListByProductIdList(List<Integer> productIdList);

}

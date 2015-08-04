package tw.roysu.mall.service;

import tw.roysu.mall.entity.Category;

/**
 * 商品類別Service
 */
public interface ICategoryService {
    
    /**
     * 新增商品類別
     * 
     * @param category
     *        {@link Category}
     */
    public void create(Category category);

}

package tw.roysu.mall.service;

import java.util.List;

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
    
    /**
     * 取得所有父類別
     * 
     * @return {@link List}<{@link Category}>
     */
    public List<Category> getAllParentCategory();

}

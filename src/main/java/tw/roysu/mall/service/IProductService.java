package tw.roysu.mall.service;

import tw.roysu.mall.entity.Product;

/**
 * 商品Service
 */
public interface IProductService {
    
    /**
     * 新增商品
     * 
     * @param product
     *        {@link Product}
     */
    public void create(Product product);

}

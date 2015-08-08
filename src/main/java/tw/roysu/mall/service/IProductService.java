package tw.roysu.mall.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
    
    /**
     * 取得商品列表
     * 
     * @param page
     *        頁數
     * @return {@link List}<{@link Product}>
     */
    public List<Product> getProductList(int page);

    /**
     * 新增商品圖片
     * 
     * @param productId
     *        商品編號
     * @param image
     *        商品圖片
     */
    public void addProductImg(int productId, MultipartFile img);

}

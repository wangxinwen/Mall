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
    
    /**
     * 根據選擇的商品類別取得商品列表
     * 
     * @param categoryId
     *        商品類別編號
     * @param page
     *        頁數
     * @return {@link List}<{@link Product}>
     */
    public List<Product> getListByCategory(int categoryId, int page);
    
    /**
     * 取得商品明細
     * 
     * @param id
     *        商品編號
     * @return {@link Product}
     */
    public Product getProduct(int id);
    
    /**
     * 根據訂單編號取得商品列表
     * 
     * @param orderId
     *        訂單編號
     * @return {@link List}<{@link Product}>
     */
    public List<Product> getListByOrder(int orderId);
    
    /**
     * 取得有圖片的商品
     * 
     * @param size
     *        數量
     * @return {@link List}<{@link Product}>
     */
    public List<Product> getListByHotAndImg(int size);

}

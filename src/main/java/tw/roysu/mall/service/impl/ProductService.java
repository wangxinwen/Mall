package tw.roysu.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.constant.AppConstant;
import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.service.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void create(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getProductList(int page) {
        return productDao.findList(getBegin(page), AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE);
    }

    /**
     * 計算後台商品列表查詢開始筆數
     * 
     * @param page
     *        現在頁數
     * @return 查詢開始值
     */
    private int getBegin(int page) {
        return (page - 1) * AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE;
    }

}

package tw.roysu.mall.dao.impl;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.entity.Product;

@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {
    
    public ProductDao() {
        super(Product.class);
    }

}

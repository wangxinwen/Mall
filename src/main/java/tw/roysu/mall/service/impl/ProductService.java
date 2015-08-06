package tw.roysu.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

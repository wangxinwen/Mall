package tw.roysu.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.dao.ICartDao;
import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.entity.Cart;
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.service.ICartService;

@Service
public class CartService extends BaseService implements ICartService {
    
    @Autowired
    private ICartDao cartDao;
    
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> getUserCart(int userId) {
        List<Product> productList = new ArrayList<>();
        List<Cart> cartList = cartDao.findByUserId(userId);
        for (Cart cart : cartList) {
            Product product = productDao.findById(cart.getProductId());
            productList.add(product);
        }
        return productList;
    }

    @Override
    public void addProduct(int userId, int productId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cartDao.save(cart);
    }

}

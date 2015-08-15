package tw.roysu.mall.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.ICartDao;
import tw.roysu.mall.entity.Cart;

@Repository
public class CartDao extends BaseDao<Cart> implements ICartDao {
    
    public CartDao() {
        super(Cart.class);
    }

    @Override
    public List<Cart> findByUserId(int userId) {
        return super.findListBy("userId", userId);
    }

    @Override
    public void removeByUserId(int userId) {
        String hql = "DELETE FROM Cart WHERE userId = :userId";
        
        Query query = super.getSession().createQuery(hql);
        query.setInteger("userId", userId);
        query.executeUpdate();
    }

}

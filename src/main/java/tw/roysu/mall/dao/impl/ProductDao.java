package tw.roysu.mall.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.entity.Product;

@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {
    
    public ProductDao() {
        super(Product.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> findList(int begin, int size) {
        Criteria criteria = super.getSession().createCriteria(Product.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(begin);
        criteria.setMaxResults(size);
        return criteria.list();
    }

}

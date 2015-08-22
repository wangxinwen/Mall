package tw.roysu.mall.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> findListByCategoryId(int categoryId, int begin, int size) {
        Criteria criteria = super.getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("categoryId", categoryId));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(begin);
        criteria.setMaxResults(size);
        return criteria.list();
    }

    @Override
    public int countByCategory(int categoryId) {
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());

        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("categoryId", categoryId));
        criteria.setProjection(projectionList);
        Long count = (Long) criteria.list().get(0);
        return Integer.valueOf(count.toString());
    }

    @Override
    public List<Product> findListByProductIdList(List<Integer> productIdList) {
        return super.findListBy("id", productIdList);
    }

}

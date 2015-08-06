package tw.roysu.mall.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.ICategoryDao;
import tw.roysu.mall.entity.Category;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {
    
    public CategoryDao() {
        super(Category.class);
    }

    @Override
    public List<Category> findByParentIdEqZero() {
        return super.findListBy("parentId", 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findListByOrderByParentId() {
        Criteria criteria = getSession().createCriteria(Category.class);
        criteria.addOrder(Order.asc("parentId"));
        return criteria.list();
    }

}

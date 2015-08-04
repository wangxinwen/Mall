package tw.roysu.mall.dao.impl;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.ICategoryDao;
import tw.roysu.mall.entity.Category;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {
    
    public CategoryDao() {
        super(Category.class);
    }

}

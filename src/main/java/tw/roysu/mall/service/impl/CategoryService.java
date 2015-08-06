package tw.roysu.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.dao.ICategoryDao;
import tw.roysu.mall.entity.Category;
import tw.roysu.mall.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public void create(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> getAllParentCategory() {
        return categoryDao.findByParentIdEqZero();
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.findListByOrderByParentId();
    }

    @Override
    public List<Category> getChildCategoryList(int id) {
        return categoryDao.findListByParentId(id);
    }

}

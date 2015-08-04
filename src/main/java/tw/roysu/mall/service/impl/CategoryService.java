package tw.roysu.mall.service.impl;

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

}

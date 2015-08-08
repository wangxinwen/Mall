package tw.roysu.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<Category, List<Category>> getSidebar() {
        Map<Category, List<Category>> result = new LinkedHashMap<>();
        
        Map<Integer, List<Category>> sortCategoryMap = getSortCategoryMap();
        // 避免沒有商品類別時發生NullPointerException
        if (sortCategoryMap.isEmpty()) {
            return result;
        }
        // 跑所有父類別迴圈, 將父類別放進Map的key, 父類別下所屬子類別放進value
        for (Category category : sortCategoryMap.get(0)) {
            result.put(category, sortCategoryMap.get(category.getId()));
        }
        return result;
    }

    /**
     * 取得分類後的商品類別Map(key為父類別編號, value為屬於該父類別下的子類別List)
     */
    private Map<Integer, List<Category>> getSortCategoryMap() {
        Map<Integer, List<Category>> result = new HashMap<>();
        
        List<Category> categoryList = categoryDao.findAll();
        for(Category category : categoryList) {
            // 取得父類別編號
            int parent = category.getParentId();
            // 根據父類別編號取得類別List, 若沒有新增一個
            List<Category> childCategoryList = result.containsKey(parent) ? 
                                               result.get(parent) : new ArrayList<>();
            // 將類別放入類別List
            childCategoryList.add(category);
            // 放入Map, key為父類別編號, value為類別List
            result.put(parent, childCategoryList);
        }
        return result;
    }

}

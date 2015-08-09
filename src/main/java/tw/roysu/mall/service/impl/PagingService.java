package tw.roysu.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.bean.PagingBean;
import tw.roysu.mall.constant.AppConstant;
import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.service.IPagingService;

@Service
public class PagingService implements IPagingService {
    
    @Autowired
    private IProductDao productDao;

    @Override
    public PagingBean getAdminProductListBean(int page) {
        int total = productDao.count();
        return new PagingBean(page, getPageTotal(total, AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE));
    }
    
    /**
     * 根據商品數量計算總頁數<br><br>
     * 
     * 公式 = (商品總數量 + 每頁商品數量 - 1) / 每頁商品數量
     * 
     * @param total
     *        商品總數量
     * @param pageSize
     *        每頁數量
     * @return pageTotal
     */
    private int getPageTotal(int total, int pageSize) {
        return (total + pageSize - 1) / pageSize;
    }

    @Override
    public PagingBean getCategoryProductListBean(int categoryId, int page) {
        int total = productDao.countByCategory(categoryId);
        return new PagingBean(page, getPageTotal(total, AppConstant.CATEGORY_PRODUCT_LIST_PAGE_SIZE));
    }

}

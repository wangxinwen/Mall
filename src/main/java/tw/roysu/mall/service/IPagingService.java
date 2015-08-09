package tw.roysu.mall.service;

import tw.roysu.mall.bean.PagingBean;

/**
 * 分頁Service
 *
 */
public interface IPagingService {
    
    /**
     * 取得後台商品列表分頁資料
     * 
     * @param page
     *        頁數
     * @return {@link PagingBean}
     */
    public PagingBean getAdminProductListBean(int page);
    
    /**
     * 取得所選類別商品列表分頁資料
     * 
     * @param categoryId
     *        選擇類別
     * @param page
     *        頁數
     * @return {@link PagingBean}
     */
    public PagingBean getCategoryProductListBean(int categoryId, int page);

}

package tw.roysu.mall.bean;

/**
 * 顯示用分頁Bean
 */
public class PagingBean {

    /**
     * 於建構子初始化
     */
    public PagingBean(int page, int pageTotal) {
        this.page = page;
        this.pageTotal = pageTotal;
        this.hasPrev = this.page > 1;
        this.hasNext = this.page < this.pageTotal;
    }

    /**
     * 現在頁數
     */
    private final int page;

    /**
     * 總頁數
     */
    private final int pageTotal;

    /**
     * 有上一頁
     */
    private final boolean hasPrev;

    /**
     * 有下一頁
     */
    private final boolean hasNext;

    public int getPage() {
        return page;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    /**
     * 有上一頁
     */
    public boolean isHasPrev() {
        return hasPrev;
    }

    /**
     * 有下一頁
     */
    public boolean isHasNext() {
        return hasNext;
    }

}

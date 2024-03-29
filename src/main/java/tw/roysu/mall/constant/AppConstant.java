package tw.roysu.mall.constant;

/**
 * 應用程式使用常數
 */
public class AppConstant {

    /**
     * 網站根目錄(需依個人電腦設定)
     */
    public static final String ROOT_PATH = "/Users/roysu/Workspace/RoySu1215/Mall/";

    /**
     * 網站靜態資源目錄
     */
    public static final String STATIC_PATH = ROOT_PATH + "src/main/webapp/resources/";

    /**
     * 網站圖片目錄
     */
    public static final String IMG_PATH = STATIC_PATH + "img/";

    /**
     * 網站商品圖片目錄
     */
    public static final String IMG_PRODUCT_PATH = IMG_PATH + "product/";

    /**
     * 網域名稱(需依個人需求設定)
     */
    public static final String DOMAIN = "http://localhost:8080/";

    /**
     * 圖片URL
     */
    public static final String IMG_URL = "/resources/img/";

    /**
     * 商品圖片URL
     */
    public static final String IMG_PRODUCT_URL = IMG_URL + "product/";

    /**
     * 商品無圖片預設圖URL
     */
    public static final String IMG_PRODUCT_NO_IMG_URL = IMG_PRODUCT_URL + "no_image.png";

    /**
     * 後台商品列表每頁顯示筆數
     */
    public static final int ADMIN_PRODUCT_LIST_PAGE_SIZE = 10;

    /**
     * 類別商品列表每頁顯示筆數
     */
    public static final int CATEGORY_PRODUCT_LIST_PAGE_SIZE = 10;
    
    /**
     * 付款方式：銀行匯款
     */
    public static final int PAYMENT_METHOD_BANK = 1;
    
    /**
     * 付款方式：信用卡
     */
    public static final int PAYMENT_METHOD_CARD = 2;
    
    /**
     * 付款方式：貨到付款
     */
    public static final int PAYMENT_METHOD_DELIVERY = 3;
    
    /**
     * 訂單狀態：收到訂單
     */
    public static final int ORDER_STATE_GET = 1;
    
    /**
     * 訂單狀態：商品處理中
     */
    public static final int ORDER_STATE_HANDLE = 2;
    
    /**
     * 訂單狀態：商品已寄出
     */
    public static final int ORDER_STATE_SEND = 3;
    
    /**
     * 訂單狀態：訂單取消
     */
    public static final int ORDER_STATE_CANCEL = 4;

}

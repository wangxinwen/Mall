package tw.roysu.mall.constant;

/**
 * 資料檢查例外種類列舉
 */
public enum DataCheckExceptionEnum {

    /**
     * 帳號重覆
     */
    REPEAT_ACCOUNT,

    /**
     * 信箱重覆
     */
    REPEAT_EMAIL,

    /**
     * 暱稱重覆
     */
    REPEAT_NAME,
    
    /**
     * 查無此帳號
     */
    FIND_NOT_ACCOUNT,
    
    /**
     * 密碼錯誤
     */
    PASSWORD_WRONG
}

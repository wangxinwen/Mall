package tw.roysu.mall.exception;

import tw.roysu.mall.constant.DataCheckExceptionEnum;

/**
 * 資料檢查例外
 */
public class DataCheckException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/** 
	 * 例外種類
	 */
	private DataCheckExceptionEnum exceptionType;
	
	/** 
	 * 錯誤訊息
	 */
	private String msg;
	
	/**
	 * 建立時必須同時傳入例外種類
	 */
	public DataCheckException(DataCheckExceptionEnum exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	/**
	 * 取得錯誤訊息
	 */
	public String getMsg() {
		switch (this.exceptionType) {
			case REPEAT_ACCOUNT:
				this.msg = "這帳號被別人註冊囉，請您更換一個帳號。";
				break;
			case REPEAT_EMAIL:
				this.msg = "這信箱被別人使用囉，請您更換一個信箱。";
				break;
			case REPEAT_NAME:
				this.msg = "這暱稱被別人註冊囉，請您更換一個暱稱。";
				break;
			default:
				this.msg = "資料驗證錯誤。";
				break;
		}
		return this.msg;
	}

}

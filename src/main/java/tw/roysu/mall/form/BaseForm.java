package tw.roysu.mall.form;

import java.util.ArrayList;
import java.util.List;

/**
 * 表單基礎建設
 */
public class BaseForm {
	
	/** 
	 * 錯誤訊息
	 */
	private List<String> errMsgList = new ArrayList<>();
	
	/**
	 * 清空錯誤訊息列表
	 */
	public void clearErrMsgList() {
		this.errMsgList.clear();
	}
	
	/**
	 * 新增錯誤訊息
	 * 
	 * @param errMsg
	 *        錯誤訊息
	 */
	public void addErrMsg(String errMsg) {
		this.errMsgList.add(errMsg);
	}
	
	/**
	 * 回傳驗證結果
	 * 
	 * @return 通過回傳true, 不通過回傳false
	 */
	public boolean validateResult() {
		return this.errMsgList.size() == 0;
	}

	/**
	 * 取得錯誤訊息列表
	 * 
	 * @return {@link List}<{@link String}>
	 */
	public List<String> getErrMsgList() {
		return errMsgList;
	}

}

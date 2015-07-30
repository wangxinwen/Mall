package tw.roysu.mall.form;

import org.apache.commons.lang3.StringUtils;

/**
 * 註冊表單<br><br>
 * 
 * 驗證規則如下：<br>
 * 帳號不能為空, 長度要介於6-20<br>
 * 密碼不能為空, 長度要介於6-20<br>
 * 密碼確認不能為空, 兩次輸入密碼必須相同<br>
 * 信箱不能為空, 長度不能大於40<br>
 * 暱稱不能為空, 長度不能大於20
 */
public class RegisterForm extends BaseForm {
	
	/** 
	 * 帳號
	 */
	private String account;

	/** 
	 * 密碼
	 */
	private String password;

	/** 
	 * 密碼確認
	 */
	private String passwordCheck;

	/** 
	 * 信箱
	 */
	private String email;

	/** 
	 * 暱稱
	 */
	private String name;
	
	/**
	 * 驗證表單
	 * 
	 * @return 通過回傳true, 不通過回傳false
	 */
	public boolean validate() {
		super.clearErrMsgList();
		// 檢查帳號
		if (StringUtils.isBlank(this.account)) {
			super.addErrMsg("帳號不能空著哦！");
		} else if (this.account.length() > 20 || this.account.length() < 6) {
			super.addErrMsg("帳號長度要介於6-20哦！");
		}
		// 檢查密碼
		if (StringUtils.isBlank(this.password)) {
			super.addErrMsg("密碼不能空著哦！");
		} else if (this.password.length() > 20 || this.password.length() < 6) {
			super.addErrMsg("密碼長度要介於6-20哦！");
		}
		// 檢查密碼確認
		if (StringUtils.isBlank(this.passwordCheck)) {
			super.addErrMsg("密碼確認不能空著哦！");
		} else if (!this.password.equals(this.passwordCheck)) {
			super.addErrMsg("兩次密碼輸入不一樣哦！");
		}
		// 檢查信箱
		if (StringUtils.isBlank(this.email)) {
			super.addErrMsg("信箱不能空著哦！");
		} else if (this.email.length() > 40) {
			super.addErrMsg("信箱長度不能大於40哦！");
		}
		// 檢查暱稱
		if (StringUtils.isBlank(this.name)) {
			super.addErrMsg("暱稱不能空著哦！");
		} else if (this.name.length() > 20) {
			super.addErrMsg("暱稱長度不能大於20哦！");
		}
		return super.validateResult();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

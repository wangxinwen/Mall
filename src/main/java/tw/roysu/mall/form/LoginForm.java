package tw.roysu.mall.form;

import org.apache.commons.lang3.StringUtils;

/**
 * 登入表單<br><br>
 * 
 * 帳號不能為空, 長度要介於6-20<br>
 * 密碼不能為空, 長度要介於6-20
 */
public class LoginForm extends BaseForm {

    /** 
     * 帳號
     */
    private String account;

    /** 
     * 密碼
     */
    private String password;

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

}

package tw.roysu.mall.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 會員
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 會員編號
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 帳號
     */
    private String account;

    /**
     * 密碼
     */
    private String password;

    /**
     * 信箱
     */
    private String email;

    /**
     * 暱稱
     */
    private String name;
    
    /**
     * 驗證密碼是否正確
     * 
     * @param password
     *        密碼
     * @return 正確回傳true, 錯誤回傳false
     */
    public boolean passwordCorrect(String password) {
        String md5Password = DigestUtils.md5Hex(password);
        return this.password.equals(md5Password);
    }
    
    /**
     * 此會員是否擁有管理者權限<br><br>
     * 
     * 備註：目前設定第1個註冊網站的會員會成為管理者, <br>
     * 日後此部份需要可以再撰寫賦予管理者權限的功能
     * 
     * @return 有回傳true, 沒有回傳false
     */
    public boolean isAdmin() {
        return this.id == 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

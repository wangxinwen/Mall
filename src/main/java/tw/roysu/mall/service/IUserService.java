package tw.roysu.mall.service;

import tw.roysu.mall.entity.User;
import tw.roysu.mall.exception.DataCheckException;

/**
 * 會員Service
 */
public interface IUserService {

    /**
     * 會員註冊<br><br>
     * 
     * 如果帳號、暱稱或信箱已被申請過會拋出例外
     * 
     * @param user
     *        {@link User}
     * @throws DataCheckException
     */
    public void register(User user) throws DataCheckException;
    
    /**
     * 會員登入<br><br>
     * 
     * 如果查無此帳號或密碼錯誤會拋出例外
     * 
     * @param account
     *        帳號
     * @param password
     *        密碼
     * @return {@link User}
     * @throws DataCheckException
     */
    public User login(String account, String password) throws DataCheckException;

}

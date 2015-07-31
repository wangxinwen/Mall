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

}

package tw.roysu.mall.dao;

import tw.roysu.mall.entity.User;

/**
 * 會員Dao
 */
public interface IUserDao extends IBaseDao<User> {

    /**
     * 根據帳號尋找{@link User}
     * 
     * @param account
     *        帳號
     * @return {@link User}
     */
    public User findByAccount(String account);

    /**
     * 根據信箱尋找{@link User}
     * 
     * @param email
     *        信箱
     * @return {@link User}
     */
    public User findByEmail(String email);

    /**
     * 根據暱稱尋找{@link User}
     * 
     * @param name
     *        暱稱
     * @return {@link User}
     */
    public User findByName(String name);

}

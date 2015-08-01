package tw.roysu.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.constant.DataCheckExceptionEnum;
import tw.roysu.mall.dao.IUserDao;
import tw.roysu.mall.entity.User;
import tw.roysu.mall.exception.DataCheckException;
import tw.roysu.mall.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void register(User user) throws DataCheckException {
        // 如果已有相同帳號拋出例外
        if (hasSameAccount(user.getAccount())) {
            throw new DataCheckException(DataCheckExceptionEnum.REPEAT_ACCOUNT);
        }
        // 如果已有相同信箱拋出例外
        if (hasSameEmail(user.getEmail())) {
            throw new DataCheckException(DataCheckExceptionEnum.REPEAT_EMAIL);
        }
        // 如果已有相同暱稱拋出例外
        if (hasSameName(user.getName())) {
            throw new DataCheckException(DataCheckExceptionEnum.REPEAT_NAME);
        }
        userDao.save(user);
    }

    /**
     * 查詢是否已有此帳號<br>
     * <br>
     * 
     * 有通過回傳true, 沒有回傳false
     * 
     * @param account
     *        帳號
     * @return true or false
     */
    private boolean hasSameAccount(String account) {
        return userDao.findByAccount(account) != null;
    }

    /**
     * 查詢是否已有此信箱<br>
     * <br>
     * 
     * 有通過回傳true, 沒有回傳false
     * 
     * @param email
     *        信箱
     * @return true or false
     */
    private boolean hasSameEmail(String email) {
        return userDao.findByEmail(email) != null;
    }

    /**
     * 查詢是否已有此暱稱<br>
     * <br>
     * 
     * 有通過回傳true, 沒有回傳false
     * 
     * @param name
     *        暱稱
     * @return true or false
     */
    private boolean hasSameName(String name) {
        return userDao.findByName(name) != null;
    }

}

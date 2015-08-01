package tw.roysu.mall.utils;

import javax.servlet.http.HttpSession;

import tw.roysu.mall.constant.SessionConstant;
import tw.roysu.mall.entity.User;

/**
 * HttpSession操作工具
 */
public class HttpSessionUtils {
    
    /**
     * 將{@link User}存入{@link HttpSession}中
     * 
     * @param session
     *        {@link HttpSession}
     * @param user
     *        {@link User}
     */
    public static void setUser(HttpSession session, User user) {
        session.setAttribute(SessionConstant.USER, user);
    }

}

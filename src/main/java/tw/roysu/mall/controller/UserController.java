package tw.roysu.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.utils.HttpSessionUtils;

/**
 * 會員Controller
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    /**
     * 登出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        HttpSessionUtils.removeUser(session);
        model.addAttribute("msg", "登出成功");
        return View.SUCCESS;
    }

}

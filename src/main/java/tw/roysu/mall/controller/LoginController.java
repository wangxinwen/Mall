package tw.roysu.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.entity.User;
import tw.roysu.mall.exception.DataCheckException;
import tw.roysu.mall.form.LoginForm;
import tw.roysu.mall.service.IUserService;
import tw.roysu.mall.utils.HttpSessionUtils;

/**
 * 登入Controller
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 登入頁
     */
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("form", new LoginForm());
        return View.LOGIN;
    }

    /**
     * 登入
     */
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(Model model, LoginForm form, HttpSession session) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.LOGIN;
        }
        try {
            User user = userService.login(form.getAccount(), form.getPassword());
            HttpSessionUtils.setUser(session, user);
        } catch (DataCheckException e) {
            form.addErrMsg(e.getMsg());
            model.addAttribute("form", form);
            return View.LOGIN;
        }
        model.addAttribute("msg", "登入成功");
        return View.SUCCESS;
    }
}

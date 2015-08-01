package tw.roysu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.form.LoginForm;

/**
 * 登入Controller
 */
@Controller
public class LoginController {

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
    public String login(Model model, LoginForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.LOGIN;
        }
        // 功能待完成
        return "";
    }
}

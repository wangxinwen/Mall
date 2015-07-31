package tw.roysu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.form.RegisterForm;

/**
 * 註冊Controller
 */
@Controller
public class RegisterController {

    /**
     * 註冊頁
     */
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("form", new RegisterForm());
        return View.REGISTER;
    }

    /**
     * 註冊
     */
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String register(Model model, RegisterForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.REGISTER;
        }
        // 功能待完成
        return "";
    }
}

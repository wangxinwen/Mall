package tw.roysu.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.exception.DataCheckException;
import tw.roysu.mall.form.RegisterForm;
import tw.roysu.mall.service.IUserService;

/**
 * 註冊Controller
 */
@Controller
public class RegisterController {

    @Autowired
    private IUserService userService;

    /**
     * 註冊頁
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("form", new RegisterForm());
        return View.REGISTER;
    }

    /**
     * 註冊
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, RegisterForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.REGISTER;
        }
        try {
            userService.register(form.toUser());
        } catch (DataCheckException e) {
            form.addErrMsg(e.getMsg());
            model.addAttribute("form", form);
            return View.REGISTER;
        }
        model.addAttribute("msg", "註冊成功");
        return View.SUCCESS;
    }
}

package tw.roysu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;

/**
 * 管理後台Controller
 */
@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
    
    /**
     * 登入頁
     */
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String home() {
        return View.ADMIN_HOME;
    }

}

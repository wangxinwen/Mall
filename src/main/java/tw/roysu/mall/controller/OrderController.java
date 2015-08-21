package tw.roysu.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.entity.User;
import tw.roysu.mall.service.IOrderService;
import tw.roysu.mall.utils.HttpSessionUtils;

/**
 * 訂單Controller
 */
@Controller
@RequestMapping(value = "/Order")
public class OrderController {
    
    @Autowired
    private IOrderService orderService;

    /**
     * 訂單管理首頁
     */
    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public String listHomePage(HttpSession session, Model model) {
        return listPage(1, session, model);
    }

    /**
     * 訂單管理頁
     */
    @RequestMapping(value = "/List/{page}", method = RequestMethod.GET)
    public String listPage(@PathVariable("page") int page, 
                           HttpSession session,
                           Model model) {
        User user = HttpSessionUtils.getUser(session);
        model.addAttribute("orderList", orderService.getOrderList(user.getId()));
        return View.ORDER_LIST;
    }

}

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
    
    /**
     * 商品類別 - 列表頁
     */
    @RequestMapping(value = "/ListCategory", method = RequestMethod.GET)
    public String listCategory() {
        return View.ADMIN_CATEGORY_LIST;
    }
    
    /**
     * 商品類別 - 新增父類別頁
     */
    @RequestMapping(value = "/AddParentCategory", method = RequestMethod.GET)
    public String addParentCategory() {
        return View.ADMIN_CATEGORY_ADD_PARENT;
    }
    
    /**
     * 商品類別 - 新增子類別頁
     */
    @RequestMapping(value = "/AddChildCategory", method = RequestMethod.GET)
    public String addChildCategory() {
        return View.ADMIN_CATEGORY_ADD_CHILD;
    }

}

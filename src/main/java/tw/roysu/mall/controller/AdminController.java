package tw.roysu.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.form.CategoryForm;
import tw.roysu.mall.service.ICategoryService;

/**
 * 管理後台Controller
 */
@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
    
    @Autowired
    private ICategoryService categoryService;
    
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
    public String addParentCategoryPage(Model model) {
        model.addAttribute("form", new CategoryForm());
        return View.ADMIN_CATEGORY_ADD_PARENT;
    }
    
    /**
     * 商品類別 - 新增父類別
     */
    @RequestMapping(value = "/AddParentCategory", method = RequestMethod.POST)
    public String addParentCategory(Model model, CategoryForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.ADMIN_CATEGORY_ADD_PARENT;
        }
        categoryService.create(form.toCategory());
        return View.ADMIN_CATEGORY_LIST;
    }
    
    /**
     * 商品類別 - 新增子類別頁
     */
    @RequestMapping(value = "/AddChildCategory", method = RequestMethod.GET)
    public String addChildCategoryPage(Model model) {
        model.addAttribute("form", new CategoryForm());
        model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
        return View.ADMIN_CATEGORY_ADD_CHILD;
    }
    
    /**
     * 商品類別 - 新增子類別
     */
    @RequestMapping(value = "/AddChildCategory", method = RequestMethod.POST)
    public String addChildCategory(Model model, CategoryForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
            return View.ADMIN_CATEGORY_ADD_CHILD ;
        }
        categoryService.create(form.toCategory());
        return View.ADMIN_CATEGORY_LIST;
    }

}

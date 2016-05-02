package tw.roysu.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.form.CategoryForm;
import tw.roysu.mall.form.ProductForm;
import tw.roysu.mall.service.ICategoryService;
import tw.roysu.mall.service.IPagingService;
import tw.roysu.mall.service.IProductService;

/**
 * 管理後台Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @Autowired
    private ICategoryService categoryService;
    
    @Autowired
    private IProductService productService;
    
    @Autowired
    private IPagingService pagingService;
    
    /**
     * 登入頁
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return View.ADMIN_HOME;
    }
    
    /**
     * 商品類別 - 列表頁
     */
    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public String listCategory(Model model) {
        model.addAttribute("categoryList", categoryService.getCategoryList());
        return View.ADMIN_CATEGORY_LIST;
    }
    
    /**
     * 商品類別 - 新增父類別頁
     */
    @RequestMapping(value = "/categorys/parents/create", method = RequestMethod.GET)
    public String addParentCategoryPage(Model model) {
        model.addAttribute("form", new CategoryForm());
        return View.ADMIN_CATEGORY_ADD_PARENT;
    }
    
    /**
     * 商品類別 - 新增父類別
     */
    @RequestMapping(value = "/categorys/parents/create", method = RequestMethod.POST)
    public String addParentCategory(Model model, CategoryForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            return View.ADMIN_CATEGORY_ADD_PARENT;
        }
        categoryService.create(form.toCategory());
        return listCategory(model);
    }
    
    /**
     * 商品類別 - 根據選擇的父類別回傳子類別
     */
    @RequestMapping(value = "/categorys/parents/{categoryId}")
    @ResponseBody
    public Object listChildCategory(@PathVariable("categoryId") int categoryId) {
        return categoryService.getChildCategoryList(categoryId);
    }
    
    /**
     * 商品類別 - 新增子類別頁
     */
    @RequestMapping(value = "/categorys/childs/create", method = RequestMethod.GET)
    public String addChildCategoryPage(Model model) {
        model.addAttribute("form", new CategoryForm());
        model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
        return View.ADMIN_CATEGORY_ADD_CHILD;
    }
    
    /**
     * 商品類別 - 新增子類別
     */
    @RequestMapping(value = "/categorys/childs/create", method = RequestMethod.POST)
    public String addChildCategory(Model model, CategoryForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
            return View.ADMIN_CATEGORY_ADD_CHILD ;
        }
        categoryService.create(form.toCategory());
        return listCategory(model);
    }
    
    /**
     * 商品 - 列表首頁
     */
    @RequestMapping(value = "/product-pages", method = RequestMethod.GET)
    public String listProductHomePage(Model model) {
        return listProduct(1, model);
    }
    
    /**
     * 商品 - 列表頁
     */
    @RequestMapping(value = "/product-pages/{page}", method = RequestMethod.GET)
    public String listProduct(@PathVariable("page") int page, Model model) {
        model.addAttribute("pagingBean", pagingService.getAdminProductListBean(page));
        model.addAttribute("productList", productService.getProductList(page));
        return View.ADMIN_PRODUCT_LIST;
    }
    
    /**
     * 商品 - 新增頁
     */
    @RequestMapping(value = "/products/create", method = RequestMethod.GET)
    public String addProductPage(Model model) {
        model.addAttribute("form", new ProductForm());
        model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
        return View.ADMIN_PRODUCT_ADD;
    }
    
    /**
     * 商品 - 新增
     */
    @RequestMapping(value = "/products/create", method = RequestMethod.POST)
    public String addProduct(Model model, ProductForm form) {
        if (!form.validate()) {
            model.addAttribute("form", form);
            model.addAttribute("parentCategoryList", categoryService.getAllParentCategory());
            return View.ADMIN_PRODUCT_ADD ;
        }
        productService.create(form.toProduct());
        return listProductHomePage(model);
    }
    
    /**
     * 商品 - 上傳圖片頁
     */
    @RequestMapping(value = "/products/upload-photo/{productId}", method = RequestMethod.GET)
    public String uploadProductPhotoPage(@PathVariable("productId") int productId,
                                         Model model) {
        return View.ADMIN_PRODUCT_UPLOAD_PHOTO;
    }
    
    /**
     * 商品 - 上傳圖片
     */
    @RequestMapping(value = "/products/upload-photo/{productId}", method = RequestMethod.POST)
    public String uploadProductPhoto(@PathVariable("productId") int productId,
                                     @RequestParam("file") MultipartFile file,
                                     Model model) {
        productService.addProductImg(productId, file);
        return listProductHomePage(model);
    }

}

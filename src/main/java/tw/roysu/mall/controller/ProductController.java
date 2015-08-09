package tw.roysu.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.service.IPagingService;
import tw.roysu.mall.service.IProductService;

/**
 * 商品Controller
 */
@Controller
@RequestMapping(value = "/Product")
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @Autowired
    private IPagingService pagingService;
    
    /**
     * 選擇類別的商品列表首頁
     */
    @RequestMapping(value = "/List/{categoryId}")
    public String listByCategoryHomePage(@PathVariable("categoryId") int categoryId,
                                    Model model) {
        return listByCategory(categoryId, 1, model);
    }
    
    /**
     * 選擇類別的商品列表
     */
    @RequestMapping(value = "/List/{categoryId}/{page}")
    public String listByCategory(@PathVariable("categoryId") int categoryId,
                                 @PathVariable("page") int page,
                                 Model model) {
        model.addAttribute("pagingBean", pagingService.getCategoryProductListBean(categoryId, page));
        model.addAttribute("productList", productService.getListByCategory(categoryId, page));
        model.addAttribute("categoryId", categoryId);
        return View.PRODUCT_LIST;
    }

}

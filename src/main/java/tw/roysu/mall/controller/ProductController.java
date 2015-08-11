package tw.roysu.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.roysu.mall.constant.View;
import tw.roysu.mall.entity.User;
import tw.roysu.mall.service.ICartService;
import tw.roysu.mall.service.IPagingService;
import tw.roysu.mall.service.IProductService;
import tw.roysu.mall.utils.HttpSessionUtils;

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
    
    @Autowired
    private ICartService cartService;
    
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
    
    /**
     * 商品明細
     */
    @RequestMapping(value = "/Detail/{productId}")
    public String detail(@PathVariable("productId") int productId,
                         Model model) {
        model.addAttribute("product", productService.getProduct(productId));
        return View.PRODUCT_DETAIL;
    }
    
    /**
     * 放入購物車
     */
    @RequestMapping(value = "/Cart/{productId}")
    @ResponseBody
    public Object addInCart(@PathVariable("productId") int productId,
                                    HttpSession session) {
        Map<String, String> result = new HashMap<>();
        
        // 未登入回傳失敗與訊息
        User user = HttpSessionUtils.getUser(session);
        if (user == null) {
            result.put("state", "fail");
            result.put("msg", "no login");
            return result;
        }
        
        cartService.addProduct(user.getId(), productId);
        result.put("state", "success");
        return result;
    }
    
    /**
     * 購物車結帳
     */
    @RequestMapping(value = "/Cart/Checkout", method = RequestMethod.GET)
    public String cartCheckout(HttpSession session, Model model) {
        User user = HttpSessionUtils.getUser(session);
        if (user == null) {
            return View.HOME;
        }

        model.addAttribute("productList", cartService.getUserCart(user.getId()));
        return View.ORDER_CHECK;
    }

}

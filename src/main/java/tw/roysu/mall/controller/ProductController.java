package tw.roysu.mall.controller;

import java.util.HashMap;
import java.util.List;
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
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.entity.User;
import tw.roysu.mall.form.BuyForm;
import tw.roysu.mall.service.ICartService;
import tw.roysu.mall.service.IOrderService;
import tw.roysu.mall.service.IPagingService;
import tw.roysu.mall.service.IProductService;
import tw.roysu.mall.utils.HttpSessionUtils;

/**
 * 商品Controller
 */
@Controller
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @Autowired
    private IPagingService pagingService;
    
    @Autowired
    private ICartService cartService;
    
    @Autowired
    private IOrderService orderService;
    
    /**
     * 選擇類別的商品列表首頁
     */
    @RequestMapping(value = "/products/category-pages/{categoryId}")
    public String listByCategoryHomePage(@PathVariable("categoryId") int categoryId,
                                    Model model) {
        return listByCategory(categoryId, 1, model);
    }
    
    /**
     * 選擇類別的商品列表
     */
    @RequestMapping(value = "/products/category-pages/{categoryId}/{page}")
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
    @RequestMapping(value = "/products/{productId}")
    public String detail(@PathVariable("productId") int productId,
                         Model model) {
        model.addAttribute("product", productService.getProduct(productId));
        return View.PRODUCT_DETAIL;
    }
    
    /**
     * 放入購物車
     */
    @RequestMapping(value = "/carts/add/{productId}")
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
     * 購物車結帳頁
     */
    @RequestMapping(value = "/carts/checkout", method = RequestMethod.GET)
    public String cartCheckoutPage(HttpSession session, Model model) {
        return cartCheckoutView(new BuyForm(), session, model);
    }
    
    /**
     * 購物車結帳
     */
    @RequestMapping(value = "/carts/checkout", method = RequestMethod.POST)
    public String create(BuyForm form, HttpSession session, Model model) {
        if (!form.validate()) {
            return cartCheckoutView(form, session, model);
        }

        User user = HttpSessionUtils.getUser(session);
        if (user == null) {
            return View.HOME;
        }

        // 計算商品總額
        List<Product> productList = cartService.getUserCart(user.getId());
        int totalPayment = productList.stream()
                                      .mapToInt(product -> product.getActualPrice())
                                      .sum();
        
        // 建立訂單
        try {
            orderService.createOrder(form.toOrder(user.getId(), totalPayment));
        } catch (Exception e) {
            form.addErrMsg("系統錯誤");
            return cartCheckoutView(form, session, model);
        }
        
        model.addAttribute("msg", "訂購成功");
        return View.SUCCESS;
    }
    
    /**
     * 購物車結帳確認頁
     */
    private String cartCheckoutView(BuyForm form, HttpSession session, Model model) {
        User user = HttpSessionUtils.getUser(session);
        if (user == null) {
            return View.HOME;
        }

        List<Product> productList = cartService.getUserCart(user.getId());
        // 商品總額
        int total = productList.stream()
                               .mapToInt(product -> product.getActualPrice())
                               .sum();
        model.addAttribute("productList", productList);
        model.addAttribute("total", total);
        model.addAttribute("form", form);
        return View.ORDER_CHECK;
    }

}

package tw.roysu.mall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import tw.roysu.mall.entity.User;
import tw.roysu.mall.service.ICartService;
import tw.roysu.mall.service.ICategoryService;
import tw.roysu.mall.utils.HttpSessionUtils;

/**
 * 側邊欄攔截器<br><br>
 * 
 * 商品側邊欄：檢查HttpSession裡有沒有存側邊欄, 如果沒有, 建立並存入<br>
 * 購物車側邊欄：每次請求都會查詢一次
 */
public class SidebarInterceptor implements HandlerInterceptor {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICartService cartService;

    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, 
                             Object obj) throws Exception {
        // 商品類別側邊欄
        request.setAttribute("sidebar", categoryService.getSidebar());
        
        // 如果有登入顯示購物車內容
        User user = HttpSessionUtils.getUser(request.getSession());
        if (user != null) {
            request.setAttribute("cart", cartService.getUserCart(user.getId()));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object obj, 
                           ModelAndView mav) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Object obj, 
                                Exception e) throws Exception {
        
    }

}

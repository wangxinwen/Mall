package tw.roysu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 會員Controller
 */
@Controller
public class UserController {

	/**
	 * 登入頁
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}

	/**
	 * 登入
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login() {
		// 功能待完成
		return "";
	}
}

package tw.roysu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登入Controller
 */
@Controller
public class LoginController {

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

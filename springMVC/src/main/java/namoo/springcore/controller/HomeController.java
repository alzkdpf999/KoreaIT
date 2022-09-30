package namoo.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//메소드가 하나면 클래스에다가 해두됨
@Controller
@RequestMapping("/")
public class HomeController {
	public String main() {
		return "index";
	}
}

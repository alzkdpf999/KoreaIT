package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	
	@GetMapping("/hello5")
	public String redirect() {
		return "redirect:/";
	}
}

package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	@GetMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("msg", "타임리프 사용해보기");
		return "thymeleaf";
	}
}

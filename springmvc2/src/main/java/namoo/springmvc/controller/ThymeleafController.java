package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	@GetMapping("/leaf")
	public String helloTR(Model model) {
		model.addAttribute("message", "안녕 타임리프...");
		return "thymeleaf";		
	}

}

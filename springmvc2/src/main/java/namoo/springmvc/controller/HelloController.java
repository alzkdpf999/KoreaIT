package namoo.springmvc.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	
	@RequestMapping("/hello")
	public String hello() {
		// 데이터 작업
		// view의 논리적이름 반환
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		String name = "김기정";
		mav.addObject("name", name);
		mav.setViewName("hello2");
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String name = "김기정";
		model.addAttribute("name", name);
		model.addAttribute("today", Calendar.getInstance());
		return "hello2";
	}
	
	@RequestMapping(value="/hello4", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@GetMapping("/hello5")
	public String redirect() {
		return "redirect:/";
	}
}












package namoo.springcore.controller;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		// 보통 리턴은 jsp 이름을 씀 그럼 자동으로 포워드 시켜줌
		// view의 논리적 이름 반환 확장자 빼도됨 이러면 views밑에 hell.jsp가 실행됨
		return "hello";
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		// 데이터와 뷰를 지정하기 위해 캡슐화
		ModelAndView mav = new ModelAndView();

		String name = "jack";
		mav.addObject("name", name);// request에 저장
		mav.setViewName("hello2");
		return mav;
	}
//위에것과 똑같이 행동 이 방법이 자주 쓰임
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String name = "jack";
		model.addAttribute("name", name);// request에 저장
		model.addAttribute("today", Calendar.getInstance());// request에 저장
//		model.addAttribute(name); key를 지정 안하면 string 으로 저장됨

		return "hello2";
	}
	/**
	 *  설정 안하면 post ,get둘 다 받는 형태
	 * RequestMethod.GET = GET
	 * RequestMethod.POST = POST
	 * value 적어주기
	 * 근데 만약 get,post를 같이 쓰고 싶으면
	 * method = {RequestMethod.GET, RequestMethod.POST}로 쓰기
	 * @return
	 */
	//@GetMapping @PostMapping @DeleteMapping @PutMapping 이 방식 자주 씀
	//@PatchMapping
	@RequestMapping(value ="/hello4",method = RequestMethod.GET)
	public String form() {
		
		return "form";
	}
	
	
}

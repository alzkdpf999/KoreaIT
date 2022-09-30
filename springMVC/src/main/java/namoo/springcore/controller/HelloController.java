package namoo.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return "hello2";
	}
}

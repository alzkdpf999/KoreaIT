package namoo.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestParamController {

	@GetMapping("/param")
	@ResponseBody
//	"/param?name=ss&age=10" 이런식으로 요청이 들어온다 치면
	//파싱 저절로 해줌
	public String param(@RequestParam("name") String name,@RequestParam("age") int age) {
		return name+age;
	}

	
	
}

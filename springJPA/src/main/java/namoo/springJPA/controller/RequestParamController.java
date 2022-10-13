package namoo.springJPA.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import namoo.springJPA.entity.Dog;

@Controller
public class RequestParamController{
	
	@GetMapping("/param")
	@ResponseBody
	public String param(@RequestParam String name, @RequestParam int age) {
		return "이름:"+name+", 나이: "+age;
	}
	
	@PostMapping("/param2")
	@ResponseBody
	public String param(@RequestParam Map<String, Object> paramMap) {
		return "이름:"+paramMap.get("name")+", 나이: "+ paramMap.get("age");
	}
	
	@PostMapping("/param3")
	public String param(@ModelAttribute("dog") Dog dog) {
		System.out.println(dog.toString());
		return "view";
	}
	
	@GetMapping("/param4")
	@ResponseBody
	public String param(HttpMethod method, Locale locale, 
			            @RequestHeader MultiValueMap<String, String> headerMap,
			            @RequestHeader("host") String host,
			            @CookieValue(value = "userId", required = false, defaultValue = "guest") String userId) {
		System.out.println(method);
		System.out.println(locale);
		System.out.println(headerMap);
		System.out.println(host);
		System.out.println(userId);
		return "host:" + host;
	}
	
	@GetMapping("/classes/{classId}/students/{studentId}")
	@ResponseBody
	public String param(@PathVariable String classId, @PathVariable String studentId) {
		return "반번호: "+classId+", 학번: "+ studentId;
	}
}












package namoo.springcore.controller;

import java.util.Locale;
import java.util.Map;

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

import namoo.springcore.dto.Dog;

@Controller
public class RequestParamController {

	@GetMapping("/param")
	@ResponseBody
//	"/param?name=ss&age=10" 이런식으로 요청이 들어온다 치면
	//파싱 저절로 해줌
	public String param(@RequestParam String name,@RequestParam int age) {
		return name+age;
	}
	@PostMapping("/param2")
	@ResponseBody
	public String param2(@RequestParam Map<String, Object> paramMap) {
		return  paramMap.get("name") +""+ paramMap.get("age")+ "map 사용";			
	}
	@PostMapping("/param3")
	public String param3(@ModelAttribute("dog") Dog dog) {
		System.out.println(dog.toString());
		return "dog";
	}
	
	/* 헤더 정보와 쿠기 정보 받기 위해 사용
	 * @RequestMapping("/headerdetail”) public String headers(HttpMethod httpMethod,
	 * Locale locale,
	 * 
	 * @RequestHeader MultiValueMap<String, String> headerMap, 
	 * 모든 헤더 정보를 가지고옴
	 * @RequestHeader("host") String host, 
	 * "host"라는 정보를 가지고옴
	 * @CookieValue(value = "userId", required = false, defaultValue = “bangry")
	 *required 가 트루면 쿠키가 있어야함 아니면 에러남, defaultValue는 쿠키가 없을 시 디폴트
	 * String userId){
	 * 
	 * System.out.println(httpMethod); System.out.println(locale);
	 * System.out.println(headerMap); System.out.println(host);
	 * System.out.println(userId); return “result"; }
	 */
	
	@GetMapping("/param4")
	public String param3(HttpMethod httpMethod, Locale locale,
			@RequestHeader MultiValueMap<String, String> headerMap,
			@RequestHeader("host") String host,
			@CookieValue(value = "userId", required = false, defaultValue = "bangry") String userId) {
		System.out.println(httpMethod);
		System.out.println(locale);
		System.out.println(headerMap);
		System.out.println(host);
		System.out.println(userId);
		return "dog";
	}
	
	// REST API에서 사용하는 방식 
	// @PathVariable
	// 정적인건가 동적인건가 API방식인가
//class 위에 @RestController라고 해주면 저절로 @ResponseBody가 적용됨
	@GetMapping("/classes/{classId}/students/{studentId}")
	public String view(@PathVariable String classId,@PathVariable String studentId) {
		return "view";
	}
}

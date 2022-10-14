package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import namoo.springmvc.dto.Dog;

@Controller
public class RequestJSONController {
	
	@PostMapping("/request-json")
	@ResponseBody
	public String requestJson(@RequestBody String jsonMessage) throws JsonMappingException, JsonProcessingException{
		System.out.println(jsonMessage);
		ObjectMapper objectMapper = new ObjectMapper();
		Dog dog = objectMapper.readValue(jsonMessage, Dog.class);
		System.out.println(dog);
		return jsonMessage;
	}
	
	@PostMapping("/request-json2")
	@ResponseBody
	public Dog requestJson(@RequestBody Dog dog) throws JsonMappingException, JsonProcessingException{
		System.out.println(dog);
		// DB에 인서트 가정
		return dog;
	}
	
}









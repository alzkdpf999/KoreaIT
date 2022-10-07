package namoo.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import namoo.springmvc.dto.Dog;

@Controller
public class RequestBodyController {
	
	@PostMapping("/request-body")
	public void requestBodyText(InputStream in, Writer out) throws IOException{
		String bodyMessage = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
		System.out.println(bodyMessage);
		out.write(bodyMessage);
	}
	
	@PostMapping("/request-body2")
	public HttpEntity<String> requestBodyText2(HttpEntity<String> httpEntity){
		String bodyMessage = httpEntity.getBody();
		System.out.println(bodyMessage);
		return new HttpEntity<String>("정상 처리"+bodyMessage);
	}
	
	@PostMapping("/request-body3")
	public ResponseEntity<String> requestBodyText3(RequestEntity<String> requestEntity){
		String bodyMessage = requestEntity.getBody();
		System.out.println(bodyMessage);
		return new ResponseEntity<String>("정상 처리"+bodyMessage,HttpStatus.CREATED);//201
	}
	
	@PostMapping("/request-body4")
	@ResponseBody
	public String requestBodyText4(@RequestBody String bodyMessage){
		System.out.println(bodyMessage);
		return bodyMessage;
	}
	
	@PostMapping("/request-json")
	@ResponseBody
	public String requestJson(@RequestBody String jsonMessage) throws IOException{
		System.out.println(jsonMessage);
		ObjectMapper objectMapper = new ObjectMapper();
		Dog dog = objectMapper.readValue(jsonMessage, Dog.class);
		System.out.println(dog);
		return "ok";
	}
	
/*
 * @RequestBody 요청
 * JSON 요청 -> HTTP 메시지 컨버터에 의해 -> 객체
 * @ResponseBody 응답
 * 객체 -> HTTP 메시지 컨버테에 의해 -> JSON 응답
 */
	@PostMapping("/request-json2")
	@ResponseBody
	public Dog requestJson2(@RequestBody Dog dog) throws IOException{
		System.out.println(dog);
		// DB에 연결 가정
		return dog;
	}
}

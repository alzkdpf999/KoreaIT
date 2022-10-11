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

@Controller
public class RequestBodyController {
	
	@PostMapping("/request-body")
	public void requestBodyText(InputStream in, Writer out) throws IOException {
		String bodyMessage = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
		System.out.println(bodyMessage);
		out.write(bodyMessage + "OK~~~");
	}
	
	@PostMapping("/request-body2")
	public HttpEntity<String> requestBodyText(HttpEntity<String> httpEntity){
		String bodyMessage = httpEntity.getBody();
		return new HttpEntity<String>(bodyMessage);
	}
	
	@PostMapping("/request-body3")
	public ResponseEntity<String> requestBodyText(RequestEntity<String> httpEntity){
		String bodyMessage = httpEntity.getBody();
		return new ResponseEntity<String>(bodyMessage, HttpStatus.CREATED);
	}
	
	@PostMapping("/request-body4")
	@ResponseBody
	public String requestBodyText(@RequestBody String bodyMessage){
		return bodyMessage;
	}
}








